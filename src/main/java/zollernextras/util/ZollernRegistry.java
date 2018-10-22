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
				ZollernBlocks.superChargedCoalOre, ZollernBlocks.netherSuperChargedCoalOre,
				ZollernBlocks.enderSuperChargedCoalOre, ZollernBlocks.amaranthBlock,
				ZollernBlocks.amaranthOre, ZollernBlocks.netherAmaranthOre,
				ZollernBlocks.enderAmaranthOre, ZollernBlocks.azuriteBlock,
				ZollernBlocks.azuriteOre, ZollernBlocks.enderShardOre,
				ZollernBlocks.enderPearlBlock, ZollernBlocks.netherEnderShardOre,
				ZollernBlocks.zollerniumBlock, ZollernBlocks.zollerniumOre,
				ZollernBlocks.witheriteBlock, ZollernBlocks.witheriteOre,
				ZollernBlocks.fueltoniumBlock, ZollernBlocks.fueltoniumOre,
				ZollernBlocks.netherFueltoniumOre, ZollernBlocks.enderFueltoniumOre,
				ZollernBlocks.zincBlock, ZollernBlocks.zincOre, ZollernBlocks.netherZincOre,
				ZollernBlocks.enderZincOre, ZollernBlocks.garnetBlock, ZollernBlocks.garnetOre,
				ZollernBlocks.amberBlock, ZollernBlocks.amberOre, ZollernBlocks.aquamarineBlock,
				ZollernBlocks.aquamarineOre, ZollernBlocks.rubyBlock, ZollernBlocks.rubyOre,
				ZollernBlocks.sapphireBlock, ZollernBlocks.sapphireOre, ZollernBlocks.topazBlock,
				ZollernBlocks.topazOre, ZollernBlocks.opalBlock, ZollernBlocks.opalOre,
				ZollernBlocks.steelBlock, ZollernBlocks.steelOre, ZollernBlocks.netherSteelOre,
				ZollernBlocks.enderSteelOre, ZollernBlocks.enderiteBlock,
				ZollernBlocks.enderiteOre, ZollernBlocks.enderDiamondBlock,
				ZollernBlocks.enderDiamondOre, ZollernBlocks.fireGarnetBlock,
				ZollernBlocks.icyAquaBlock, ZollernBlocks.staticAmberBlock,
				ZollernBlocks.enderOpalBlock, ZollernBlocks.badStone, ZollernBlocks.redshroomBlock,
				ZollernBlocks.redshroomStem, ZollernBlocks.shadowBoneBlock,
				ZollernBlocks.netherIronOre, ZollernBlocks.netherGoldOre,
				ZollernBlocks.netherDiamondOre, ZollernBlocks.netherEmeraldOre,
				ZollernBlocks.netherRedstoneOre, ZollernBlocks.netherCopperOre,
				ZollernBlocks.netherTinOre, ZollernBlocks.netherLeadOre,
				ZollernBlocks.netherNickleOre, ZollernBlocks.netherSilverOre,
				ZollernBlocks.netherShiniumOre, ZollernBlocks.netherCoalOre,
				ZollernBlocks.netherLapisOre, ZollernBlocks.asphaltBlack,
				ZollernBlocks.asphaltGray, ZollernBlocks.asphaltStripeLeft,
				ZollernBlocks.asphaltStripeRight, ZollernBlocks.coldSand,
				ZollernBlocks.coldSandSmooth, ZollernBlocks.chargiumBlock,
				ZollernBlocks.shiniumBlock, ZollernBlocks.shinestone,
				ZollernBlocks.shinestoneCrystal, ZollernBlocks.shinestonePolished,
				ZollernBlocks.shinestoneCrystalBricks, ZollernBlocks.caveMarble,
				ZollernBlocks.blackCaveMarble, ZollernBlocks.canyonRock,
				ZollernBlocks.canyonRockBricks, ZollernBlocks.swampClay, ZollernBlocks.bricksMud,
				ZollernBlocks.seaLamp, ZollernBlocks.shineTorch, ZollernBlocks.enderGlow,
				ZollernBlocks.radiumBlock);
		
		// New Hell Blocks
		registerBlocks(event, ZollernBlocks.blazeRock, ZollernBlocks.netherDirt,
				ZollernBlocks.netherrack, ZollernBlocks.hellObsidian);
		
		// Upside-Down Blocks
		registerBlocks(event, ZollernBlocks.upsideDownSurfaceRock, ZollernBlocks.upsideDownSubRock,
				ZollernBlocks.witherrack, ZollernBlocks.upsideDownCobble,
				ZollernBlocks.upsideDownStone, ZollernBlocks.upsideDownStoneBricks,
				ZollernBlocks.upsideDownDirt, ZollernBlocks.upsideDownCobbleMossy,
				ZollernBlocks.creepStone, ZollernBlocks.creepDirt,
				ZollernBlocks.shadowEssenceBlock, ZollernBlocks.endrock,
				ZollernBlocks.netheridiumBlock, ZollernBlocks.netherizedObsidian,
				ZollernBlocks.upsideDownSuperChargedCoalOre, ZollernBlocks.upsideDownAmaranthOre,
				ZollernBlocks.upsideDownEnderShardOre, ZollernBlocks.upsideDownAmberOre,
				ZollernBlocks.upsideDownAquamarineOre, ZollernBlocks.upsideDownGarnetOre,
				ZollernBlocks.upsideDownFueltoniumOre, ZollernBlocks.upsideDownZincOre,
				ZollernBlocks.upsideDownTopazOre, ZollernBlocks.upsideDownRubyOre,
				ZollernBlocks.upsideDownSapphireOre, ZollernBlocks.upsideDownOpalOre,
				ZollernBlocks.upsideDownIronOre, ZollernBlocks.upsideDownGoldOre,
				ZollernBlocks.upsideDownDiamondOre, ZollernBlocks.upsideDownEmeraldOre,
				ZollernBlocks.upsideDownRedstoneOre, ZollernBlocks.upsideDownLapisOre,
				ZollernBlocks.upsideDownShiniumOre, ZollernBlocks.upsideDownCopperOre,
				ZollernBlocks.upsideDownLeadOre, ZollernBlocks.upsideDownTinOre,
				ZollernBlocks.upsideDownSilverOre, ZollernBlocks.upsideDownNickleOre,
				ZollernBlocks.upsideDownRadianceOre);
		
		// Corrupt Blocks
		registerBlocks(event, ZollernBlocks.corruptStone, ZollernBlocks.corruptCobble,
				ZollernBlocks.corruptStoneBricks, ZollernBlocks.corruptRock,
				ZollernBlocks.corruptCreepStone, ZollernBlocks.corruptEtriumOre,
				ZollernBlocks.corruptAscendiumOre, ZollernBlocks.corruptChargiumOre,
				ZollernBlocks.corruptZucriteOre, ZollernBlocks.corruptZucriteBlock);
		
		// Items
		registerItems(event, ZollernItems.superChargedCoal, ZollernItems.amaranthIngot,
				ZollernItems.amaranthNugget, ZollernItems.amaranthDust, ZollernItems.azurite,
				ZollernItems.enderShard, ZollernItems.zollerniumDust, ZollernItems.zollerniumIngot,
				ZollernItems.obsidianIngot, ZollernItems.obsidianDust, ZollernItems.witherite,
				ZollernItems.fuelonite, ZollernItems.fueltoniumIngot, ZollernItems.zincIngot,
				ZollernItems.zincDust, ZollernItems.garnet, ZollernItems.opal,
				ZollernItems.aquamarine, ZollernItems.topaz, ZollernItems.ruby,
				ZollernItems.sapphire, ZollernItems.amber, ZollernItems.icyAqua,
				ZollernItems.fireGarnet, ZollernItems.staticAmber, ZollernItems.enderOpal,
				ZollernItems.steelIngot, ZollernItems.steelDust, ZollernItems.enderiteIngot,
				ZollernItems.enderiteDust, ZollernItems.enderDiamond, ZollernItems.flour,
				ZollernItems.radium, ZollernItems.amaranthHelm, ZollernItems.amaranthChest,
				ZollernItems.amaranthLegs, ZollernItems.amaranthBoots, ZollernItems.amaranthSword,
				ZollernItems.amaranthAxe, ZollernItems.amaranthPickaxe,
				ZollernItems.amaranthShovel, ZollernItems.amaranthHoe, ZollernItems.azuriteHelm,
				ZollernItems.azuriteChest, ZollernItems.azuriteLegs, ZollernItems.azuriteBoots,
				ZollernItems.azuriteSword, ZollernItems.azuriteAxe, ZollernItems.azuritePickaxe,
				ZollernItems.azuriteShovel, ZollernItems.azuriteHoe, ZollernItems.zollerniumHelm,
				ZollernItems.zollerniumChest, ZollernItems.zollerniumLegs,
				ZollernItems.zollerniumBoots, ZollernItems.zollerniumSword,
				ZollernItems.zollerniumAxe, ZollernItems.zollerniumPickaxe,
				ZollernItems.zollerniumShovel, ZollernItems.zollerniumHoe,
				ZollernItems.radiantHelm, ZollernItems.radiantChest, ZollernItems.radiantLegs,
				ZollernItems.radiantBoots, ZollernItems.chargiumIngot, ZollernItems.chargiumDust,
				ZollernItems.rubySword, ZollernItems.rubyAxe, ZollernItems.rubyPickaxe,
				ZollernItems.rubyShovel, ZollernItems.rubyHoe, ZollernItems.sapphireSword,
				ZollernItems.sapphireAxe, ZollernItems.sapphirePickaxe,
				ZollernItems.sapphireShovel, ZollernItems.sapphireHoe,
				ZollernItems.shinestoneIngot, ZollernItems.shinestoneDust,
				ZollernItems.shiniumIngot, ZollernItems.shiniumDust, ZollernItems.swampClayBall,
				ZollernItems.brickMud, ZollernItems.lapisIngot, ZollernItems.enderGlowDust,
				ZollernItems.duckFeather, ZollernItems.marbleStick, ZollernItems.blackMarbleStick,
				ZollernItems.lapisStick, ZollernItems.steelStick, ZollernItems.powerStick,
				ZollernItems.bedrockBreaker, ZollernItems.rokkite,
				ZollernItems.ascendantAmaranthIngot, ZollernItems.shadowBone,
				ZollernItems.shadowEssence, ZollernItems.netheridium, ZollernItems.etrium,
				ZollernItems.crushedEtrium, ZollernItems.ascendium, ZollernItems.zucriteDust,
				ZollernItems.zucriteIngot, ZollernItems.upsideDownEye_uncharged,
				ZollernItems.upsideDownEye_charged);
		
		// Power Swords
		registerItems(event, ZollernItems.DIABLO, ZollernItems.ENDER, ZollernItems.THOR,
				ZollernItems.GLACIES, ZollernItems.MORTEM);
	}
	
	public static void registerBlocks(FMLPreInitializationEvent event, Block... blocks) {
		for (Block block : blocks) {
			final ItemBlock itemBlock = new ItemBlock(block);
			GameRegistry.register(block);
			GameRegistry.register(itemBlock, block.getRegistryName());
			if (event.getSide() == Side.CLIENT) {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
						new ModelResourceLocation(block.getRegistryName(), "normal"));
			}
		}
	}
	
	public static void registerItems(FMLPreInitializationEvent event, Item... items) {
		for (Item item : items) {
			if (event.getSide() == Side.CLIENT) {
				ModelLoader.setCustomModelResourceLocation(item, 0,
						new ModelResourceLocation(item.getRegistryName(), "normal"));
			}
			GameRegistry.register(item);
		}
	}
	
}