package zollernextras.blocks.lostdesert;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class CreepDirt extends Block {
	public CreepDirt() {
		super(Material.ground);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "creepdirt");
		this.setResistance(0.5F);
		this.setHardness(0.4F);
		this.setStepSound(soundTypeGravel);
		this.setHarvestLevel("shovel", 2);
	}
}