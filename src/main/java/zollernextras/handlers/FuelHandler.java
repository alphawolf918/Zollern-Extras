package zollernextras.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import zollernextras.items.ZollernItems;

public class FuelHandler implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == ZollernItems.superChargedCoal) {
			return 102400;
		} else {
			return 0;
		}
	}
	
}