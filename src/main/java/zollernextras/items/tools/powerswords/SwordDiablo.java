package zollernextras.items.tools.powerswords;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.items.tools.ZollernSword;
import zollernextras.items.tools.ZollernToolMaterials;
import zollernextras.lib.KeyHelper;

public class SwordDiablo extends ZollernSword {
	
	public SwordDiablo() {
		super(ZollernToolMaterials.POWER, "nethersword");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn,
			EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		if (!worldIn.isRemote) {
			ItemStack par1ItemStack = playerIn.getHeldItem(handIn);
			Vec3d look = playerIn.getLookVec();
			EntityLargeFireball fireball = new EntityLargeFireball(worldIn);
			fireball.setPosition(playerIn.posX + look.xCoord * 5, playerIn.posY
					+ 1 + look.yCoord * 5, playerIn.posZ + look.zCoord * 5);
			fireball.accelerationX = look.xCoord * 0.1;
			fireball.accelerationY = look.yCoord * 0.1;
			fireball.accelerationZ = look.zCoord * 0.1;
			worldIn.spawnEntity(fireball);
			if (!playerIn.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, playerIn);
			}
		}
		return new ActionResult(EnumActionResult.PASS,
				playerIn.getHeldItem(handIn));
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.BLOCK;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack p_77613_1_) {
		return EnumRarity.EPIC;
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
			list.add(TextFormatting.ITALIC
					+ "A sword of fire, said to match the");
			list.add(TextFormatting.ITALIC + "power of the Nether itself.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
	
}