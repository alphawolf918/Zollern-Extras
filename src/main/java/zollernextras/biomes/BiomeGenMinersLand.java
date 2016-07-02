package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenMinersLand extends BiomeGenBase {
	public BiomeGenMinersLand(int par1) {
		super(par1);
		this.temperature = 6F;
		this.setBiomeName("Miner's Land");
		this.setColor(BiomeList.biomeColor);
		this.setHeight(height_HighPlateaus);
		this.heightVariation = 2F;
		this.setDisableRain();
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
		this.topBlock = Blocks.stone;
		this.fillerBlock = Blocks.stone;
	}
}