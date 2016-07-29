package zollernextras.mobs.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zollernextras.items.ZollernItems;

public class EntityShrimp extends EntityJellyfish {
	public EntityShrimp(World par1World) {
		super(par1World);
		this.setSize(this.width, this.height);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(2.0D);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		
	}
	
	@Override
	protected Item getDropItem() {
		return ZollernItems.rawShrimp;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3 + par2) + 1;
		for (int k = 0; k < j; ++k) {
			this.entityDropItem(new ItemStack(ZollernItems.rawShrimp, 1), 0.0F);
		}
	}
	
	@Override
	public boolean isInWater() {
		return this.worldObj.handleMaterialAcceleration(
				this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D),
				Material.water, this);
	}
}