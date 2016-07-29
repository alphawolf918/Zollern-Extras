package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BabyDragonEgg extends BlockDragonEgg {
	
	public BabyDragonEgg() {
		ZollernHelper.setTab(this);
		ZollernHelper.setName(this, "babydragonegg");
		ZollernHelper.setTexture(this, "azurite");
		setHardness(1.3F);
		setResistance(15.0F);
		setStepSound(Block.soundTypePiston);
		setLightLevel(1.0F);
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4,
			EntityPlayer par5EntityPlayer) {
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return Item.getItemById(0);
	}
}