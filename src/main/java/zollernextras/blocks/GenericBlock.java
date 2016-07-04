package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class GenericBlock extends Block {
	
	public static Material blockMaterial = Material.rock;
	public static SoundType soundType = soundTypeStone;
	public static String harvestTool = "pickaxe";
	public static int harvestLevel = 0;
	
	public GenericBlock(String strTexture, float resistHardness) {
		super(blockMaterial);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
		if (resistHardness != 0F) {
			this.setResistance(resistHardness);
			this.setHardness(resistHardness);
		}
		this.setStepSound(soundType);
		if (harvestLevel > 0) {
			this.setHarvestLevel(harvestTool, harvestLevel);
		}
	}
	
	public static void setMaterial(Material material) {
		blockMaterial = material;
	}
	
	@Override
	public Material getMaterial() {
		return blockMaterial;
	}
	
}