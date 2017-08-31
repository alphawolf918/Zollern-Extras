package zollernextras.items.tools;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.items.ZollernItemBase;
import zollernextras.items.ZollernItems;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;

public class ItemBedrockBreaker extends ZollernItemBase {
	
	private int maxUses = 5;
	
	public ItemBedrockBreaker() {
		super("bedrockbreaker");
		this.setMaxDamage(this.maxUses);
		this.setMaxStackSize(1);
	}
	
	// First thing this does is it checks to make sure the world isn't remote,
	// which basically just tells it not to do ghost things. Second, we get the
	// Block that the Player is right-clicking on, and compare it to Bedrock. If
	// it is a match, we retrieve the currently held item in their hand that
	// they're currently using, and we check its durability damage. If its less
	// than the max damage it can have, spawn between 1 and 2 Rokkite gems, and
	// set the Bedrock Block to air. If the Player is not in Creative Mode,
	// damage the tool one time. If it is not a match, play a sound event that
	// lets the user know that it's broken.
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn,
			BlockPos pos, EnumHand hand, EnumFacing facing, float hitX,
			float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			IBlockState blockState = worldIn.getBlockState(pos);
			Block block = blockState.getBlock();
			if (block == Blocks.BEDROCK) {
				ItemStack heldItem = player.getHeldItem(hand);
				int toolDamage = this.getDamage(heldItem);
				if (toolDamage < this.getMaxDamage(heldItem)) {
					EntityItem rokkiteItem = new EntityItem(worldIn,
							pos.getX(), pos.getY(), pos.getZ(), new ItemStack(
									ZollernItems.rokkite,
									ZollernHelper.rngNumber(1, 2)));
					worldIn.spawnEntity(rokkiteItem);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
					if (!player.capabilities.isCreativeMode) {
						this.setDamage(heldItem, toolDamage + 1);
					}
				} else {
					// TODO: Play a sound event
				}
				return EnumActionResult.PASS;
			}
		}
		return EnumActionResult.FAIL;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add("Provides the power to");
			list.add("break Bedrock on right-click.");
			list.add("Recharge it with Ascendant");
			list.add("Amaranth Ingots, only works");
			list.add("when it's used up.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
	
}