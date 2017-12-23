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

public class WorldGenShadowSkull extends WorldGenerator {
	
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
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
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
		
		world.setBlock(i + 1, j + 2, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 2, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 2, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 2, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 2, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 2, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 2, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 3, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 4, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 4, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 4, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 5, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 6, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 6, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 6, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 6, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 6, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 7, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 8, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 8, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 8, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 9, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 9, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 9, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 9, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 9, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 10, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 11, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 11, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 11, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 11, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 1, j + 11, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 2, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 2, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 2, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 2, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 2, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 5, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 5, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 6, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 6, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 7, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 7, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 8, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 8, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 9, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 9, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 10, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 10, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 11, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 12, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 12, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 12, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 12, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 2, j + 12, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 0, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 1, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 2, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 2, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 2, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 2, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 2, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 3, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 3, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 4, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 5, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 5, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 6, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 6, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 8, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 8, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 9, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 9, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 10, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 10, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 11, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 11, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 12, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 12, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 12, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 12, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 12, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 13, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 13, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 3, j + 13, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 0, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 1, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 2, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 2, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 2, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 2, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 2, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 3, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 3, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 3, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 4, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 4, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 5, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 5, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 5, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 6, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 6, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 6, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 7, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 7, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 7, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 8, k + 1, ZollernBlocks.shadowBoneBlock);
		int randDist = rand.nextInt(10);
		int chestX = i + 4;
		int chestY = j + 8;
		int chestZ = k + 4;
		boolean isBigChest = false;
		String chestString = chestX + " " + chestY + " " + chestZ;
		Treasures.spawnChest(world, rand, chestX, chestY, chestZ, isBigChest,
				ZEChestGenHooks.SHADE_TREE);
		world.setBlock(i + 4, j + 8, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 9, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 9, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 10, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 10, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 11, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 11, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 12, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 12, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 12, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 12, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 12, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 13, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 13, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 4, j + 13, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 2, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 2, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 2, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 2, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 2, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 4, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 5, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 5, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 6, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 6, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 7, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 7, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 8, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 8, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 9, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 9, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 10, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 10, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 11, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 11, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 12, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 12, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 12, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 12, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 5, j + 12, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 2, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 2, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 3, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 4, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 5, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 6, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 7, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 8, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 9, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 1, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 6, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 10, k + 7, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 11, k + 2, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 11, k + 3, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 11, k + 4, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 11, k + 5, ZollernBlocks.shadowBoneBlock);
		world.setBlock(i + 6, j + 11, k + 6, ZollernBlocks.shadowBoneBlock);
		
		return true;
	}
}