package net.luckystudios.luckyswardrobe.events;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.LuckysWardrobeConfig;
import net.luckystudios.luckyswardrobe.datagen.types.entity_tags.ModEntityTypeTags;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.Random;

@EventBusSubscriber(modid = LuckysWardrobe.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event) {
        if (LuckysWardrobeConfig.MODS_SPAWN_COSMETICS_CHANCE.get().floatValue() == 0) return;
        Level level = event.getLevel();
        Entity entity = event.getEntity();
        if (!(entity instanceof LivingEntity livingEntity)) return;
        BlockPos pos = entity.blockPosition();
        Holder<Biome> biomeHolder = level.getBiome(pos);
        if (!entity.getType().is(ModEntityTypeTags.WEAR_COSMETICS)) return;

        Random random = new Random();
        float chance = LuckysWardrobeConfig.MODS_SPAWN_COSMETICS_CHANCE.get().floatValue();
        if (random.nextFloat() >= chance) return;

        boolean onlyHelmet = (livingEntity instanceof AbstractSkeleton);

        if (biomeHolder.is(BiomeTags.HAS_VILLAGE_SNOWY)) {
            equipColdOutfit(livingEntity, onlyHelmet);
        } else if (biomeHolder.is(BiomeTags.HAS_VILLAGE_DESERT)) {
            equipHotOutfit(livingEntity, onlyHelmet);
        } else if (biomeHolder.is(BiomeTags.IS_SAVANNA)) {
            equipSavannaOutfit(livingEntity, onlyHelmet);
        } else if (biomeHolder.is(BiomeTags.IS_JUNGLE)) {
            if (!onlyHelmet) equipJungleOutfit(livingEntity);
        } else if (biomeHolder.is(BiomeTags.HAS_RUINED_PORTAL_SWAMP)) {
            equipSwampOutfit(livingEntity, onlyHelmet);
        } else if (biomeHolder.is(BiomeTags.IS_BEACH) && livingEntity instanceof Zombie) {
            livingEntity.setItemSlot(EquipmentSlot.CHEST, ModItems.BROKEN_BARREL.toStack());
        }
    }

    private static void equipColdOutfit(LivingEntity entity, boolean onlyHelmet) {
        Random random = new Random();
        boolean taiga = random.nextFloat() < 0.7F;

        if (onlyHelmet) {
            entity.setItemSlot(EquipmentSlot.HEAD, taiga ? ModItems.TAIGA_HOOD.toStack() : ModItems.SNOWY_HOOD.toStack());
        } else {
            entity.setItemSlot(EquipmentSlot.CHEST, taiga ? ModItems.TAIGA_COAT.toStack() : ModItems.SNOWY_COAT.toStack());
            entity.setItemSlot(EquipmentSlot.LEGS, taiga ? ModItems.TAIGA_PANTS.toStack() : ModItems.SNOWY_PANTS.toStack());
            entity.setItemSlot(EquipmentSlot.FEET, taiga ? ModItems.TAIGA_BOOTS.toStack() : ModItems.SNOWY_BOOTS.toStack());
        }
    }

    private static void equipHotOutfit(LivingEntity entity, boolean onlyHelmet) {
        if (onlyHelmet) {
            entity.setItemSlot(EquipmentSlot.HEAD, ModItems.DESERT_HAT.toStack());
        } else {
            entity.setItemSlot(EquipmentSlot.CHEST, ModItems.DESERT_ROBE.toStack());
            entity.setItemSlot(EquipmentSlot.LEGS, ModItems.DESERT_PANTS.toStack());
            entity.setItemSlot(EquipmentSlot.FEET, ModItems.DESERT_SANDALS.toStack());
        }
    }

    private static void equipSavannaOutfit(LivingEntity entity, boolean onlyHelmet) {
        if (onlyHelmet) {
            entity.setItemSlot(EquipmentSlot.HEAD, ModItems.SAVANNA_FLORAL_CROWN.toStack());
        } else {
            entity.setItemSlot(EquipmentSlot.CHEST, ModItems.SAVANNA_ROBE.toStack());
            entity.setItemSlot(EquipmentSlot.LEGS, ModItems.SAVANNA_PANTS.toStack());
            entity.setItemSlot(EquipmentSlot.FEET, ModItems.SAVANNA_SANDALS.toStack());
        }
    }

    private static void equipJungleOutfit(LivingEntity entity) {
        entity.setItemSlot(EquipmentSlot.CHEST, ModItems.JUNGLE_ROBE.toStack());
        entity.setItemSlot(EquipmentSlot.LEGS, ModItems.JUNGLE_PANTS.toStack());
        entity.setItemSlot(EquipmentSlot.FEET, ModItems.JUNGLE_SANDALS.toStack());
    }

    private static void equipSwampOutfit(LivingEntity entity, boolean onlyHelmet) {
        if (onlyHelmet) {
            entity.setItemSlot(EquipmentSlot.HEAD, ModItems.SWAMPY_HAT.toStack());
        } else {
            entity.setItemSlot(EquipmentSlot.CHEST, ModItems.SWAMPY_ROBE.toStack());
            entity.setItemSlot(EquipmentSlot.LEGS, ModItems.SWAMPY_PANTS.toStack());
            entity.setItemSlot(EquipmentSlot.FEET, ModItems.SWAMPY_SHOES.toStack());
        }
    }

    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        Level level = entity.level();
        BlockPos pos = entity.blockPosition();
        Random random = new Random();
        float chance = LuckysWardrobeConfig.MODS_DROP_COSMETICS_CHANCE.get().floatValue();
        if (random.nextFloat() >= chance) return;
        if (entity instanceof Witch) {
            if (level instanceof ServerLevel serverLevel) {
                ItemEntity entityToSpawn = new ItemEntity(serverLevel, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.WITCH_HAT.asItem()));
                serverLevel.addFreshEntity(entityToSpawn);
            }
        }
    }

    // Adding custom trades for the wandering trader and villagers
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {

        }
    }
}
