package zollernextras.items.armor.amaranth;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthArmor extends ItemArmor {
	
	public String textureName;
	public String unName;
	
	public AmaranthArmor(ArmorMaterial material, String textureName, int type) {
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
		return Reference.MODID + ":textures/armor/" + "amarantharmor" + "_"
				+ (this.armorType == 2 ? "2" : "1") + ".png";
	}
}