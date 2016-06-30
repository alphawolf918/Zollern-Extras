package zollernextras.items.tools;

import net.minecraft.item.ItemHoe;
import zollernextras.lib.MainHelper;

public class ItemZEHoe extends ItemHoe {
	
	public ItemZEHoe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		MainHelper.setTab(this);
	}
	
}