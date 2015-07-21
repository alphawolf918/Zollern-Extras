package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.lib.MainHelper;

public class ItemIngot extends Item {
	public ItemIngot(String strTexture) {
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
	}
}