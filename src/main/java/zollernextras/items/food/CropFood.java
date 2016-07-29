package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.ZollernHelper;

public class CropFood extends ItemFood {
	public CropFood(String strTexture) {
		super(10, 10, false);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
	}
	
	public CropFood(String strTexture, int hunger, int saturation) {
		super(hunger, saturation, false);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
	}
}