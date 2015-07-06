package zollernextras.events;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}
}