package zollernextras.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernItemFood extends ItemFood {
	
	public ZollernItemFood(String itemName, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		ZollernHelper.setName(this, itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
}