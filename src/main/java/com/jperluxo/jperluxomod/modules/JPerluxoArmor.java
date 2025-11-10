package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import javax.annotation.Nonnull;
import net.minecraft.util.SoundEvents;
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

public class JPerluxoArmor {

  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");

  public static final RegistryObject<Item> JPERLUXO_HELMET = ITEMS.register("jperluxo_helmet", () -> new JPerluxoArmorItem(EquipmentSlotType.HEAD));

  public static final RegistryObject<Item> JPERLUXO_CHESTPLATE = ITEMS.register("jperluxo_chestplate", () -> new JPerluxoArmorItem(EquipmentSlotType.CHEST));

  public static final RegistryObject<Item> JPERLUXO_LEGGINGS = ITEMS.register("jperluxo_leggings", () -> new JPerluxoArmorItem(EquipmentSlotType.LEGS));

  public static final RegistryObject<Item> JPERLUXO_BOOTS = ITEMS.register("jperluxo_boots", () -> new JPerluxoArmorItem(EquipmentSlotType.FEET));

  public static final void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

  public static final class JPerluxoArmorItem extends ArmorItem {

    public JPerluxoArmorItem(EquipmentSlotType slot) {
      super(
        new IArmorMaterial() {
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
        },
        slot,
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
}
