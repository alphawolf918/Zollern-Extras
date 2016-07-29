package zollernextras.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import zollernextras.lib.ZollernHelper;

public class ModTabs {
	public static CreativeTabs zTab;
	
	public static void init() {
		ZollernHelper.Log("Preparing to load creative tab..");
		zTab = new ZollernTab("Zollern Extras");
		ZollernHelper.Log("Creative tab successfully loaded!");
	}
}