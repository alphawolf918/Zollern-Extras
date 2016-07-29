package zollernextras.lib.modhelper;

import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.common.Loader;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useZaneExtras = false;
	public static boolean useBigReactors = false;
	public static boolean useMineFactoryReloaded = false;
	public static boolean useThermalFoundation = false;
	public static boolean useAppliedEnergistics2 = false;
	
	public static void detectMods() {
		useCofh = isModLoaded("CoFHCore");
		useZaneExtras = isModLoaded("zaneextras");
		useBigReactors = isModLoaded("BigReactors");
		useMineFactoryReloaded = isModLoaded("MineFactoryReloaded");
		useThermalFoundation = isModLoaded("ThermalFoundation");
		useAppliedEnergistics2 = isModLoaded("appliedenergistics2");
	}
	
	public static boolean isModLoaded(String modName) {
		boolean isLoaded = Loader.isModLoaded(modName);
		if (isLoaded) {
			ZollernHelper.Log("Detected mod: " + modName + ".");
		} else {
			ZollernHelper.Log("Could not detect mod: " + modName + ".");
		}
		return isLoaded;
	}
}