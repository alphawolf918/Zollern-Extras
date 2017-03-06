package zollernextras.items.swords;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;
import zollernextras.potions.ZollernPotion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LightSword extends ItemSword {
	
	public LightSword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "lightsword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3Player) {
		super.onItemRightClick(par1ItemStack, par2World, par3Player);
		if (!par2World.isRemote) {
			Vec3 look = par3Player.getLookVec();
			par3Player.addPotionEffect(new PotionEffect(
					ZollernPotion.radiance.id, ZollernPotion.radianceTime, 0));
			if (!par3Player.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, par3Player);
			}
		}
		return par1ItemStack;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			if (living.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
				if (!living.worldObj.isRemote) {
					living.setDead();
				}
			}
		}
		return false;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack p_77613_1_) {
		return EnumRarity.epic;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.block;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(EnumChatFormatting.ITALIC + "Light, forged in a");
			list.add(EnumChatFormatting.ITALIC + "blade.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}