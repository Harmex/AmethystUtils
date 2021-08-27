package com.harmex.amethystutils.common.block;

import com.harmex.amethystutils.AmethystUtils;
import com.harmex.amethystutils.common.block.custom.InfuserBlock;
import com.harmex.amethystutils.common.item.ModCreativeModeTab;
import com.harmex.amethystutils.common.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AmethystUtils.MOD_ID);

    //region Misc
    public static final RegistryObject<Block> AMETHYST_INGOT_BLOCK =
            registerBlock("amethyst_ingot_block",
                    () -> new Block(BlockBehaviour.Properties
                            .of(Material.METAL)
                            .strength(3f, 15)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                    ));
    //endregion
    //region Crafting
    public static final RegistryObject<Block> INFUSER =
            registerBlock("infuser",
                    InfuserBlock::new);
    //endregion

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.TAB_AMETHYST)
                ));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
