package zollernextras.items.armor.amaranth;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ModInfo;

public class AmaranthArmor extends ItemArmor {
	
	public String textureName;
	public String unName;
	
	protected Enchantment armorEnchantment;
	protected int enchantmentAmplifier = 1;
	
	public AmaranthArmor(ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.textureName = textureName;
		unName = textureName;
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ModInfo.MODID + "_" + unName);
		this.setTextureName(ModInfo.MODID + ":" + textureName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return ModInfo.MODID + ":textures/armor/" + "amarantharmor" + "_"
				+ (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
		return p_82789_2_ == new ItemStack(ItemList.amaranthIngot, 1);
	}
}