package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGrandCanyon extends ZollernBiome {
	
	public BiomeGrandCanyon(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(9.2F);
		props.setBaseHeight(1.6F);
		props.setHeightVariation(0.5F);
		this.setNoRain(props);
		this.setTempCategory(TempCategory.WARM);
		this.setBlocks(ZollernBlocks.canyonRock);
	}
	
}