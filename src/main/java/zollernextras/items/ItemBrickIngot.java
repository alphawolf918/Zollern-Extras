package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.lib.MainHelper;

public class ItemBrickIngot extends Item {
	public ItemBrickIngot(String color) {
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "brickingot_" + color);
	}
}