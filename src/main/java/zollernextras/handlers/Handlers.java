package zollernextras.handlers;

import zollernextras.events.EventHandler;
import zollernextras.lib.M;
import zollernextras.managers.WorldGenManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Handlers {
	public static void init() {
		M.Log("Initializing handlers..");
		GameRegistry.registerFuelHandler(new FuelHandlers());
		GameRegistry.registerWorldGenerator(new WorldGenManager(), 40);
		EventHandler.init();
		M.Log("Handlers initialized.");
	}
}