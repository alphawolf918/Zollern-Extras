package zollernextras.managers;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.worldgen.minable.WorldGenEnderMinable;
import zollernextras.worldgen.minable.WorldGenNetherMinable;
import zollernextras.worldgen.minable.WorldGenObsidianMinable;

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
		
		// Azurite Ore
		addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreAzuriteSpawnRate, 1, 72);
		
		int y = world.getHeight(x, z);
		
		if (random.nextInt(1200) <= 10 && y <= 50) {
			new WorldGenLakes(Blocks.OBSIDIAN).generate(world, random,
					new BlockPos(x, y, z));
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Zcoord = z + random.nextInt(16);
		
		// Super Charged Coal Ore
		addNetherOreSpawn(ZollernBlocks.netherSuperChargedCoalOre, world,
				random, Xcoord, Zcoord, 16, 16, 4 + random.nextInt(10),
				ZEConfig.oreSuperCoalSpawnRate + 10, 2, 128);
		
		// Nether Amaranth Ore
		addNetherOreSpawn(ZollernBlocks.netherAmaranthOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2),
				ZEConfig.oreAmaranthSpawnRate + 10, 2, 128);
		
		int y = world.getHeight(x, z);
		
		if (random.nextInt(120) <= 10) {
			new WorldGenLakes(Blocks.OBSIDIAN).generate(world, random,
					new BlockPos(Xcoord, y, Zcoord));
		}
		
		// Azurite Ore
		addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreAzuriteSpawnRate, 1, 92);
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Zcoord = z + random.nextInt(16);
		
		// Super Charged Coal Ore
		addEnderOreSpawn(ZollernBlocks.enderSuperChargedCoalOre, world, random,
				Xcoord, Zcoord, 16, 16, 4 + random.nextInt(2),
				ZEConfig.oreSuperCoalSpawnRate + 5, 4, 110);
		
		// Ender Amaranth Ore
		addEnderOreSpawn(ZollernBlocks.enderAmaranthOre, world, random, Xcoord,
				Zcoord, 16, 16, 4 + random.nextInt(2),
				ZEConfig.oreAmaranthSpawnRate + 5, 4, 110);
		
		// Azurite Ore
		addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), ZEConfig.oreAzuriteSpawnRate, 1, 72);
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
			new WorldGenObsidianMinable(block.getDefaultState(), maxVeinSize)
					.generate(world, random, new BlockPos(posX, posY, posZ));
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
			new WorldGenNetherMinable(block.getDefaultState(), maxVeinSize)
					.generate(world, random, new BlockPos(posX, posY, posZ));
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
			new WorldGenEnderMinable(block.getDefaultState(), maxVeinSize)
					.generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	public static void spawnStructure(int minChance, int maxChance,
			World world, Random random, int x, int y, int z, WorldGenerator wg) {
		if (random.nextInt(maxChance) <= minChance) {
			wg.generate(world, random, new BlockPos(x, y, z));
		}
	}
}