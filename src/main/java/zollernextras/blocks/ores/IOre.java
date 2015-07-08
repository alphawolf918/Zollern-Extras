package zollernextras.blocks.ores;

import net.minecraft.item.ItemStack;

public interface IOre {
	
	public double getFortune();
	
	public int getMaxDropIncrease();
	
	public ItemStack getDroppedItemStack();
}