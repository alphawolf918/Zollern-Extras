package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;

public class BiomeBadLands extends ZollernBiome {
	
	public BiomeBadLands(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(8.2F);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.05F);
		this.setNoRain(props);
		this.setTempCategory(TempCategory.WARM);
		this.setBlocks(ZollernBlocks.badStone);
	}
	
}