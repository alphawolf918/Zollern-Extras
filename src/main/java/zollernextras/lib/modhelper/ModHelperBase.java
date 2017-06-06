package zollernextras.lib.modhelper;

import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.common.Loader;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useThermalFoundation = false;
	public static boolean useThermalExpansion = false;
	public static boolean useThermalDynamics = false;
	public static boolean useNetherOres = false;
	public static boolean useZaneExtras = false;
	public static boolean useBigReactors = false;
	public static boolean useMineFactoryReloaded = false;
	public static boolean useAppliedEnergistics2 = false;
	public static boolean usePlayerAPI = false;
	public static boolean useWeaponMod = false;
	public static boolean useZombieMutation = false;
	
	public static void detectMods() {
		useCofh = isModLoaded("CoFHCore");
		useThermalFoundation = isModLoaded("ThermalFoundation");
		useThermalExpansion = isModLoaded("ThermalExpansion");
		useThermalDynamics = isModLoaded("ThermalDynamics");
		useNetherOres = isModLoaded("NetherOres");
		useZaneExtras = isModLoaded("zaneextras");
		useBigReactors = isModLoaded("BigReactors");
		useMineFactoryReloaded = isModLoaded("MineFactoryReloaded");
		useAppliedEnergistics2 = isModLoaded("appliedenergistics2");
		usePlayerAPI = isModLoaded("PlayerAPI");
		useWeaponMod = isModLoaded("weaponmod");
		useZombieMutation = isModLoaded("zombiemutation");
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