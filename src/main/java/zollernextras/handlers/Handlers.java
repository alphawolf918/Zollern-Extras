package zollernextras.handlers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollernextras.config.ZEConfig;
import zollernextras.events.ZollernEventManager;
import zollernextras.managers.WorldGenManager;

public class Handlers {
	
	public static void init() {
		GameRegistry.registerWorldGenerator(new WorldGenManager(),
				ZEConfig.worldGenerationWeight);
		GameRegistry.registerFuelHandler(new FuelHandler());
		MinecraftForge.EVENT_BUS.register(new ZollernEventManager());
	}
}