package zollernextras.items.tools.powerswords;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
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

public class SwordEnder extends ZollernSword {
	
	private Random rand = new Random();
	
	public SwordEnder() {
		super(ZollernToolMaterials.POWER, "endersword");
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
		this.checkBlockAt(vecPos.getX(), vecPos.getY(), vecPos.getZ(), worldIn,
				playerIn);
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		return new ActionResult(EnumActionResult.PASS,
				playerIn.getHeldItem(handIn));
	}
	
	/**
	 * Recursive function, checks to ensure a block is not present at the
	 * desired teleport location, and if it is, adds 2 to the Y coordinate.
	 * Repeats until it finds an empty spot.
	 */
	private void checkBlockAt(double posX, double posY, double posZ,
			World world, EntityPlayer entityplayer) {
		if (world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.AIR
				.getDefaultState()) {
			world.playSound(entityplayer, new BlockPos(posX + 0.5D,
					posY + 0.5D, posZ + 0.5D),
					SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.MASTER,
					2.0F, world.rand.nextFloat() * 0.1F + 0.9F);
			entityplayer.attemptTeleport(posX, posY, posZ);
			for (int t = 1; t < 10; t++) {
				world.spawnParticle(EnumParticleTypes.PORTAL, posX + 5.0D,
						posY + 5.0D, posZ + 5.0D, 0, 0, 0);
			}
		} else {
			checkBlockAt(posX, posY + 2, posZ, world, entityplayer);
		}
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
			list.add(TextFormatting.ITALIC + "A sword forged from");
			list.add(TextFormatting.ITALIC + "the teeth of the Ender Dragon.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
	
}