package zollernextras.inventory;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import zollernextras.items.storage.ItemQuiver;

public class SlotQuiver extends Slot {
	
	public SlotQuiver(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	// This is the only method we need to override so that
	
	// we can't place our inventory-storing Item within
	
	// its own inventory (thus making it permanently inaccessible)
	
	// as well as preventing abuse of storing backpacks within backpacks
	
	/**
	 * 
	 * Check if the stack is a valid item for this slot.
	 */
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		// Everything returns true except an instance of our Item
		return !(itemstack.getItem() instanceof ItemQuiver && itemstack
				.getItem() == Items.arrow);
	}
}