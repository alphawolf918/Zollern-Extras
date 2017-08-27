package zollernextras.items.tools;

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
import zollernextras.items.ZollernItemBase;
import zollernextras.items.ZollernItems;

public class ItemBedrockBreaker extends ZollernItemBase {
	
	public ItemBedrockBreaker() {
		super("bedrockbreaker");
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn,
			BlockPos pos, EnumHand hand, EnumFacing facing, float hitX,
			float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			IBlockState blockState = worldIn.getBlockState(pos);
			Block block = blockState.getBlock();
			if (block == Blocks.BEDROCK) {
				EntityItem rokkiteItem = new EntityItem(worldIn, pos.getX(),
						pos.getY(), pos.getZ(), new ItemStack(
								ZollernItems.rokkite, 2));
				worldIn.spawnEntity(rokkiteItem);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
				return EnumActionResult.PASS;
			}
		}
		return EnumActionResult.FAIL;
	}
	
}