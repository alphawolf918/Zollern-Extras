package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeTropicalForest extends BiomeGenBase {
	
	public BiomeTropicalForest(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x3399ff;
		this.temperature = 5F;
		this.setBiomeName("Tropical Forest");
		this.setColor(BiomeList.biomeColor);
		this.rainfall = 6F;
		this.theBiomeDecorator.flowersPerChunk = 4;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = 2;
		this.theBiomeDecorator.sandPerChunk = 2;
		this.theBiomeDecorator.sandPerChunk2 = 2;
		this.theBiomeDecorator.mushroomsPerChunk = 1;
		this.theBiomeDecorator.bigMushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = 4;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = BlockList.betterGrass;
		this.fillerBlock = Blocks.dirt;
	}
	
	@Override
	public int getBiomeGrassColor(int par1, int par2, int par3) {
		return 0x00ff00;
	}
	
	@Override
	public int getBiomeFoliageColor(int original, int par2, int par3) {
		return 0x00ff00;
	}
}