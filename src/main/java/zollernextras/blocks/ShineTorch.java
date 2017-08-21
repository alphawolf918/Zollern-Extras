package zollernextras.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
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
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernTabs.zTab;
	}
}