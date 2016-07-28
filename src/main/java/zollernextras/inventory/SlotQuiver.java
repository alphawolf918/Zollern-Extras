package zollernextras.inventory;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.api.items.IArrow;
import zollernextras.items.storage.ItemQuiver;

public class SlotQuiver extends Slot {
	
	public SlotQuiver(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	// 1. Only allow Arrows to be placed inside.
	// 2. Ensure that the Quiver can't be placed within itself.
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		Item item = itemstack.getItem();
		if (!(item instanceof ItemQuiver)) {
			return item == Items.arrow
					|| item.getUnlocalizedName().contains("arrow")
					|| item instanceof IArrow;
		}
		return false;
	}
}