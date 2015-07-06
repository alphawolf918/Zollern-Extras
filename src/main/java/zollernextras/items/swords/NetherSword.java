package zollernextras.items.swords;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.M;

public class NetherSword extends ItemSword {
	
	public NetherSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		M.setTab(this);
		M.setNameAndTexture(this, "nethersword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3Entity) {
		super.onItemRightClick(par1ItemStack, par2World, par3Entity);
		Vec3 look = par3Entity.getLookVec();
		EntityLargeFireball fireball = new EntityLargeFireball(par2World);
		fireball.setPosition(par3Entity.posX + look.xCoord * 5, par3Entity.posY
				+ 1 + look.yCoord * 5, par3Entity.posZ + look.zCoord * 5);
		fireball.accelerationX = look.xCoord * 0.1;
		fireball.accelerationY = look.yCoord * 0.1;
		fireball.accelerationZ = look.zCoord * 0.1;
		par2World.spawnEntityInWorld(fireball);
		return par1ItemStack;
	}
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
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
	public boolean onLeftClickEntity(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		entity.setFire(60);
		DamageSource par1DamageSource = DamageSource
				.causePlayerDamage(par2EntityPlayer);
		entity.attackEntityFrom(par1DamageSource,
				ToolMaterials.POWER.getDamageVsEntity());
		return true;
	}
}