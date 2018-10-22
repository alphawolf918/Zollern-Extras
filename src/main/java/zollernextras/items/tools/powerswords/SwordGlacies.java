package zollernextras.items.tools.powerswords;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class SwordGlacies extends ZollernSword {
	
	public SwordGlacies() {
		super(ZollernToolMaterials.POWER, "icesword");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,
			EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		
		int length = 100;
		Vec3d startPos = new Vec3d(playerIn.posX, playerIn.posY + playerIn.getEyeHeight(),
				playerIn.posZ);
		Vec3d endPos = startPos.add(new Vec3d(playerIn.getLookVec().xCoord * length, playerIn
				.getLookVec().yCoord * length, playerIn.getLookVec().zCoord * length));
		RayTraceResult mop = worldIn.rayTraceBlocks(startPos, endPos);
		if (mop == null) {
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}
		BlockPos vecPos = new BlockPos(mop.getBlockPos());
		
		int i = vecPos.getX();
		int j = vecPos.getY();
		int k = vecPos.getZ();
		
		for (int l = 0; l < 8; l++) {
			int j2 = j + l;
			worldIn.setBlockState(new BlockPos(i, j2, k), Blocks.PACKED_ICE.getDefaultState());
			if (j2 < 256) {
				worldIn.setBlockState(new BlockPos(i, (j2 + 1), k),
						Blocks.PACKED_ICE.getDefaultState());
			}
		}
		
		playerIn.swingArm(handIn);
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
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
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list,
			boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(TextFormatting.ITALIC + "A sword born from");
			list.add(TextFormatting.ITALIC + " the land of ice.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
	
}