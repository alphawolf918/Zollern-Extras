package zollernextras.mobs.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import zollernextras.lib.ZollernModInfo;

public class EntityHellDuck extends EntityDuck implements IMob {
	
	public EntityHellDuck(World par1World) {
		super(par1World);
		this.setSize(0.3F * 2.0F, 0.7F * 2.0F);
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, 4.0D, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 6, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this,
				EntityIronGolem.class, 6, true));
		this.isImmuneToFire = true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		.setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
		.setBaseValue(45.0F);
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound() {
		return ZollernModInfo.MODID + ":hellduck.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return ZollernModInfo.MODID + ":hellduck.hurt";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return ZollernModInfo.MODID + ":hellduck.die";
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.isInWater()) {
			this.attackEntityFrom(DamageSource.drown, 5.0F);
		}
		super.onLivingUpdate();
	}
	
	@Override
	public boolean isInWater() {
		return this.worldObj.handleMaterialAcceleration(
				this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D),
				Material.water, this);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		player.attackEntityFrom(DamageSource.causeMobDamage(this), 4.0F);
	}
}