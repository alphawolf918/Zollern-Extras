package zollernextras.worldgen.upsidedown;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.lib.Treasures;
import zollernextras.lib.ZEChestGenHooks;
import zollernextras.lib.ZollernHelper;

public class WorldGenShadeMonument extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlockList() {
		return new Block[] { ZollernBlocks.upsideDownStone,
				ZollernBlocks.upsideDownSurfaceRock,
				ZollernBlocks.upsideDownRock, ZollernBlocks.upsideDownDirt };
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);
		
		while (checkID != Blocks.air) {
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 8) {
			return false;
		}
		j += distanceToAir - 1;
		
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j + 1, k);
		Block blockIDBelow = world.getBlock(i, j - 1, k);
		for (Block x : GetValidSpawnBlockList()) {
			if (blockIDAbove != Blocks.air) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID != x && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public void failedToSpawn(String strMessage) {
		ZollernHelper.debugLog("Failed to spawn structure: " + strMessage);
	}
	
	public WorldGenShadeMonument() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
		j -= 1;
		
		int x = i;
		int y = j;
		int z = k;
		
		if (!LocationIsValidSpawn(world, x, y, z)) {
			this.failedToSpawn("Location was not valid spawn.");
			return false;
		}
		
		if (world.getBlock(x, y - 1, z) == Blocks.air) {
			this.failedToSpawn("The block below was air.");
			return false;
		}
		
		if (world.getBlock(x, y + 1, z) != Blocks.air) {
			this.failedToSpawn("The block above was NOT air.");
			return false;
		}
		generate2(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate2(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 11, j + 1, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 1, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 2, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 2, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 10, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 11, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 13, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 14, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 16, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 11, j + 3, k + 18, ZollernBlocks.shadowBoneBlock);
		generate3(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate3(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 12, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 12, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 12, j + 3, k + 18, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 12, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 12, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 12, j + 4, k + 18, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 10, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 11, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 13, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 14, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 16, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 13, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 5, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 5, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 6, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 6, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 6, k + 16, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 14, j + 6, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 10, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 11, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 13, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 14, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 15, j + 6, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 6, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 6, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 6, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 7, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 16, j + 8, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 10, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 11, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 13, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 14, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 17, j + 6, k + 15, ZollernBlocks.shadowBoneBlock);
		generate4(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate4(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 18, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 5, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 5, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 6, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 6, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 6, k + 16, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 18, j + 6, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 10, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 11, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 13, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 14, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 16, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 19, j + 4, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 1, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 2, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 3, k + 18, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 3, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 20, j + 4, k + 18, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 1, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 2, k + 19, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 8, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 9, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 10, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 11, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 12, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 13, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 14, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 15, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 16, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 17, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 21, j + 3, k + 18, ZollernBlocks.shadowBoneBlock);
		if (rand.nextInt(100) <= 95) {
			int chestX = i + 16;
			int chestY = j + 9;
			int chestZ = k + 12;
			int chestRand = rand.nextInt(2);
			boolean isBigChest = false;
			String chestString = chestX + " " + chestY + " " + chestZ;
			Treasures.spawnChest(world, rand, chestX, chestY, chestZ,
					isBigChest, ZEChestGenHooks.SHADE_TREE);
		}
		ZollernHelper.Log("Spawned structure at: " + i + " " + j + " " + k);
		return true;
	}
}