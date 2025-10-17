package com.jperluxo.jperluxomod.block;

import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.ActionResultType;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import com.jperluxo.jperluxomod.container.JPerluxoCraftingTableContainer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.TranslationTextComponent;

public class JPerluxoCraftingTableBlock extends CraftingTableBlock {

  public JPerluxoCraftingTableBlock(AbstractBlock.Properties properties) {
    super(properties);
  }

  @Override public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (!worldIn.isRemote) {
      INamedContainerProvider provider = state.getContainer(worldIn, pos);
      if (provider != null && player instanceof ServerPlayerEntity) {
        NetworkHooks.openGui((ServerPlayerEntity) player, provider, pos);
      }
      return ActionResultType.CONSUME;
    } else {
      return ActionResultType.SUCCESS;
    }
  }

  @Override public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
    return new SimpleNamedContainerProvider((id, inventory, player) -> {
      return new JPerluxoCraftingTableContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
    }, new TranslationTextComponent("container.crafting"));
  }
}
