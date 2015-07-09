package zollernextras.proxies;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.inventory.ContainerQuiver;
import zollernextras.inventory.GuiQuiver;
import zollernextras.inventory.InventoryQuiver;
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
	
	public void initSounds() {
		
	}
	
	public void initGUI() {
		
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