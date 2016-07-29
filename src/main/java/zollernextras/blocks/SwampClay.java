package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernHelper;

public class SwampClay extends Block {
	public SwampClay() {
		super(Material.clay);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "swampclay");
		this.setHardness(1.0F);
		this.setResistance(0.1F);
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(this.soundTypeGravel);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ZollernItems.swampClayBall;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 4;
	}
}