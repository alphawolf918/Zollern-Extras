package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.M;

public class SweetFood extends ItemFood {
	public SweetFood(String par1, int par2) {
		super(6, false);
		M.setTab(this);
		M.setNameAndTexture(this, par1);
		this.setAlwaysEdible();
		this.setPotionEffect(par2, 360, 4, 100);
	}
}