package zollernextras.worldgen.predicates;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import com.google.common.base.Predicate;

public class ZollernPredicate implements Predicate<IBlockState> {
	
	private Block blockPredicate = Blocks.STONE;
	
	public ZollernPredicate(Block predicateBlock) {
		this.blockPredicate = predicateBlock;
	}
	
	@Override
	public boolean apply(IBlockState p_apply_1_) {
		if (p_apply_1_ != null && p_apply_1_.getBlock() == this.blockPredicate) {
			return true;
		}
		return false;
	}
}