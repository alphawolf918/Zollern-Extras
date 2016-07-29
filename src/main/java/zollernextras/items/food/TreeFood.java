package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.ZollernHelper;

public class TreeFood extends ItemFood {
	
	public TreeFood(String strTexture, int hunger, int saturation) {
		super(hunger, saturation, false);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
	}
}