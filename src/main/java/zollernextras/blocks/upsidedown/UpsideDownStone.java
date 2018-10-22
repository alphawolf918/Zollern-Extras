package zollernextras.blocks.upsidedown;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import zollernextras.blocks.ZollernBlockBase;
import zollernextras.blocks.ZollernBlocks;

public class UpsideDownStone extends ZollernBlockBase {
	
	public UpsideDownStone() {
		super("ud_stone", 1.4F);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return Item.getItemFromBlock(ZollernBlocks.upsideDownCobble);
	}
	
}