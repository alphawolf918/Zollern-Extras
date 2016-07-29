package zollernextras.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import zollernextras.blocks.ZollernBlocks;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryUtil {
	
	public static void addToTERegistry(String id,
			Class<? extends TileEntity> TEClass) {
		ZollernBlocks.TERegistry.put(id, TEClass);
		GameRegistry.registerTileEntity(TEClass, id);
	}
	
	public static void addToBlockRegistry(Block block, String name) {
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
	}
	
	public static Block registerItemBlock(Block block,
			Class<? extends ItemBlock> itemBlockClass,
			Class<? extends TileEntity> TEClass, String name) {
		block.setBlockName(name);
		GameRegistry.registerBlock(block, itemBlockClass, name);
		addToTERegistry(name, TEClass);
		return block;
	}
	
	public static Block fullRegister(Block block, String name,
			Class<? extends TileEntity> TEClass) {
		addToBlockRegistry(block, name);
		addToTERegistry(name, TEClass);
		return block;
	}
	
	static int id = 0;
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, ItemBlock.class, block
				.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlock(Block block,
			Class<? extends ItemBlock> itemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName()
				.substring(5));
	}
	
	public static void registerBlock(Block block,
			Class<? extends ItemBlock> itemBlock, Object... objectFromItemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName()
				.substring(5), objectFromItemBlock);
	}
	
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void registerFluidContainer(Fluid fluid,
			ItemStack filledContainer, ItemStack emptyContainer) {
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(
				new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME),
				filledContainer, emptyContainer));
	}
	
	public static void setFireBurn(Block block, int encouragement,
			int flammibility) {
		Blocks.fire.setFireInfo(block, encouragement, flammibility);
	}
	
	@Deprecated
	public static void registerEntity(Class<? extends Entity> var0,
			String var1, int color1, int color2) {
		EntityRegistry.registerGlobalEntityID(var0, var1,
				EntityRegistry.findGlobalUniqueEntityId(), color1, color2);
	}
	
	public static void registerNonMobEntity(Class<? extends Entity> var0,
			String var1, Object mod, boolean sendVel) {
		EntityRegistry
		.registerModEntity(var0, var1, id++, mod, 256, 1, sendVel);
	}
}