package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import zollernextras.lib.MainHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FlowerBlock extends BlockBush {
	
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;
	public String flowerTexture;
	
	public FlowerBlock(String strTexture) {
		super(Material.plants);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, strTexture);
		flowerTexture = strTexture;
		setHardness(0.1F);
		setResistance(0.0F);
		setStepSound(soundTypeGrass);
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block p_149854_1_) {
		return p_149854_1_ == Blocks.grass || p_149854_1_ == Blocks.dirt
				|| p_149854_1_ == Blocks.farmland
				|| p_149854_1_ == BlockList.betterGrass;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}
}