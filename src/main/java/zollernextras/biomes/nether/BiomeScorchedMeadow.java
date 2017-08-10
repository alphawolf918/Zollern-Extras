package zollernextras.biomes.nether;

import net.minecraft.world.biome.Biome;
import zollernextras.biomes.ZollernNetherBiome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.HellRegistry;

public class BiomeScorchedMeadow extends ZollernNetherBiome {
	
	public BiomeScorchedMeadow() {
		super(new Biome.BiomeProperties("Scorched Meadow"), "scorched_meadow");
		this.setBlocks(ZollernBlocks.netherDirt);
		this.setBiomeWeight(21);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
}