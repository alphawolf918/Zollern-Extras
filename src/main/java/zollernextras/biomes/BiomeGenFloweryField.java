package zollernextras.biomes;

import java.util.ArrayList;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeGenFloweryField extends BiomeGenBase {
	
	public ArrayList<FlowerEntry> flowerList = new ArrayList<FlowerEntry>();
	public static FlowerEntry flowerCosmos = new FlowerEntry(BlockList.cosmos,
			0, 24);
	public static FlowerEntry flowerAster = new FlowerEntry(BlockList.aster, 0,
			36);
	public static FlowerEntry flowerLilac = new FlowerEntry(BlockList.lilac, 0,
			11);
	public static FlowerEntry flowerCrocosmia = new FlowerEntry(
			BlockList.crocosmia, 0, 11);
	
	public BiomeGenFloweryField(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x00008b;
		this.temperature = 6F;
		this.setBiomeName("Flowery Field");
		this.setColor(BiomeList.biomeColor);
		this.rainfall = 1F;
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 9,
				4, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 9,
				4, 8));
		this.theBiomeDecorator.flowersPerChunk = 250;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = Blocks.grass;
		this.fillerBlock = BlockList.betterGrass;
	}
}