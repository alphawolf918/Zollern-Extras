package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.lib.M;

public class Gem extends Item {
	public Gem(String name) {
		M.setTab(this);
		M.setNameAndTexture(this, name);
	}
}