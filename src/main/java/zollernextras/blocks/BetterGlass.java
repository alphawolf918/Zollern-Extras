package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BetterGlass extends BlockGlass {
	
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	
	public BetterGlass() {
		super(Material.glass, false);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "betterglass");
		this.setHardness(0.5F);
		this.setStepSound(this.soundTypeGlass);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		blockIcon = p_149651_1_.registerIcon(ModInfo.MODID + ":"
				+ "betterglass");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return this.blockIcon;
	}
	
	@Override
	protected boolean canSilkHarvest() {
		return true;
	}
}