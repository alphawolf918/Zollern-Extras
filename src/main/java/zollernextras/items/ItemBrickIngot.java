package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.lib.ZollernHelper;

public class ItemBrickIngot extends Item {
	public ItemBrickIngot(String color) {
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "brickingot_" + color);
	}
}