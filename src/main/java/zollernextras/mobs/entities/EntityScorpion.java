package zollernextras.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityScorpion extends EntityCaveSpider implements IShadeEntity {
	
	public EntityScorpion(World par1World) {
		super(par1World);
		this.setSize(1.2F, 0.9F);
		this.setHealth(60F);
		this.setAIMoveSpeed(2.8F);
		this.experienceValue = 80;
		this.scoreValue = 450;
		this.stepHeight = 2F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(
				0.600000001920930D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_SPIDER_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}
	
	@Override
	public boolean isShadowBeing() {
		return true;
	}
	
}