package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import zollernextras.lib.M;
import zollernextras.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IceCreamSandwichBlock extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon field_150035_a;
	@SideOnly(Side.CLIENT)
	private IIcon field_150034_b;
	
	public IceCreamSandwichBlock() {
		super(Material.clay);
		M.setTab(this);
		M.setName(this, "icecreamsandwichblock");
		this.setHardness(1.6F);
		this.setResistance(0.1F);
		this.setStepSound(soundTypeSnow);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ == 1 ? this.field_150035_a
				: p_149691_1_ == 0 ? BlockList.cookieBlock
						.getBlockTextureFromSide(p_149691_1_)
						: p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon
								: this.field_150034_b;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(Reference.MODID
				+ ":icecreamsandwichblock");
		this.field_150035_a = p_149651_1_.registerIcon(Reference.MODID
				+ ":cookieblock");
		this.field_150034_b = p_149651_1_.registerIcon(Reference.MODID
				+ ":icecreamsandwichblock");
	}
}