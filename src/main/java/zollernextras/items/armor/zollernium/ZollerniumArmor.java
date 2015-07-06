package zollernextras.items.armor.zollernium;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.Reference;

public class ZollerniumArmor extends ItemArmor {
	
	public String textureName;
	public String unName;
	public static boolean tickActive = false;
	public static double currentSpeed = 0D;
	
	public ZollerniumArmor(ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.textureName = textureName;
		unName = textureName;
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_" + unName);
		this.setTextureName(Reference.MODID + ":" + textureName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return Reference.MODID + ":textures/armor/" + "zollerniumarmor" + "_"
				+ (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public EnumRarity getRarity(ItemStack item) {
		return EnumRarity.epic;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
		return (p_82789_2_ == new ItemStack(ItemList.zollerniumIngot, 2));
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		player.stepHeight = 2F;
	}
}