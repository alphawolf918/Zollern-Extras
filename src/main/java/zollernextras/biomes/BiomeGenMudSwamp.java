package zollernextras.biomes;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeGenMudSwamp extends BiomeGenBase {
	
	public BiomeGenMudSwamp(int par1) {
		super(par1);
		this.temperature = 4F;
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Mud Swamp");
		this.theBiomeDecorator.treesPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = 1;
		this.theBiomeDecorator.deadBushPerChunk = 1;
		this.theBiomeDecorator.mushroomsPerChunk = 10;
		this.theBiomeDecorator.reedsPerChunk = 10;
		this.theBiomeDecorator.clayPerChunk = 1;
		this.theBiomeDecorator.waterlilyPerChunk = 4;
		this.waterColorMultiplier = 14745518;
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1,
				1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 1,
				0, 1));
		this.topBlock = BlockList.swampClay;
		this.fillerBlock = BlockList.swampClay;
		this.theBiomeDecorator.waterlilyPerChunk = 2;
	}
	
	@Override
	public int getBiomeFoliageColor(int original, int par2, int par3) {
		return 0x22bb00;
	}
	
	@Override
	public int getBiomeGrassColor(int par1, int par2, int par3) {
		return 0x22bb00;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0xdddddd;
	}
}
