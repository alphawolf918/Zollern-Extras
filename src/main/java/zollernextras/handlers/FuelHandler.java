package zollernextras.handlers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;

public class FuelHandler implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == ZollernItems.superChargedCoal) {
			return 3200;
		} else if (fuel.getItem() == Item.getItemFromBlock(ZollernBlocks.superChargedCoalBlock)) {
			return 28800;
		} else {
			return 0;
		}
	}
	
}