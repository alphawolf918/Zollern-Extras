package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class ShinestoneCrystal extends Block {
	public ShinestoneCrystal() {
		super(Material.glass);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "shinestonecrystal");
		this.setHardness(1.2F);
		this.setResistance(4.0F);
		this.setLightLevel(1.0F);
		this.setStepSound(this.soundTypeGlass);
		this.setHarvestLevel("pickaxe", 1);
	}
}