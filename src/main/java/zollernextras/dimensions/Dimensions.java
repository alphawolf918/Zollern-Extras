package zollernextras.dimensions;

import net.minecraftforge.common.DimensionManager;
import zollernextras.dimensions.lostdesert.providers.WorldProviderLostDesert;

public class Dimensions {
	
	public static final int dimId = 36;
	
	public static void init() {
		DimensionManager.registerProviderType(dimId,
				WorldProviderLostDesert.class, false);
		DimensionManager.registerDimension(dimId, dimId);
	}
}