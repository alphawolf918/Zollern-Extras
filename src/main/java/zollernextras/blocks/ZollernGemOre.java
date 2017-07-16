package zollernextras.blocks;

import java.util.Random;

public class ZollernGemOre extends ZollernBlockOre {
	
	public ZollernGemOre(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
	
	@Override
	public int quantityDropped(Random rand) {
		if (rand.nextInt(10) == 2) {
			return 2;
		} else {
			return 1;
		}
	}
	
}