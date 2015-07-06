package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import zollernextras.lib.M;

public class RedRock extends Block {
	public RedRock() {
		super(Material.rock);
		M.setTab(this);
		this.setHardness(1.6F);
		this.setResistance(10F);
		M.setNameAndTexture(this, "redrock");
		this.setStepSound(Block.soundTypeStone);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(BlockList.redRockCobble);
	}
}