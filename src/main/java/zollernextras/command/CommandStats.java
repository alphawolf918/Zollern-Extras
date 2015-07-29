package zollernextras.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import zollernextras.entity.ExtendedPlayer;

public class CommandStats extends CommandBase implements ICommand {
	
	private final List aliases;
	
	public CommandStats() {
		aliases = new ArrayList();
		aliases.add("stats");
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
		return "stats";
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/stats";
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
			ExtendedPlayer props = ExtendedPlayer.get(player);
			int powerLevel = props.getLevel();
			double maxHealth = props.getMaxHealth();
			double maxJump = props.getMaxJump();
			double maxFallResistance = props.getFallResistance();
			double maxDefense = props.getMaxDefense();
			double maxDamage = props.getMaxDamage();
			double maxFortune = props.getMaxFortune();
			double maxIntelligence = props.getMaxIntelligence();
			double maxSmelting = props.getMaxSmelting();
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Power Level: "
					+ EnumChatFormatting.WHITE + powerLevel);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Max Health: "
					+ EnumChatFormatting.WHITE + maxHealth);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Max Jump: "
					+ EnumChatFormatting.WHITE + maxJump);
			sendChatMessage(sender, EnumChatFormatting.GOLD
					+ "Fall Resistance: " + EnumChatFormatting.WHITE
					+ maxFallResistance);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Max Defense: "
					+ EnumChatFormatting.WHITE + maxDefense);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Max Damage: "
					+ EnumChatFormatting.WHITE + maxDamage);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Fortune: "
					+ EnumChatFormatting.WHITE + maxFortune);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Intelligence: "
					+ EnumChatFormatting.WHITE + maxIntelligence);
			sendChatMessage(sender, EnumChatFormatting.GOLD + "Smelting: "
					+ EnumChatFormatting.WHITE + maxSmelting);
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