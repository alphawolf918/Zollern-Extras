package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class RedRockCobble extends Block {
	public RedRockCobble() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		this.setHardness(1.2F);
		this.setResistance(10F);
		ZollernHelper.setNameAndTexture(this, "redrockcobble", "redcobble");
		this.setHarvestLevel("pickaxe", 1);
	}
}