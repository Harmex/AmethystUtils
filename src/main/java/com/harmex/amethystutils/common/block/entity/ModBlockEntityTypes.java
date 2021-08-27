package com.harmex.amethystutils.common.block.entity;

import com.harmex.amethystutils.AmethystUtils;
import com.harmex.amethystutils.common.block.ModBlocks;
import com.harmex.amethystutils.common.block.entity.custom.InfuserBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, AmethystUtils.MOD_ID);

    //region Crafters
    public static final RegistryObject<BlockEntityType<?>> INFUSER =
            BLOCK_ENTITY_TYPES.register("infuser",
                    () -> BlockEntityType.Builder.of(InfuserBlockEntity::new, ModBlocks.INFUSER.get())
                            .build(null));
    //endregion

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
