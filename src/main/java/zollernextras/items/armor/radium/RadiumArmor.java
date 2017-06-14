package zollernextras.items.armor.radium;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernModInfo;

public class RadiumArmor extends ItemArmor {
	
	public String textureName;
	public String unName;
	
	public RadiumArmor(ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.textureName = textureName;
		unName = textureName;
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(ZollernModInfo.MODID + "_" + unName);
		this.setTextureName(ZollernModInfo.MODID + ":" + textureName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return ZollernModInfo.MODID + ":textures/armor/" + "radiumarmor" + "_"
				+ (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public EnumRarity getRarity(ItemStack item) {
		return EnumRarity.epic;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
		return p_82789_2_ == new ItemStack(ZollernItems.radiance, 1);
	}
}