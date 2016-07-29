package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import zollernextras.lib.ZollernHelper;

public class RedRock extends Block {
	public RedRock() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		this.setHardness(1.4F);
		this.setResistance(10F);
		ZollernHelper.setNameAndTexture(this, "redrock");
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(ZollernBlocks.redRockCobble);
	}
}