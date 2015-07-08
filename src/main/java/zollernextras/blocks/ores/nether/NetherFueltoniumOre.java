package zollernextras.blocks.ores.nether;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.blocks.ores.IOre;
import zollernextras.lib.M;
import zollernextras.lib.Reference;

public class NetherFueltoniumOre extends Block implements IOre {
	public NetherFueltoniumOre() {
		super(Material.rock);
		M.setTab(this);
		this.setBlockName(Reference.MODID + "_netherfueltoniumore");
		this.setHardness(0.3F);
		this.setStepSound(this.soundTypeStone);
		this.setBlockTextureName(Reference.MODID + ":" + "fuelnetherore");
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypePiston);
		this.setHardness(6.0F);
		this.setResistance(9.2F);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 8, 16);
			
			return j1;
		}
		return 0;
	}
	
	@Override
	public double getFortune() {
		return 0.06D;
	}
	
	@Override
	public int getMaxDropIncrease() {
		return 4;
	}
	
	@Override
	public ItemStack getDroppedItemStack() {
		return new ItemStack(this);
	}
}