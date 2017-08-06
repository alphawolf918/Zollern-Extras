package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import zollernextras.items.ZollernItems;

public class BlockSwampClay extends ZollernBlockBase {
	
	public BlockSwampClay() {
		super("swampclay", 0.6F);
		this.setMaterial(Material.CLAY);
		this.setLightLevel(1.0F);
		this.setSoundType(SoundType.SNOW);
		this.setHarvestLevel("shovel", 0);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand,
			int fortune) {
		return ZollernItems.swampClayBall;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int randInt = rand.nextInt(4);
		return (randInt > 0) ? randInt : 2;
	}
	
}