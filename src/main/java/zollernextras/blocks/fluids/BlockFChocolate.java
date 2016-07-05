package zollernextras.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFChocolate extends BlockFluidClassic {
	
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	
	public BlockFChocolate(Fluid fluid) {
		super(fluid, Material.water);
		MainHelper.setName(this, "chocolate");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		IIcon result = stillIcon;
		if (side == 1) {
			result = flowingIcon;
		}
		return result;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_,
			int p_149720_3_, int p_149720_4_) {
		return 0x302013;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iir) {
		stillIcon = iir.registerIcon(ModInfo.MODID + ":" + "chocolate_still");
		flowingIcon = iir.registerIcon(ModInfo.MODID + ":"
				+ "chocolate_flowing");
		this.getFluid().setStillIcon(
				iir.registerIcon(ModInfo.MODID + ":chocolate_still"));
		this.getFluid().setFlowingIcon(
				iir.registerIcon(ModInfo.MODID + ":chocolate_flowing"));
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
			return false;
		} else {
			return super.canDisplace(world, x, y, z);
		}
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
			return false;
		} else {
			return super.displaceIfPossible(world, x, y, z);
		}
	}
	
}