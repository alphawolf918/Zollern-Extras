package zollernextras.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import zollernextras.lib.ZollernModInfo;

public class CommandWarpTp extends CommandBase implements ICommand {
	
	private final List aliases;
	
	public CommandWarpTp() {
		aliases = new ArrayList();
		aliases.add("warptp");
		aliases.add("wtp");
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return "warptp";
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/wtp <x> <y> <z>";
	}
	
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (args.length != 3) {
			throw new WrongUsageException(ZollernModInfo.MODID
					+ "_commands.warptp.usage", new Object[0]);
		} else {
			EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(sender);
			if (entityplayermp == null) {
				throw new PlayerNotFoundException();
			}
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			double z = Double.parseDouble(args[2]);
			float rotationPitch = Float.valueOf(entityplayermp.rotationPitch);
			float rotationYaw = Float.valueOf(entityplayermp.rotationYaw);
			entityplayermp.playerNetServerHandler.setPlayerLocation(x, y, z,
					rotationPitch, rotationYaw);
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		return true;
	}
	
	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_,
			String[] p_71516_2_) {
		return null;
	}
	
	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return false;
	}
}