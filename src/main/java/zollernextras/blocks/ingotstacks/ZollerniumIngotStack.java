package zollernextras.blocks.ingotstacks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollernextras.blocks.tiles.TEBlockBase;
import zollernextras.blocks.tiles.TEZollerniumBlockIngot;
import zollernextras.items.ItemList;
import zollernextras.lib.M;

public class ZollerniumIngotStack extends BlockContainer {
	
	private float boundingBoxMaxY = 0.6F;
	
	public ZollerniumIngotStack(String strTexture) {
		super(Material.iron);
		M.setTab(this);
		M.setName(this, "ingotBlock_" + strTexture);
		M.setTexture(this, "zollerniumblock");
		this.setBlockBounds(0.125F, 0.0F, 0.125F, 1.0F - 0.125F,
				boundingBoxMaxY, 1.0F - 0.125F);
		this.setHardness(2.0F);
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y,
			int z, int side) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k,
			EntityLivingBase entityLiving, ItemStack itemStack) {
		int facing = MathHelper
				.floor_double((entityLiving.rotationYaw * 4F) / 360F + 0.5D) & 3;
		TileEntity te = world.getTileEntity(i, j, k);
		if (te != null && te instanceof TEBlockBase) {
			TEBlockBase ted = (TEBlockBase) te;
			ted.setFacing(facing);
			world.markBlockForUpdate(i, j, k);
		}
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int p_149650_3_) {
		return ItemList.zollerniumIngot;
	}
	
	private int blockMetadata;
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block,
			int par6) {
		blockMetadata = world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return 6;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TEZollerniumBlockIngot();
	}
}