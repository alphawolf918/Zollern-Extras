package zollernextras.lib;

import net.minecraft.util.DamageSource;

public class DSource extends DamageSource {
	
	public static DSource deathJellyfish = new DSource("jellyfishsting");
	public static DSource deathShark = new DSource("sharkattack");
	
	public DSource(String par1) {
		super(par1);
	}
}