package zollernextras.lib.recipes;

import net.minecraft.item.ItemStack;
import zollernextras.items.ZollernItems;
import cofh.api.util.ThermalExpansionHelper;

public class InductionSmelterRecipes {
	
	public static void init() {
		// 2 Amaranth + 1 Zinc = 1 Zollernium (Ingots)
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(
				ZollernItems.amaranthIngot, 2), new ItemStack(
				ZollernItems.zincIngot, 1), new ItemStack(
				ZollernItems.zollerniumIngot));
		
		// 2 Amaranth + 1 Zinc = 1 Zollernium (Dusts)
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(
				ZollernItems.amaranthDust, 2), new ItemStack(
				ZollernItems.zincDust, 1), new ItemStack(
				ZollernItems.zollerniumDust));
	}
	
}