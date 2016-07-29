package zollernextras.biomes;

import java.util.Random;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGenSlimeLands extends BiomeGenBase {
	public BiomeGenSlimeLands(int id) {
		super(id);
		this.waterColorMultiplier = 0x009b00;
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Slime Lands");
		this.temperature = 8F;
		this.rainfall = 2F;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 10,
				8, 10));
		this.topBlock = ZollernBlocks.slimeBlock;
		this.fillerBlock = ZollernBlocks.slimeBlock;
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemById(341);
	}
}