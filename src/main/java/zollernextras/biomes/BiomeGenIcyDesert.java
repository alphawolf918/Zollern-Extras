package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeGenIcyDesert extends BiomeGenBase {
	
	public BiomeGenIcyDesert(int p_i1971_1_) {
		super(p_i1971_1_);
		this.waterColorMultiplier = 0x0099ff;
		this.setBiomeName("Icy Desert");
		this.setEnableSnow();
		this.temperature = 0F;
		this.rainfall = 0.5F;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.topBlock = BlockList.icySand;
		this.fillerBlock = BlockList.icyStone;
	}
}