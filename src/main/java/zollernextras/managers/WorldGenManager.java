package zollernextras.managers;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import zanextras.blocks.ZaneBlocks;
import zollernextras.biomes.BiomeList;
import zollernextras.biomes.nether.BiomeNetherMinersLand;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.worldgen.WorldGenEnderTower;
import zollernextras.worldgen.WorldGenShinestone;
import zollernextras.worldgen.minable.ZollernMinable;
import cofh.thermalfoundation.block.BlockOre;
import erogenousbeef.bigreactors.init.BrBlocks;

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
			this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
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
		
		// Shinestone
		addOreSpawn(ZollernBlocks.shinestone, world, random, x, z, 16, 16,
				5 + random.nextInt(10), 14, 14, 42);
		
		// Cave Marble
		addOreSpawn(ZollernBlocks.caveMarble, world, random, x, z, 16, 16,
				5 + random.nextInt(10), 15, 14, 26);
		
		// Black Cave Marble
		addOreSpawn(ZollernBlocks.blackCaveMarble, world, random, x, z, 16, 16,
				5 + random.nextInt(10), 10, 4, 20);
		
		int y = world.getHeight(x, z);
		
		if (random.nextInt(500) <= 5) {
			if (y <= 36) {
				(new WorldGenShinestone()).generate(world, random,
						new BlockPos(x, y, z));
			}
		}
		
		Biome currentBiome = world.getBiome(new BlockPos(x, y, z));
		
		if (currentBiome.equals(BiomeList.biomeMinersLand)) {
			// Super Charged Coal Ore
			addOreSpawn(ZollernBlocks.superChargedCoalOre, world, random, x, z,
					16, 16, 6 + random.nextInt(4), 30, 1, 256);
			
			// Amaranth Ore
			addOreSpawn(ZollernBlocks.amaranthOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 2562);
			
			// Obsidian (needed for Azurite Ore gen)
			addOreSpawn(Blocks.OBSIDIAN, world, random, x, z, 16, 16,
					15 + random.nextInt(4), 30, 1, 256);
			
			// Azurite Ore
			addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z,
					16, 16, 6 + random.nextInt(4), 30, 1, 256);
			
			// Ender Shard Ore
			addOreSpawn(ZollernBlocks.enderShardOre, world, random, x, z, 16,
					16, 6 + random.nextInt(4), 30, 1, 256);
			
			// Zollernium Ore
			addOreSpawn(ZollernBlocks.zollerniumOre, world, random, x, z, 16,
					16, 6 + random.nextInt(4), 30, 1, 256);
			
			// Witherite Ore
			addOreSpawn(ZollernBlocks.witheriteOre, world, random, x, z, 16,
					16, 4 + random.nextInt(2), ZEConfig.oreWitheriteSpawnRate,
					1, 44);
			
			// Fueltonium Ore
			addOreSpawn(ZollernBlocks.fueltoniumOre, world, random, x, z, 16,
					16, 6 + random.nextInt(4), 30, 1, 256);
			
			// Zinc Ore
			addOreSpawn(ZollernBlocks.zincOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Steel Ore
			addOreSpawn(ZollernBlocks.steelOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Garnet Ore
			addOreSpawn(ZollernBlocks.garnetOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Amber Ore
			addOreSpawn(ZollernBlocks.amberOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Aquamarine Ore
			addOreSpawn(ZollernBlocks.aquamarineOre, world, random, x, z, 16,
					16, 6 + random.nextInt(4), 30, 1, 256);
			
			// Ruby Ore
			addOreSpawn(ZollernBlocks.rubyOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Sapphire Ore
			addOreSpawn(ZollernBlocks.sapphireOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Topaz Ore
			addOreSpawn(ZollernBlocks.topazOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Opal Ore
			addOreSpawn(ZollernBlocks.opalOre, world, random, x, z, 16, 16,
					6 + random.nextInt(4), 30, 1, 256);
			
			// Thermal Expansion Ores
			if (ModHelperBase.useThermalExpansion) {
				// Copper Ore
				addOreSpawn(
						Block.getBlockFromItem(BlockOre.oreCopper.getItem()),
						world, random, x, z, 16, 16, 6 + random.nextInt(4), 30,
						1, 256);
				
				// Tin Ore
				addOreSpawn(Block.getBlockFromItem(BlockOre.oreTin.getItem()),
						world, random, x, z, 16, 16, 6 + random.nextInt(4), 30,
						1, 256);
				
				// Silver Ore
				addOreSpawn(
						Block.getBlockFromItem(BlockOre.oreSilver.getItem()),
						world, random, x, z, 16, 16, 6 + random.nextInt(4), 30,
						1, 256);
				
				// Lead Ore
				addOreSpawn(Block.getBlockFromItem(BlockOre.oreLead.getItem()),
						world, random, x, z, 16, 16, 6 + random.nextInt(4), 30,
						1, 256);
				
				// Nickel Ore
				addOreSpawn(
						Block.getBlockFromItem(BlockOre.oreNickel.getItem()),
						world, random, x, z, 16, 16, 6 + random.nextInt(4), 30,
						1, 256);
			}
			
			// ZaneXtras Ores
			if (ModHelperBase.useZaneExtras) {
				// Butter Ore
				addOreSpawn(ZaneBlocks.butterOre, world, random, x, z, 16, 16,
						6 + random.nextInt(4), 30, 1, 256);
				
				// Radite Ore
				addOreSpawn(ZaneBlocks.raditeOre, world, random, x, z, 16, 16,
						6 + random.nextInt(4), 30, 1, 256);
				
				// Zogite Ore
				addOreSpawn(ZaneBlocks.zogiteOre, world, random, x, z, 16, 16,
						6 + random.nextInt(4), 30, 1, 256);
				
				// Staria
				addOreSpawn(ZaneBlocks.stariaOre, world, random, x, z, 16, 16,
						6 + random.nextInt(4), 30, 1, 256);
				
				// Skyium
				addOreSpawn(ZaneBlocks.skyiumOre, world, random, x, z, 16, 16,
						6 + random.nextInt(4), 5, 1, 256);
			}
			
			// Extreme Reactors Ores
			if (ModHelperBase.useExtremeReactors) {
				// Yellorite Ore
				addOreSpawn(BrBlocks.brOre, world, random, x, z, 16, 16,
						6 + random.nextInt(4), 5, 1, 256);
			}
		}
		
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16) + 8;
		int Zcoord = z + random.nextInt(16) + 8;
		
		// Nether Super Charged Coal Ore
		addNetherOreSpawn(ZollernBlocks.netherSuperChargedCoalOre, world,
				random, x, z, 16, 16, 4 + random.nextInt(10),
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
		
		// Nether Iron Ore
		addNetherOreSpawn(ZollernBlocks.netherIronOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), 22, 4, 128);
		
		// Nether Gold Ore
		addNetherOreSpawn(ZollernBlocks.netherGoldOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), 12, 4, 128);
		
		// Nether Diamond Ore
		addNetherOreSpawn(ZollernBlocks.netherDiamondOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 10, 4, 128);
		
		// Nether Emerald Ore
		addNetherOreSpawn(ZollernBlocks.netherEmeraldOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 5, 4, 128);
		
		// Nether Redstone Ore
		addNetherOreSpawn(ZollernBlocks.netherRedstoneOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 8, 4, 128);
		
		// Nether Lapis Ore
		// TODO
		
		// Nether Coal Ore
		// TODO
		
		// Nether Platinum Ore
		// TODO
		
		// Nether Copper Ore
		addNetherOreSpawn(ZollernBlocks.netherCopperOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 21, 4, 128);
		
		// Nether Lead Ore
		addNetherOreSpawn(ZollernBlocks.netherLeadOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), 18, 4, 128);
		
		// Nether Silver Ore
		addNetherOreSpawn(ZollernBlocks.netherSilverOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 11, 4, 128);
		
		// Nether Tin Ore
		addNetherOreSpawn(ZollernBlocks.netherTinOre, world, random, x, z, 16,
				16, 4 + random.nextInt(2), 24, 4, 128);
		
		// Nether Nickel Ore
		addNetherOreSpawn(ZollernBlocks.netherNickleOre, world, random, x, z,
				16, 16, 4 + random.nextInt(2), 8, 4, 128);
		
		// Fake Netherrack
		addNetherOreSpawn(ZollernBlocks.netherrack, world, random, x, z, 16,
				16, 8 + random.nextInt(8), 60, 1, 128);
		
		int y = world.getHeight(x, z);
		Biome currentBiome = world.getBiome(new BlockPos(x, y, z));
		if (currentBiome instanceof BiomeNetherMinersLand) {
			// Nether Super Charged Coal Ore
			addNetherOreSpawn(ZollernBlocks.netherSuperChargedCoalOre, world,
					random, Xcoord, Zcoord, 16, 16, 4 + random.nextInt(10), 30,
					2, 128);
			
			// Nether Amaranth Ore
			addNetherOreSpawn(ZollernBlocks.netherAmaranthOre, world, random,
					x, z, 16, 16, 4 + random.nextInt(2), 30, 2, 128);
			
			// Obsidian (needed for Azurite Ore gen)
			addNetherOreSpawn(Blocks.OBSIDIAN, world, random, x, z, 16, 16,
					10 + random.nextInt(5), 62, 1, 128);
			
			// Azurite Ore
			addObsidianOreSpawn(ZollernBlocks.azuriteOre, world, random, x, z,
					16, 16, 10 + random.nextInt(5),
					ZEConfig.oreAzuriteSpawnRate + 30, 1, 128);
			
			// Nether Ender Shard Ore
			addNetherOreSpawn(ZollernBlocks.netherEnderShardOre, world, random,
					x, z, 16, 16, 2 + random.nextInt(4), 30, 4, 128);
			
			// Nether Fueltonium Ore
			addNetherOreSpawn(ZollernBlocks.netherFueltoniumOre, world, random,
					x, z, 16, 16, 2 + random.nextInt(4), 30, 4, 128);
			
			// Nether Zinc Ore
			addNetherOreSpawn(ZollernBlocks.netherZincOre, world, random, x, z,
					16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Steel Ore
			addNetherOreSpawn(ZollernBlocks.netherSteelOre, world, random, x,
					z, 16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Iron Ore
			addNetherOreSpawn(ZollernBlocks.netherIronOre, world, random, x, z,
					16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Gold Ore
			addNetherOreSpawn(ZollernBlocks.netherGoldOre, world, random, x, z,
					16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Diamond Ore
			addNetherOreSpawn(ZollernBlocks.netherDiamondOre, world, random, x,
					z, 16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Emerald Ore
			addNetherOreSpawn(ZollernBlocks.netherEmeraldOre, world, random, x,
					z, 16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Redstone Ore
			addNetherOreSpawn(ZollernBlocks.netherRedstoneOre, world, random,
					x, z, 16, 16, 4 + random.nextInt(2), 30, 4, 128);
			
			// Nether Lapis Ore
			// TODO
			
			// Nether Coal Ore
			// TODO
			
			// Nether Platinum Ore
			// TODO
			
			// Nether Copper Ore
			addNetherOreSpawn(ZollernBlocks.netherCopperOre, world, random, x,
					z, 16, 16, 4 + random.nextInt(2), 21, 4, 128);
			
			// Nether Lead Ore
			addNetherOreSpawn(ZollernBlocks.netherLeadOre, world, random, x, z,
					16, 16, 4 + random.nextInt(2), 18, 4, 128);
			
			// Nether Silver Ore
			addNetherOreSpawn(ZollernBlocks.netherSilverOre, world, random, x,
					z, 16, 16, 4 + random.nextInt(2), 11, 4, 128);
			
			// Nether Tin Ore
			addNetherOreSpawn(ZollernBlocks.netherTinOre, world, random, x, z,
					16, 16, 4 + random.nextInt(2), 24, 4, 128);
			
			// Nether Nickel Ore
			addNetherOreSpawn(ZollernBlocks.netherNickleOre, world, random, x,
					z, 16, 16, 4 + random.nextInt(2), 8, 4, 128);
			
			// Nether Quartz Ore
			addNetherOreSpawn(Blocks.QUARTZ_ORE, world, random, x, z, 16, 16,
					4 + random.nextInt(2), 8, 4, 128);
		}
		
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		int Xcoord = x + random.nextInt(16);
		int Zcoord = z + random.nextInt(16);
		
		int y = world.getHeight(x, z);
		
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
		
		if (random.nextInt(250) <= 2) {
			(new WorldGenEnderTower()).generate(world, random, new BlockPos(x,
					y, z));
		}
		
	}
	
	private void generateUpsideDown(World world, Random random, int x, int z) {
		// TODO
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