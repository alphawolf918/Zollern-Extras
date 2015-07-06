package zollernextras.blocks;

import java.util.List;
import net.minecraft.block.BlockAnvil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollernextras.lib.M;
import zollernextras.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GoldenAnvil extends BlockAnvil {
	public static final String[] anvilDamageNames = new String[] { "intact",
			"slightlyDamaged", "veryDamaged" };
	private static final String[] anvilIconNames = new String[] {
			"goldanvil_top_damaged_0", "goldanvil_top_damaged_1",
			"goldanvil_top_damaged_2" };
	@SideOnly(Side.CLIENT)
	public int anvilRenderSide;
	@SideOnly(Side.CLIENT)
	private IIcon[] anvilIcons;
	
	protected GoldenAnvil() {
		this.setLightOpacity(0);
		M.setTab(this);
		this.setBlockName(Reference.MODID + "_goldanvil");
		this.setResistance(4000.0F);
		this.setHardness(5.0F);
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		if (this.anvilRenderSide == 3 && p_149691_1_ == 1) {
			int k = (p_149691_2_ >> 2) % this.anvilIcons.length;
			return this.anvilIcons[k];
		} else {
			return this.blockIcon;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(Reference.MODID
				+ ":goldanvil_base");
		this.anvilIcons = new IIcon[anvilIconNames.length];
		
		for (int i = 0; i < this.anvilIcons.length; ++i) {
			this.anvilIcons[i] = p_149651_1_.registerIcon(Reference.MODID + ":"
					+ anvilIconNames[i]);
		}
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_,
			int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_,
			ItemStack p_149689_6_) {
		int l = MathHelper
				.floor_double(p_149689_5_.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		int i1 = p_149689_1_.getBlockMetadata(p_149689_2_, p_149689_3_,
				p_149689_4_) >> 2;
		++l;
		l %= 4;
		
		if (l == 0) {
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_,
					p_149689_4_, 2 | i1 << 2, 2);
		}
		
		if (l == 1) {
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_,
					p_149689_4_, 3 | i1 << 2, 2);
		}
		
		if (l == 2) {
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_,
					p_149689_4_, 0 | i1 << 2, 2);
		}
		
		if (l == 3) {
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_,
					p_149689_4_, 1 | i1 << 2, 2);
		}
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return 35;
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int p_149692_1_) {
		return p_149692_1_ >> 2;
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_,
			int p_149719_2_, int p_149719_3_, int p_149719_4_) {
		int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_,
				p_149719_4_) & 3;
		
		if (l != 3 && l != 1) {
			this.setBlockBounds(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
		}
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_,
			List p_149666_3_) {
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
	}
	
	@Override
	protected void func_149829_a(EntityFallingBlock p_149829_1_) {
		p_149829_1_.func_145806_a(true);
	}
	
	@Override
	public void func_149828_a(World p_149828_1_, int p_149828_2_,
			int p_149828_3_, int p_149828_4_, int p_149828_5_) {
		p_149828_1_.playAuxSFX(1022, p_149828_2_, p_149828_3_, p_149828_4_, 0);
	}
	
	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return true;
	}
}