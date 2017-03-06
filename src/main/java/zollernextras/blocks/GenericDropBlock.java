package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class GenericDropBlock extends GenericBlock {
	
	protected Item itemDropped;
	protected int itemAmountDropped;
	
	public GenericDropBlock(String strTexture, float hardResist) {
		super(strTexture, hardResist);
	}
	
	public Block setItemDropped(Item itemToDrop) {
		this.itemDropped = itemToDrop;
		return this;
	}
	
	public Block setItemAmountDropped(int itemAmountToDrop) {
		this.itemAmountDropped = itemAmountToDrop;
		return this;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return this.itemDropped;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return this.itemAmountDropped;
	}
}