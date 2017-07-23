package zollernextras.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;

public class RegistryUtil {
	
	public static void registerAll(FMLPreInitializationEvent event) {
		registerBlocks(event, ZollernBlocks.superChargedCoalBlock,
				ZollernBlocks.superChargedCoalOre,
				ZollernBlocks.netherSuperChargedCoalOre,
				ZollernBlocks.enderSuperChargedCoalOre,
				ZollernBlocks.amaranthBlock, ZollernBlocks.amaranthOre,
				ZollernBlocks.netherAmaranthOre,
				ZollernBlocks.enderAmaranthOre, ZollernBlocks.azuriteBlock,
				ZollernBlocks.azuriteOre, ZollernBlocks.enderShardOre,
				ZollernBlocks.enderPearlBlock,
				ZollernBlocks.netherEnderShardOre,
				ZollernBlocks.zollerniumBlock, ZollernBlocks.zollerniumOre,
				ZollernBlocks.witheriteBlock, ZollernBlocks.witheriteOre,
				ZollernBlocks.fueltoniumBlock, ZollernBlocks.fueltoniumOre,
				ZollernBlocks.netherFueltoniumOre,
				ZollernBlocks.enderFueltoniumOre, ZollernBlocks.zincBlock,
				ZollernBlocks.zincOre, ZollernBlocks.netherZincOre,
				ZollernBlocks.enderZincOre, ZollernBlocks.garnetBlock,
				ZollernBlocks.garnetOre, ZollernBlocks.amberBlock,
				ZollernBlocks.amberOre, ZollernBlocks.aquamarineBlock,
				ZollernBlocks.aquamarineOre, ZollernBlocks.rubyBlock,
				ZollernBlocks.rubyOre, ZollernBlocks.sapphireBlock,
				ZollernBlocks.sapphireOre, ZollernBlocks.topazBlock,
				ZollernBlocks.topazOre, ZollernBlocks.opalBlock,
				ZollernBlocks.opalOre, ZollernBlocks.steelBlock,
				ZollernBlocks.steelOre, ZollernBlocks.netherSteelOre,
				ZollernBlocks.enderSteelOre, ZollernBlocks.enderiteBlock,
				ZollernBlocks.enderiteOre);
		
		registerItems(event, ZollernItems.superChargedCoal,
				ZollernItems.amaranthIngot, ZollernItems.amaranthDust,
				ZollernItems.azurite, ZollernItems.enderShard,
				ZollernItems.zollerniumDust, ZollernItems.zollerniumIngot,
				ZollernItems.obsidianIngot, ZollernItems.obsidianDust,
				ZollernItems.witherite, ZollernItems.fuelonite,
				ZollernItems.fueltoniumIngot, ZollernItems.zincIngot,
				ZollernItems.zincDust, ZollernItems.garnet, ZollernItems.opal,
				ZollernItems.aquamarine, ZollernItems.topaz, ZollernItems.ruby,
				ZollernItems.sapphire, ZollernItems.amber,
				ZollernItems.steelIngot, ZollernItems.steelDust,
				ZollernItems.enderiteIngot, ZollernItems.enderiteDust);
	}
	
	public static void registerBlocks(FMLPreInitializationEvent event,
			Block... blocks) {
		for (Block block : blocks) {
			final ItemBlock itemBlock = new ItemBlock(block);
			if (event.getSide() == Side.CLIENT) {
				GameRegistry.register(block);
				GameRegistry.register(itemBlock, block.getRegistryName());
				ModelLoader.setCustomModelResourceLocation(Item
						.getItemFromBlock(block), 0, new ModelResourceLocation(
						block.getRegistryName(), "normal"));
			}
		}
	}
	
	public static void registerItems(FMLPreInitializationEvent event,
			Item... items) {
		for (Item item : items) {
			if (event.getSide() == Side.CLIENT) {
				GameRegistry.register(item);
				ModelLoader.setCustomModelResourceLocation(item, 0,
						new ModelResourceLocation(item.getRegistryName(),
								"normal"));
			}
		}
	}
	
}