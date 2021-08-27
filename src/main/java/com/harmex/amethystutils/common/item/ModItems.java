package com.harmex.amethystutils.common.item;

import com.harmex.amethystutils.AmethystUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AmethystUtils.MOD_ID);

    //region Misc
    public static final RegistryObject<Item> AMETHYST_INGOT = ITEMS.register("amethyst_ingot",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    //endregion
    //region Tools
    //region MKI
    public static final RegistryObject<Item> AMETHYST_SWORD_MKI = ITEMS.register("amethyst_sword_mki",
            () -> new SwordItem(ModItemTier.AMETHYST_MKI, 3, -2.4f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_PICKAXE_MKI = ITEMS.register("amethyst_pickaxe_mki",
            () -> new PickaxeItem(ModItemTier.AMETHYST_MKI, 1, -2.8f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_AXE_MKI = ITEMS.register("amethyst_axe_mki",
            () -> new AxeItem(ModItemTier.AMETHYST_MKI, 6, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_SHOVEL_MKI = ITEMS.register("amethyst_shovel_mki",
            () -> new ShovelItem(ModItemTier.AMETHYST_MKI, 1.5f, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_HOE_MKI = ITEMS.register("amethyst_hoe_mki",
            () -> new HoeItem(ModItemTier.AMETHYST_MKI, 0, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    //endregion
    //region MKII
    public static final RegistryObject<Item> AMETHYST_SWORD_MKII = ITEMS.register("amethyst_sword_mkii",
            () -> new SwordItem(ModItemTier.AMETHYST_MKII, 3, -2.4f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_PICKAXE_MKII = ITEMS.register("amethyst_pickaxe_mkii",
            () -> new PickaxeItem(ModItemTier.AMETHYST_MKII, 1, -2.8f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_AXE_MKII = ITEMS.register("amethyst_axe_mkii",
            () -> new AxeItem(ModItemTier.AMETHYST_MKII, 6, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_SHOVEL_MKII = ITEMS.register("amethyst_shovel_mkii",
            () -> new ShovelItem(ModItemTier.AMETHYST_MKII, 1.5f, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_HOE_MKII = ITEMS.register("amethyst_hoe_mkii",
            () -> new HoeItem(ModItemTier.AMETHYST_MKII, 0, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    //endregion
    //endregion
    //region Armors
    //region MKI
    public static final RegistryObject<Item> AMETHYST_HELMET_MKI = ITEMS.register("amethyst_helmet_mki",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKI, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE_MKI = ITEMS.register("amethyst_chestplate_mki",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKI, EquipmentSlot.CHEST, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS_MKI = ITEMS.register("amethyst_leggings_mki",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKI, EquipmentSlot.LEGS, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_BOOTS_MKI = ITEMS.register("amethyst_boots_mki",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKI, EquipmentSlot.FEET, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    //endregion
    //region MKII
    public static final RegistryObject<Item> AMETHYST_HELMET_MKII = ITEMS.register("amethyst_helmet_mkii",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKII, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE_MKII = ITEMS.register("amethyst_chestplate_mkii",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKII, EquipmentSlot.CHEST, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS_MKII = ITEMS.register("amethyst_leggings_mkii",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKII, EquipmentSlot.LEGS, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    public static final RegistryObject<Item> AMETHYST_BOOTS_MKII = ITEMS.register("amethyst_boots_mkii",
            () -> new ArmorItem(ModArmorMaterial.AMETHYST_MKII, EquipmentSlot.FEET, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_AMETHYST)
            ));
    //endregion
    //endregion


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
