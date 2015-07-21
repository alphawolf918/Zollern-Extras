package zollernextras.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import zollernextras.blocks.BlockList;
import zollernextras.config.ZEConfig;
import zollernextras.items.ItemList;

public class OreDict {
	
	static int totalEntries = 0;
	
	public static void init() {
		
		MainHelper.Log("Loading OreDictionary..");
		
		// Better Glass
		if (ZEConfig.betterGlassIsGlass) {
			registerOre("glass", BlockList.betterGlass);
			registerOre("blockGlass", BlockList.betterGlass);
			registerOre("blockGlassColorless", BlockList.betterGlass);
		}
		
		// Fueltonium
		if (ZEConfig.fueltoniumIsYellorite) {
			registerOre("ingotUranium", ItemList.ingotFueltonium);
		}
		registerOre("ingotFueltonium", ItemList.ingotFueltonium);
		registerOre("oreFueltonium", BlockList.fueltonium);
		
		// Shinium
		if (ZEConfig.shiniumIsPlatinum) {
			registerOre("ingotPlatinum", ItemList.shiniumIngot);
			registerOre("dustPlatinum", ItemList.shiniumDust);
			registerOre("blockPlatinum", BlockList.shiniumBlock);
		}
		
		// Zinc
		registerOre("ingotZinc", ItemList.zincIngot);
		registerOre("dustZinc", ItemList.zincDust);
		registerOre("oreZinc", BlockList.zincOre);
		registerOre("blockZinc", BlockList.zincBlock);
		
		// Amaranth
		registerOre("ingotAmaranth", ItemList.amaranthIngot);
		registerOre("dustAmaranth", ItemList.amaranthDust);
		
		// Super Charged Coal
		registerOre("dustSuperCoal", ItemList.spcItem);
		registerOre("oreSuperChargedCoal", BlockList.spcOre);
		
		// Zollernium
		registerOre("ingotZollernium", ItemList.zollerniumIngot);
		registerOre("dustZollernium", ItemList.zollerniumDust);
		
		// Dye
		registerOre("dyeGreen", ItemList.greenDye);
		
		// Pulverized Obsidian
		registerOre("dustObsidian", ItemList.obsidianDust);
		registerOre("pulverizedObsidian", ItemList.obsidianDust);
		
		// Obsidian Ingot
		registerOre("ingotObsidian", ItemList.obsidianIngot);
		
		// Stone Registry
		registerOre("blockStone", Blocks.stone);
		registerOre("blockStone", BlockList.andesite);
		registerOre("blockAndesite", BlockList.andesite);
		registerOre("blockStone", BlockList.diorite);
		registerOre("blockDiorite", BlockList.diorite);
		registerOre("blockStone", BlockList.granite);
		registerOre("blockGranite", BlockList.granite);
		
		MainHelper.Log("OreDictionary loaded: " + totalEntries + " entries.");
	}
	
	public static void registerOre(String strName, Item item) {
		OreDictionary.registerOre(strName, new ItemStack(item, 1));
		totalEntries++;
	}
	
	public static void registerOre(String strName, Block block) {
		OreDictionary.registerOre(strName, new ItemStack(block, 1));
		totalEntries++;
	}
}