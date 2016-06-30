package zollernextras.items.tools;

import net.minecraft.item.ItemPickaxe;
import zollernextras.lib.MainHelper;

public class ItemZEPickaxe extends ItemPickaxe {
	
	public ItemZEPickaxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		MainHelper.setTab(this);
	}
	
}