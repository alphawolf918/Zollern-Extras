package zollernextras.lib.modhelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import zollernextras.blocks.BlockList;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameData;

public class TreeCapHelper {
	
	public static void init() {
		
		NBTTagCompound tpModCfg = new NBTTagCompound();
		NBTTagList treeList = new NBTTagList();
		NBTTagCompound tree = new NBTTagCompound();
		
		// Banana
		String bananaLog = blockName(BlockList.bananaLog);
		String bananaLeaves = blockName(BlockList.bananaLeaves);
		
		// Orange
		String orangeLog = blockName(BlockList.orangeLog);
		String orangeLeaves = blockName(BlockList.orangeLeaves);
		
		// Guava
		String guavaLog = blockName(BlockList.guavaLog);
		String guavaLeaves = blockName(BlockList.guavaLeaves);
		
		// Lemon
		String lemonLog = blockName(BlockList.lemonLog);
		String lemonLeaves = blockName(BlockList.lemonLeaves);
		
		// Lime
		String limeLog = blockName(BlockList.limeLog);
		String limeLeaves = blockName(BlockList.limeLeaves);
		
		// Limon
		String limonLog = blockName(BlockList.limonLog);
		String limonLeaves = blockName(BlockList.limonLeaves);
		
		// Cherry
		String cherryLog = blockName(BlockList.cherryLog);
		String cherryLeaves = blockName(BlockList.cherryLeaves);
		
		// Grapefruit
		String grapefruitLog = blockName(BlockList.grapefruitLog);
		String grapefruitLeaves = blockName(BlockList.grapefruitLeaves);
		
		// Ender Berry
		String enderBerryLog = blockName(BlockList.enderBerryLog);
		String enderBerryLeaves = blockName(BlockList.enderBerryLeaves);
		
		tpModCfg.setString("modID", ZollernModInfo.MODID);
		
		// Banana Tree
		tree.setString("treeName", "bananawood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8", bananaLog,
				bananaLog, bananaLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", bananaLeaves, bananaLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Orange Tree
		tree.setString("treeName", "orangewood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8", orangeLog,
				orangeLog, orangeLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", orangeLeaves, orangeLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Guava Tree
		tree.setString("treeName", "guavawood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8", guavaLog,
				guavaLog, guavaLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", guavaLeaves, guavaLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Lemon Tree
		tree.setString("treeName", "lemonwood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8", lemonLog,
				lemonLog, lemonLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", lemonLeaves, lemonLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Lime Tree
		tree.setString("treeName", "limewood");
		tree.setString("logs",
				String.format("%s, 0; %s, 4; %s, 8", limeLog, limeLog, limeLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", limeLeaves, limeLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Limon Tree
		tree.setString("treeName", "limonwood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8", limonLog,
				limonLog, limonLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", limonLeaves, limonLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Cherry Tree
		tree.setString("treeName", "cherrywood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8", cherryLog,
				cherryLog, cherryLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", cherryLeaves, cherryLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Grapefruit Tree
		tree.setString("treeName", "grapefruitwood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8",
				grapefruitLog, grapefruitLog, grapefruitLog));
		tree.setString("leaves", String.format("%s, 0; %s, 8",
				grapefruitLeaves, grapefruitLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		// Ender Berry Tree
		tree.setString("treeName", "enderberrywood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8",
				enderBerryLog, enderBerryLog, enderBerryLog));
		tree.setString("leaves", String.format("%s, 0; %s, 8",
				enderBerryLeaves, enderBerryLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		FMLInterModComms.sendMessage("TreeCapitator", "ThirdPartyModConfig",
				tpModCfg);
		FMLInterModComms.sendMessage("Treecapitator", "ThirdPartyModConfig",
				tpModCfg);
	}
	
	private static String blockName(Block block) {
		return GameData.getBlockRegistry().getNameForObject(block);
	}
	
	private static String itemName(Item item) {
		return GameData.getItemRegistry().getNameForObject(item);
	}
	
}