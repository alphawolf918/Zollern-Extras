package zollernextras.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import zollernextras.mobs.entities.EntityDuck;
import cpw.mods.fml.common.registry.IThrowableEntity;

public class EntityDuckEgg extends EntityThrowable implements IThrowableEntity {
	
	public EntityDuckEgg(World p_i1779_1_) {
		super(p_i1779_1_);
	}
	
	public EntityDuckEgg(World p_i1780_1_, EntityLivingBase p_i1780_2_) {
		super(p_i1780_1_, p_i1780_2_);
	}
	
	public EntityDuckEgg(World p_i1781_1_, double p_i1781_2_,
			double p_i1781_4_, double p_i1781_6_) {
		super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
	}
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		if (p_70184_1_.entityHit != null) {
			p_70184_1_.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, this.getThrower()),
					0.0F);
		}
		
		if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0) {
			byte b0 = 1;
			
			if (this.rand.nextInt(32) == 0) {
				b0 = 4;
			}
			
			for (int i = 0; i < b0; ++i) {
				EntityDuck entityduck = new EntityDuck(this.worldObj);
				entityduck.setGrowingAge(-24000);
				entityduck.setLocationAndAngles(this.posX, this.posY,
						this.posZ, this.rotationYaw, 0.0F);
				this.worldObj.spawnEntityInWorld(entityduck);
			}
		}
		
		for (int j = 0; j < 8; ++j) {
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY,
					this.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
	
	@Override
	public void setThrower(Entity entity) {
		
	}
}