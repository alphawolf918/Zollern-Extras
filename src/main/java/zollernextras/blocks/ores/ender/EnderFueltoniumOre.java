package zollernextras.blocks.ores.ender;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.lib.M;

public class EnderFueltoniumOre extends Block {
	public EnderFueltoniumOre() {
		super(Material.rock);
		M.setTab(this);
		M.setNameAndTexture(this, "enderfnore");
		this.setStepSound(this.soundTypeStone);
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypePiston);
		this.setHardness(4.5F);
		this.setResistance(8.2F);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 14, 25);
			
			return j1;
		}
		return 0;
	}
}