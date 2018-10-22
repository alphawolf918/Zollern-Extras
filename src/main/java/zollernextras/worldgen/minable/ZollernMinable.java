package zollernextras.worldgen.minable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.worldgen.predicates.ZollernPredicate;

public class ZollernMinable extends WorldGenMinable {
	
	public ZollernMinable(IBlockState state, int blockCount, Block blockToReplace) {
		super(state, blockCount, new ZollernPredicate(blockToReplace));
	}
}