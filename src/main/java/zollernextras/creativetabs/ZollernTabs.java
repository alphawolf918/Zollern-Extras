package zollernextras.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import zollernextras.common.CommonRegisterHelper;
import zollernextras.items.ZollernItems;

public class ZollernTabs {
	
	public static CreativeTabs zTab;
	
	public static void init() {
		zTab = CommonRegisterHelper.createCreativeTabs("Zollern Extras",
				new ItemStack(ZollernItems.superChargedCoal));
	}
	
}