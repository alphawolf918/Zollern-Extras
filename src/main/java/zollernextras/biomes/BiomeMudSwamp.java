package zollernextras.biomes;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;

public class BiomeMudSwamp extends ZollernBiome {
	
	public BiomeMudSwamp(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(5.2F);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.05F);
		this.setWaterColor(0x0000ff);
		this.setNoRain(props);
		this.setTempCategory(TempCategory.WARM);
		this.setBlocks(ZollernBlocks.swampClay);
		this.setGrassAndFoliageColor(0x22bb00);
		this.setSkyColor(0xddd);
		this.theBiomeDecorator.treesPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = 1;
		this.theBiomeDecorator.deadBushPerChunk = 1;
		this.theBiomeDecorator.mushroomsPerChunk = 10;
		this.theBiomeDecorator.reedsPerChunk = 10;
		this.theBiomeDecorator.clayPerChunk = 1;
		this.theBiomeDecorator.waterlilyPerChunk = 4;
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 1, 0, 1));
	}
	
}