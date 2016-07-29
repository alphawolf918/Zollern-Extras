package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGenGrandCanyon extends BiomeGenBase {
	
	public BiomeGenGrandCanyon(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x000099;
		this.temperature = 6F;
		this.rainfall = 0.40F;
		this.setHeight(height_HighPlateaus);
		this.setBiomeName("Grand Canyon");
		this.setColor(BiomeList.biomeColor);
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.mushroomsPerChunk = 1;
		this.spawnableCreatureList.clear();
		this.topBlock = ZollernBlocks.canyonRock;
		this.fillerBlock = ZollernBlocks.canyonRock;
	}
}