package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;

public class BiomeIceDesert extends ZollernBiome {
	
	public BiomeIceDesert(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(1.1F);
		this.setTempCategory(TempCategory.COLD);
		this.setBlocks(ZollernBlocks.coldSand, ZollernBlocks.coldSandSmooth);
	}
	
}