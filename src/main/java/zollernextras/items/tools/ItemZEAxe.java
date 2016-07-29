package zollernextras.items.tools;

import net.minecraft.item.ItemPickaxe;
import zollernextras.lib.ZollernHelper;

public class ItemZEAxe extends ItemPickaxe {
	
	public ItemZEAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
	}
	
}