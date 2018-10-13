package zollernextras.items.tools.powerswords;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.items.tools.ZollernSword;
import zollernextras.items.tools.ZollernToolMaterials;
import zollernextras.lib.KeyHelper;

public class SwordWither extends ZollernSword {
	
	public SwordWither() {
		super(ZollernToolMaterials.POWER, "withersword");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn,
			EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		if (!worldIn.isRemote) {
			ItemStack par1ItemStack = playerIn.getHeldItem(handIn);
			Vec3d look = playerIn.getLookVec();
			EntityWitherSkull witherskull = new EntityWitherSkull(worldIn);
			witherskull.setPosition(playerIn.posX + look.xCoord * 5,
					playerIn.posY + 1 + look.yCoord * 5, playerIn.posZ
							+ look.zCoord * 5);
			witherskull.accelerationX = look.xCoord * 0.1;
			witherskull.accelerationY = look.yCoord * 0.1;
			witherskull.accelerationZ = look.zCoord * 0.1;
			worldIn.spawnEntity(witherskull);
			if (!playerIn.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, playerIn);
			}
		}
		playerIn.swingArm(handIn);
		return new ActionResult(EnumActionResult.PASS,
				playerIn.getHeldItem(handIn));
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			living.addPotionEffect(new PotionEffect(MobEffects.WITHER, 50, 2));
			this.playWitherSound(living.getEntityWorld(), living.posX,
					living.posY, living.posZ);
		}
		return false;
	}
	
	private void playWitherSound(World world, double i, double j, double k) {
		world.playSound(i + 5.0D, j + 5.0D, k + 5.0D,
				SoundEvents.ENTITY_WITHER_AMBIENT, SoundCategory.AMBIENT, 1.0F,
				world.rand.nextFloat() * 0.1F + 0.9F, true);
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
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(TextFormatting.ITALIC + "A withering");
			list.add(TextFormatting.ITALIC + "blade, touched with death.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}