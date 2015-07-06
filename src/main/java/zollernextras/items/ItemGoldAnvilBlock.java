package zollernextras.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import zollernextras.blocks.GoldenAnvil;

public class ItemGoldAnvilBlock extends ItemMultiTexture {
	private static final String __OBFID = "CL_00001764";
	
	public ItemGoldAnvilBlock(Block p_i1826_1_) {
		super(p_i1826_1_, p_i1826_1_, GoldenAnvil.anvilDamageNames);
	}
	
	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	@Override
	public int getMetadata(int p_77647_1_) {
		return p_77647_1_ << 2;
	}
}