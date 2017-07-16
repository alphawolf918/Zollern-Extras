package zollernextras.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import zollernextras.config.ZEConfig;
import zollernextras.managers.WorldGenManager;

public class Handlers {
	
	public static void init() {
		GameRegistry.registerWorldGenerator(new WorldGenManager(),
				ZEConfig.worldGenerationWeight);
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
}