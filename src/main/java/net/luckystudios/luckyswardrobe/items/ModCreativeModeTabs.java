package net.luckystudios.luckyswardrobe.items;
import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LuckysWardrobe.MOD_ID);

    public static final Supplier<CreativeModeTab> WARDROBE_CREATIVE_TAB = CREATIVE_MODE_TAB.register(LuckysWardrobe.MOD_ID + "_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HAT.get()))
                    .title(Component.translatable("itemGroup.luckyswardrobe"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Villager Profession Cosmetics
//                        output.accept(ModItems.LEATHER_APRON);
//                        output.accept(ModItems.HARDENED_LEATHER_APRON);
//                        output.accept(ModItems.BUTCHERS_APRON);
//                        output.accept(ModItems.CLERICS_APRON);
//                        output.accept(ModItems.FISHING_APRON);
//                        output.accept(ModItems.CHITON);
//                        output.accept(ModItems.MASONS_APRON);
//                        output.accept(ModItems.WOOL_VEST);
//
//                        // Clothing
//                        output.accept(ModItems.TAIGA_HOOD);
//                        output.accept(ModItems.TAIGA_COAT);
//                        output.accept(ModItems.TAIGA_PANTS);
//                        output.accept(ModItems.TAIGA_BOOTS);
//
//                        output.accept(ModItems.SNOWY_HAT);
//                        output.accept(ModItems.SNOWY_HOOD);
//                        output.accept(ModItems.SNOWY_COAT);
//                        output.accept(ModItems.SNOWY_PANTS);
//                        output.accept(ModItems.SNOWY_BOOTS);
//
//                        output.accept(ModItems.SAVANNA_FLORAL_CROWN);
//                        output.accept(ModItems.SAVANNA_ROBE);
//                        output.accept(ModItems.SAVANNA_PANTS);
//                        output.accept(ModItems.SAVANNA_SANDALS);
//
//                        output.accept(ModItems.SWAMPY_HAT);
//                        output.accept(ModItems.SWAMPY_ROBE);
//                        output.accept(ModItems.SWAMPY_PANTS);
//                        output.accept(ModItems.SWAMPY_SHOES);
//
//                        output.accept(ModItems.JUNGLE_ROBE);
//                        output.accept(ModItems.JUNGLE_PANTS);
//                        output.accept(ModItems.JUNGLE_SANDALS);
//
//                        output.accept(ModItems.DESERT_HAT);
//                        output.accept(ModItems.DESERT_ROBE);
//                        output.accept(ModItems.DESERT_PANTS);
//                        output.accept(ModItems.DESERT_SANDALS);

                        // Unique Cosmetics
                        output.accept(ModItems.HAT);
//                        output.accept(ModItems.TOP_HAT);
//                        output.accept(ModItems.EXPLORERS_HAT);
//                        output.accept(ModItems.WITCH_HAT);
//                        output.accept(ModItems.FOX_HAT);
//                        output.accept(ModItems.SNOW_FOX_HAT);
//                        output.accept(ModItems.SCARF);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
