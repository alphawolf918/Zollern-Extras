package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CookieBlock extends GenericBlock {
	public CookieBlock() {
		super("cookieblock", 0.2F);
		this.blockMaterial = Material.clay;
		this.setHardness(0.2F);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeCloth);
	}
	
	@Override
	public boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Items.cookie;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		int r = par1Random.nextInt(9);
		r = r == 0 ? 1 : r;
		return r;
	}
}