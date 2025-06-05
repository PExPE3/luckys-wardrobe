package net.luckystudios.luckyswardrobe;

import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import net.luckystudios.luckyswardrobe.components.ModDataComponents;
import net.luckystudios.luckyswardrobe.items.ModCreativeModeTabs;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.luckystudios.luckyswardrobe.items.cosmetics.ModArmorMaterials;
import net.minecraft.core.cauldron.CauldronInteraction;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LuckysWardrobe.MOD_ID)
public class LuckysWardrobe
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "luckyswardrobe";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LuckysWardrobe(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModDataComponents.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            // Register the cauldron interaction for dyeing armor items
            CauldronInteraction.WATER.map().put(ModItems.HAT.get(), ModArmorMaterials.DYED_ARMOR_ITEM);
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
