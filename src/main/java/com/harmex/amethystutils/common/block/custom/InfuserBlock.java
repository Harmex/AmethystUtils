package com.harmex.amethystutils.common.block.custom;

import com.harmex.amethystutils.AmethystUtils;
import com.harmex.amethystutils.common.block.entity.custom.InfuserBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class InfuserBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private static final Component CONTAINER_TITLE = new TranslatableComponent("container." + AmethystUtils.MOD_ID + ".infuser");

    public InfuserBlock() {
        super(Properties
                .of(Material.METAL)
                .strength(3f, 15)
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops()
        );
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));
    }

    //region BlockStates
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING, LIT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        if (itemStack.hasCustomHoverName()) {
            BlockEntity blockentity = level.getBlockEntity(blockPos);
            if (blockentity instanceof AbstractFurnaceBlockEntity) {
                ((AbstractFurnaceBlockEntity)blockentity).setCustomName(itemStack.getHoverName());
            }
        }
    }

    public void onRemove(BlockState blockState1, Level level, BlockPos blockPos, BlockState blockState2, boolean b) {
        if (!blockState1.is(blockState2.getBlock())) {
            BlockEntity blockentity = level.getBlockEntity(blockPos);
            if (blockentity instanceof InfuserBlockEntity) {
                if (level instanceof ServerLevel) {
                    Containers.dropContents(level, blockPos, (InfuserBlockEntity)blockentity);
                }
            }
            super.onRemove(blockState1, level, blockPos, blockState2, b);
        }
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }
    //endregion
    //region BlockEntity
    @Nullable
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new InfuserBlockEntity(blockPos, blockState);
    }
    //endregion
    //region Menu
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player,
                                 InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            //player.openMenu(blockState.getMenuProvider(level, blockPos));
            player.openMenu((InfuserBlockEntity)level.getBlockEntity(blockPos));
            return InteractionResult.CONSUME;
        }
    }

    /*@Nullable
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((menuConstructor , inventory, player) ->
                new InfuserMenu(menuConstructor, inventory),
                CONTAINER_TITLE);
    }*/
    //endregion
}
