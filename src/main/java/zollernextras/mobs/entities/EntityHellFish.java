package zollernextras.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityHellFish extends EntityMob {
	
	public EntityHellFish(World par1World) {
		super(par1World);
		setSize(0.4F, 0.3F);
		stepHeight = 0.5F;
		isImmuneToFire = true;
	}
	
	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, 1.2D, false));
		tasks.addTask(2, new EntityAIWander(this, 1.4D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class,
				8.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(0, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(
				8.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
				.setBaseValue(0.25D);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(
				1.5D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_SILVERFISH_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SILVERFISH_DEATH;
	}
	
	// @Override
	// public void onUpdate() {
	// renderYawOffset = rotationYaw;
	// super.onUpdate();
	// }
	
	// @Override
	// public void setRenderYawOffset(float offset) {
	// rotationYaw = offset;
	// super.setRenderYawOffset(offset);
	// }
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15F, 1.0F);
	}
}