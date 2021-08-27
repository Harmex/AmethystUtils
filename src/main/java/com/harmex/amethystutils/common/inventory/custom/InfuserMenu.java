package com.harmex.amethystutils.common.inventory.custom;

import com.harmex.amethystutils.common.inventory.ModMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class InfuserMenu extends AbstractContainerMenu {

    private final Container infuser;

    public InfuserMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(9));
    }

    public InfuserMenu(int id, Inventory inventory, Container container) {
        super(MenuType.GENERIC_3x3, id);
        checkContainerSize(container, 9);
        this.infuser = container;
        container.startOpen(inventory.player);

        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 3; ++col) {
                this.addSlot(new Slot(container, col + row * 3, 62 + col * 18, 17 + row * 18));
            }
        }

        // Player Inventory
        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Player Hotbar
        for(int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142));
        }

    }

    public boolean stillValid(Player player) {
        return this.infuser.stillValid(player);
    }

    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 9) {
                if (!this.moveItemStackTo(itemstack1, 9, 45, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.infuser.stopOpen(player);
    }
}
