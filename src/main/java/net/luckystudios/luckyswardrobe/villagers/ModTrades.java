package net.luckystudios.luckyswardrobe.villagers;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = LuckysWardrobe.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModTrades {

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(ModItems.FOX_HAT.get(), 1), 1, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(ModItems.WOLF_HAT.get(), 1), 1, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(ModItems.PANDA_HAT.get(), 1), 1, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.SNOW_FOX_HAT.get(), 1), 1, 10, 0.2f));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.BEE_HAT.get(), 1), 1, 10, 0.2f));

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(ModItems.ENTERTAINERS_HAT.get(), 1), 1, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(ModItems.ENTERTAINERS_SHIRT.get(), 1), 1, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(ModItems.ENTERTAINERS_PANTS.get(), 1), 1, 10, 0.2f));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(ModItems.ENTERTAINERS_SHOES.get(), 1), 1, 10, 0.2f));
    }
}
