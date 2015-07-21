package zollernextras.handlers;

import zollernextras.events.EventHandler;
import zollernextras.lib.MainHelper;
import zollernextras.managers.WorldGenManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Handlers {
	public static void init() {
		MainHelper.Log("Initializing handlers..");
		GameRegistry.registerFuelHandler(new FuelHandlers());
		GameRegistry.registerWorldGenerator(new WorldGenManager(), 40);
		EventHandler.init();
		MainHelper.Log("Handlers initialized.");
	}
}