package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import zollernextras.items.ZollernItems;

public class BlockShinestone extends ZollernBlockBase {
	
	public BlockShinestone() {
		super("shinestone", 1.2F);
		this.setMaterial(Material.GLASS);
		this.setLightLevel(1.0F);
		this.setSoundType(SoundType.GLASS);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return ZollernItems.shinestoneDust;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int randInt = rand.nextInt(4);
		return (randInt > 0) ? randInt : 1;
	}
}