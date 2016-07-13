package zollernextras.command;

import net.minecraft.command.CommandBase;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class Commands {
	
	public static void init(FMLServerStartingEvent event) {
		registerCommand(event, new CommandTpd());
		registerCommand(event, new CommandWp());
		registerCommand(event, new CommandStats());
		registerCommand(event, new CommandHeal());
		registerCommand(event, new CommandWarpTp());
		// event.registerServerCommand(new CommandSetHome());
	}
	
	public static void registerCommand(FMLServerStartingEvent event,
			CommandBase command) {
		String commandName = command.getCommandName();
		event.registerServerCommand(command);
		MainHelper.Log("Command Registered: /" + commandName);
	}
}