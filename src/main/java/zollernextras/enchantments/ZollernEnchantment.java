package zollernextras.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import zollernextras.lib.ZollernModInfo;

public abstract class ZollernEnchantment extends Enchantment {
	
	public ZollernEnchantment(int par1EnchantmentId, int par2EnchantmentWeight,
			EnumEnchantmentType par3EnchantmentType) {
		super(par1EnchantmentId, par2EnchantmentWeight, par3EnchantmentType);
	}
	
	public Enchantment setEnchantmentName(String par1EnchantmentName) {
		this.setName(ZollernModInfo.MODID + "_" + par1EnchantmentName);
		return this;
	}
	
	@Override
	public int getMinLevel() {
		return 1;
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
	
	@Override
	public int getMinEnchantability(int p_77321_1_) {
		return 10 * p_77321_1_;
	}
	
	@Override
	public int getMaxEnchantability(int p_77317_1_) {
		return this.getMinEnchantability(p_77317_1_) + 30;
	}
}