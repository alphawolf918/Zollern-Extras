package zollernextras.blocks.lostdesert;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class WonderStone extends Block {
	public WonderStone() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "wonderstone");
		this.setResistance(2.5F);
		this.setHardness(4F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
	}
}