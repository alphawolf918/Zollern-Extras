package zollernextras.blocks.upsidedown.corrupt;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import zollernextras.blocks.ZollernBlocks;

public class CorruptStone extends CorruptBlock {
	
	public CorruptStone() {
		super("corruptstone", 1.8F);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand,
			int fortune) {
		return Item.getItemFromBlock(ZollernBlocks.corruptCobble);
	}
	
}