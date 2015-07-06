package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class SugarCube extends GenericBlock {
	public SugarCube() {
		super("sugarcube", 0.1F);
		this.setMaterial(Material.sand);
		this.setStepSound(soundTypeSand);
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int p_149650_3_) {
		return Items.sugar;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int numDropped = rand.nextInt(9);
		numDropped = numDropped == 0 ? 1 : numDropped;
		return numDropped;
	}
}