package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class JPerluxoSword {

  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");

  public static final RegistryObject<Item> JPERLUXO_SWORD = ITEMS.register("jperluxo_sword", () -> new JPerluxoSwordItem());

  public static final void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

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

    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      return false;
    }

    @Override public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
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
}
