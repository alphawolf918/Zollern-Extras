package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class GenericBlock extends Block {
	
	public static Material blockMaterial = Material.rock;
	public static SoundType soundType = soundTypeStone;
	public static String harvestTool = "pickaxe";
	public static int harvestLevel = 0;
	
	public GenericBlock(String strTexture, float resistHardness) {
		super(blockMaterial);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
		if (resistHardness != 0F) {
			this.setResistance(resistHardness);
			this.setHardness(resistHardness);
		}
		this.setStepSound(soundType);
		if (harvestLevel > 0) {
			this.setHarvestLevel(harvestTool, harvestLevel);
		} else {
			this.setHarvestLevel("pickaxe", 0);
		}
	}
	
	public Block setBlockMaterial(Material material) {
		blockMaterial = material;
		return this;
	}
	
	public static void setMaterial(Material material) {
		blockMaterial = material;
	}
	
	@Override
	public Material getMaterial() {
		return blockMaterial;
	}
	
	public Block setBlockHarvestLevel(String tool, int level) {
		this.setHarvestLevel(tool, level, 0);
		return this;
	}
	
}