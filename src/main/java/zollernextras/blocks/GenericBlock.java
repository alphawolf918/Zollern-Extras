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
		this.setTab();
		this.setNameAndTexture(strTexture);
		if (resistHardness != 0F) {
			this.setHardResist(resistHardness);
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
	
	public Block setHardResist(float hardness, float resistance) {
		ZollernHelper.setHardResist(this, hardness, resistance);
		return this;
	}
	
	public Block setHardResist(float hardResist) {
		ZollernHelper.setHardResist(this, hardResist);
		return this;
	}
	
	public Block setTab() {
		ZollernHelper.setTab(this);
		return this;
	}
	
	public Block setName(String strName) {
		ZollernHelper.setName(this, strName);
		return this;
	}
	
	public Block setTexture(String strTexture) {
		ZollernHelper.setTexture(this, strTexture);
		return this;
	}
	
	public Block setNameAndTexture(String strNameTexture) {
		ZollernHelper.setNameAndTexture(this, strNameTexture);
		return this;
	}
	
	public Block setNameAndTexture(String strName, String strTexture) {
		ZollernHelper.setNameAndTexture(this, strName, strTexture);
		return this;
	}
}