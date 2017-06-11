package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGenUpsideDown extends BiomeGenBase {
	
	public int foliageColor = 0x55aa55;
	
	public BiomeGenUpsideDown(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x000;
		this.setColor(BiomeList.biomeColor);
		this.rootHeight = 2F;
		this.theBiomeDecorator.generateLakes = false;
		this.setDisableRain();
		this.setBiomeName("Upside-Down");
		this.setHeight(new Height(2.0F, 1.9F));
		this.temperature = 1F;
		this.topBlock = ZollernBlocks.upsideDownSurfaceRock;
		this.fillerBlock = ZollernBlocks.upsideDownRock;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}
	
	@Override
	public float getSpawningChance() {
		return 2.0F;
	}
	
	@Override
	public int getBiomeFoliageColor(int original, int par2, int par3) {
		return this.foliageColor;
	}
	
	@Override
	public int getBiomeGrassColor(int par1, int par2, int par3) {
		return this.foliageColor;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x44aa44;
	}
}