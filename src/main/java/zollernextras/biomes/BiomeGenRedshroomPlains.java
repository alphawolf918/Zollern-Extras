package zollernextras.biomes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGenRedshroomPlains extends BiomeGenBase {
	public BiomeGenRedshroomPlains(int id) {
		super(id);
		this.waterColorMultiplier = 0xdd00ff;
		this.setColor(BiomeList.biomeColor);
		this.temperature = 4F;
		this.spawnableMonsterList.clear();
		this.setBiomeName("Redshroom Plains");
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(
				EntityMooshroom.class, 5, 6, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class,
				1, 1, 2));
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 2;
		this.theBiomeDecorator.bigMushroomsPerChunk = 5;
		this.topBlock = ZollernBlocks.redShroomBlock;
		this.fillerBlock = ZollernBlocks.redShroomStem;
	}
}
