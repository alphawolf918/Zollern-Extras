package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zanextras.blocks.ZaneBlocks;
import zollernextras.api.biome.ZollernBiome;

public class BiomeCheesePlains extends ZollernBiome {
	
	public BiomeCheesePlains(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(8.2F);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.05F);
		this.setTempCategory(TempCategory.WARM);
		this.setBlocks(ZaneBlocks.cheeseBlock);
	}
	
}