package zollernextras.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import zollernextras.lib.M;

public class ModTabs {
	public static CreativeTabs zTab;
	
	public static void init() {
		M.Log("Preparing to load creative tab..");
		zTab = new ZollernTab("Zollern Extras");
		M.Log("Creative tab successfully loaded!");
	}
}