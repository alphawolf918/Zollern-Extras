package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.MainHelper;

public class CropFood extends ItemFood {
	public CropFood(String strTexture) {
		super(10, 10, false);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
	}
	
	public CropFood(String strTexture, int hunger, int saturation) {
		super(hunger, saturation, false);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
	}
}