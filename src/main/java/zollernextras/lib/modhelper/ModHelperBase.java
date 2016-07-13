package zollernextras.lib.modhelper;

import zollernextras.lib.MainHelper;
import cpw.mods.fml.common.Loader;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useZaneExtras = false;
	public static boolean useBigReactors = false;
	
	public static void detectMods() {
		useCofh = isModLoaded("CoFHCore");
		useZaneExtras = isModLoaded("zaneextras");
		useBigReactors = isModLoaded("BigReactors");
	}
	
	public static boolean isModLoaded(String modName) {
		boolean isLoaded = Loader.isModLoaded(modName);
		if (isLoaded) {
			MainHelper.Log("Detected mod: " + modName + ".");
		} else {
			MainHelper.Log("Could not detect mod: " + modName + ".");
		}
		return isLoaded;
	}
}