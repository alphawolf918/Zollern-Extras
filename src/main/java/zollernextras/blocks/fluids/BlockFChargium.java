package zollernextras.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFChargium extends BlockFluidClassic {
	
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	
	public BlockFChargium(Fluid fluid) {
		super(fluid, Material.water);
		ZollernHelper.setName(this, "chargiumfluid");
		this.setLightLevel(1.0F);
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z,
			ForgeDirection face) {
		return true;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {
		if (entity instanceof EntityItem) {
			EntityItem item = (EntityItem) entity;
			item.setDead();
		}
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
		return 0x0099ff;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iir) {
		stillIcon = iir.registerIcon(ZollernModInfo.MODID + ":"
				+ "chargiumfluid");
		flowingIcon = iir.registerIcon(ZollernModInfo.MODID + ":"
				+ "chargiumfluid");
		this.getFluid().setStillIcon(
				iir.registerIcon(ZollernModInfo.MODID + ":chargiumfluid"));
		this.getFluid().setFlowingIcon(
				iir.registerIcon(ZollernModInfo.MODID + ":chargiumfluid"));
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