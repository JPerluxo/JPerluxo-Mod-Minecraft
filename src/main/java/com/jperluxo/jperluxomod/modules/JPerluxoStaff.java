package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class JPerluxoStaff {

  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");

  public static final RegistryObject<Item> JPERLUXO_STAFF = ITEMS.register("jperluxo_staff", () -> new JPerluxoStaffItem());

  public static final void register() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    MinecraftForge.EVENT_BUS.register(JPerluxoStaff.class);
  }

  public static final class JPerluxoStaffItem extends Item {

    public JPerluxoStaffItem() {
      super(new Item.Properties().maxStackSize(1).group(ItemGroup.COMBAT).rarity(Rarity.EPIC).isImmuneToFire());
    }

    @Override public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      return !player.isCreative();
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
