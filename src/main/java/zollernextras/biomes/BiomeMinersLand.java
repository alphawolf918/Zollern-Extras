package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;

public class BiomeMinersLand extends ZollernBiome {
	
	public BiomeMinersLand(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(6.2F);
		props.setBaseHeight(2.0F);
		props.setHeightVariation(0.5F);
		this.clearAllSpawning();
		this.setNoRain(props);
		this.setTempCategory(TempCategory.WARM);
		this.setBlocks(Blocks.STONE);
	}
	
}