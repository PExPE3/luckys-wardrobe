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
                        output.accept(ModItems.HAT);
                        output.accept(ModItems.TOP_HAT);
                        output.accept(ModItems.FOX_HAT);
                        output.accept(ModItems.SNOW_FOX_HAT);
                        output.accept(ModItems.SCARF);
                        output.accept(ModItems.LEATHER_APRON);
                        output.accept(ModItems.HARDENED_LEATHER_APRON);
                        output.accept(ModItems.BUTCHERS_APRON);
                        output.accept(ModItems.CLERICS_APRON);
                        output.accept(ModItems.FISHING_APRON);
                        output.accept(ModItems.CHITON);
                        output.accept(ModItems.MASONS_APRON);
                        output.accept(ModItems.WOOL_VEST);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
