package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class ShinestoneBricks extends Block {
	public ShinestoneBricks() {
		super(Material.glass);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "crystalbricks");
		this.setHardness(1.2F);
		this.setResistance(6.0F);
		this.setLightLevel(1.0F);
		this.setStepSound(this.soundTypeGlass);
		this.setHarvestLevel("pickaxe", 1);
	}
}