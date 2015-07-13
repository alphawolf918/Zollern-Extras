package zollernextras.managers;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.biomes.BiomeList;
import zollernextras.blocks.BlockList;
import zollernextras.config.ZEConfig;
import zollernextras.worldgen.WorldGenBerries;
import zollernextras.worldgen.WorldGenCrop;
import zollernextras.worldgen.WorldGenEnderMinable;
import zollernextras.worldgen.WorldGenNetherMinable;
import zollernextras.worldgen.WorldGenSeaLamp;
import zollernextras.worldgen.WorldGenSugarCubes;
import zollernextras.worldgen.WorldGenSwampClay;
import zollernextras.worldgen.WorldGenTreasureChest;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenManager implements IWorldGenerator {
	
	public static BiomeGenBase currentBiome;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
		case 7:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		// Super Charged Coal Ore
		addOreSpawn(BlockList.spcOre, world, random, x, z, 16, 16,
				4 + random.nextInt(10), ZEConfig.oreSuperCoalSpawnRate, 4, 22);
		
		// Shinestone
		addOreSpawn(BlockList.shinestone, world, random, x, z, 16, 16,
				5 + random.nextInt(10), 14, 14, 32);
		
		// Cave Marble
		addOreSpawn(BlockList.caveMarbleWhite, world, random, x, z, 16, 16,
				5 + random.nextInt(10), 15, 14, 26);
		
		// Andesite
		addOreSpawn(BlockList.andesite, world, random, x, z, 16, 16,
				10 + random.nextInt(10), 25, 10, 56);
		
		// Diorite
		addOreSpawn(BlockList.diorite, world, random, x, z, 16, 16,
				4 + random.nextInt(10), 15, 10, 56);
		
		// Granite
		addOreSpawn(BlockList.granite, world, random, x, z, 16, 16,
				15 + random.nextInt(20), 35, 10, 56);
		
		// Fueltonium
		addOreSpawn(BlockList.fueltonium, world, random, x, z, 16, 16,
				6 + random.nextInt(8), ZEConfig.oreFueltoniumSpawnRate, 2, 12);
		
		// Shard Ore
		addOreSpawn(BlockList.enderShardOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreEnderShardSpawnRate, 6, 48);
		
		// Amaranth Ore
		addOreSpawn(BlockList.amaranthOre, world, random, x, z, 16, 16,
				1 + random.nextInt(4), ZEConfig.oreAmaranthSpawnRate, 10, 14);
		
		// Zinc Ore
		addOreSpawn(BlockList.zincOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreZincSpawnRate, 4, 18);
		
		// Diamond Ore
		addOreSpawn(Blocks.diamond_ore, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreDiamondIncreaseSpawnRate, 4,
				18);
		
		// Opal Ore
		addOreSpawn(BlockList.opalOre, world, random, x, z, 16, 16,
				2 + random.nextInt(3), ZEConfig.oreOpalSpawnRate, 12, 16);
		// Amber Ore
		addOreSpawn(BlockList.amberOre, world, random, x, z, 16, 16,
				3 + random.nextInt(3), ZEConfig.oreAmberSpawnRate, 12, 16);
		// Garnet Ore
		addOreSpawn(BlockList.garnetOre, world, random, x, z, 16, 16,
				3 + random.nextInt(3), ZEConfig.oreGarnetSpawnRate, 12, 16);
		// Aquamarine Ore
		addOreSpawn(BlockList.aquamarineOre, world, random, x, z, 16, 16,
				3 + random.nextInt(3), ZEConfig.oreAquamarineSpawnRate, 12, 16);
		// Topaz Ore
		addOreSpawn(BlockList.topazOre, world, random, x, z, 16, 16,
				3 + random.nextInt(3), ZEConfig.oreTopazSpawnRate, 12, 16);
		
		// Grab Biome
		currentBiome = world.getBiomeGenForCoords(x, z);
		
		// Current Layer
		int y = world.getHeightValue(x, z);
		
		// Swamp Clay
		if (currentBiome.isEqualTo(BiomeGenBase.swampland)) {
			addBlockSpawn(BlockList.swampClay, world, random, x, z, 16, 16,
					1 + random.nextInt(8), 20, 59, 68);
		}
		
		// Sea Lamp
		if (currentBiome.isEqualTo(BiomeGenBase.river)
				|| currentBiome.isEqualTo(BiomeGenBase.ocean)
				|| currentBiome.isEqualTo(BiomeGenBase.deepOcean)) {
			addBlockSpawn(BlockList.seaLamp, world, random, x, z, 16, 16,
					4 + random.nextInt(4), 40, 24, 68);
			addBlockSpawn(BlockList.prismarine, world, random, x, z, 16, 16,
					15 + random.nextInt(6), 40, 4, 28);
		}
		
		// Sea Laterns
		if (currentBiome.isEqualTo(BiomeList.crystalOcean)) {
			addBlockSpawn(BlockList.seaLantern, world, random, x, z, 16, 16,
					10 + random.nextInt(10), 50, 4, 78);
			addBlockSpawn(BlockList.prismarineOre, world, random, x, z, 16, 16,
					2 + random.nextInt(4), 15, 4, 28);
		}
		
		if (currentBiome.isEqualTo(BiomeList.badLands)) {
			spawnStructure(8, 9, world, random, x, y, z, new WorldGenLakes(
					Block.getBlockById(11)));
		}
		
		if (currentBiome.isEqualTo(BiomeList.mudSwamp)) {
			spawnStructure(5, 10, world, random, x, y, z, new WorldGenLakes(
					Block.getBlockById(3)));
		}
		
		// Treasure Chests
		if ((currentBiome.isEqualTo(BiomeGenBase.deepOcean) || currentBiome
				.equals(BiomeGenBase.ocean)) && y <= 44) {
			spawnStructure(10, 20, world, random, x, y, z,
					new WorldGenTreasureChest());
		}
		
		// Berry Farm
		if (currentBiome.isEqualTo(BiomeGenBase.plains)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHills)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHillsEdge)
				|| currentBiome.isEqualTo(BiomeList.floweryField)
				|| currentBiome.isEqualTo(BiomeList.mudSwamp)) {
			spawnStructure(40, 120, world, random, x, y, z,
					new WorldGenBerries());
			spawnStructure(40, 120, world, random, x, y, z, new WorldGenCrop());
		}
		
		// Custom flowers
		if (currentBiome.isEqualTo(BiomeList.floweryField)
				|| currentBiome.isEqualTo(BiomeGenBase.plains)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHills)
				|| currentBiome.isEqualTo(BiomeGenBase.forest)
				|| currentBiome.isEqualTo(BiomeGenBase.birchForest)
				|| currentBiome.isEqualTo(BiomeList.mushroomForest)) {
			spawnStructure(15, 20, world, random, x, y, z, new WorldGenFlowers(
					BlockList.aster));
			spawnStructure(15, 20, world, random, x, y, z, new WorldGenFlowers(
					BlockList.crocosmia));
			spawnStructure(15, 20, world, random, x, y, z, new WorldGenFlowers(
					BlockList.cosmos));
			spawnStructure(15, 20, world, random, x, y, z, new WorldGenFlowers(
					BlockList.lilac));
		}
		
		// Miner's Land Ore Generation
		if (currentBiome.isEqualTo(BiomeList.minersLand)) {
			// Super Charged Coal Ore
			addOreSpawn(BlockList.spcOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 1, 256);
			// Amaranth
			addOreSpawn(BlockList.amaranthOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 1, 256);
			// Fueltonium
			addOreSpawn(BlockList.fueltonium, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 1, 256);
			// Zinc
			addOreSpawn(BlockList.zincOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Amber
			addOreSpawn(BlockList.amberOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Aquamarine
			addOreSpawn(BlockList.aquamarineOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Garnet
			addOreSpawn(BlockList.garnetOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Opal
			addOreSpawn(BlockList.opalOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Topaz
			addOreSpawn(BlockList.topazOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Azurite
			addOreSpawn(BlockList.azuriteOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			
			// Vanilla Ores
			addOreSpawn(Blocks.coal_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.iron_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.gold_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.redstone_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.diamond_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.lapis_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.emerald_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			addOreSpawn(Blocks.lapis_ore, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			spawnStructure(5, 20, world, random, x, y, z, new WorldGenLakes(
					Blocks.obsidian));
		}
		
		// Sugar
		if (currentBiome.isEqualTo(BiomeList.candyLand)) {
			addBlockSpawn(BlockList.sugarCube, world, random, x, z, 16, 16,
					4 + random.nextInt(4), 20, 4, 68);
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Ycoord = 10 + random.nextInt(128);
		int Zcoord = z + random.nextInt(16);
		
		// Nether Super Coal Ore
		new WorldGenNetherMinable(BlockList.spcNetherOre, 2, 4).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Nether Fueltonium Ore
		new WorldGenNetherMinable(BlockList.fuelNetherOre, 2, 4).generate(
				world, random, Xcoord, Ycoord, Zcoord);
		
		// Nether Amaranth Ore
		new WorldGenNetherMinable(BlockList.amaranthNetherOre, 1, 5).generate(
				world, random, Xcoord, Ycoord, Zcoord);
		
		// Nether Zinc Ore
		new WorldGenNetherMinable(BlockList.zincNetherOre, 1, 5).generate(
				world, random, Xcoord, Ycoord, Zcoord);
		
		// Nether Ender Shard Ore
		new WorldGenNetherMinable(BlockList.enderShardNetherOre, 1, 5)
				.generate(world, random, Xcoord, Ycoord, Zcoord);
		
		// Azurite
		new WorldGenNetherMinable(BlockList.azuriteOre,
				ZEConfig.oreAzuriteSpawnRate, 30).generate(world, random,
				Xcoord, Ycoord, Zcoord);
		
		// Nether Dirt
		new WorldGenNetherMinable(BlockList.netherDirt, 10, 25).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Brimstone
		new WorldGenNetherMinable(BlockList.brimStone, 20, 45).generate(world,
				random, Xcoord, Ycoord, Zcoord);
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		
		int Xcoord = x + random.nextInt(16);
		int Ycoord = 10 + random.nextInt(80);
		int Zcoord = z + random.nextInt(16);
		
		// Ender Super Coal Ore
		new WorldGenEnderMinable(BlockList.enderSpcOre, 2, 4).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Ender Fueltonium Ore
		new WorldGenEnderMinable(BlockList.enderFnOre, 2, 4).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Ender Amaranth Ore
		new WorldGenEnderMinable(BlockList.enderAmaranthOre, 2, 4).generate(
				world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Zinc Ore
		new WorldGenEnderMinable(BlockList.enderZincOre, 2, 4).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Ender Ore
		new WorldGenEnderMinable(BlockList.enderiteOre,
				ZEConfig.oreEnderiteSpawnRate, 25).generate(world, random,
				Xcoord, Ycoord, Zcoord);
	}
	
	/**
	 * Spawns a structure in the world
	 *
	 * @author Zollern Wolf
	 * @param minChance
	 *            The minimum chance that the structure has to spawn.
	 * @param maxChance
	 *            The maximum chance that the structure has to spawn.
	 * @param world
	 *            The world for the structure to spawn in.
	 * @param random
	 *            Needed for randomization and comparison.
	 * @param x
	 *            The X coordinate to spawn in at.
	 * @param y
	 *            The Y coordinate to spawn in at.
	 * @param z
	 * @param wg
	 *            The structure.
	 */
	public static void spawnStructure(int minChance, int maxChance,
			World world, Random random, int x, int y, int z, WorldGenerator wg) {
		if (random.nextInt(maxChance) == minChance) {
			wg.generate(world, random, x, y, z);
		}
	}
	
	public void addBlockSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		WorldGenerator wg = null;
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
			if (block.equals(BlockList.swampClay)
					|| block.equals(BlockList.betterGrass)) {
				wg = new WorldGenSwampClay(block, maxVeinSize);
			} else if (block.equals(BlockList.seaLamp)
					|| block.equals(BlockList.seaLantern)) {
				wg = new WorldGenSeaLamp(block, maxVeinSize);
			} else if (block.equals(BlockList.sugarCube)) {
				wg = new WorldGenSugarCubes(BlockList.sugarCube, maxVeinSize);
			} else {
				wg = new WorldGenMinable(block, maxVeinSize);
			}
			wg.generate(world, random, posX, posY, posZ);
		}
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
			new WorldGenMinable(block, maxVeinSize).generate(world, random,
					posX, posY, posZ);
		}
	}
}