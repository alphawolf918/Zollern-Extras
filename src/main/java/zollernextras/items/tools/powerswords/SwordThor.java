package zollernextras.items.tools.powerswords;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.items.tools.ZollernSword;
import zollernextras.items.tools.ZollernToolMaterials;
import zollernextras.lib.KeyHelper;

public class SwordThor extends ZollernSword {
	
	private Random rand = new Random();
	
	public SwordThor() {
		super(ZollernToolMaterials.POWER, "thorsword");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn,
			EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		int length = 100;
		Vec3d startPos = new Vec3d(playerIn.posX, playerIn.posY
				+ playerIn.getEyeHeight(), playerIn.posZ);
		Vec3d endPos = startPos.add(new Vec3d(playerIn.getLookVec().xCoord
				* length, playerIn.getLookVec().yCoord * length, playerIn
				.getLookVec().zCoord * length));
		RayTraceResult mop = worldIn.rayTraceBlocks(startPos, endPos);
		if (mop == null) {
			return new ActionResult(EnumActionResult.PASS,
					playerIn.getHeldItem(handIn));
		}
		BlockPos vecPos = new BlockPos(mop.getBlockPos());
		BlockPos spawnPos = new BlockPos(vecPos.getX(), vecPos.getY(),
				vecPos.getZ());
		for (int l = 0; l < 4; l += 4) {
			worldIn.spawnEntity(new EntityLightningBolt(worldIn, vecPos.getX(),
					vecPos.getY(), vecPos.getZ() + l, false));
		}
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		playerIn.swingArm(handIn);
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
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(TextFormatting.ITALIC + "Whosoever holds this blade,");
			list.add(TextFormatting.ITALIC + "should he be worthy,");
			list.add(TextFormatting.ITALIC + "shall possess the power of Thor.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
	
}