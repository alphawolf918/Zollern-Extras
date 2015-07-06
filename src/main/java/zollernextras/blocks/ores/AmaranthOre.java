package zollernextras.blocks.ores;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthOre extends Block {
	public AmaranthOre() {
		super(Material.rock);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(Reference.MODID + "_amaranthore");
		this.setStepSound(this.soundTypeGlass);
		this.setBlockTextureName(Reference.MODID + ":" + "amaranthore");
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypePiston);
		this.setHardness(4.0F);
		this.setResistance(9.2F);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 6, 10);
			
			return j1;
		}
		return 0;
	}
}