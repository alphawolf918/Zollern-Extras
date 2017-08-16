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

public class ZollernRegistry {
	
	public static void registerAll(FMLPreInitializationEvent event) {
		
		// Blocks
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
				ZollernBlocks.enderiteOre, ZollernBlocks.enderDiamondBlock,
				ZollernBlocks.enderDiamondOre, ZollernBlocks.badStone,
				ZollernBlocks.redshroomBlock, ZollernBlocks.redshroomStem,
				ZollernBlocks.netherIronOre, ZollernBlocks.netherGoldOre,
				ZollernBlocks.netherDiamondOre, ZollernBlocks.netherEmeraldOre,
				ZollernBlocks.netherRedstoneOre, ZollernBlocks.netherCopperOre,
				ZollernBlocks.netherTinOre, ZollernBlocks.netherLeadOre,
				ZollernBlocks.netherNickleOre, ZollernBlocks.netherSilverOre,
				ZollernBlocks.asphaltBlack, ZollernBlocks.asphaltGray,
				ZollernBlocks.asphaltStripeLeft,
				ZollernBlocks.asphaltStripeRight, ZollernBlocks.coldSand,
				ZollernBlocks.coldSandSmooth, ZollernBlocks.chargiumBlock,
				ZollernBlocks.shiniumBlock, ZollernBlocks.shinestone,
				ZollernBlocks.caveMarble, ZollernBlocks.blackCaveMarble,
				ZollernBlocks.canyonRock, ZollernBlocks.canyonRockBricks,
				ZollernBlocks.swampClay, ZollernBlocks.bricksMud,
				ZollernBlocks.witherrack, ZollernBlocks.upsideDownCobble,
				ZollernBlocks.upsideDownStone);
		
		// New Hell Blocks
		registerBlocks(event, ZollernBlocks.blazeRock,
				ZollernBlocks.netherDirt, ZollernBlocks.netherrack,
				ZollernBlocks.hellObsidian);
		
		// Upside-Down Blocks
		registerBlocks(event, ZollernBlocks.upsideDownSurfaceRock,
				ZollernBlocks.upsideDownSubRock);
		
		// Croppies
		// registerBlocks(event, ZollernBlocks.garlicCrop,
		// ZollernBlocks.tomatoCrop);
		
		// Items
		registerItems(event, ZollernItems.superChargedCoal,
				ZollernItems.amaranthIngot, ZollernItems.amaranthNugget,
				ZollernItems.amaranthDust, ZollernItems.azurite,
				ZollernItems.enderShard, ZollernItems.zollerniumDust,
				ZollernItems.zollerniumIngot, ZollernItems.obsidianIngot,
				ZollernItems.obsidianDust, ZollernItems.witherite,
				ZollernItems.fuelonite, ZollernItems.fueltoniumIngot,
				ZollernItems.zincIngot, ZollernItems.zincDust,
				ZollernItems.garnet, ZollernItems.opal,
				ZollernItems.aquamarine, ZollernItems.topaz, ZollernItems.ruby,
				ZollernItems.sapphire, ZollernItems.amber,
				ZollernItems.steelIngot, ZollernItems.steelDust,
				ZollernItems.enderiteIngot, ZollernItems.enderiteDust,
				ZollernItems.enderDiamond, ZollernItems.flour,
				ZollernItems.radium, ZollernItems.amaranthHelm,
				ZollernItems.amaranthChest, ZollernItems.amaranthLegs,
				ZollernItems.amaranthBoots, ZollernItems.amaranthSword,
				ZollernItems.amaranthAxe, ZollernItems.amaranthPickaxe,
				ZollernItems.amaranthShovel, ZollernItems.amaranthHoe,
				ZollernItems.azuriteHelm, ZollernItems.azuriteChest,
				ZollernItems.azuriteLegs, ZollernItems.azuriteBoots,
				ZollernItems.azuriteSword, ZollernItems.azuriteAxe,
				ZollernItems.azuritePickaxe, ZollernItems.azuriteShovel,
				ZollernItems.azuriteHoe, ZollernItems.zollerniumHelm,
				ZollernItems.zollerniumChest, ZollernItems.zollerniumLegs,
				ZollernItems.zollerniumBoots, ZollernItems.zollerniumSword,
				ZollernItems.zollerniumAxe, ZollernItems.zollerniumPickaxe,
				ZollernItems.zollerniumShovel, ZollernItems.zollerniumHoe,
				ZollernItems.radiantHelm, ZollernItems.radiantChest,
				ZollernItems.radiantLegs, ZollernItems.radiantBoots,
				ZollernItems.chargiumIngot, ZollernItems.chargiumDust,
				ZollernItems.rubySword, ZollernItems.rubyAxe,
				ZollernItems.rubyPickaxe, ZollernItems.rubyShovel,
				ZollernItems.rubyHoe, ZollernItems.sapphireSword,
				ZollernItems.sapphireAxe, ZollernItems.sapphirePickaxe,
				ZollernItems.sapphireShovel, ZollernItems.sapphireHoe,
				ZollernItems.shinestoneIngot, ZollernItems.shinestoneDust,
				ZollernItems.shiniumIngot, ZollernItems.shiniumDust,
				ZollernItems.swampClayBall, ZollernItems.brickMud);
		
		// Croppies
		// registerItems(event, ZollernItems.garlic, ZollernItems.tomato,
		// ZollernItems.tomatoSeeds);
		
		// Power Swords
		registerItems(event, ZollernItems.DIABLO, ZollernItems.ENDER,
				ZollernItems.THOR);
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