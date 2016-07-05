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

public class CommandHeal extends CommandBase implements ICommand {
	
	private final List aliases;
	
	public CommandHeal() {
		aliases = new ArrayList();
		aliases.add("heal");
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
		return "heal";
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/heal";
	}
	
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] str) {
		if (!sender.getEntityWorld().isRemote && sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			if (!(sender instanceof EntityPlayer)) {
				sendChatMessage(sender, EnumChatFormatting.RED
						+ "Only online Players may use this command.");
				return;
			}
			player.getFoodStats().setFoodLevel(20);
			player.getFoodStats().setFoodSaturationLevel(5.0F);
			ExtendedPlayer props = ExtendedPlayer.get(player);
			double maxHealth = props.getMaxHealth();
			player.setHealth((float) maxHealth);
			sendChatMessage(sender, "You have been fully healed.");
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