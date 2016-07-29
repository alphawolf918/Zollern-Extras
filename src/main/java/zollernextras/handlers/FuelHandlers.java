package zollernextras.handlers;

import net.minecraft.item.ItemStack;
import zollernextras.items.ZollernItems;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandlers implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == ZollernItems.spcItem) {
			return 102400;
		} else {
			return 0;
		}
	}
}