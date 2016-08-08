package zollernextras.proxies;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.entity.ExtendedPlayer;
import zollernextras.inventory.ContainerQuiver;
import zollernextras.inventory.GuiQuiver;
import zollernextras.inventory.InventoryQuiver;
import zollernextras.network.PacketDispatcher;
import zollernextras.network.client.SyncPlayerPropsMessage;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy implements IGuiHandler {
	
	/**
	 * Used to store IExtendedEntityProperties data temporarily between player
	 * death and respawn
	 */
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void initRenderers() {
		
	}
	
	public void initGUI() {
		
	}
	
	public Minecraft getMinecraft() {
		return null;
	}
	
	public void sendChatMessage(EntityPlayer player, String message) {
		
	}
	
	public void doPotionEffect(EntityPlayer player, int potionId) {
		
	}
	
	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player,
			World world, int x, int y, int z) {
		if (guiId == ZollernExtrasMod.QUIVER_INV) {
			return new ContainerQuiver(player, player.inventory,
					new InventoryQuiver(player.getHeldItem()));
		} else {
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player,
			World world, int x, int y, int z) {
		if (guiId == ZollernExtrasMod.QUIVER_INV) {
			return new GuiQuiver(player, player.inventory, new InventoryQuiver(
					player.getHeldItem()));
		} else {
			return null;
		}
	}
	
	private static String getSaveKey(EntityPlayer player) {
		return player.getCommandSenderName() + ":"
				+ ExtendedPlayer.EXT_PROP_NAME;
	}
	
	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();
		
		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static void loadProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy
				.getEntityData(getSaveKey(player));
		
		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
		PacketDispatcher.sendTo(new SyncPlayerPropsMessage(player),
				(EntityPlayerMP) player);
	}
	
	/**
	 * Adds an entity's custom data to the map for temporary storage
	 * 
	 * @param compound
	 *            An NBT Tag Compound that stores the IExtendedEntityProperties
	 *            data only
	 */
	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}
	
	/**
	 * Removes the compound from the map and returns the NBT tag stored for name
	 * or null if none exists
	 */
	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
}