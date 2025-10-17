package com.jperluxo.jperluxomod.core;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import com.jperluxo.jperluxomod.block.JPerluxoCraftingTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "jperluxomod");

  public static final RegistryObject<Block> JPERLUXO_CRAFTING_TABLE = BLOCKS.register("jperluxo_crafting_table", () -> new JPerluxoCraftingTableBlock(AbstractBlock.Properties.from(Blocks.CRAFTING_TABLE)));

  public static void register(IEventBus bus) {
    BLOCKS.register(bus);
  }
}
