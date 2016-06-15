package zollernextras.items.swords;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EnderSword extends ItemSword {
	
	public EnderSword(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(ModTabs.zTab);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "endersword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer) {
		super.onItemRightClick(itemstack, world, entityplayer);
		float f = 2.0F;
		
		float f1 = entityplayer.prevRotationPitch
				+ (entityplayer.rotationPitch - entityplayer.prevRotationPitch)
				* f;
		
		float f2 = entityplayer.prevRotationYaw
				+ (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
		
		double d = entityplayer.prevPosX
				+ (entityplayer.posX - entityplayer.prevPosX) * f;
		
		double d1 = entityplayer.prevPosY
				+ (entityplayer.posY - entityplayer.prevPosY) * f +
				
				1.6200000000000001D - entityplayer.yOffset;
		
		double d2 = entityplayer.prevPosZ
				+ (entityplayer.posZ - entityplayer.prevPosZ) * f;
		Vec3 vec3d = null;
		vec3d = vec3d.createVectorHelper(d, d1, d2);
		
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		
		float f7 = f4 * f5;
		
		float f8 = f6;
		
		float f9 = f3 * f5;
		
		double d3 = 5000D;
		
		Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
		
		MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3d,
				vec3d1, false);
		
		if (movingobjectposition == null)
		
		{
			
			return itemstack;
			
		}
		
		int i = movingobjectposition.blockX;
		
		int j = movingobjectposition.blockY;
		
		int k = movingobjectposition.blockZ;
		
		this.checkBlockAt(i, j, k, world, entityplayer);
		world.playSoundEffect(i + 5.0D, j + 5.0D, k + 5.0D,
				"mob.endermen.portal", 2.0F,
				world.rand.nextFloat() * 0.1F + 0.9F);
		return itemstack;
	}
	
	/**
	 * Recursive function, checks to ensure a block is not present at the
	 * desired teleport location, and if it is, adds 2 to the Y coordinate.
	 * Repeats until it finds an empty spot.
	 */
	private void checkBlockAt(int x, int y, int z, World world,
			EntityPlayer entityplayer) {
		if (world.getBlock(x, y, z) == Block.getBlockById(0)) {
			world.playSoundEffect(x + 5.0D, y + 5.0D, z + 5.0D,
					"mob.endermen.portal", 2.0F,
					world.rand.nextFloat() * 0.1F + 0.9F);
			entityplayer.setPosition(x, y, z);
		} else {
			checkBlockAt(x, y + 2, z, world, entityplayer);
		}
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
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		DamageSource par1DamageSource = DamageSource
				.causePlayerDamage(par2EntityPlayer);
		entity.attackEntityFrom(par1DamageSource,
				ToolMaterials.POWER.getDamageVsEntity());
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(EnumChatFormatting.ITALIC + "A sword forged from");
			list.add(EnumChatFormatting.ITALIC
					+ "the teeth of the Ender Dragon.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}