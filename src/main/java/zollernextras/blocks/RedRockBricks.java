package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class RedRockBricks extends Block {
	public RedRockBricks() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		this.setHardness(0.5F);
		this.setResistance(10F);
		ZollernHelper.setNameAndTexture(this, "redrockbricks", "redrockbrick");
		this.setHarvestLevel("pickaxe", 1);
	}
}