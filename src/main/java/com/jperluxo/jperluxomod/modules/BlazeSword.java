package com.jperluxo.jperluxomod.modules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.particles.ParticleTypes;

public class BlazeSword {

  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jperluxomod");

  public static final RegistryObject<Item> BLAZE_SWORD = ITEMS.register("blaze_sword", () -> new BlazeSwordItem());

  public static final void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

  public static final class BlazeSwordItem extends SwordItem {

    public BlazeSwordItem() {
      super(
        new IItemTier() {
          @Override public int getMaxUses() { return 4062; }
          @Override public float getEfficiency() { return 14.0F; }
          @Override public float getAttackDamage() { return 5.0F; }
          @Override public int getHarvestLevel() { return 4; }
          @Override public int getEnchantability() { return 0; }
          @Override public Ingredient getRepairMaterial() { return Ingredient.fromItems(Items.BLAZE_POWDER); }
        },
        10,
        -2.4F,
        new Item.Properties().group(ItemGroup.COMBAT).rarity(Rarity.EPIC).isImmuneToFire()
      );
    }

    @Override public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      if (!attacker.world.isRemote) {
        ((ServerWorld) attacker.world).spawnParticle(ParticleTypes.FLAME, target.getPosX(), target.getPosY() + 1.0D, target.getPosZ(), 8, 0.3D, 0.3D, 0.3D, 0.02D);
        if (!target.isBurning()) target.setFire(10);
      }

      return super.hitEntity(stack, target, attacker);
    }
  }
}
