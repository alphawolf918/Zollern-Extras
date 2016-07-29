package zollernextras.lib.modhelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameData;

public class TreeCapHelper {
	
	public static void init() {
		
		NBTTagCompound tpModCfg = new NBTTagCompound();
		NBTTagList treeList = new NBTTagList();
		NBTTagCompound tree = new NBTTagCompound();
		
		// Banana
		String bananaLog = blockName(ZollernBlocks.bananaLog);
		String bananaLeaves = blockName(ZollernBlocks.bananaLeaves);
		
		// Orange
		String orangeLog = blockName(ZollernBlocks.orangeLog);
		String orangeLeaves = blockName(ZollernBlocks.orangeLeaves);
		
		// Guava
		String guavaLog = blockName(ZollernBlocks.guavaLog);
		String guavaLeaves = blockName(ZollernBlocks.guavaLeaves);
		
		// Lemon
		String lemonLog = blockName(ZollernBlocks.lemonLog);
		String lemonLeaves = blockName(ZollernBlocks.lemonLeaves);
		
		// Lime
		String limeLog = blockName(ZollernBlocks.limeLog);
		String limeLeaves = blockName(ZollernBlocks.limeLeaves);
		
		// Limon
		String limonLog = blockName(ZollernBlocks.limonLog);
		String limonLeaves = blockName(ZollernBlocks.limonLeaves);
		
		// Cherry
		String cherryLog = blockName(ZollernBlocks.cherryLog);
		String cherryLeaves = blockName(ZollernBlocks.cherryLeaves);
		
		// Grapefruit
		String grapefruitLog = blockName(ZollernBlocks.grapefruitLog);
		String grapefruitLeaves = blockName(ZollernBlocks.grapefruitLeaves);
		
		// Ender Berry
		String enderBerryLog = blockName(ZollernBlocks.enderBerryLog);
		String enderBerryLeaves = blockName(ZollernBlocks.enderBerryLeaves);
		
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