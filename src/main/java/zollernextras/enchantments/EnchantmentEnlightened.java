package zollernextras.enchantments;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import zollernextras.mobs.entities.IShadeEntity;
import zollernextras.potions.ZollernPotion;

public class EnchantmentEnlightened extends ZollernEnchantment {
	
	public static float lightDamageBase = 4.0F;
	
	public EnchantmentEnlightened(int par1EnchantmentId,
			int par2EnchantmentWeight, EnumEnchantmentType par3EnchantmentType) {
		super(par1EnchantmentId, par2EnchantmentWeight, par3EnchantmentType);
		this.setEnchantmentName("enlightened");
	}
	
	// I have no idea what this does.
	@Override
	public float func_152376_a(int par1, EnumCreatureAttribute par2) {
		return par1 * 1.25F;
	}
	
	// This is where the "effect" of the Enchantment lives. I think the par3 is
	// the level of the Enchantment, but I'm not 100% sure on that.
	//
	// Radiance Time = 6000 / 4 = 1500 / 20 = 75 seconds.
	@Override
	public void func_151368_a(EntityLivingBase par1UsingEntity,
			Entity par2TargetEntity, int par3) {
		if (par2TargetEntity instanceof EntityLivingBase
				&& !(par2TargetEntity instanceof EntityPlayer)) {
			EntityLivingBase targetEntity = (EntityLivingBase) par2TargetEntity;
			if (targetEntity instanceof IShadeEntity) {
				targetEntity.addPotionEffect(new PotionEffect(
						ZollernPotion.radiance.id,
						(ZollernPotion.radianceTime / 4)));
				lightDamageBase += par3;
			}
		}
	}
}