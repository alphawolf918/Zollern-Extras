package zollernextras.worldgen.upsidedown.corrupt;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.lib.Treasures;
import zollernextras.lib.ZEChestGenHooks;
import zollernextras.lib.ZollernHelper;

public class WorldGenCorruptBuilding extends WorldGenerator {
	
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
	
	public WorldGenCorruptBuilding() {
		
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
		// j -= 2;
		
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
		
		world.setBlock(i + 4, j + 1, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 1, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 4, j + 2, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 5, j + 1, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 1, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 2, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 5, j + 3, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 6, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 6, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 7, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 0, k + 11, Blocks.mob_spawner);
		if (!world.isRemote) {
			TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner) world
					.getTileEntity(i + 7, j + 0, k + 11);
			tileentitymobspawner1.func_145881_a().setEntityName(
					"zollernextras_shadowfish");
		}
		world.setBlock(i + 7, j + 0, k + 19, Blocks.mob_spawner);
		if (!world.isRemote) {
			TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner) world
					.getTileEntity(i + 7, j + 0, k + 19);
			tileentitymobspawner1.func_145881_a().setEntityName(
					"zollernextras_shadowfish");
		}
		world.setBlock(i + 7, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 7, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 8, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 8, j + 6, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 9, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 6, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 6, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 7, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 7, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 7, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 7, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 7, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 9, j + 7, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 10, j + 1, k + 16, ZollernBlocks.shadePlanks);
		world.setBlock(i + 10, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 6, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 6, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 7, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 7, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 7, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 7, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 7, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 10, j + 7, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 11, j + 1, k + 16, ZollernBlocks.shadePlanks);
		world.setBlock(i + 11, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 6, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 6, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 7, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 7, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 7, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 7, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 7, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 11, j + 7, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 12, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 6, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 6, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 7, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 7, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 7, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 7, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 7, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 12, j + 7, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 13, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 13, j + 6, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 14, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 0, k + 11, Blocks.mob_spawner);
		if (!world.isRemote) {
			TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner) world
					.getTileEntity(i + 14, j + 0, k + 11);
			tileentitymobspawner1.func_145881_a().setEntityName(
					"zollernextras_shadowfish");
		}
		world.setBlock(i + 14, j + 0, k + 19, Blocks.mob_spawner);
		if (!world.isRemote) {
			TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner) world
					.getTileEntity(i + 14, j + 0, k + 19);
			tileentitymobspawner1.func_145881_a().setEntityName(
					"zollernextras_shadowfish");
		}
		world.setBlock(i + 14, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 14, j + 5, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 0, k + 9, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 10, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 11, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 12, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 13, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 14, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 15, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 16, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 17, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 18, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 19, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 20, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 0, k + 21, ZollernBlocks.bloodStone);
		world.setBlock(i + 15, j + 1, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 1, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 2, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 2, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 3, k + 9, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 3, k + 22, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 15, j + 4, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 1, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 2, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 16, j + 3, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 1, k + 21, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 10, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 11, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 12, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 13, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 14, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 15, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 16, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 17, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 18, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 19, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 20, ZollernBlocks.corruptRock);
		world.setBlock(i + 17, j + 2, k + 21, ZollernBlocks.corruptRock);
		int randDist = rand.nextInt(10);
		int chestX = i + 11;
		int chestY = j + 2;
		int chestZ = k + 16;
		int chestRand = rand.nextInt(2);
		boolean isBigChest = chestRand == 1 ? true : false;
		String chestString = chestX + " " + chestY + " " + chestZ;
		Treasures.spawnChest(world, rand, chestX, chestY, chestZ, isBigChest,
				ZEChestGenHooks.CORRUPT_BUILDING);
		ZollernHelper.Log("Spawned Corrupt Building structure at: " + i + " "
				+ j + " " + k);
		return true;
	}
}