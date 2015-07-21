package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.MainHelper;

public class SweetFood extends ItemFood {
	public SweetFood(String par1, int par2) {
		super(6, false);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, par1);
		this.setAlwaysEdible();
		this.setPotionEffect(par2, 360, 4, 100);
	}
}