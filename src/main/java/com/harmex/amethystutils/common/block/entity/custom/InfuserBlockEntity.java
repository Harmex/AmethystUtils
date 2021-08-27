package com.harmex.amethystutils.common.block.entity.custom;

import com.harmex.amethystutils.AmethystUtils;
import com.harmex.amethystutils.common.block.entity.ModBlockEntityTypes;
import com.harmex.amethystutils.common.inventory.custom.InfuserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class InfuserBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    public static final int CONTAINER_SIZE = 9;
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);

    protected InfuserBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    public InfuserBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(ModBlockEntityTypes.INFUSER.get(), blockPos, blockState);
    }

    //region In / Out
    public int[] getSlotsForFace(Direction direction) {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }

    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return true;
    }
    //endregion
    //region Container
    protected Component getDefaultName() {
        return new TranslatableComponent("container." + AmethystUtils.MOD_ID + ".infuser");
    }

    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new InfuserMenu(id, inventory, this);
    }

    public int getContainerSize() {
        return CONTAINER_SIZE;
    }

    public boolean isEmpty() {
        return false;
    }

    public ItemStack getItem(int i) {
        return this.items.get(i);
    }

    public ItemStack removeItem(int i, int j) {
        return ContainerHelper.removeItem(this.items, i, j);
    }

    public ItemStack removeItemNoUpdate(int i) {
        return ContainerHelper.takeItem(this.items, i);
    }

    public void setItem(int i, ItemStack itemStack) {
        this.items.set(i, itemStack);
    }

    public boolean stillValid(Player player) {
        return true;
    }

    public void clearContent() {

    }

    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
    }

    public CompoundTag save(CompoundTag compoundTag) {
        super.save(compoundTag);
        return compoundTag;
    }
    //endregion
}
