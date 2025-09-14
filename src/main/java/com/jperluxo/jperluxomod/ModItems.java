package com.jperluxo.jperluxomod;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");

  public static final IItemTier JPERLUXO = new IItemTier() {
    @Override public int getMaxUses() { return -1; }
    @Override public float getEfficiency() { return 14.0F; }
    @Override public float getAttackDamage() { return 5.0F; }
    @Override public int getHarvestLevel() { return 4; }
    @Override public int getEnchantability() { return 25; }
    @Override public Ingredient getRepairMaterial() { return Ingredient.EMPTY; }
  };

  public static final RegistryObject<Item> JPERLUXO_SWORD = ITEMS.register("jperluxo_sword", () -> new SwordItem(JPERLUXO, 10, -2.4F, new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC).isImmuneToFire().setNoRepair()));

  public static final RegistryObject<Item> JPERLUXO_SHARD = ITEMS.register("jperluxo_shard", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE).isImmuneToFire().setNoRepair()));

  public static void register(IEventBus bus) {
    ITEMS.register(bus);
  }
}
