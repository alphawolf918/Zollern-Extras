package zollernextras.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PopcornBowl extends CookedFood {
	
	public PopcornBowl() {
		super("popcornbowl", 4, 4);
	}
	
	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_,
			EntityPlayer p_77654_3_) {
		super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
		return new ItemStack(Items.bowl);
	}
}
