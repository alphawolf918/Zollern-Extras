package zollernextras.managers;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.worldgen.minable.ZollernMinable;

public class WorldGenManager implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 0:
			this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -1:
			this.generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			this.generateEnd(world, random, chunkX * 16, chunkX * 16);
			break;
		}
		if (world.provider.getDimension() == ZEConfig.dimensionUpsideDownID) {
			this.generateUpsideDown(world, random, chunkX, chunkZ);
		}
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		// Super Charged Coal Ore
		addOreSpawn(ZollernBlocks.superChargedCoalOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreSuperCoalSpawnRate, 4,
				22);
		
		// Amaranth Ore
		addOreSpawn(ZollernBlocks.amaranthOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreAmaranthSpawnRate, 4, 42);
		
		// Obsidian (needed for Azurite Ore gen)
		addOreSpawn(Blocks.OBSIDIAN, world, random, x, z, 16, 16,
				15 + random.nextInt(10), 52, 1, 42);
		
		// Azurite Ore
		addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreAzuriteSpawnRate + 30,
				1, 42);
		
		// Ender Shard Ore
		addOreSpawn(ZollernBlocks.enderShardOre, world, random, x, z, 16, 16,
				2 + random.nextInt(4), ZEConfig.oreEnderShardSpawnRate, 4, 32);
		
		// Zollernium Ore
		addOreSpawn(ZollernBlocks.zollerniumOre, world, random, x, z, 16, 16,
				1 + random.nextInt(4), 5, 1, 14);
		
		// Witherite Ore
		addOreSpawn(ZollernBlocks.witheriteOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreWitheriteSpawnRate, 1, 44);
		
		// Fueltonium Ore
		addOreSpawn(ZollernBlocks.fueltoniumOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreFueltoniumSpawnRate, 1, 22);
		
		// Zinc Ore
		addOreSpawn(ZollernBlocks.zincOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreZincSpawnRate, 4, 32);
		
		// Steel Ore
		addOreSpawn(ZollernBlocks.steelOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreSteelSpawnRate, 4, 32);
		
		// Garnet Ore
		addOreSpawn(ZollernBlocks.garnetOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreGarnetSpawnRate, 4, 42);
		
		// Amber Ore
		addOreSpawn(ZollernBlocks.amberOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreAmberSpawnRate, 4, 42);
		
		// Aquamarine Ore
		addOreSpawn(ZollernBlocks.aquamarineOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreAquamarineSpawnRate, 4, 42);
		
		// Ruby Ore
		addOreSpawn(ZollernBlocks.rubyOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreRubySpawnRate, 4, 42);
		
		// Sapphire Ore
		addOreSpawn(ZollernBlocks.sapphireOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreSapphireSpawnRate, 4, 42);
		
		// Topaz Ore
		addOreSpawn(ZollernBlocks.topazOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreTopazSpawnRate, 4, 42);
		
		// Opal Ore
		addOreSpawn(ZollernBlocks.opalOre, world, random, x, z, 16, 16,
				4 + random.nextInt(2), ZEConfig.oreOpalSpawnRate, 4, 42);
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Zcoord = z + random.nextInt(16);
		
		// Nether Super Charged Coal Ore
		addNetherOreSpawn(ZollernBlocks.netherSuperChargedCoalOre, world,
				random, Xcoord, Zcoord, 16, 16, 4 + random.nextInt(10),
				ZEConfig.oreSuperCoalSpawnRate + 10, 2, 128);
		
		// Nether Amaranth Ore
		addNetherOreSpawn(ZollernBlocks.netherAmaranthOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2),
				ZEConfig.oreAmaranthSpawnRate + 10, 2, 128);
		
		// Obsidian (needed for Azurite Ore gen)
		addNetherOreSpawn(Blocks.OBSIDIAN, world, random, x, z, 16, 16,
				10 + random.nextInt(5), 62, 1, 128);
		
		// Azurite Ore
		addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z, 16,
				16, 10 + random.nextInt(5), ZEConfig.oreAzuriteSpawnRate + 30,
				1, 128);
		
		// Nether Ender Shard Ore
		addNetherOreSpawn(ZollernBlocks.netherEnderShardOre, world, random, x,
				z, 16, 16, 2 + random.nextInt(4),
				ZEConfig.oreEnderShardSpawnRate + 10, 4, 128);
		
		// Nether Fueltonium Ore
		addNetherOreSpawn(ZollernBlocks.netherFueltoniumOre, world, random, x,
				z, 16, 16, 2 + random.nextInt(4),
				ZEConfig.oreFueltoniumSpawnRate + 10, 4, 128);
		
		// Nether Zinc Ore
		addNetherOreSpawn(ZollernBlocks.netherZincOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreZincSpawnRate + 10, 4,
				128);
		
		// Nether Steel Ore
		addNetherOreSpawn(ZollernBlocks.netherSteelOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), ZEConfig.oreSteelSpawnRate + 10,
				4, 128);
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		int Xcoord = x;// + random.nextInt(16);
		int Zcoord = z;// + random.nextInt(16);
		
		// Ender Super Charged Coal Ore
		addEnderOreSpawn(ZollernBlocks.enderSuperChargedCoalOre, world, random,
				Xcoord, Zcoord, 16, 16, 4 + random.nextInt(2),
				ZEConfig.oreSuperCoalSpawnRate + 5, 4, 110);
		
		// Ender Amaranth Ore
		addEnderOreSpawn(ZollernBlocks.enderAmaranthOre, world, random, Xcoord,
				Zcoord, 16, 16, 4 + random.nextInt(2),
				ZEConfig.oreAmaranthSpawnRate + 5, 4, 110);
		
		// Azurite Ore
		addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreAzuriteSpawnRate + 10,
				1, 210);
		
		// Ender Fueltonium Ore
		addEnderOreSpawn(ZollernBlocks.enderFueltoniumOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2),
				ZEConfig.oreFueltoniumSpawnRate + 5, 1, 110);
		
		// Ender Zinc Ore
		addEnderOreSpawn(ZollernBlocks.enderZincOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreZincSpawnRate + 5, 4,
				110);
		
		// Ender Steel Ore
		addEnderOreSpawn(ZollernBlocks.enderSteelOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreSteelSpawnRate + 5, 4,
				110);
		
		// Enderite Ore
		addEnderOreSpawn(ZollernBlocks.enderiteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreEnderiteSpawnRate + 5,
				4, 110);
		
		// Ender Diamond Ore
		addEnderOreSpawn(ZollernBlocks.enderDiamondOre, world, random, x, z,
				16, 16, 2 + random.nextInt(2), 26, 4, 110);
		
	}
	
	private void generateUpsideDown(World world, Random random, int x, int z) {
		
	}
	
	public void addOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block.getDefaultState(), maxVeinSize).generate(
					world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	public void addObsidianOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new ZollernMinable(block.getDefaultState(), maxVeinSize,
					Blocks.OBSIDIAN).generate(world, random, new BlockPos(posX,
					posY, posZ));
		}
	}
	
	public void addNetherOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new ZollernMinable(block.getDefaultState(), maxVeinSize,
					Blocks.NETHERRACK).generate(world, random, new BlockPos(
					posX, posY, posZ));
		}
	}
	
	public void addEnderOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + maxY - 1;
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new ZollernMinable(block.getDefaultState(), maxVeinSize,
					Blocks.END_STONE).generate(world, random, new BlockPos(
					posX, posY, posZ));
		}
	}
	
	public static void spawnStructure(int minChance, int maxChance,
			World world, Random random, int x, int y, int z, WorldGenerator wg) {
		if (random.nextInt(maxChance) <= minChance) {
			wg.generate(world, random, new BlockPos(x, y, z));
		}
	}
}