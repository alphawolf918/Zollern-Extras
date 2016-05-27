package zollernextras.command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import zollernextras.ZollernExtrasMod;

public class CommandSetHome extends CommandBase implements ICommand {
	
	private final List aliases;
	private final String name = "sethome";
	
	public CommandSetHome() {
		aliases = new ArrayList();
		aliases.add(this.name);
		aliases.add("sh");
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return this.name;
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/" + this.name;
	}
	
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] str) {
		if (!sender.getEntityWorld().isRemote) {
			EntityPlayer player = (EntityPlayer) sender;
			if (!(sender instanceof EntityPlayer)) {
				sendChatMessage(sender, EnumChatFormatting.RED
						+ "Only online Players may use this command.");
				return;
			}
			String senderName = sender.getCommandSenderName();
			double playerX = player.posX;
			double playerY = player.posY;
			double playerZ = player.posZ;
			String fullString = senderName + "=" + playerX + " " + playerY
					+ " " + playerZ;
			// TODO
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader(
						ZollernExtrasMod.INSTANCE.filePath + "Homes.txt"));
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendChatMessage(ICommandSender sender, String str) {
		sender.addChatMessage(new ChatComponentText(str));
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