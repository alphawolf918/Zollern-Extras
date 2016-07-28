package zollernextras.blocks.fluids;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import zollernextras.blocks.materials.MaterialList;
import zollernextras.lib.DSource;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFFueltonium extends BlockFluidClassic {
	
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	
	public BlockFFueltonium(Fluid fluid) {
		super(fluid, MaterialList.fueltonium);
		MainHelper.setName(this, "fuel");
		// this.setTickRandomly(true);
	}
	
	// @Override
	// public void updateTick(World world, int x, int y, int z, Random rand) {
	// super.updateTick(world, x, y, z, rand);
	// if (world.getBlock(x, y + 1, z) == Blocks.fire) {
	// world.createExplosion(null, x, y, z, 20, true);
	// }
	// }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			living.attackEntityFrom(DSource.deathFueltonium, 4.0F);
		} else if (entity instanceof EntityItem) {
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
		return 0x008b00;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iir) {
		stillIcon = iir.registerIcon(ZollernModInfo.MODID + ":" + "fuel");
		flowingIcon = iir.registerIcon(ZollernModInfo.MODID + ":" + "fuel");
		this.getFluid().setStillIcon(iir.registerIcon(ZollernModInfo.MODID + ":fuel"));
		this.getFluid().setFlowingIcon(
				iir.registerIcon(ZollernModInfo.MODID + ":fuel"));
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