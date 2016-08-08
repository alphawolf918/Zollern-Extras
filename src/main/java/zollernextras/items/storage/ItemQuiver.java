package zollernextras.items.storage;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.items.GenericItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemQuiver extends GenericItem {
	
	public ItemQuiver() {
		super("quiver");
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {
			if (!player.isSneaking()) {
				player.openGui(ZollernExtrasMod.INSTANCE,
						ZollernExtrasMod.QUIVER_INV, player.worldObj,
						(int) player.posX, (int) player.posY, (int) player.posZ);
			}
		}
		return stack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 10;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		list.add(EnumChatFormatting.ITALIC + "A quiver for your arrows!");
	}
}