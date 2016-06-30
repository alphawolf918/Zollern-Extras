package zollernextras.items.tools;

import net.minecraft.item.ItemSpade;
import zollernextras.lib.MainHelper;

public class ItemZEShovel extends ItemSpade {
	
	public ItemZEShovel(ToolMaterial toolMaterial) {
		super(toolMaterial);
		MainHelper.setTab(this);
	}
	
}