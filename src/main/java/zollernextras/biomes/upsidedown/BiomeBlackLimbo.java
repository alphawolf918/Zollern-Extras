package zollernextras.biomes.upsidedown;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.dimensions.DimensionRegistry;

public class BiomeBlackLimbo extends ZollernUpsideDownBiome {
	
	public BiomeBlackLimbo() {
		super(new Biome.BiomeProperties("Black Limbo"), "black_limbo");
		this.setBlocks(Blocks.OBSIDIAN);
		this.setBiomeWeight(24);
		DimensionRegistry.addUpsideDownBiome(this, this.getBiomeWeight());
	}
	
}