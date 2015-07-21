package zollernextras.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import zollernextras.lib.MainHelper;

public class ModTabs {
	public static CreativeTabs zTab;
	
	public static void init() {
		MainHelper.Log("Preparing to load creative tab..");
		zTab = new ZollernTab("Zollern Extras");
		MainHelper.Log("Creative tab successfully loaded!");
	}
}