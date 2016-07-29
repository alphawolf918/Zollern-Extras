package zollernextras.items.tools;

import net.minecraft.item.ItemSpade;
import zollernextras.lib.ZollernHelper;

public class ItemZEShovel extends ItemSpade {
	
	public ItemZEShovel(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
	}
	
}