package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;

public class SeaLamp extends Block {
	public SeaLamp() {
		super(Material.glass);
		MainHelper.setTab(this);
		this.setBlockName(ModInfo.MODID + "_sealamp");
		MainHelper.setNameAndTexture(this, "sealamp");
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setLightOpacity(0);
		this.setLightLevel(1.0F);
		this.setStepSound(soundTypeGlass);
		this.setHarvestLevel("pickaxe", 1);
	}
}