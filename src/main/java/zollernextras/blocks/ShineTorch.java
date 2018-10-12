package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ShineTorch extends BlockTorch {
	
	protected ShineTorch() {
		super();
		ZollernHelper.setName(this, "shinetorch");
		this.setDefaultState(this.blockState.getBaseState().withProperty(
				FACING, EnumFacing.UP));
		this.setTickRandomly(true);
		this.setLightLevel(1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn,
			BlockPos pos, Random rand) {
		EnumFacing enumfacing = stateIn.getValue(FACING);
		double d0 = pos.getX() + 0.5D;
		double d1 = pos.getY() + 0.7D;
		double d2 = pos.getZ() + 0.5D;
		double d3 = 0.22D;
		double d4 = 0.27D;
		
		if (enumfacing.getAxis().isHorizontal()) {
			EnumFacing enumfacing1 = enumfacing.getOpposite();
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.27D
					* enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.27D
					* enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D,
					new int[0]);
		} else {
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2,
					0.0D, 0.0D, 0.0D, new int[0]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernTabs.zTab;
	}
}