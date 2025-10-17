package com.jperluxo.jperluxomod.container;

import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import com.jperluxo.jperluxomod.core.ModBlocks;

public class JPerluxoCraftingTableContainer extends WorkbenchContainer {

  private final IWorldPosCallable worldPosCallable;

  public JPerluxoCraftingTableContainer(int id, PlayerInventory playerInventory, IWorldPosCallable p_i50090_3_) {
    super(id, playerInventory, p_i50090_3_);
    this.worldPosCallable = p_i50090_3_;
  }

  @Override public boolean canInteractWith(PlayerEntity playerIn) {
    return isWithinUsableDistance(this.worldPosCallable, playerIn, ModBlocks.JPERLUXO_CRAFTING_TABLE.get());
  }
}
