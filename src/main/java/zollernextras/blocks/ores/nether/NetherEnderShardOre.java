package zollernextras.blocks.ores.nether;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.blocks.ores.IOre;
import zollernextras.lib.MainHelper;
import zollernextras.lib.Reference;

public class NetherEnderShardOre extends Block implements IOre {
	public NetherEnderShardOre() {
		super(Material.rock);
		MainHelper.setTab(this);
		this.setBlockName(Reference.MODID + "_netherendershardore");
		this.setHardness(0.3F);
		this.setStepSound(this.soundTypeStone);
		this.setBlockTextureName(Reference.MODID + ":" + "endernetherore");
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypePiston);
		this.setHardness(3.5F);
		this.setResistance(6.2F);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 6, 11);
			
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