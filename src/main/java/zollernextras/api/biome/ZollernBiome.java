package zollernextras.api.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;

public abstract class ZollernBiome extends Biome {
	
	protected TempCategory tempBiomeCtg = TempCategory.MEDIUM;
	protected boolean hasMutation = false;
	
	public ZollernBiome(BiomeProperties properties) {
		super(properties);
		// this.setRegistryName(ZollernModInfo.modId, this.getBiomeName());
	}
	
	@Override
	public boolean isMutation() {
		return hasMutation;
	}
	
	public Biome setHasMutation(boolean isMutated) {
		this.hasMutation = isMutated;
		return this;
	}
	
	public Biome clearAllSpawning() {
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		return this;
	}
	
	public Biome setNoRain(Biome.BiomeProperties props) {
		props.setRainfall(0.0F);
		props.setRainDisabled();
		return this;
	}
	
	public Biome setBlocks(Block block) {
		this.setBlocks(block, block);
		return this;
	}
	
	public Biome setBlocks(Block topBlock, Block fillerBlock) {
		this.setTopBlock(topBlock);
		this.setFillerBlock(fillerBlock);
		return this;
	}
	
	public Biome setFillerBlock(Block b) {
		this.fillerBlock = b.getDefaultState();
		return this;
	}
	
	public Block getFillerBlock() {
		return this.fillerBlock.getBlock();
	}
	
	public Biome setTopBlock(Block b) {
		this.topBlock = b.getDefaultState();
		return this;
	}
	
	public Block getTopBlock() {
		return this.topBlock.getBlock();
	}
	
	public Biome setTempCategory(TempCategory tc) {
		this.tempBiomeCtg = tc;
		return this;
	}
	
	@Override
	public TempCategory getTempCategory() {
		return this.tempBiomeCtg;
	}
	
	public static enum Type {
		NORMAL, EXTRA_TREES, MUTATED;
	}
	
}