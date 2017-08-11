package zollernextras.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.blocks.crops.ZollernCrops;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernModInfo;

public class ZollernSeed extends ItemSeeds {
	
	public final Block plant;
	
	public ZollernSeed(Block plant, String name, Item returnItem, int returnMeta) {
		super(plant, Blocks.FARMLAND);
		this.plant = plant;
		this.setRegistryName(ZollernModInfo.modId + "_" + name);
		this.setUnlocalizedName(ZollernModInfo.modId + "_" + name);
		
		if (plant instanceof ZollernCrops) {
			((ZollernCrops) plant).doStuff(this, returnItem, returnMeta);
		}
	}
	
	public ZollernSeed(Block plant, Block soil, String name, Item returnItem,
			int returnMeta) {
		super(plant, soil);
		this.plant = plant;
		this.setRegistryName(ZollernModInfo.modId + "_" + name);
		this.setUnlocalizedName(ZollernModInfo.modId + "_" + name);
		
		if (plant instanceof ZollernCrops) {
			((ZollernCrops) plant).doStuff(this, returnItem, returnMeta);
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