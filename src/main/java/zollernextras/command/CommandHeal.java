package zollernextras.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import zollernextras.entity.ExtendedPlayer;
import zollernextras.lib.ModInfo;

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
		return "/heal [player]";
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
			if (str.length <= 0) {
				// player.getFoodStats().setFoodLevel(20);
				// player.getFoodStats().setFoodSaturationLevel(5.0F);
				
				NBTTagCompound nbtHunger = new NBTTagCompound();
				nbtHunger.setInteger("foodLevel", 20);
				nbtHunger.setInteger("foodTickTimer", 0);
				nbtHunger.setFloat("foodSaturationLevel", 0.5F);
				nbtHunger.setFloat("foodExhaustionLevel", 0.0F);
				player.writeEntityToNBT(nbtHunger);
				ExtendedPlayer props = ExtendedPlayer.get(player);
				double maxHealth = props.getMaxHealth();
				player.setHealth((float) maxHealth);
				sendChatMessage(sender, "You have been fully healed.");
			} else if (str.length == 1) {
				EntityPlayerMP playerMP;
				String otherPlayerName = str[0];
				playerMP = getPlayer(sender, otherPlayerName);
				if (playerMP == null) {
					throw new PlayerNotFoundException();
				}
				playerMP.getFoodStats().setFoodLevel(20);
				playerMP.getFoodStats().setFoodSaturationLevel(5.0F);
				ExtendedPlayer props = ExtendedPlayer.get(playerMP);
				double maxHealth = props.getMaxHealth();
				playerMP.setHealth((float) maxHealth);
				playerMP.addChatMessage(new ChatComponentText(
						"You have been fully healed by "
								+ sender.getCommandSenderName()));
				player.addChatMessage(new ChatComponentText(otherPlayerName
						+ " has been fully healed."));
			} else {
				throw new WrongUsageException(ModInfo.MODID
						+ "_commands.heal.usage", new Object[0]);
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
		return p_71516_2_.length != 1 && p_71516_2_.length != 2 ? null
				: getListOfStringsMatchingLastWord(p_71516_2_, MinecraftServer
						.getServer().getAllUsernames());
	}
	
	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return p_82358_2_ == 0;
	}
}