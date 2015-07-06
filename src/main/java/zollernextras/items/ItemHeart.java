package zollernextras.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class ItemHeart extends Item {
	public ItemHeart() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_heart");
		this.setTextureName(Reference.MODID + ":heart");
		this.setMaxStackSize(1);
		this.setMaxDamage(5);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		EntityPlayer player = par2EntityPlayer;
		if (!player.capabilities.isCreativeMode) {
			float maxHealth = player.getMaxHealth();
			player.setHealth(maxHealth);
			par1ItemStack.damageItem(1, par2EntityPlayer);
		}
		return true;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.uncommon;
	}
}