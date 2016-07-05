package zollernextras.blocks.fluids;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import zollernextras.blocks.materials.MaterialList;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;
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
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			living.addPotionEffect(new PotionEffect(Potion.harm.id, 60, 4));
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
		return 0x00ff00;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iir) {
		stillIcon = iir.registerIcon(ModInfo.MODID + ":" + "fuel");
		flowingIcon = iir.registerIcon(ModInfo.MODID + ":" + "fuel");
		this.getFluid().setStillIcon(iir.registerIcon(ModInfo.MODID + ":fuel"));
		this.getFluid().setFlowingIcon(
				iir.registerIcon(ModInfo.MODID + ":fuel"));
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