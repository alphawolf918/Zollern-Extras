package zollernextras.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityDiamondGolem extends EntityIronGolem {
	
	public EntityDiamondGolem(World p_i1694_1_) {
		super(p_i1694_1_);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.50D);
	}
	
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3);
		int k;
		
		for (k = 0; k < j; ++k) {
			this.func_145778_a(Item.getItemFromBlock(Blocks.red_flower), 1,
					0.0F);
		}
		
		k = 3 + this.rand.nextInt(3);
		
		for (int l = 0; l < k; ++l) {
			this.dropItem(Items.diamond, 1);
		}
	}
}