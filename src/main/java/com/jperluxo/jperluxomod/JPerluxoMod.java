package com.jperluxo.jperluxomod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.jperluxo.jperluxomod.core.*;

@Mod("jperluxomod")
public class JPerluxoMod {

  public JPerluxoMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    ModBlocks.register(bus);
    ModItems.register(bus);
  }
}
