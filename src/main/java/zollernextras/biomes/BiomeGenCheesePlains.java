package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zaneextras.blocks.BlockList;

public class BiomeGenCheesePlains extends BiomeGenBase {
	public BiomeGenCheesePlains(int par1) {
		super(par1);
		this.temperature = 4F;
		this.setBiomeName("Cheese Plains");
		this.setColor(BiomeList.biomeColor);
		this.setHeight(this.height_LowPlains);
		this.createMutation();
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.topBlock = BlockList.cheeseBlock;
		this.fillerBlock = BlockList.cheeseBlock;
	}
}