package zollernextras.items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import zollernextras.lib.KeyHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherEye extends ModItem {
	
	public ItemNetherEye() {
		super("nethereye");
		this.setMaxStackSize(1);
		this.setMaxDamage(16);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			par1ItemStack.damageItem(1, par3EntityPlayer);
		}
		if (!par2World.isRemote) {
			int dimId = par2World.provider.dimensionId == 0 ? -1 : 0;
			par3EntityPlayer.travelToDimension(dimId);
			double posX = par3EntityPlayer.posX;
			double posY = par3EntityPlayer.posY;
			double posZ = par3EntityPlayer.posZ;
			for (int i = 0; i < 5; i++) {
				par2World.setBlock((int) posX + i, (int) posY + i, (int) posZ
						+ i, Blocks.air);
				par2World.setBlock((int) posX + i, (int) posY + 1, (int) posZ
						+ i, Blocks.air);
			}
		}
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(EnumChatFormatting.ITALIC + "WARNING: ");
			list.add(EnumChatFormatting.ITALIC
					+ "Currently buggy, may not work");
			list.add(EnumChatFormatting.ITALIC + " correctly.");
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
}