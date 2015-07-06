package zollernextras.blocks.ores.nether;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.lib.M;
import zollernextras.lib.Reference;

public class NetherAmaranthOre extends Block {
	public NetherAmaranthOre() {
		super(Material.rock);
		M.setTab(this);
		this.setBlockName(Reference.MODID + "_netheramaranthore");
		this.setStepSound(this.soundTypeStone);
		this.setBlockTextureName(Reference.MODID + ":" + "amaranthnetherore");
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
}