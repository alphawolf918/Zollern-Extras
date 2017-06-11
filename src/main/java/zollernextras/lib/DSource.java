package zollernextras.lib;

import net.minecraft.util.DamageSource;

public class DSource extends DamageSource {
	
	public static DSource deathJellyfish = new DSource("jellyfishsting");
	public static DSource deathShark = new DSource("sharkattack");
	public static DSource deathFueltonium = new DSource("fueltonium");
	public static DSource deathShadows = new DSource("shadows");
	public static DSource deathInfection = new DSource("infection");
	public static DSource deathLight = new DSource("light");
	
	public DSource(String par1) {
		super(par1);
	}
}