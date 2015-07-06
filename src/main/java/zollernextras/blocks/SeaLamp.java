package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;
import zollernextras.lib.Reference;

public class SeaLamp extends Block {
	public SeaLamp() {
		super(Material.glass);
		M.setTab(this);
		this.setBlockName(Reference.MODID + "_sealamp");
		M.setNameAndTexture(this, "sealamp");
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setLightOpacity(0);
		this.setLightLevel(1.0F);
		this.setStepSound(soundTypeGlass);
	}
}