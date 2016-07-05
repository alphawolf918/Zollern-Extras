package zollernextras.lib.modhelper;

import zollernextras.lib.MainHelper;
import cpw.mods.fml.common.Loader;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useZaneExtras = false;
	
	public static void detectMods() {
		useCofh = isModLoaded("CoFHCore");
		useZaneExtras = isModLoaded("zaneextras");
	}
	
	public static boolean isModLoaded(String modName) {
		boolean isLoaded = Loader.isModLoaded(modName);
		if (isLoaded) {
			MainHelper.Log("Detected mod: " + modName + ".");
		}
		return isLoaded;
	}
}