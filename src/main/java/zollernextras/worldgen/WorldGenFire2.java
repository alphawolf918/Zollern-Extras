package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;

public class WorldGenFire2 extends WorldGenerator {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8),
					rand.nextInt(4) - rand.nextInt(4),
					rand.nextInt(8) - rand.nextInt(8));
			
			IBlockState blockState = worldIn.getBlockState(blockpos.down());
			Block block = blockState.getBlock();
			
			if (worldIn.isAirBlock(blockpos)) {
				if (block == Blocks.NETHERRACK
						|| block == ZollernBlocks.blazeRock
						|| block == Blocks.OBSIDIAN
						|| block == ZollernBlocks.netherDirt
						|| block == Blocks.SOUL_SAND) {
					worldIn.setBlockState(blockpos,
							Blocks.FIRE.getDefaultState(), 2);
				}
			}
		}
		
		return true;
	}
}