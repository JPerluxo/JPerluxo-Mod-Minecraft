package com.jperluxo.jperluxomod.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import javax.annotation.Nonnull;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.SoundEvents;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.NonNullList;

public class JPerluxoArmorItem extends ArmorItem {
  
  public static final IArmorMaterial JPERLUXO = new IArmorMaterial() {
    @Override public int getDurability(@Nonnull EquipmentSlotType slot) { return 100_000; }
    @Override public int getDamageReductionAmount(@Nonnull EquipmentSlotType slot) {
      switch (slot) {
        case HEAD: return 5;
        case CHEST: return 10;
        case LEGS: return 8;
        case FEET: return 5;
        default: return 0;
      }
    }
    @Override public int getEnchantability() { return 25; }
    @Override public net.minecraft.util.SoundEvent getSoundEvent() { return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC; }
    @Override public Ingredient getRepairMaterial() { return Ingredient.EMPTY; }
    @Override public String getName() { return "jperluxomod:jperluxo"; }
    @Override public float getToughness() { return 4.0F; }
    @Override public float getKnockbackResistance() { return 0.1F; }
  };

  public JPerluxoArmorItem(EquipmentSlotType slot) {
    super(JPERLUXO, slot, new Item.Properties()
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
