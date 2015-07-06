package zollernextras.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import zollernextras.blocks.BlockList;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryUtil {
	
	public static void addToTERegistry(String id,
			Class<? extends TileEntity> TEClass) {
		BlockList.TERegistry.put(id, TEClass);
		GameRegistry.registerTileEntity(TEClass, id);
	}
	
	public static void addToBlockRegistry(Block block, String name) {
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
	}
	
	public static Block fullRegister(Block block, String name,
			Class<? extends TileEntity> TEClass) {
		addToBlockRegistry(block, name);
		addToTERegistry(name, TEClass);
		return block;
	}
}