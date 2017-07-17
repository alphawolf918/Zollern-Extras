package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollernextras.lib.EnumBlockVariant;

public class ZollernBlockOre extends ZollernBlockBase {
	
	protected static Item itemDropped;
	protected EnumBlockVariant oreVariant = EnumBlockVariant.OVERWORLD;
	
	public ZollernBlockOre(String strName, float hardResist) {
		super(strName, hardResist);
		this.itemDropped = Item.getItemFromBlock(this);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	public EnumBlockVariant getBlockVariant() {
		return this.oreVariant;
	}
	
	public Block setBlockVariant(EnumBlockVariant variantType) {
		this.oreVariant = variantType;
		return this;
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
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(itemDropped);
	}
	
}