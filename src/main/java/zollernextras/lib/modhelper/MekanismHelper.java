package zollernextras.lib.modhelper;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Optional;

public class MekanismHelper extends ModHelperBase {
	
	@Optional.Method(modid = "Metallurgy")
	@Override
	public void register() {
	}
	
	/**
	 * Add a Crusher recipe. (Ingot -> Dust)
	 * 
	 * @param input
	 *            - input ItemStack
	 * @param output
	 *            - output ItemStack
	 */
	public static void addMekanismCrusherRecipe(ItemStack input,
			ItemStack output) {
		try {
			Class recipeClass = Class.forName("metallurgy.api.RecipeHelper");
			java.lang.reflect.Method m = recipeClass.getMethod(
					"addCrusherRecipe", ItemStack.class, ItemStack.class);
			m.invoke(null, input, output);
		} catch (Exception e) {
			System.err.println("[Metallurgy] Error while adding recipe: "
					+ e.getMessage());
		}
	}
}