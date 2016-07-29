package zollernextras.lib.recipes;

import net.minecraft.item.ItemStack;
import zollernextras.items.ZollernItems;
import zollernextras.lib.modhelper.ThermalExpansionHelper;

public class InductionSmelterRecipes {
	public static void init() {
		
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(
				ZollernItems.amaranthIngot, 2),
				new ItemStack(ZollernItems.zincIngot, 1), new ItemStack(
						ZollernItems.zollerniumIngot));
		
		ThermalExpansionHelper.addSmelterRecipe(3500, new ItemStack(
				ZollernItems.amaranthDust, 2), new ItemStack(ZollernItems.zincDust, 1),
				new ItemStack(ZollernItems.zollerniumDust));
		
		ThermalExpansionHelper.addSmelterRecipe(5000, new ItemStack(
				ZollernItems.shiniumDust, 1), new ItemStack(ZollernItems.chargiumDust,
				2), new ItemStack(ZollernItems.chargiumIngot, 2));
	}
}