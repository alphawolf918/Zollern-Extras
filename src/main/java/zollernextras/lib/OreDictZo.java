package zollernextras.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.items.ZollernItems;

public class OreDictZo {
	
	public static void init() {
		// Fueltonium
		if (ZEConfig.fueltoniumIsYellorite) {
			registerOre("ingotUranium", ZollernItems.fueltoniumIngot);
			registerOre("dustUranium", ZollernItems.fuelonite);
		}
		registerOre("ingotFueltonium", ZollernItems.fueltoniumIngot);
		registerOre("oreFueltonium", ZollernBlocks.fueltoniumBlock);
		registerOre("oreNetherFueltonium", ZollernBlocks.netherFueltoniumOre);
		registerOre("oreEnderFueltonium", ZollernBlocks.enderFueltoniumOre);
		// registerOre("oreUpsideDownFueltonium",
		// ZollernBlocks.upsideDownFuelOre);
		registerOre("dustFueltonium", ZollernItems.fuelonite);
		registerOre("blockFueltonium", ZollernBlocks.fueltoniumBlock);
		
		// Shinium
		if (ZEConfig.shiniumIsPlatinum) {
			registerOre("ingotPlatinum", ZollernItems.shiniumIngot);
			registerOre("dustPlatinum", ZollernItems.shiniumDust);
			registerOre("blockPlatinum", ZollernBlocks.shiniumBlock);
		}
		registerOre("ingotShinium", ZollernItems.shiniumIngot);
		registerOre("dustShinium", ZollernItems.shiniumDust);
		registerOre("blockShinium", ZollernBlocks.shiniumBlock);
		
		// Zinc
		registerOre("ingotZinc", ZollernItems.zincIngot);
		registerOre("dustZinc", ZollernItems.zincDust);
		registerOre("oreZinc", ZollernBlocks.zincOre);
		registerOre("oreNetherZinc", ZollernBlocks.netherZincOre);
		registerOre("oreEnderZinc", ZollernBlocks.enderZincOre);
		// registerOre("oreUpsideDownZinc", ZollernBlocks.upsideDownZincOre);
		registerOre("blockZinc", ZollernBlocks.zincBlock);
		
		// Amaranth
		registerOre("ingotAmaranth", ZollernItems.amaranthIngot);
		registerOre("dustAmaranth", ZollernItems.amaranthDust);
		registerOre("oreAmaranth", ZollernBlocks.amaranthOre);
		registerOre("oreNetherAmaranth", ZollernBlocks.netherAmaranthOre);
		registerOre("oreEnderAmaranth", ZollernBlocks.enderAmaranthOre);
		// registerOre("oreUpsideDownAmaranth",
		// ZollernBlocks.upsideDownAmaranthOre);
		registerOre("blockAmaranth", ZollernBlocks.amaranthBlock);
		
		// Super Charged Coal
		registerOre("dustSuperChargedCoal", ZollernItems.superChargedCoal);
		registerOre("oreSuperChargedCoal", ZollernBlocks.superChargedCoalOre);
		registerOre("oreNetherSuperChargedCoal",
				ZollernBlocks.netherSuperChargedCoalOre);
		registerOre("oreEnderSuperChargedCoal",
				ZollernBlocks.enderSuperChargedCoalOre);
		// registerOre("oreUpsideDownSuperChargedCoal",
		// ZollernBlocks.upsideDownSpcOre);
		registerOre("blockSuperChargedCoal",
				ZollernBlocks.superChargedCoalBlock);
		
		// Zollernium
		registerOre("ingotZollernium", ZollernItems.zollerniumIngot);
		registerOre("dustZollernium", ZollernItems.zollerniumDust);
		registerOre("oreZollernium", ZollernBlocks.zollerniumOre);
		registerOre("blockZollernium", ZollernBlocks.zollerniumBlock);
		
		// Ender Diamond
		registerOre("gemEnderDiamond", ZollernItems.enderDiamond);
		registerOre("oreEnderDiamond", ZollernBlocks.enderDiamondOre);
		registerOre("blockEnderDiamond", ZollernBlocks.enderDiamondBlock);
		
		// Azurite
		registerOre("gemAzurite", ZollernItems.azurite);
		registerOre("oreAzurite", ZollernBlocks.azuriteOre);
		registerOre("blockAzurite", ZollernBlocks.azuriteBlock);
		
		// Amber
		registerOre("gemAmber", ZollernItems.amber);
		registerOre("oreAmber", ZollernBlocks.amberOre);
		// registerOre("oreUpsideDownAmber", ZollernBlocks.upsideDownAmberOre);
		registerOre("blockAmber", ZollernBlocks.amberBlock);
		
		// Topaz
		registerOre("gemTopaz", ZollernItems.topaz);
		registerOre("oreTopaz", ZollernBlocks.topazOre);
		// registerOre("oreUpsideDownTopaz", ZollernBlocks.upsideDownTopazOre);
		registerOre("blockTopaz", ZollernBlocks.topazBlock);
		
		// Aquamarine
		registerOre("gemAquamarine", ZollernItems.aquamarine);
		registerOre("oreAquamarine", ZollernBlocks.aquamarineOre);
		// registerOre("oreUpsideDownAquamarine",
		// ZollernBlocks.upsideDownAquaOre);
		registerOre("blockAquamarine", ZollernBlocks.aquamarineBlock);
		
		// Garnet
		registerOre("gemGarnet", ZollernItems.garnet);
		registerOre("oreGarnet", ZollernBlocks.garnetOre);
		// registerOre("oreUpsideDownGarnet",
		// ZollernBlocks.upsideDownGarnetOre);
		registerOre("blockGarnet", ZollernBlocks.garnetBlock);
		
		// Opal
		registerOre("gemOpal", ZollernItems.opal);
		registerOre("oreOpal", ZollernBlocks.opalOre);
		// registerOre("oreUpsideDownOpal", ZollernBlocks.upsideDownOpalOre);
		registerOre("blockOpal", ZollernBlocks.opalBlock);
		
		// Enderite
		registerOre("ingotEnderite", ZollernItems.enderiteIngot);
		registerOre("oreEnderite", ZollernBlocks.enderiteOre);
		registerOre("blockEnderite", ZollernBlocks.enderiteBlock);
		
		// Witherite
		registerOre("oreWitherite", ZollernBlocks.witheriteOre);
		registerOre("gemWitherite", ZollernItems.witherite);
		registerOre("blockWitherite", ZollernBlocks.witheriteBlock);
		
		// Ruby
		registerOre("oreRuby", ZollernBlocks.rubyOre);
		// registerOre("oreUpsideDownRuby", ZollernBlocks.upsideDownRubyOre);
		registerOre("blockRuby", ZollernBlocks.rubyBlock);
		registerOre("gemRuby", ZollernItems.ruby);
		
		// Sapphire
		registerOre("oreSapphire", ZollernBlocks.sapphireOre);
		// registerOre("oreUpsideDownSapphire",
		// ZollernBlocks.upsideDownSapphireOre);
		registerOre("blockSapphire", ZollernBlocks.sapphireBlock);
		registerOre("gemSapphire", ZollernItems.sapphire);
		
		// Ender Shard
		registerOre("gemEnderShard", ZollernItems.enderShard);
		registerOre("oreEnderShard", ZollernBlocks.enderShardOre);
		registerOre("oreNetherEnderShard", ZollernBlocks.netherEnderShardOre);
		// registerOre("oreUpsideDownEnderShard",
		// ZollernBlocks.upsideDownEnderShardOre);
		
		// Lapis
		registerOre("ingotLapis", ZollernItems.lapisIngot);
		registerOre("dustLapis", new ItemStack(Items.DYE, 1, 4).getItem());
		
		// Steel
		registerOre("ingotSteel", ZollernItems.steelIngot);
		registerOre("dustSteel", ZollernItems.steelDust);
		registerOre("oreSteel", ZollernBlocks.steelOre);
		registerOre("blockSteel", ZollernBlocks.steelBlock);
		
		// Obsidian
		registerOre("ingotObsidian", ZollernItems.obsidianIngot);
		registerOre("dustObsidian", ZollernItems.obsidianDust);
	}
	
	public static void registerOre(String strName, Item item) {
		OreDictionary.registerOre(strName, new ItemStack(item, 1));
	}
	
	public static void registerOre(String strName, Block block) {
		OreDictionary.registerOre(strName, new ItemStack(block, 1));
	}
	
	public static void registerOre(String strName, Block... blocks) {
		for (Block zollernBlock : blocks) {
			registerOre(strName, zollernBlock);
		}
	}
	
	public static void registerOre(String strName, Item... items) {
		for (Item zollernItem : items) {
			registerOre(strName, zollernItem);
		}
	}
	
}