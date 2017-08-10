package zollernextras.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.blocks.crops.ZollernCrops;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernSeedFood extends ItemSeedFood {
	
	public final Block plant;
	
	public ZollernSeedFood(Block plant, String name, int returnMeta, int heal,
			float sat) {
		super(heal, sat, plant, Blocks.FARMLAND);
		this.plant = plant;
		ZollernHelper.setName(this, name);
		
		if (plant instanceof ZollernCrops) {
			((ZollernCrops) plant).doStuff(this, this, returnMeta);
		}
	}
	
	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.plant.getDefaultState();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
}