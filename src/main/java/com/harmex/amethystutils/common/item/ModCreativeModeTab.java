package com.harmex.amethystutils.common.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab TAB_AMETHYST = new CreativeModeTab("amethyst_utils") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AMETHYST_INGOT.get());
        }
    };
}
