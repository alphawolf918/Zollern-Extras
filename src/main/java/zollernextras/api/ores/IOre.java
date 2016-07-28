package zollernextras.api.ores;

import net.minecraft.item.ItemStack;

/**
 * Implement this interface on an ore to register it with this mod's "Fortune"
 * ExtendedPlayer stat.
 * 
 * @author Zollern Wolf
 */
public interface IOre {
	
	/**
	 * Controls how much Fortune stat is increased by.
	 * 
	 * @return
	 */
	public double getFortune();
	
	/**
	 * The max that this ore's drop amount can be increased.
	 * 
	 * @return
	 */
	public int getMaxDropIncrease();
	
	/**
	 * The ItemStack that this ore drops.
	 * 
	 * @return
	 */
	public ItemStack getDroppedItemStack();
}