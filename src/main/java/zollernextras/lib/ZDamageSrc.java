package zollernextras.lib;

import net.minecraft.util.DamageSource;

public class ZDamageSrc extends DamageSource {
	
	public static ZDamageSrc deathJellyfish = new ZDamageSrc("jellyfishsting");
	public static ZDamageSrc deathShark = new ZDamageSrc("sharkattack");
	public static ZDamageSrc deathFueltonium = new ZDamageSrc("fueltonium");
	public static ZDamageSrc deathShadows = new ZDamageSrc("shadows");
	public static ZDamageSrc deathInfection = new ZDamageSrc("infection");
	public static ZDamageSrc deathLight = new ZDamageSrc("light");
	
	public ZDamageSrc(String par1) {
		super(par1);
	}
}