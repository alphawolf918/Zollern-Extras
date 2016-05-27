package zollernextras.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class IceCream extends SweetFood {
	
	public IceCream() {
		super("icecream", Potion.fireResistance.id);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_,
			EntityPlayer p_77654_3_) {
		super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
		return new ItemStack(Items.bowl);
	}
	
}