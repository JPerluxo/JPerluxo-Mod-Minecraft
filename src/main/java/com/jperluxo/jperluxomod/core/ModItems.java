package com.jperluxo.jperluxomod.core;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import com.jperluxo.jperluxomod.item.JPerluxoSwordItem;
import com.jperluxo.jperluxomod.item.JPerluxoArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import com.jperluxo.jperluxomod.item.JPerluxoBannerPatternItem;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");
  
  public static final RegistryObject<Item> JPERLUXO_SWORD = ITEMS.register("jperluxo_sword", () -> new JPerluxoSwordItem());
  
  public static final RegistryObject<Item> JPERLUXO_HELMET = ITEMS.register("jperluxo_helmet", () -> new JPerluxoArmorItem(EquipmentSlotType.HEAD));

  public static final RegistryObject<Item> JPERLUXO_CHESTPLATE = ITEMS.register("jperluxo_chestplate", () -> new JPerluxoArmorItem(EquipmentSlotType.CHEST));

  public static final RegistryObject<Item> JPERLUXO_LEGGINGS = ITEMS.register("jperluxo_leggings", () -> new JPerluxoArmorItem(EquipmentSlotType.LEGS));

  public static final RegistryObject<Item> JPERLUXO_BOOTS = ITEMS.register("jperluxo_boots", () -> new JPerluxoArmorItem(EquipmentSlotType.FEET));

  public static final RegistryObject<Item> JPERLUXO_BANNER_PATTERN = ITEMS.register("jperluxo_banner_pattern", () -> new JPerluxoBannerPatternItem());

  public static final RegistryObject<Item> JPERLUXO_SHARD = ITEMS.register("jperluxo_shard", () -> new Item(new Item.Properties().group(ItemGroup.MISC).rarity(Rarity.RARE).isImmuneToFire().setNoRepair()));

  public static void register(IEventBus bus) {
    ITEMS.register(bus);
  }
}
