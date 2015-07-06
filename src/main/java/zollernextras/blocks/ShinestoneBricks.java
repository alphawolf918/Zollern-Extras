package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class ShinestoneBricks extends Block {
	public ShinestoneBricks() {
		super(Material.glass);
		M.setTab(this);
		M.setNameAndTexture(this, "crystalbricks");
		this.setHardness(1.4F);
		this.setResistance(6.0F);
		this.setLightLevel(1.0F);
		this.setStepSound(this.soundTypeGlass);
	}
}