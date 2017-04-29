package zollernextras.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZollernPotionItem extends GenericItem {
	
	protected static Potion potionEffect = null;
	
	public ZollernPotionItem(String strName, Potion pe) {
		super(strName);
		this.setMaxStackSize(1);
		this.setPotionEffect(pe);
	}
	
	public static void setPotionEffect(Potion pe) {
		potionEffect = pe;
	}
	
	public Potion getPotionEffect() {
		return potionEffect;
	}
	
	// Even though it says onEaten, this actually applies to when an item is
	// drank, too.
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {
			if (!(potionEffect == null)) {
				player.addPotionEffect(new PotionEffect(
						this.getPotionEffect().id, 12000, 2));
			}
		}
		if (!player.capabilities.isCreativeMode) {
			--itemStack.stackSize;
			if (itemStack.stackSize <= 0) {
				return new ItemStack(Items.glass_bottle);
			}
			player.inventory.addItemStackToInventory(new ItemStack(
					Items.glass_bottle));
		}
		return itemStack;
	}
	
	// This was in the ItemPotion class so I migrated it here - I believe it's
	// the amount of ticks that it takes to drink a potion.
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 32;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.drink;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
	}
	
	@Override
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_,
			World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_,
			int p_77648_7_, float p_77648_8_, float p_77648_9_,
			float p_77648_10_) {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
}