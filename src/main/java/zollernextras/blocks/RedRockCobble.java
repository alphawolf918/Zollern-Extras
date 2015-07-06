package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class RedRockCobble extends Block {
	public RedRockCobble() {
		super(Material.rock);
		M.setTab(this);
		this.setHardness(1.6F);
		this.setResistance(10F);
		M.setNameAndTexture(this, "redrockcobble", "redcobble");
	}
}