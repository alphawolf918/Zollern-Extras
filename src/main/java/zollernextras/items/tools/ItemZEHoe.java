package zollernextras.items.tools;

import net.minecraft.item.ItemHoe;
import zollernextras.lib.ZollernHelper;

public class ItemZEHoe extends ItemHoe {
	
	public ItemZEHoe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
	}
	
}