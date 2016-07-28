package zollernextras.potions;

import net.minecraft.potion.Potion;
import zollernextras.lib.ZollernModInfo;

public class ZollernPotion extends Potion {
	
	/**
	 * @param Potion
	 *            ID.
	 * @param Potion
	 *            Whether the Potion is a good or bad effect.
	 * @param Potion
	 *            Amplifier.
	 */
	protected ZollernPotion(String potionName, int potionId,
			boolean potionIsBadEffect, int potionEffectiveness) {
		super(potionId, potionIsBadEffect, potionEffectiveness);
		this.setPotionName(ZollernModInfo.MODID + "_" + potionName);
		this.setIconIndex(0, 0);
	}
	
	@Override
	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}
	
}