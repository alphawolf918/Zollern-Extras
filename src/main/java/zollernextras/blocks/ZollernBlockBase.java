package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernBlockBase extends Block {
	
	protected static ZollernBlockBase instance;
	protected static Material blockMaterial = Material.ROCK;
	
	public ZollernBlockBase(String blockName, float hardResist) {
		super(blockMaterial);
		instance = this;
		ZollernHelper.setName(this, blockName);
		ZollernHelper.setTab(this);
		this.setHardness(hardResist);
		this.setResistance(hardResist);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	public Block setBlockHarvestLevel(String toolClass, int level) {
		this.setHarvestLevel(toolClass, level);
		return this;
	}
	
	public Block setMaterial(Material material) {
		blockMaterial = material;
		return this;
	}
	
	@Override
	public Material getMaterial(IBlockState block) {
		return blockMaterial;
	}
	
	public static ZollernBlockBase instance() {
		return instance;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernTabs.zTab;
	}
}