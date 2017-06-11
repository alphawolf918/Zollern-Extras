package zollernextras.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import zollernextras.config.ZEConfig;

public class EnchantmentList {
	
	/**
	 * Enchantment for weapons, applies the Radiance potion effect to whatever's
	 * hit, causing extra damage to IShadeEntity (shadow) mobs.
	 */
	public static Enchantment enlightened;
	
	public static void init() {
		enlightened = new EnchantmentEnlightened(
				ZEConfig.enchantmentEnlightenedID, 8,
				EnumEnchantmentType.weapon);
	}
}