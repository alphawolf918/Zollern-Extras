package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.lib.M;

public class ItemBrickIngot extends Item {
	public ItemBrickIngot(String color) {
		M.setTab(this);
		M.setNameAndTexture(this, "brickingot_" + color);
	}
}