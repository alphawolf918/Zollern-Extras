package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMinersLand extends Biome {
	
	public BiomeMinersLand(Biome.BiomeProperties props) {
		super(props);
		props.setBaseBiome("miners_land");
		props.setTemperature(6.2F);
		props.setRainfall(0.0F);
		props.setRainDisabled();
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.005F);
		this.topBlock = Blocks.STONE.getDefaultState();
		this.fillerBlock = Blocks.STONE.getDefaultState();
	}
	
}