package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeGenRedRockMountains extends BiomeGenBase {
	public BiomeGenRedRockMountains(int par1) {
		super(par1);
		this.temperature = 9F;
		this.setDisableRain();
		this.setBiomeName("Redrock Mountains");
		this.topBlock = BlockList.redRock;
		this.fillerBlock = BlockList.redRock;
	}
}