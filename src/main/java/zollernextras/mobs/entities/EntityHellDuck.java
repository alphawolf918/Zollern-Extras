package zollernextras.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import zollernextras.events.ZollernSoundEvents;

public class EntityHellDuck extends EntityDuck implements IMob {
	
	public EntityHellDuck(World par1World) {
		super(par1World);
	}
	
	@Override
	public void initEntityAI() {
		this.setSize(0.3F * 2.0F, 0.7F * 2.0F);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this,
				EntityVillager.class, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this,
				EntityIronGolem.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
				.setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
				.setBaseValue(45.0F);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZollernSoundEvents.ENTITY_HELLDUCK_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return ZollernSoundEvents.ENTITY_HELLDUCK_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZollernSoundEvents.ENTITY_HELLDUCK_DIE;
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		player.attackEntityFrom(DamageSource.causeMobDamage(this), 4.0F);
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.isInWater()) {
			this.attackEntityFrom(DamageSource.DROWN, 5.0F);
		}
		super.onLivingUpdate();
	}
	
}