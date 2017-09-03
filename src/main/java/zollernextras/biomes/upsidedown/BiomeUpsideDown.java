package zollernextras.biomes.upsidedown;

import net.minecraft.world.biome.Biome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.DimensionRegistry;

public class BiomeUpsideDown extends ZollernUpsideDownBiome {
	
	public BiomeUpsideDown() {
		super(new Biome.BiomeProperties("Upside-Down"), "upside_down");
		this.setBlocks(ZollernBlocks.upsideDownSurfaceRock,
				ZollernBlocks.witherrack);
		this.setBiomeWeight(86);
		DimensionRegistry.addUpsideDownBiome(this, this.getBiomeWeight());
	}
	
}