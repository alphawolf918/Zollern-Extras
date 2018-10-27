package zollernextras.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import zollernextras.events.ZollernSoundEvents;

public class EntityShade extends EntityZombie implements IShadeEntity {
	
	public EntityShade(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.31D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
	}
	
	@Override
	public int getTotalArmorValue() {
		int i = super.getTotalArmorValue() + 2;
		
		if (i > 20) {
			i = 20;
		}
		
		return i;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZollernSoundEvents.ENTITY_SHADE_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return ZollernSoundEvents.ENTITY_SHADE_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZollernSoundEvents.ENTITY_SHADE_DIE;
	}
	
	@Override
	public void setFire(int par1) {
		// nothing
	}
	
	@Override
	public boolean isShadowBeing() {
		return true;
	}
	
}