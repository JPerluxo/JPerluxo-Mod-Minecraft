package com.jperluxo.jperluxomod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("jperluxomod")
public class JPerluxoMod {

  public JPerluxoMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(bus);
  }
}
