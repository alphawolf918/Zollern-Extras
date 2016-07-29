package zollernextras.command;

import net.minecraft.command.CommandBase;
import zollernextras.config.ZEConfig;
import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class Commands {
	
	public static void init(FMLServerStartingEvent event) {
		registerCommand(event, new CommandTpd());
		registerCommand(event, new CommandWp());
		registerCommand(event, new CommandStats());
		registerCommand(event, new CommandHeal());
		if (ZEConfig.commandEnableWarpTp) {
			registerCommand(event, new CommandWarpTp());
		}
		// event.registerServerCommand(new CommandSetHome());
	}
	
	public static void registerCommand(FMLServerStartingEvent event,
			CommandBase command) {
		String commandName = command.getCommandName();
		event.registerServerCommand(command);
		ZollernHelper.Log("Command Registered: /" + commandName);
	}
}