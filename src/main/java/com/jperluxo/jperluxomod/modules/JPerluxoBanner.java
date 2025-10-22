package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.common.MinecraftForge;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.item.DyeColor;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import java.util.List;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.MerchantOffer;

public class JPerluxoBanner {

  public static void register() {
    MinecraftForge.EVENT_BUS.register(JPerluxoBanner.class);
  }

  public static final BannerPattern JPERLUXO = BannerPattern.create("JPERLUXO", "jperluxo", "jperluxo", false);

  public static ItemStack createJPerluxoBanner() {
    ItemStack stack = new ItemStack(Items.BLACK_BANNER);
    CompoundNBT blockEntityTag = stack.getOrCreateChildTag("BlockEntityTag");
    ListNBT patterns = (new BannerPattern.Builder()).setPatternWithColor(JPERLUXO, DyeColor.BLUE).buildNBT();

    blockEntityTag.put("Patterns", patterns);
    stack.func_242395_a(ItemStack.TooltipDisplayFlags.ADDITIONAL);
    stack.setDisplayName(new TranslationTextComponent("item.jperluxomod.jperluxo_banner").setStyle(Style.EMPTY.setFormatting(TextFormatting.LIGHT_PURPLE).setItalic(false)));
    return stack;
  }

  @SubscribeEvent
  public static void onVillagerTrades(VillagerTradesEvent event) {
    if (event.getType() == VillagerProfession.SHEPHERD) {
      List<ITrade> noviceTrades = event.getTrades().get(1);

      noviceTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), createJPerluxoBanner(), 16, 1, 0));
    }
  }
}
