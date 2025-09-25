package com.jperluxo.jperluxomod.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.item.DyeColor;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import java.util.Arrays;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import java.util.List;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.MerchantOffer;

@Mod.EventBusSubscriber(modid = "jperluxomod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

  public static final BannerPattern JPERLUXO = BannerPattern.create("JPERLUXO", "jperluxo", "jperluxo", false);

  public static ItemStack createJPerluxoBanner() {
    ItemStack stack = new ItemStack(Items.BLACK_BANNER);
    CompoundNBT blockEntityTag = stack.getOrCreateChildTag("BlockEntityTag");
    ListNBT patterns = (new BannerPattern.Builder()).setPatternWithColor(JPERLUXO, DyeColor.BLUE).buildNBT();

    blockEntityTag.put("Patterns", patterns);
    stack.func_242395_a(ItemStack.TooltipDisplayFlags.ADDITIONAL);
    stack.setDisplayName(new TranslationTextComponent("item.jperluxomod.jperluxo_banner"));
    return stack;
  }

  @SubscribeEvent
  public static void onVillagerTrades(VillagerTradesEvent event) {
    if (Arrays.asList(VillagerProfession.ARMORER, VillagerProfession.WEAPONSMITH).contains(event.getType())) {
      List<ITrade> noviceTrades = event.getTrades().get(1);

      noviceTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ModItems.JPERLUXO_SHARD.get(), 1), 12, 1, 0));
    }

    if (event.getType() == VillagerProfession.SHEPHERD) {
      List<ITrade> noviceTrades = event.getTrades().get(1);

      noviceTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(ModItems.JPERLUXO_SHARD.get(), 3), createJPerluxoBanner(), 16, 1, 0));
    }
  }
}
