package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class ShinestoneCrystal extends Block {
	public ShinestoneCrystal() {
		super(Material.glass);
		M.setTab(this);
		M.setNameAndTexture(this, "shinestonecrystal");
		this.setHardness(1.2F);
		this.setResistance(4.0F);
		this.setLightLevel(1.0F);
		this.setStepSound(this.soundTypeGlass);
	}
}