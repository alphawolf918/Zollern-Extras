package zollernextras.items.swords;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherSword extends ItemSword {
	
	public NetherSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "nethersword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3Entity) {
		super.onItemRightClick(par1ItemStack, par2World, par3Entity);
		if (!par2World.isRemote) {
			Vec3 look = par3Entity.getLookVec();
			EntityLargeFireball fireball = new EntityLargeFireball(par2World);
			fireball.setPosition(par3Entity.posX + look.xCoord * 5,
					par3Entity.posY + 1 + look.yCoord * 5, par3Entity.posZ
					+ look.zCoord * 5);
			fireball.accelerationX = look.xCoord * 0.1;
			fireball.accelerationY = look.yCoord * 0.1;
			fireball.accelerationZ = look.zCoord * 0.1;
			par2World.spawnEntityInWorld(fireball);
			if (!par3Entity.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, par3Entity);
			}
		}
		return par1ItemStack;
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
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(EnumChatFormatting.ITALIC
					+ "A sword of fire, said to match the");
			list.add(EnumChatFormatting.ITALIC + "power of the Nether itself.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}