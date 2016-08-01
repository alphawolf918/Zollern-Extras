package zollernextras.potions;

import net.minecraft.potion.Potion;

public class ZollernPotionList {
	
	public static Potion radiance;
	public static Potion infected;
	
	public static void init() {
		radiance = new PotionRadiance(30, false, 13458603);
		infected = new PotionInfected(31, true, 13615421);
	}
}