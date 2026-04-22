package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import java.util.Map;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.stats.Stats;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

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

    @Override public boolean isEnchantable(ItemStack stack) {
      return true;
    }

    @Override public int getItemEnchantability() {
      return 25;
    }

    @Override public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
      return enchantment == Enchantments.KNOCKBACK;
    }

    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
      Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(book);
      return enchants.size() == 1 && enchants.containsKey(Enchantments.KNOCKBACK);
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

    @Override public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      if (playerIn.getCooldownTracker().hasCooldown(this)) return ActionResult.resultFail(itemstack);

      if (!worldIn.isRemote) {
        Vector3d look = playerIn.getLookVec();
        worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (worldIn.rand.nextFloat() * 0.4F + 0.8F));
        SmallFireballEntity fireball = new SmallFireballEntity(worldIn, playerIn, look.x * 1.1D, look.y * 1.1D, look.z * 1.1D);
        fireball.setPosition((playerIn.getPosX() + look.x * 1.0D), (playerIn.getPosYEye() - 0.1D + look.y * 1.0D), (playerIn.getPosZ() + look.z * 1.0D));
        worldIn.addEntity(fireball);
      }

      playerIn.addStat(Stats.ITEM_USED.get(this));
      playerIn.getCooldownTracker().setCooldown(this, 20);
      return ActionResult.func_233538_a_(itemstack, worldIn.isRemote);
    }
  }

  @SubscribeEvent
  public static void onPlayerTick(PlayerTickEvent event) {
    if (event.player.world.isRemote) return;
    if (event.phase != TickEvent.Phase.END) return;

    boolean isEquipped = (event.player.getHeldItemMainhand().getItem() == JPERLUXO_STAFF.get()) || (event.player.getHeldItemOffhand().getItem() == JPERLUXO_STAFF.get());
    boolean hasEffect = event.player.getActivePotionEffect(Effects.FIRE_RESISTANCE) != null;

    if (isEquipped && (!hasEffect || (event.player.world.getGameTime() % 80L == 0L))) {
      event.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 220, 0, false, false, true));
    }
  }
}
