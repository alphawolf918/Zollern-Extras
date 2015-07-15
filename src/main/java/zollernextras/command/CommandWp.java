package zollernextras.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandWp extends CommandBase implements ICommand {
	
	private final List aliases;
	
	public CommandWp() {
		aliases = new ArrayList();
		aliases.add("playerwarp");
		aliases.add("wp");
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	@Override
	public String getCommandName() {
		return "wp";
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/wp <player>";
	}
	
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (args.length != 1) {
			sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED
					+ "Invalid use of command."));
			return;
		} else {
			EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(sender);
			if (entityplayermp == null) {
				throw new PlayerNotFoundException();
			}
			EntityPlayerMP entityplayermp1 = getPlayer(sender, args[0]);
			if (entityplayermp1 == null) {
				throw new PlayerNotFoundException();
			}
			if (entityplayermp1.worldObj != entityplayermp.worldObj) {
				func_152373_a(sender, this, "commands.tp.notSameDimension",
						new Object[0]);
				return;
			}
			entityplayermp.mountEntity((Entity) null);
			entityplayermp.playerNetServerHandler.setPlayerLocation(
					entityplayermp1.posX, entityplayermp1.posY,
					entityplayermp1.posZ, entityplayermp1.rotationYaw,
					entityplayermp1.rotationPitch);
			sender.addChatMessage(new ChatComponentText(
					EnumChatFormatting.GREEN + "Successfully warped to Player "
							+ EnumChatFormatting.GOLD + args[0]
							+ EnumChatFormatting.WHITE + "."));
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		return true;
	}
	
	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_,
			String[] p_71516_2_) {
		return p_71516_2_.length != 1 && p_71516_2_.length != 2 ? null
				: getListOfStringsMatchingLastWord(p_71516_2_, MinecraftServer
						.getServer().getAllUsernames());
	}
	
	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return p_82358_2_ == 0;
	}
}