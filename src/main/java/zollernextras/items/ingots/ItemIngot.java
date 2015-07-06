package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.lib.M;

public class ItemIngot extends Item {
	public ItemIngot(String strTexture) {
		M.setTab(this);
		M.setNameAndTexture(this, strTexture);
	}
}