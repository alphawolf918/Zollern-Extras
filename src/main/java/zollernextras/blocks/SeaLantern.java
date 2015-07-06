package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import zollernextras.items.ItemList;

public class SeaLantern extends GenericBlock {
	
	public SeaLantern() {
		super("sealantern", 2.0F);
		this.harvestLevel = 2;
		this.setLightLevel(1.0F);
		this.setMaterial(Material.glass);
		this.setStepSound(this.soundTypeGlass);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.prismarineCrystal;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) <= 5) {
			return 2;
		} else {
			return 3;
		}
	}
}