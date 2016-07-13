package zollernextras.api.ores;

import net.minecraft.item.ItemStack;

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