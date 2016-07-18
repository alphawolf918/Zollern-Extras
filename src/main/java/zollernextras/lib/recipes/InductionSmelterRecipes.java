package zollernextras.lib.recipes;

import net.minecraft.item.ItemStack;
import zollernextras.items.ItemList;
import zollernextras.lib.modhelper.ThermalExpansionHelper;

public class InductionSmelterRecipes {
	public static void init() {
		
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(
				ItemList.amaranthIngot, 2),
				new ItemStack(ItemList.zincIngot, 1), new ItemStack(
						ItemList.zollerniumIngot));
		
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(
				ItemList.amaranthDust, 2), new ItemStack(ItemList.zincDust, 1),
				new ItemStack(ItemList.zollerniumDust));
		
		ThermalExpansionHelper.addSmelterRecipe(5000, new ItemStack(
				ItemList.shiniumDust, 1), new ItemStack(ItemList.chargiumDust,
				2), new ItemStack(ItemList.chargiumIngot, 2));
	}
}