package zollernextras.worldgen.minable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.worldgen.predicates.ObsidianPredicate;

public class WorldGenObsidianMinable extends WorldGenMinable {
	
	public WorldGenObsidianMinable(IBlockState state, int blockCount) {
		super(state, blockCount, new ObsidianPredicate());
	}
}