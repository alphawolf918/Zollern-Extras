package zollernextras.items.ingots;

import net.minecraft.item.Item;
import zollernextras.lib.MainHelper;

public class Gem extends Item {
	public Gem(String name) {
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, name);
	}
}