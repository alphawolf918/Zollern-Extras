package zollernextras.lib.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.items.ZollernItems;
import cofh.api.util.ThermalExpansionHelper;
import cofh.lib.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;

public class PulverizerRecipes {
	
	public static void init() {
		
		// Shinestone Dust
		ThermalExpansionHelper.addPulverizerRecipe(1200, new ItemStack(
				ZollernItems.shinestoneIngot, 1), new ItemStack(
				ZollernItems.shinestoneDust, 1));
		
		// Amaranth Ore
		// Overworld
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				ZollernBlocks.amaranthOre, 1), new ItemStack(
				ZollernItems.amaranthDust, 2));
		// Nether
		ThermalExpansionHelper.addPulverizerRecipe(4500, new ItemStack(
				ZollernBlocks.netherAmaranthOre), new ItemStack(
				ZollernItems.amaranthDust, 4));
		// Ender
		ThermalExpansionHelper.addPulverizerRecipe(5200, new ItemStack(
				ZollernBlocks.enderAmaranthOre), new ItemStack(
				ZollernItems.amaranthDust, 6));
		// Upside-Down
		ThermalExpansionHelper.addPulverizerRecipe(6200, new ItemStack(
				ZollernBlocks.upsideDownAmaranthOre), new ItemStack(
				ZollernItems.amaranthDust, 8));
		
		// // Amaranth Ingot
		ThermalExpansionHelper.addPulverizerRecipe(500, new ItemStack(
				ZollernItems.amaranthIngot), new ItemStack(
				ZollernItems.amaranthDust, 1));
		
		// Zinc Ore
		// Overworld
		ThermalExpansionHelper
				.addPulverizerRecipe(4500,
						new ItemStack(ZollernBlocks.zincOre), new ItemStack(
								ZollernItems.zincDust, 2));
		// Nether
		ThermalExpansionHelper.addPulverizerRecipe(5500, new ItemStack(
				ZollernBlocks.netherZincOre), new ItemStack(
				ZollernItems.zincDust, 4));
		// Ender
		ThermalExpansionHelper.addPulverizerRecipe(6500, new ItemStack(
				ZollernBlocks.enderZincOre), new ItemStack(
				ZollernItems.zincDust, 6));
		// Upside-Down
		ThermalExpansionHelper.addPulverizerRecipe(7500, new ItemStack(
				ZollernBlocks.upsideDownZincOre), new ItemStack(
				ZollernItems.zincDust, 8));
		
		// Zinc Ingot
		ThermalExpansionHelper.addPulverizerRecipe(600, new ItemStack(
				ZollernItems.zincIngot),
				new ItemStack(ZollernItems.zincDust, 1));
		
		// Iron
		ThermalExpansionHelper
				.addPulverizerRecipe(
						4500,
						new ItemStack(ZollernBlocks.netherIronOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustIron),
								4, 0));
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5500,
						new ItemStack(ZollernBlocks.upsideDownIronOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustIron),
								8, 0));
		
		// Gold
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZollernBlocks.netherGoldOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustGold),
								4, 1));
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5500,
						new ItemStack(ZollernBlocks.upsideDownGoldOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustGold),
								8, 1));
		
		// Copper
		ThermalExpansionHelper.addPulverizerRecipe(
				5400,
				new ItemStack(ZollernBlocks.netherCopperOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustCopper), 4,
						64));
		ThermalExpansionHelper.addPulverizerRecipe(
				6400,
				new ItemStack(ZollernBlocks.upsideDownCopperOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustCopper), 8,
						64));
		
		// Lead
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZollernBlocks.netherLeadOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustLead),
								4, 67));
		ThermalExpansionHelper
				.addPulverizerRecipe(
						6400,
						new ItemStack(ZollernBlocks.upsideDownLeadOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustLead),
								8, 67));
		
		// Tin
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZollernBlocks.netherTinOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustTin),
								4, 65));
		ThermalExpansionHelper
				.addPulverizerRecipe(
						6400,
						new ItemStack(ZollernBlocks.upsideDownTinOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustTin),
								8, 65));
		
		// Silver
		ThermalExpansionHelper.addPulverizerRecipe(
				5400,
				new ItemStack(ZollernBlocks.netherSilverOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustSilver), 4,
						66));
		ThermalExpansionHelper.addPulverizerRecipe(
				6400,
				new ItemStack(ZollernBlocks.upsideDownSilverOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustSilver), 8,
						66));
		
		// Nickle
		ThermalExpansionHelper.addPulverizerRecipe(
				5400,
				new ItemStack(ZollernBlocks.netherNickleOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustNickel), 4,
						69));
		ThermalExpansionHelper.addPulverizerRecipe(
				6400,
				new ItemStack(ZollernBlocks.upsideDownNickleOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustNickel), 8,
						69));
		
		// Platinum / Shinium
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(
				ZollernBlocks.netherShiniumOre), new ItemStack(
				ZollernItems.shiniumDust, 4));
		ThermalExpansionHelper.addPulverizerRecipe(6400, new ItemStack(
				ZollernBlocks.upsideDownShiniumOre), new ItemStack(
				ZollernItems.shiniumDust, 8));
		
		// Steel Ore
		// Overworld
		ThermalExpansionHelper.addPulverizerRecipe(3200, new ItemStack(
				ZollernBlocks.steelOre), new ItemStack(ZollernItems.steelDust,
				2));
		// Nether
		ThermalExpansionHelper.addPulverizerRecipe(6400, new ItemStack(
				ZollernBlocks.netherSteelOre), new ItemStack(
				ZollernItems.steelDust, 4));
		// Ender
		ThermalExpansionHelper.addPulverizerRecipe(6800, new ItemStack(
				ZollernBlocks.enderSteelOre), new ItemStack(
				ZollernItems.steelDust, 6));
		
		// Steel Ingot
		ThermalExpansionHelper.addPulverizerRecipe(800, new ItemStack(
				ZollernItems.steelIngot), new ItemStack(ZollernItems.steelDust,
				1));
		
		// Zollernium Ore
		ThermalExpansionHelper.addPulverizerRecipe(7200, new ItemStack(
				ZollernBlocks.zollerniumOre), new ItemStack(
				ZollernItems.zollerniumDust, 2));
		
		// Zollernium Ingot
		ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
				ZollernItems.zollerniumIngot), new ItemStack(
				ZollernItems.zollerniumDust, 1));
		
		// Enderite Ore
		ThermalExpansionHelper.addPulverizerRecipe(3600, new ItemStack(
				ZollernBlocks.enderiteOre), new ItemStack(
				ZollernItems.enderiteDust, 1));
		
		// Enderite Ingot
		ThermalExpansionHelper.addPulverizerRecipe(1800, new ItemStack(
				ZollernItems.enderiteIngot), new ItemStack(
				ZollernItems.enderiteDust, 1));
		
		// Wheat -> Flour
		ThermalExpansionHelper.addPulverizerRecipe(400, new ItemStack(
				Items.WHEAT), new ItemStack(ZollernItems.flour, 2));
		
		// Chargium (Ingot -> Dust)
		ThermalExpansionHelper.addPulverizerRecipe(800, new ItemStack(
				ZollernItems.chargiumIngot), new ItemStack(
				ZollernItems.chargiumDust, 1));
		
		// Shinium (Ingot -> Dust)
		ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
				ZollernItems.shiniumIngot), new ItemStack(
				ZollernItems.shiniumDust));
		
		// Lapis Ingot -> Lapis Dust
		ThermalExpansionHelper.addPulverizerRecipe(600, new ItemStack(
				ZollernItems.lapisIngot), new ItemStack(Items.DYE, 1,
				EnumDyeColor.BLUE.getDyeDamage()));
		
		// Obsidian Ingot -> Obsidian Dust
		ThermalExpansionHelper.addPulverizerRecipe(800, new ItemStack(
				ZollernItems.obsidianIngot), new ItemStack(
				ZollernItems.obsidianDust));
		
		// Obsidian Block -> Obsidian Dust
		ThermalExpansionHelper.addPulverizerRecipe(1200, new ItemStack(
				Blocks.OBSIDIAN), new ItemStack(ZollernItems.obsidianDust, 8));
		
		// Etrium -> Crushed Etrium
		ThermalExpansionHelper.addPulverizerRecipe(1200, new ItemStack(
				ZollernItems.etrium), new ItemStack(ZollernItems.crushedEtrium,
				8));
		
		// Corrupt Chargium Ore -> Chargium Dust
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(
				ZollernBlocks.corruptChargiumOre), new ItemStack(
				ZollernItems.chargiumDust, 2));
	}
}