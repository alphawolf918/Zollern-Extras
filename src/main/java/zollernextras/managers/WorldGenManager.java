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
import zollernextras.dimension.DimensionLoader;
import zollernextras.dimension.upsidedown.WorldGenUpsideDownMinable;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.mobs.entities.EntityEnderCreeper;
import zollernextras.mobs.entities.EntityEnderSkeleton;
import zollernextras.worldgen.WorldGenBerries;
import zollernextras.worldgen.WorldGenCandyTree;
import zollernextras.worldgen.WorldGenCrop;
import zollernextras.worldgen.WorldGenCrops;
import zollernextras.worldgen.WorldGenEnderBerryTree;
import zollernextras.worldgen.WorldGenEnderGlow;
import zollernextras.worldgen.WorldGenEnderMinable;
import zollernextras.worldgen.WorldGenEnderReeds;
import zollernextras.worldgen.WorldGenEnderTower;
import zollernextras.worldgen.WorldGenFruitTree;
import zollernextras.worldgen.WorldGenMagmaRock;
import zollernextras.worldgen.WorldGenMinableNether;
import zollernextras.worldgen.WorldGenNetherOre;
import zollernextras.worldgen.WorldGenSeaLamp;
import zollernextras.worldgen.WorldGenSugarCubes;
import zollernextras.worldgen.WorldGenSwampClay;
import zollernextras.worldgen.WorldGenTreasureChest;
import zollernextras.worldgen.upsidedown.WorldGenCrater;
import zollernextras.worldgen.upsidedown.WorldGenShadowShrine;
import cpw.mods.fml.common.IWorldGenerator;
import erogenousbeef.bigreactors.common.BigReactors;

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
		if (world.provider.dimensionId == DimensionLoader.getDimID()) {
			generateUpsideDown(world, random, chunkX * 16, chunkZ * 16);
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
		
		// Zollernium
		addOreSpawn(BlockList.zollerniumOre, world, random, x, z, 16, 16,
				1 + random.nextInt(3), 10, 2, 16);
		
		// Shard Ore
		addOreSpawn(BlockList.enderShardOre, world, random, x, z, 16, 16,
				4 + random.nextInt(4), ZEConfig.oreEnderShardSpawnRate, 4, 48);
		
		// Amaranth Ore
		addOreSpawn(BlockList.amaranthOre, world, random, x, z, 16, 16,
				1 + random.nextInt(4), ZEConfig.oreAmaranthSpawnRate, 10, 14);
		
		// Zinc Ore
		addOreSpawn(BlockList.zincOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreZincSpawnRate, 4, 18);
		
		// Diamond Ore
		addOreSpawn(Blocks.diamond_ore, world, random, x, z, 16, 16,
				2 + random.nextInt(4), ZEConfig.oreDiamondIncreaseSpawnRate, 4,
				22);
		
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
		
		// Witherite Ore
		addOreSpawn(BlockList.witheriteOre, world, random, x, z, 16, 16,
				3 + random.nextInt(3), ZEConfig.oreWitheriteSpawnRate, 12, 16);
		
		// Ruby Ore
		addOreSpawn(BlockList.rubyOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreRubySpawnRate, 12, 16);
		
		// Sapphire Ore
		addOreSpawn(BlockList.sapphireOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), ZEConfig.oreSapphireSpawnRate, 12, 16);
		
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
					4 + random.nextInt(4), 35, 24, 42);
			addBlockSpawn(BlockList.prismarine, world, random, x, z, 16, 16,
					15 + random.nextInt(6), 35, 4, 28);
		}
		
		// Sea Lanterns
		if (currentBiome.isEqualTo(BiomeList.crystalOcean)) {
			addBlockSpawn(BlockList.seaLantern, world, random, x, z, 16, 16,
					2 + random.nextInt(2), 15, 4, 48);
			addBlockSpawn(BlockList.prismarineOre, world, random, x, z, 16, 16,
					2 + random.nextInt(4), 15, 4, 28);
		}
		
		if (currentBiome.isEqualTo(BiomeList.badLands)) {
			spawnStructure(8, 9, world, random, x, y, z, new WorldGenLakes(
					Blocks.lava));
		}
		
		if (currentBiome.isEqualTo(BiomeList.mudSwamp)) {
			spawnStructure(10, 65, world, random, x, y, z, new WorldGenLakes(
					Blocks.dirt));
		}
		
		// Treasure Chests
		if ((currentBiome.isEqualTo(BiomeGenBase.deepOcean)
				|| currentBiome.equals(BiomeGenBase.ocean) || currentBiome
					.equals(BiomeList.crystalOcean)) && y <= 44) {
			spawnStructure(80, 200, world, random, x, y, z,
					new WorldGenTreasureChest());
		}
		
		// Farms
		if (currentBiome.isEqualTo(BiomeGenBase.plains)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHills)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHillsEdge)
				|| currentBiome.isEqualTo(BiomeGenBase.forest)
				|| currentBiome.isEqualTo(BiomeGenBase.swampland)
				|| currentBiome.isEqualTo(BiomeGenBase.birchForest)
				|| currentBiome.isEqualTo(BiomeList.floweryField)
				|| currentBiome.isEqualTo(BiomeList.mudSwamp)
				|| currentBiome.isEqualTo(BiomeList.mushroomForest)) {
			Random r = new Random();
			int randInt = random.nextInt(282);
			if (randInt <= 25) {
				y -= 1;
				spawnStructure(5, 86, world, random, x, y, z,
						new WorldGenBerries());
				spawnStructure(5, 95, world, random, x, y, z,
						new WorldGenCrop());
				spawnStructure(5, 78, world, random, x, y, z,
						new WorldGenCrops(BlockList.peas));
				spawnStructure(5, 82, world, random, x, y, z,
						new WorldGenCrops(BlockList.tomatoes));
				spawnStructure(2, 102, world, random, x, y, z,
						new WorldGenCrops(BlockList.garlic));
				spawnStructure(4, 89, world, random, x, y, z,
						new WorldGenCrops(BlockList.radish));
				spawnStructure(4, 92, world, random, x, y, z,
						new WorldGenCrops(BlockList.corn));
				spawnStructure(2, 102, world, random, x, y, z,
						new WorldGenCrops(BlockList.cucumbers));
			}
		}
		
		// Custom flowers
		if (currentBiome.isEqualTo(BiomeGenBase.plains)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHills)
				|| currentBiome.isEqualTo(BiomeGenBase.forest)
				|| currentBiome.isEqualTo(BiomeGenBase.birchForest)
				|| currentBiome.isEqualTo(BiomeList.mushroomForest)) {
			Random r = new Random();
			int randInt = random.nextInt(75);
			if (randInt <= 15) {
				spawnStructure(5, 40, world, random, x, y, z,
						new WorldGenFlowers(BlockList.aster));
				spawnStructure(5, 40, world, random, x, y, z,
						new WorldGenFlowers(BlockList.crocosmia));
				spawnStructure(5, 40, world, random, x, y, z,
						new WorldGenFlowers(BlockList.cosmos));
				spawnStructure(5, 40, world, random, x, y, z,
						new WorldGenFlowers(BlockList.lilac));
			}
		}
		
		if (currentBiome.isEqualTo(BiomeList.floweryField)) {
			if (new Random().nextInt(50) <= 35) {
				spawnStructure(15, 20, world, random, x, y, z,
						new WorldGenFlowers(BlockList.aster));
				spawnStructure(15, 20, world, random, x, y, z,
						new WorldGenFlowers(BlockList.crocosmia));
				spawnStructure(15, 20, world, random, x, y, z,
						new WorldGenFlowers(BlockList.cosmos));
				spawnStructure(15, 20, world, random, x, y, z,
						new WorldGenFlowers(BlockList.lilac));
				spawnStructure(15, 20, world, random, x, y, z,
						new WorldGenFlowers(BlockList.heartFlower));
			}
		}
		
		if (currentBiome.isEqualTo(BiomeList.floweryField)
				|| currentBiome.isEqualTo(BiomeList.mudSwamp)
				|| currentBiome.isEqualTo(BiomeGenBase.plains)
				|| currentBiome.isEqualTo(BiomeGenBase.extremeHills)
				|| currentBiome.isEqualTo(BiomeGenBase.forest)
				|| currentBiome.isEqualTo(BiomeGenBase.birchForest)
				|| currentBiome.isEqualTo(BiomeGenBase.savanna)
				|| currentBiome.isEqualTo(BiomeGenBase.jungle)) {
			Random r = new Random();
			int randInt = random.nextInt(75);
			if (randInt <= 10) {
				// BERNANERZ
				spawnStructure(25, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.bananaLog,
								BlockList.bananaLeaves));
				
				// ERNGES
				spawnStructure(25, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.orangeLog,
								BlockList.orangeLeaves));
				
				// GWAVERS
				spawnStructure(50, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.guavaLog,
								BlockList.guavaLeaves));
				
				// LERMENS
				spawnStructure(16, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.lemonLog,
								BlockList.lemonLeaves));
				
				// LIRMS
				spawnStructure(14, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.limeLog,
								BlockList.limeLeaves));
				
				// CHURRIES
				spawnStructure(22, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.cherryLog,
								BlockList.cherryLeaves));
				
				// GRERPFRUTS
				spawnStructure(8, 100, world, random, x, y, z,
						new WorldGenFruitTree(BlockList.grapefruitLog,
								BlockList.grapefruitLeaves));
			}
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
			// Witherite
			addOreSpawn(BlockList.topazOre, world, random, x, z, 16, 16,
					1 + random.nextInt(3), 4, 2, 256);
			// Ruby Ore
			addOreSpawn(BlockList.rubyOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Sapphire Ore
			addOreSpawn(BlockList.sapphireOre, world, random, x, z, 16, 16,
					4 + random.nextInt(8), 60, 2, 256);
			// Zollernium Ore
			addOreSpawn(BlockList.zollerniumOre, world, random, x, z, 16, 16,
					1, 8, 1, 256);
			// Obsidian
			addOreSpawn(Blocks.obsidian, world, random, x, z, 16, 16,
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
			spawnStructure(5, 15, world, random, x, y, z, new WorldGenLakes(
					Blocks.obsidian));
			
			// Intermod Ores
			// Yellorite
			if (ModHelperBase.useBigReactors) {
				addOreSpawn(BigReactors.blockYelloriteOre, world, random, x, z,
						16, 16, 4 + random.nextInt(8), 60, 2, 256);
			}
		}
		
		// Candy Land
		if (currentBiome.isEqualTo(BiomeList.candyLand)) {
			addBlockSpawn(BlockList.sugarCube, world, random, x, z, 16, 16,
					4 + random.nextInt(4), 20, 4, 68);
			addBlockSpawn(BlockList.cookieBlock, world, random, x, z, 16, 16,
					4 + random.nextInt(4), 20, 4, 68);
			addBlockSpawn(BlockList.chocolateBlock, world, random, x, z, 16,
					16, 4 + random.nextInt(4), 20, 4, 68);
			int randInt = random.nextInt(76);
			if (randInt <= 44) {
				Block candyCube = randInt <= 20 ? BlockList.candyCubeWhite
						: BlockList.candyCubeRed;
				Block candyCube2 = randInt <= 20 ? BlockList.candyCubeRed
						: BlockList.candyCubeWhite;
				this.spawnStructure(4, 20, world, random, x, y, z,
						new WorldGenCandyTree(candyCube, candyCube2));
			}
			if (random.nextInt(55) < 22) {
				new WorldGenLakes(BlockList.blockChocolate).generate(world,
						random, x, y, z);
			}
		}
		
		// Tropical Forest
		if (currentBiome.isEqualTo(BiomeList.tropicalForest)) {
			// BERNANERZ
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.bananaLog,
							BlockList.bananaLeaves));
			
			// ERNGES
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.orangeLog,
							BlockList.orangeLeaves));
			
			// GWAVERS
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.guavaLog,
							BlockList.guavaLeaves));
			
			// LERMENS
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.lemonLog,
							BlockList.lemonLeaves));
			
			// LIRMS
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.limeLog,
							BlockList.limeLeaves));
			
			// CHURRIES
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.cherryLog,
							BlockList.cherryLeaves));
			
			// GRERPFRUTS
			spawnStructure(25, 30, world, random, x, y, z,
					new WorldGenFruitTree(BlockList.grapefruitLog,
							BlockList.grapefruitLeaves));
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Ycoord = 10 + random.nextInt(128);
		int Zcoord = z + random.nextInt(16);
		
		// Nether Super Coal Ore
		int randGen = random.nextInt(100);
		if (randGen <= 16) {
			new WorldGenNetherOre(BlockList.spcNetherOre, 4).generate(world,
					random, Xcoord, Ycoord, Zcoord);
		}
		
		// Nether Fueltonium Ore
		if (randGen <= 8) {
			new WorldGenNetherOre(BlockList.fuelNetherOre, 2).generate(world,
					random, Xcoord, Ycoord, Zcoord);
		}
		
		// Nether Amaranth Ore
		if (randGen <= 32) {
			new WorldGenNetherOre(BlockList.amaranthNetherOre, 4).generate(
					world, random, Xcoord, Ycoord, Zcoord);
		}
		
		// Nether Zinc Ore
		if (randGen <= 28) {
			new WorldGenNetherOre(BlockList.zincNetherOre, 4).generate(world,
					random, Xcoord, Ycoord, Zcoord);
		}
		
		// Nether Ender Shard Ore
		if (randGen <= 22) {
			new WorldGenNetherOre(BlockList.enderShardNetherOre, 6).generate(
					world, random, Xcoord, Ycoord, Zcoord);
		}
		
		// Azurite
		if (randGen <= 5) {
			new WorldGenNetherOre(BlockList.azuriteOre, 8).generate(world,
					random, Xcoord, Ycoord, Zcoord);
		}
		
		// Nether Dirt
		if (randGen <= 65) {
			new WorldGenNetherOre(BlockList.netherDirt, 16).generate(world,
					random, Xcoord, Ycoord, Zcoord);
		}
		
		// Brimstone
		if (randGen <= 24) {
			new WorldGenNetherOre(BlockList.brimStone, 4).generate(world,
					random, Xcoord, Ycoord, Zcoord);
		}
		
		// Magma Rock
		if (new Random().nextInt(250) < 150) {
			new WorldGenLakes(BlockList.magmaBlock).generate(world, random,
					Xcoord, Ycoord, Zcoord);
		}
		if (new Random().nextInt(550) < 340) {
			new WorldGenMagmaRock().generate(world, random, Xcoord, Ycoord,
					Zcoord);
		}
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Ycoord = 10 + random.nextInt(80);
		int Zcoord = z + random.nextInt(16);
		
		// End Lakes
		if (random.nextInt(20) <= 25) {
			new WorldGenLakes(Blocks.end_stone).generate(world, random, Xcoord
					+ random.nextInt(50), Ycoord + random.nextInt(50), Zcoord
					+ random.nextInt(50));
		}
		
		// Ender Super Coal Ore
		new WorldGenEnderMinable(BlockList.enderSpcOre, 6, 8).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Ender Fueltonium Ore
		new WorldGenEnderMinable(BlockList.enderFnOre, 6, 8).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Ender Amaranth Ore
		new WorldGenEnderMinable(BlockList.enderAmaranthOre, 6, 8).generate(
				world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Zinc Ore
		new WorldGenEnderMinable(BlockList.enderZincOre, 6, 8).generate(world,
				random, Xcoord, Ycoord, Zcoord);
		
		// Enderite Ore
		new WorldGenEnderMinable(BlockList.enderiteOre,
				ZEConfig.oreEnderiteSpawnRate,
				ZEConfig.oreEnderiteSpawnRate + 6).generate(world, random,
				Xcoord, Ycoord, Zcoord);
		
		// Ender Diamond Ore
		new WorldGenEnderMinable(BlockList.enderDiamondOre, 6, 8).generate(
				world, random, Xcoord, Ycoord, Zcoord);
		
		// Ender Dirt
		if (new Random().nextInt(51) <= 42) {
			new WorldGenLakes(BlockList.enderDirt).generate(world, random,
					Xcoord, Ycoord, Zcoord);
			if (!world.isRemote) {
				for (int i = 0; i < 3; i++) {
					EntityEnderSkeleton skeleton = new EntityEnderSkeleton(
							world);
					skeleton.setLocationAndAngles(Xcoord + i, Ycoord + 1,
							Zcoord + i, 0.0f, 0.0f);
					world.spawnEntityInWorld(skeleton);
				}
			}
		}
		
		// Ender Reeds
		if (new Random().nextInt(35) <= 15) {
			new WorldGenEnderReeds().generate(world, random, Xcoord,
					Ycoord + 1, Zcoord);
			if (!world.isRemote) {
				for (int i = 0; i < 4; i++) {
					EntityEnderCreeper creeper = new EntityEnderCreeper(world);
					creeper.setLocationAndAngles(Xcoord + i, Ycoord + 1, Zcoord
							+ i, 0.0f, 0.0f);
					world.spawnEntityInWorld(creeper);
				}
			}
		}
		
		// Ender Tower
		if (new Random().nextInt(32) <= 11) {
			this.spawnStructure(2, 4, world, random, Xcoord,
					Ycoord + random.nextInt(5), Zcoord,
					new WorldGenEnderTower());
		}
		
		// Ender Glow
		if (new Random().nextInt(11) <= 10) {
			new WorldGenEnderGlow().generate(world, random, Xcoord, Ycoord
					+ random.nextInt(20), Zcoord);
		}
		
		// Ender Berry Tree
		if (new Random().nextInt(20) <= 15) {
			this.spawnStructure(2, 3, world, random, Xcoord, Ycoord, Zcoord,
					new WorldGenEnderBerryTree(BlockList.enderBerryLog,
							BlockList.enderBerryLeaves));
		}
	}
	
	private void generateUpsideDown(World world, Random random, int x, int z) {
		// Iron Ore
		addUpsideDownOreSpawn(BlockList.upsideDownIronOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 44, 4, 55);
		
		// Gold Ore
		addUpsideDownOreSpawn(BlockList.upsideDownGoldOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 34, 4, 45);
		
		// Amaranth Ore
		addUpsideDownOreSpawn(BlockList.upsideDownAmaranthOre, world, random,
				x, z, 16, 16, 2 + random.nextInt(2), 14, 4, 35);
		
		// Witherite Ore
		addUpsideDownOreSpawn(BlockList.witheriteOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), 24, 4, 35);
		
		// Diamond Ore
		addUpsideDownOreSpawn(BlockList.upsideDownDiamondOre, world, random, x,
				z, 16, 16, 2 + random.nextInt(2), 14, 8, 24);
		
		// Emerald Ore
		addUpsideDownOreSpawn(BlockList.upsideDownEmeraldOre, world, random, x,
				z, 16, 16, 2 + random.nextInt(4), 10, 4, 24);
		
		// Zollernium Ore
		addUpsideDownOreSpawn(BlockList.zollerniumOre, world, random, x, z, 16,
				16, 2 + random.nextInt(4), 10, 4, 24);
		
		// Zinc Ore
		addUpsideDownOreSpawn(BlockList.upsideDownZincOre, world, random, x, z,
				16, 16, 2 + random.nextInt(2), 10, 4, 35);
		
		// Ruby Ore
		addUpsideDownOreSpawn(BlockList.upsideDownRubyOre, world, random, x, z,
				16, 16, 2 + random.nextInt(2), 14, 4, 35);
		
		// Sapphire Ore
		addUpsideDownOreSpawn(BlockList.upsideDownSapphireOre, world, random,
				x, z, 16, 16, 2 + random.nextInt(2), 14, 4, 35);
		
		// Super Charged Coal Ore
		addUpsideDownOreSpawn(BlockList.upsideDownSpcOre, world, random, x, z,
				16, 16, 4 + random.nextInt(6), 16, 1, 30);
		
		// Fueltonium Ore
		addUpsideDownOreSpawn(BlockList.upsideDownFuelOre, world, random, x, z,
				16, 16, 4 + random.nextInt(4), 20, 1, 42);
		
		// Lapis Lazuli Ore
		addUpsideDownOreSpawn(BlockList.upsideDownLapisOre, world, random, x,
				z, 16, 16, 2 + random.nextInt(2), 18, 10, 52);
		
		// Redstone Ore
		addUpsideDownOreSpawn(BlockList.upsideDownRedstoneOre, world, random,
				x, z, 16, 16, 2 + random.nextInt(2), 11, 4, 14);
		
		// Ender Shard Ore
		addUpsideDownOreSpawn(BlockList.upsideDownEnderShardOre, world, random,
				x, z, 16, 16, 2 + random.nextInt(2), 18, 10, 52);
		
		// Zanium Ore
		if (ModHelperBase.useZaneExtras) {
			addUpsideDownOreSpawn(zaneextras.blocks.BlockList.zaniumOre, world,
					random, x, z, 16, 16, 2 + random.nextInt(2), 8, 10, 22);
		}
		
		int y = world.getHeightValue(x, z);
		
		// Shadow Shrine
		if (random.nextInt(1500) <= 5) {
			this.spawnStructure(5, 10, world, random, x, y, z,
					new WorldGenShadowShrine());
		}
		
		// Crater
		if (random.nextInt(250) <= 50) {
			this.spawnStructure(8, 10, world, random, x, y, z,
					new WorldGenCrater());
		}
		
		// Dirt
		if (random.nextInt(300) <= 25) {
			new WorldGenLakes(BlockList.upsideDownDirt).generate(world, random,
					x, y, z);
		}
		
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
		if (random.nextInt(maxChance) <= minChance) {
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
			} else if (block.equals(BlockList.sugarCube)
					|| block.equals(BlockList.cookieBlock)
					|| block.equals(BlockList.chocolateBlock)) {
				wg = new WorldGenSugarCubes(block, maxVeinSize);
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
			new WorldGenMinableNether(block, maxVeinSize, 0).generate(world,
					random, posX, posY, posZ);
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
			new WorldGenEnderMinable(block, maxVeinSize, 0).generate(world,
					random, posX, posY, posZ);
		}
	}
	
	public void addUpsideDownOreSpawn(Block block, World world, Random random,
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
			new WorldGenUpsideDownMinable(block, maxVeinSize).generate(world,
					random, posX, posY, posZ);
		}
	}
}