package zollernextras.items.tools;

import net.minecraft.item.ItemPickaxe;
import zollernextras.lib.MainHelper;

public class ItemZEAxe extends ItemPickaxe {
	
	public ItemZEAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		MainHelper.setTab(this);
	}
	
}