package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.MainHelper;

public class TreeFood extends ItemFood {
	
	public TreeFood(String strTexture, int hunger, int saturation) {
		super(hunger, saturation, false);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
	}
}