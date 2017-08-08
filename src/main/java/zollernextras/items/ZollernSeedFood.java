package zollernextras.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import zanextras.lib.ModInfo;
import zollernextras.blocks.crops.ZollernCrops;

public class ZollernSeedFood extends ItemSeedFood {
	
	public final Block plant;
	
	public ZollernSeedFood(Block plant, String name, Item returnItem,
			int returnMeta, int heal, int sat) {
		super(heal, sat, plant, Blocks.FARMLAND);
		this.plant = plant;
		this.setRegistryName(ModInfo.MODID + "_" + name);
		this.setUnlocalizedName(ModInfo.MODID + "_" + name);
		
		if (plant instanceof ZollernCrops) {
			((ZollernCrops) plant).doStuff(this, returnItem, returnMeta);
		}
	}
	
	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.plant.getDefaultState();
	}
}