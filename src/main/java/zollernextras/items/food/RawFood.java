package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import zollernextras.lib.ZollernHelper;

public class RawFood extends ItemFood {
	public RawFood(String strTexture) {
		super(2, 2F, false);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
		setMaxStackSize(64);
		this.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F);
	}
}