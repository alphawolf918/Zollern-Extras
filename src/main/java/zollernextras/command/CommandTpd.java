package zollernextras.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class CommandTpd extends CommandBase implements ICommand {
	
	private final List aliases;
	
	public CommandTpd() {
		aliases = new ArrayList();
		aliases.add("tpd");
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 4;
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return "tpd";
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/tpd <dimID>";
	}
	
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] str) {
		if (!sender.getEntityWorld().isRemote) {
			EntityPlayer player = (EntityPlayer) sender;
			if (player.worldObj.getWorldInfo().areCommandsAllowed()) {
				if (player.capabilities.isCreativeMode) {
					if (str.length == 0) {
						sender.addChatMessage(new ChatComponentText(
								"Invalid use of command."));
						return;
					} else if (str.length >= 1) {
						int dimId = Integer.parseInt(str[0]);
						player.travelToDimension(dimId);
						sender.addChatMessage(new ChatComponentText(
								"Successfully traveled to dimension " + dimId));
					}
				} else {
					sender.addChatMessage(new ChatComponentText(
							"You must be in Creative Mode to use this command."));
					return;
				}
			} else {
				sender.addChatMessage(new ChatComponentText(
						"Commands are not allowed on this world."));
				return;
			}
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
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