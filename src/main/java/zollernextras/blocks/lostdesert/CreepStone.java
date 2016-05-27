package zollernextras.blocks.lostdesert;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class CreepStone extends Block {
	public CreepStone() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "creepstone");
		this.setResistance(4.5F);
		this.setHardness(2.4F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
	}
}