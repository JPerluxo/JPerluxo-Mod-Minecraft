package com.jperluxo.jperluxomod.item;

import net.minecraft.item.BannerPatternItem;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemGroup;

public class JPerluxoBannerPatternItem extends BannerPatternItem {

  public static final BannerPattern JPERLUXO = BannerPattern.create("JPERLUXO", "jperluxo", "jperluxo", true);

  public JPerluxoBannerPatternItem() {
    super(
      JPERLUXO,
      new Item.Properties()
        .maxStackSize(1)
        .rarity(Rarity.EPIC)
        .group(ItemGroup.MISC)
        .isImmuneToFire()
        .setNoRepair());
  }
}
