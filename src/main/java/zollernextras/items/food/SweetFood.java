package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.ZollernHelper;

public class SweetFood extends ItemFood {
	public SweetFood(String par1, int par2) {
		super(6, false);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, par1);
		this.setAlwaysEdible();
		this.setPotionEffect(par2, 360, 4, 1.0F);
	}
}