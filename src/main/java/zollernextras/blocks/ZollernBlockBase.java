package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernBlockBase extends Block {
	
	protected static ZollernBlockBase instance;
	protected static Material blockMaterial = Material.ROCK;
	protected boolean shouldAlwaysBurn = false;
	
	public ZollernBlockBase(String blockName, float hardResist) {
		super(blockMaterial);
		instance = this;
		ZollernHelper.setName(this, blockName);
		this.setHardness(hardResist);
		this.setResistance(hardResist);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (this.getShouldAlwaysBurn() && side == EnumFacing.UP) {
			return true;
		}
		return false;
	}
	
	public Block setShouldAlwaysBurn(boolean shouldBurn) {
		this.shouldAlwaysBurn = shouldBurn;
		return this;
	}
	
	public boolean getShouldAlwaysBurn() {
		return this.shouldAlwaysBurn;
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