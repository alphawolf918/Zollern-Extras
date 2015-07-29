package zollernextras.command;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class Commands {
	public static void init(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandTpd());
		event.registerServerCommand(new CommandWp());
		event.registerServerCommand(new CommandStats());
	}
}