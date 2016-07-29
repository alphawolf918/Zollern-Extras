package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.lib.ZollernHelper;

public class ItemIngot extends Item {
	public ItemIngot(String strTexture) {
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
	}
}