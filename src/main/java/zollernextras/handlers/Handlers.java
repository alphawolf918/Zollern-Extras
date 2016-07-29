package zollernextras.handlers;

import zollernextras.events.EventHandler;
import zollernextras.lib.ZollernHelper;
import zollernextras.managers.WorldGenManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Handlers {
	public static void init() {
		ZollernHelper.Log("Initializing handlers..");
		GameRegistry.registerWorldGenerator(new WorldGenManager(), 40);
		EventHandler.init();
		ZollernHelper.Log("Handlers initialized.");
	}
}