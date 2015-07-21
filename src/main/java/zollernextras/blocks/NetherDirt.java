package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class NetherDirt extends Block {
	public NetherDirt() {
		super(Material.rock);
		MainHelper.setTab(this);
		this.setHardness(0.2F);
		this.setResistance(0.1F);
		MainHelper.setNameAndTexture(this, "netherdirt");
		this.setStepSound(soundTypeGravel);
		this.setHarvestLevel("shovel", 1);
	}
}