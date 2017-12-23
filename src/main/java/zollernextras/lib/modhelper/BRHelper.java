package zollernextras.lib.modhelper;

import erogenousbeef.bigreactors.api.registry.TurbineCoil;

public class BRHelper {
	
	public static void init() {
		TurbineCoil.registerBlock("blockFueltonium", 2.5f, 1.0f, 2.4f);
		TurbineCoil.registerBlock("blockZollernium", 2.9f, 1.02f, 2.9f);
		TurbineCoil.registerBlock("blockChargium", 4.0f, 1.04f, 3.0f);
	}
	
}