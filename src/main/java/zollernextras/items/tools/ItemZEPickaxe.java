package zollernextras.items.tools;

import net.minecraft.item.ItemPickaxe;
import zollernextras.lib.ZollernHelper;

public class ItemZEPickaxe extends ItemPickaxe {
	
	public ItemZEPickaxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
	}
	
}