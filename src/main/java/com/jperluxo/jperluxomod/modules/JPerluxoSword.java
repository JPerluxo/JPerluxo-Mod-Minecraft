package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

public class JPerluxoSword {

  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");

  public static final RegistryObject<Item> JPERLUXO_SWORD = ITEMS.register("jperluxo_sword", () -> new JPerluxoSwordItem());

  public static final void register() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    MinecraftForge.EVENT_BUS.register(JPerluxoSword.class);
  }

  public static final class JPerluxoSwordItem extends SwordItem {

    public JPerluxoSwordItem() {
      super(
        new IItemTier() {
          @Override public int getMaxUses() { return 100_000; }
          @Override public float getEfficiency() { return 14.0F; }
          @Override public float getAttackDamage() { return 5.0F; }
          @Override public int getHarvestLevel() { return 4; }
          @Override public int getEnchantability() { return 25; }
          @Override public Ingredient getRepairMaterial() { return Ingredient.EMPTY; }
        },
        10,
        -2.4F,
        new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC).isImmuneToFire().setNoRepair()
      );
    }

    @Override public boolean isDamageable() {
      return false;
    }

    @OnlyIn(Dist.CLIENT)
    @Override public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      tooltip.add(this.getDescription().mergeStyle(new TextFormatting[]{TextFormatting.GRAY, TextFormatting.ITALIC}));
    }

    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getDescription() {
      return new TranslationTextComponent(this.getTranslationKey() + ".desc");
    }
  }

  @SubscribeEvent
  public static void onPlayerTick(PlayerTickEvent event) {
    if (event.player.world.isRemote) return;
    if (event.phase != TickEvent.Phase.END) return;

    boolean isEquipped = event.player.getHeldItemMainhand().getItem() == JPERLUXO_SWORD.get();
    boolean hasEffect = event.player.getActivePotionEffect(Effects.STRENGTH) != null;

    if (isEquipped && (!hasEffect || (event.player.world.getGameTime() % 80L == 0L))) {
      event.player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 220, 1, false, false, true));
    }
  }
}
