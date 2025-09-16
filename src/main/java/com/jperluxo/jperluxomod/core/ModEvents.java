package com.jperluxo.jperluxomod.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import java.util.Arrays;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import java.util.List;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

@Mod.EventBusSubscriber(modid = "jperluxomod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

  @SubscribeEvent
  public static void onVillagerTrades(VillagerTradesEvent event) {
    if (Arrays.asList(VillagerProfession.ARMORER, VillagerProfession.WEAPONSMITH).contains(event.getType())) {
      List<ITrade> noviceTrades = event.getTrades().get(1);

      noviceTrades.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ModItems.JPERLUXO_SHARD.get(), 1), 12, 1, 0));
    }
  }
}
