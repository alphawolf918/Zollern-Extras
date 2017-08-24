package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;

public class WorldGenEnderGlow extends WorldGenerator {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		Block block = worldIn.getBlockState(position.up()).getBlock();
		if (block != Blocks.END_STONE && block != Blocks.OBSIDIAN) {
			return false;
		} else {
			worldIn.setBlockState(position,
					ZollernBlocks.enderGlow.getDefaultState());
			
			for (int i = 0; i < 1500; ++i) {
				BlockPos blockpos = position.add(
						rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12),
						rand.nextInt(8) - rand.nextInt(8));
				
				if (worldIn.isAirBlock(blockpos)) {
					int j = 0;
					
					for (EnumFacing enumfacing : EnumFacing.values()) {
						if (worldIn.getBlockState(blockpos.offset(enumfacing))
								.getBlock() == ZollernBlocks.enderGlow) {
							++j;
						}
						
						if (j > 1) {
							break;
						}
					}
					
					if (j == 1) {
						worldIn.setBlockState(blockpos,
								ZollernBlocks.enderGlow.getDefaultState());
					}
				}
			}
			
			return true;
		}
	}
}