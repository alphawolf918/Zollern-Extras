package zollernextras.worldgen.predicates;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import com.google.common.base.Predicate;

public class ObsidianPredicate implements Predicate<IBlockState> {
	
	public ObsidianPredicate() {
		
	}
	
	@Override
	public boolean apply(IBlockState p_apply_1_) {
		if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.OBSIDIAN) {
			return true;
		}
		return false;
	}
}