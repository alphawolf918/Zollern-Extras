package zollernextras.lib.recipes;

import net.minecraft.item.ItemStack;
import zollernextras.items.ZollernItems;
import cofh.api.util.ThermalExpansionHelper;

public class InductionSmelterRecipes {
	
	public static void init() {
		// 2 Amaranth + 1 Zinc = 1 Zollernium (Ingots)
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(ZollernItems.amaranthIngot, 2),
				new ItemStack(ZollernItems.zincIngot, 1), new ItemStack(
						ZollernItems.zollerniumIngot));
		
		// 2 Amaranth + 1 Zinc = 1 Zollernium (Dusts)
		ThermalExpansionHelper
				.addSmelterRecipe(3500, new ItemStack(ZollernItems.amaranthDust, 2), new ItemStack(
						ZollernItems.zincDust, 1), new ItemStack(ZollernItems.zollerniumDust));
		
		// 1 Shinium Dust + 2 Chargium Dust = 2 Chargium Ingots
		ThermalExpansionHelper.addSmelterRecipe(5000, new ItemStack(ZollernItems.shiniumDust, 1),
				new ItemStack(ZollernItems.chargiumDust, 2), new ItemStack(
						ZollernItems.chargiumIngot, 2));
		
		// 2 Ascendium + 1 Amaranth Ingot = 1 Ascendant Amaranth Ingot
		ThermalExpansionHelper.addSmelterRecipe(5000, new ItemStack(ZollernItems.ascendium, 2),
				new ItemStack(ZollernItems.amaranthIngot, 1), new ItemStack(
						ZollernItems.ascendantAmaranthIngot, 1));
		
		// 1 Crushed Etrium + 1 Ascendant Amaranth Ingot = 1 Zucrite Dust
		ThermalExpansionHelper.addSmelterRecipe(5200, new ItemStack(ZollernItems.crushedEtrium, 1),
				new ItemStack(ZollernItems.ascendantAmaranthIngot, 1), new ItemStack(
						ZollernItems.zucriteDust, 1));
		
		// 1 Zucrite Dust + 1 Zollernium Ingot = 1 Zucrite Ingot
		ThermalExpansionHelper.addSmelterRecipe(6200, new ItemStack(ZollernItems.zucriteDust, 1),
				new ItemStack(ZollernItems.zollerniumIngot, 1), new ItemStack(
						ZollernItems.zucriteIngot, 1));
		
	}
	
}