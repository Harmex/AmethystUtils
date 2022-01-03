package com.harmex.amethystutils;

import com.harmex.amethystutils.common.block.ModBlocks;
import com.harmex.amethystutils.common.block.entity.ModBlockEntityTypes;
import com.harmex.amethystutils.common.inventory.ModMenuTypes;
import com.harmex.amethystutils.common.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AmethystUtils.MOD_ID)
public class AmethystUtils
{
    public static final String MOD_ID = "amethystutils";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public AmethystUtils() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntityTypes.register(eventBus);
        ModMenuTypes.register(eventBus);

        // Register the setup method for modloading
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
