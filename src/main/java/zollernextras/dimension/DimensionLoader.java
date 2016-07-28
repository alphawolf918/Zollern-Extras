package zollernextras.dimension;

import net.minecraftforge.common.DimensionManager;
import zollernextras.config.ZEConfig;
import zollernextras.dimension.upsidedown.providers.WorldProviderUpsideDown;
import zollernextras.lib.MainHelper;

public class DimensionLoader {
	
	private static int dimId = ZEConfig.dimensionUpsideDownID;
	
	public static void init() {
		MainHelper.Log("Loading dimensions..");
		DimensionManager.registerProviderType(dimId,
				WorldProviderUpsideDown.class, false);
		DimensionManager.registerDimension(dimId, dimId);
		MainHelper.Log("Loaded dimension \"Upside-Down\" with ID: " + dimId);
	}
	
	public static int getDimID() {
		return dimId;
	}
	
}