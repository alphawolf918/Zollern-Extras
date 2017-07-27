package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;

public class BiomeUpsideDown extends ZollernBiome {
	
	private int biomeFoliageColor = 0x004400;
	
	public BiomeUpsideDown(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(2.2F);
		props.setRainfall(0.0F);
		props.setRainDisabled();
		props.setBaseHeight(2.0F);
		props.setHeightVariation(0.05F);
		this.setTempCategory(TempCategory.COLD);
		this.setTopBlock(ZollernBlocks.upsideDownSurfaceRock);
		this.setFillerBlock(ZollernBlocks.upsideDownSubRock);
		// TODO: remove all entities from spawning
		// TODO: other things
	}
	
}