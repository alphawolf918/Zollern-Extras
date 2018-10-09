package zollernextras.biomes.upsidedown;

import net.minecraft.world.biome.Biome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.DimensionRegistry;

public class BiomeCorruption extends ZollernUpsideDownBiome {
	
	public BiomeCorruption() {
		super(new Biome.BiomeProperties("Corruption"), "corruption");
		this.setBlocks(ZollernBlocks.corruptStone);
		this.setBiomeWeight(4);
		DimensionRegistry.addUpsideDownBiome(this, this.getBiomeWeight());
	}
	
}