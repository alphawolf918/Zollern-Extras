package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;

public class SeaLamp extends Block {
	public SeaLamp() {
		super(Material.glass);
		ZollernHelper.setTab(this);
		this.setBlockName(ZollernModInfo.MODID + "_sealamp");
		ZollernHelper.setNameAndTexture(this, "sealamp");
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setLightOpacity(0);
		this.setLightLevel(1.0F);
		this.setStepSound(soundTypeGlass);
		this.setHarvestLevel("pickaxe", 1);
	}
}