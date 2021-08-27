package com.harmex.amethystutils.common.inventory;

import com.harmex.amethystutils.AmethystUtils;
import com.harmex.amethystutils.common.inventory.custom.InfuserMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, AmethystUtils.MOD_ID);

    public static final RegistryObject<MenuType<?>> INFUSER =
            MENU_TYPES.register("infuser", () -> new MenuType<>(InfuserMenu::new));


    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
