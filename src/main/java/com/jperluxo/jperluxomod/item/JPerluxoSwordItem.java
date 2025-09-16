package com.jperluxo.jperluxomod.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.NonNullList;

public class JPerluxoSwordItem extends SwordItem {

  public static final IItemTier JPERLUXO = new IItemTier() {
    @Override public int getMaxUses() { return 100_000; }
    @Override public float getEfficiency() { return 14.0F; }
    @Override public float getAttackDamage() { return 5.0F; }
    @Override public int getHarvestLevel() { return 4; }
    @Override public int getEnchantability() { return 25; }
    @Override public Ingredient getRepairMaterial() { return Ingredient.EMPTY; }
  };
    
  public JPerluxoSwordItem() {
    super(JPERLUXO, 10, -2.4F, new Item.Properties()
      .group(ItemGroup.COMBAT)
      .rarity(Rarity.EPIC)
      .isImmuneToFire()
      .setNoRepair());
  }
  
  @Override public void onCreated(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull PlayerEntity playerIn) {
    stack.getOrCreateTag().putBoolean("Unbreakable", true);
    super.onCreated(stack, worldIn, playerIn);
  }

  @Override public void fillItemGroup(@Nonnull ItemGroup group, @Nonnull NonNullList<ItemStack> items) {
    if (this.isInGroup(group)) {
      ItemStack itemStack = new ItemStack(this);
      itemStack.getOrCreateTag().putBoolean("Unbreakable", true);
      items.add(itemStack);
    }
  }
}
