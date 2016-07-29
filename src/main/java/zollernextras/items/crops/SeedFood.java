package zollernextras.items.crops;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;
import zollernextras.lib.ZollernHelper;

public class SeedFood extends ItemSeedFood {
	public SeedFood(int p_i45351_1_, float p_i45351_2_, Block p_i45351_3_,
			Block farmLand, String strTexture) {
		super(p_i45351_1_, p_i45351_2_, p_i45351_3_, Blocks.farmland);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, strTexture);
	}
}