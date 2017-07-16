package zollernextras.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		// if (fuel.getItem() == ZollernItems.spcItem) {
		// return 102400;
		// } else {
		// return 0;
		// }
		return 0;
	}
	
}