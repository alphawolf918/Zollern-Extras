package zollernextras.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zollernextras.items.ItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZollernTab extends CreativeTabs {
	public ZollernTab(String tabLabel) {
		super(tabLabel);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ItemList.spcItem;
	}
}