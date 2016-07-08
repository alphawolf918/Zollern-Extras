package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.BlockList;
import zollernextras.lib.Treasures;
import zollernextras.lib.ZEChestGenHooks;
import zollernextras.mobs.entities.EntityEnderSkeleton;

public class WorldGenEnderTower extends WorldGenerator {
	
	int randInt = new Random().nextInt(10);
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] { Blocks.end_stone, BlockList.enderDirt };
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);
		
		while (checkID != Blocks.air) {
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 3) {
			return false;
		}
		j += distanceToAir - 1;
		
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j + 1, k);
		Block blockIDBelow = world.getBlock(i, j - 1, k);
		for (Block x : GetValidSpawnBlocks()) {
			if (blockIDAbove != Blocks.air) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID == Blocks.end_stone && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public void setBlock(World world, int x, int y, int z, Block block,
			int metadata) {
		Block b1 = world.getBlock(x, y, z);
		
		if (b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, metadata, metadata);
		}
	}
	
	public WorldGenEnderTower() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
		j -= 10;
		if (world.getBlock(i, j + 1, k) == Blocks.air) {
			return false;
		}
		
		world.setBlock(i + 4, j + 2, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 2, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 2, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 2, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 2, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 2, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 2, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 3, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 4, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 5, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 6, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 7, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 4, j + 8, k + 16,
				
				BlockList.purpurBlock);
		int randDist = rand.nextInt(10);
		int chestX = i + 5;
		int chestY = j - 1;
		int chestZ = k + 13;
		int chestRand = rand.nextInt(2);
		boolean isBigChest = chestRand == 1 ? true : false;
		String chestString = chestX + " " + chestY + " " + chestZ;
		world.setBlock(chestX, chestY, chestZ, Blocks.chest);
		if (randDist == 5) {
			Treasures.spawnChest(world, rand, chestX, chestY, chestZ,
					isBigChest, ZEChestGenHooks.CRYSTAL_TOWER);
		}
		world.setBlock(i + 5, j + 2, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 2, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 2, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 2, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 3, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 3, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 3, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 3, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 4, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 4, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 4, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 4, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 5, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 5, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 5, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 5, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 6, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 6, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 6, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 6, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 7, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 7, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 7, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 7, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 8, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 5, j + 9, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 2, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 2, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 3, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 3, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 4, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 4, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 5, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 5, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 6, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 6, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 7, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 7, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 8, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 8, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 8, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 8, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 8, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 8, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 9, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 9, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 9, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 9, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 9, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 9, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 10, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 10, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 10, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 10, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 10, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 11, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 11, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 11, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 11, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 6, j + 11, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 2, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 2, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 3, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 3, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 4, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 4, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 5, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 5, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 6, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 6, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 7, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 7, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 8, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 8, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 8, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 8, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 9, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 9, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 9, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 9, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 10, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 10, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 10, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 10, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 11, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 11, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 11, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 11, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 12, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 12, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 12, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 12, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 12, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 13, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 13, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 13, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 13, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 7, j + 13, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 2, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 2, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 3, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 3, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 4, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 4, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 5, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 5, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 6, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 6, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 7, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 7, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 8, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 8, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 8, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 8, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 9, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 9, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 10, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 10, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 10, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 10, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 11, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 11, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 11, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 11, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 12, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 12, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 12, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 12, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 13, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 13, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 13, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 13, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 14, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 14, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 14, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 14, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 14, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 15, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 15, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 15, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 15, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 8, j + 15, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 2, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 2, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 3, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 3, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 4, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 4, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 5, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 5, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 6, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 6, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 7, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 7, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 8, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 8, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 9, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 9, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 9, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 9, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 10, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 10, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 11, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 11, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 12, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 12, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 13, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 13, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 14, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 14, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 14, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 14, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 15, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 15, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 15, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 15, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 16, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 16, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 16, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 16, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 16, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 17, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 17, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 17, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 17, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 9, j + 17, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 2, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 2, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 3, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 3, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 4, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 4, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 5, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 5, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 6, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 6, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 7, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 7, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 8, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 8, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 9, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 9, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 10, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 10, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 11, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 11, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 12, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 12, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 13, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 13, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 14, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 14, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 15, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 15, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 15, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 15, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 16, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 16, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 17, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 17, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 18, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 18, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 18, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 18, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 18, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 19, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 19, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 19, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 19, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 10, j + 19, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 9, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 9, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 10, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 10, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 11, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 11, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 12, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 12, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 13, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 13, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 14, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 14, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 15, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 15, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 16, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 16, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 17, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 17, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 18, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 18, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 19, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 19, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 19, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 19, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 20, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 20, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 20, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 21, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 21, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 11, j + 21, k + 14,
				
				BlockList.purpurBlock);
		int randDist2 = rand.nextInt(10);
		int chestX2 = i + 12;
		int chestY2 = j + 11;
		int chestZ2 = k + 13;
		int chestRand2 = rand.nextInt(2);
		boolean isBigChest2 = chestRand2 == 1 ? true : false;
		String chestString2 = chestX2 + " " + chestY2 + " " + chestZ2;
		world.setBlock(chestX2, chestY2, chestZ2, Blocks.chest);
		if (randDist == 5) {
			Treasures.spawnChest(world, rand, chestX2, chestY2, chestZ2,
					isBigChest2, ZEChestGenHooks.CRYSTAL_TOWER);
		}
		world.setBlock(i + 12, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 10, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 10, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 11, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 11, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 12, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 12, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 13, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 13, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 14, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 14, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 15, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 15, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 16, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 16, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 17, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 17, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 18, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 18, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 19, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 19, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 19, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 19, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 20, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 20, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 21, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 21, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 22, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 22, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 22, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 23, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 23, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 12, j + 23, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 10, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 10, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 11, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 11, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 12, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 12, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 13, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 13, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 14, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 14, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 15, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 15, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 16, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 16, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 17, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 17, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 18, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 18, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 19, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 19, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 20, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 20, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 21, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 21, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 22, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 22, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 23, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 23, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 24, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 24, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 13, j + 24, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 10, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 10, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 11, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 11, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 12, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 12, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 13, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 13, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 14, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 14, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 15, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 15, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 16, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 16, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 17, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 17, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 18, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 18, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 19, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 19, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 20, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 20, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 21, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 21, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 22, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 22, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 23, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 23, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 24, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 14, j + 24, k + 13, BlockList.enderPearlBlock);
		
		if (!world.isRemote) {
			EntityEnderSkeleton skeleton = new EntityEnderSkeleton(world);
			skeleton.setLocationAndAngles(i + 14, j + 25, k + 13, 0.0f, 0.0f);
			world.spawnEntityInWorld(skeleton);
			
			for (int t = 1; t < rand.nextInt(5) + 1; t++) {
				EntityEnderSkeleton skeleton2 = new EntityEnderSkeleton(world);
				skeleton2.setLocationAndAngles(i + 14 + t, j + 25, k + 13 + t,
						0.0f, 0.0f);
				world.spawnEntityInWorld(skeleton2);
			}
		}
		
		world.setBlock(i + 14, j + 24, k + 14, BlockList.purpurBlock);
		
		generate2(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate2(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 15, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 10, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 10, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 11, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 11, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 12, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 12, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 13, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 13, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 14, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 14, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 15, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 15, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 16, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 16, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 17, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 17, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 18, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 18, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 19, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 19, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 20, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 20, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 21, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 21, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 22, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 22, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 23, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 23, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 24, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 24, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 15, j + 24, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 10, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 10, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 11, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 11, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 12, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 12, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 13, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 13, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 14, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 14, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 15, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 15, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 16, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 16, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 17, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 17, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 18, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 18, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 19, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 19, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 19, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 19, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 20, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 20, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 21, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 21, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 22, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 22, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 22, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 23, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 23, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 16, j + 23, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 2, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 2, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 3, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 3, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 4, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 4, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 5, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 5, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 6, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 6, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 7, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 7, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 8, k + 3,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 8, k + 23,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 9, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 9, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 9, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 9, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 10, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 10, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 11, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 11, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 12, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 12, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 13, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 13, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 14, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 14, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 15, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 15, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 16, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 16, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 17, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 17, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 18, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 18, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 19, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 19, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 19, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 19, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 20, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 20, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 20, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 21, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 21, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 17, j + 21, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 2, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 2, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 3, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 3, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 4, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 4, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 5, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 5, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 6, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 6, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 7, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 7, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 8, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 8, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 9, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 9, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 10, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 10, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 11, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 11, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 12, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 12, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 13, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 13, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 14, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 14, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 15, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 15, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 15, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 15, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 16, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 16, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 17, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 17, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 18, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 18, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 18, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 18, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 18, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 19, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 19, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 19, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 19, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 18, j + 19, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 2, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 2, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 3, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 3, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 4, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 4, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 5, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 5, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 6, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 6, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 7, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 7, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 8, k + 4,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 8, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 8, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 8, k + 22,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 9, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 9, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 9, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 9, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 10, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 10, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 11, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 11, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 12, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 12, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 13, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 13, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 14, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 14, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 14, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 14, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 15, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 15, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 15, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 15, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 16, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 16, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 16, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 16, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 16, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 17, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 17, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 17, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 17, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 19, j + 17, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 2, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 2, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 3, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 3, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 4, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 4, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 5, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 5, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 6, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 6, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 7, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 7, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 8, k + 5,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 8, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 8, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 8, k + 21,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 9, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 9, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 10, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 10, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 10, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 10, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 11, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 11, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 11, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 11, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 12, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 12, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 12, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 12, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 13, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 13, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 13, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 13, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 14, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 14, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 14, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 14, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 14, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 15, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 15, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 15, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 15, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 20, j + 15, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 2, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 2, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 3, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 3, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 4, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 4, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 5, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 5, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 6, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 6, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 7, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 7, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 8, k + 6,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 8, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 8, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 8, k + 20,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 9, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 9, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 9, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 9, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 10, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 10, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 10, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 10, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 11, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 11, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 11, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 11, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 12, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 12, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 12, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 12, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 12, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 13, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 13, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 13, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 13, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 21, j + 13, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 2, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 2, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 3, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 3, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 4, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 4, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 5, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 5, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 6, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 6, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 7, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 7, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 8, k + 7,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 8, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 8, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 8, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 8, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 8, k + 19,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 9, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 9, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 9, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 9, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 9, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 9, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 10, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 10, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 10, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 10, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 10, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 11, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 11, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 11, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 11, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 22, j + 11, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 2, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 2, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 2, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 2, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 3, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 3, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 3, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 3, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 4, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 4, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 4, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 4, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 5, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 5, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 5, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 5, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 6, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 6, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 6, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 6, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 7, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 7, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 7, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 7, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 8,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 9,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 17,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 8, k + 18,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 23, j + 9, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 2, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 2, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 2, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 2, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 2, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 3, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 3, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 3, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 3, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 3, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 4, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 5, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 6, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 7, k + 16,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 10,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 11,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 12,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 13,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 14,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 15,
				
				BlockList.purpurBlock);
		world.setBlock(i + 24, j + 8, k + 16,
				
				BlockList.purpurBlock);
		return true;
	}
}