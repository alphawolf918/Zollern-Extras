package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class ZollernBlockOre extends ZollernBlockBase {
	
	protected static Item itemDropped;
	protected static int amountDropped = 1;
	
	public ZollernBlockOre(String strName, float hardResist) {
		super(strName, hardResist);
		this.itemDropped = Item.getItemFromBlock(this);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	public Block setItemDropped(Item itemToDrop) {
		itemDropped = itemToDrop;
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return itemDropped;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return amountDropped;
	}
	
	public Block setAmountDropped(int dropAmount) {
		amountDropped = dropAmount;
		return this;
	}
	
}