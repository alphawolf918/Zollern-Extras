package zollernextras.lib.modhelper;

import net.minecraftforge.fml.common.Loader;
import zollernextras.lib.ZollernHelper;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useThermalExpansion = false;
	public static boolean useThermalFoundation = false;
	public static boolean useThermalDynamics = false;
	public static boolean useZaneExtras = false;
	public static boolean useExtremeReactors = false;
	public static boolean useNatura = false;
	
	public static void detectMods() {
		useCofh = isModLoaded("cofhcore");
		useThermalExpansion = isModLoaded("thermalexpansion");
		useThermalFoundation = isModLoaded("thermalfoundation");
		useThermalDynamics = isModLoaded("thermaldynamics");
		useZaneExtras = isModLoaded("zanextras");
		useExtremeReactors = isModLoaded("bigreactors");
		useNatura = isModLoaded("natura");
	}
	
	public static boolean isModLoaded(String modId) {
		boolean isLoaded = Loader.isModLoaded(modId);
		String strDetectedMod = (isLoaded) ? "Detected mod: " + modId
				: "Could not detect mod: " + modId;
		ZollernHelper.logInfo(strDetectedMod);
		return isLoaded;
	}
	
}