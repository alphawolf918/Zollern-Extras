package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;

public class BiomeMinersLand extends ZollernBiome {
	
	public BiomeMinersLand(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(6.2F);
		props.setRainfall(0.0F);
		props.setRainDisabled();
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.05F);
		this.setTempCategory(TempCategory.WARM);
		this.topBlock = Blocks.STONE.getDefaultState();
		this.fillerBlock = Blocks.STONE.getDefaultState();
	}
	
}