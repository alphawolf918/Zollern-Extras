package zollernextras.blocks.ores;

import java.util.Random;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class ShadowGemOre extends GemOre {
	
	public ShadowGemOre(String strTexture, Item theItem) {
		super(strTexture, theItem);
		this.setHardResist(1.4F);
		this.setHarvestLevel("pickaxe", 4);
		this.setFortune(.08D);
		this.setMaxDropIncrease(8);
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) <= 5) {
			return 4;
		} else {
			return 2;
		}
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 15, 20);
			
			return j1;
		}
		return 0;
	}
}