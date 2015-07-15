package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.M;

public class CropFood extends ItemFood {
	public CropFood(String strTexture) {
		super(10, 10, false);
		M.setTab(this);
		M.setNameAndTexture(this, strTexture);
	}
}