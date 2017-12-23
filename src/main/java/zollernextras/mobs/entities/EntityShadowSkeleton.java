package zollernextras.mobs.entities;

import java.util.Random;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollernextras.items.ZollernItems;

public class EntityShadowSkeleton extends AbstractSkeleton implements
		IShadeEntity {
	
	public EntityShadowSkeleton(World worldIn) {
		super(worldIn);
		this.setHealth(35.0F);
		this.setAIMoveSpeed(2.8F);
		this.setCanPickUpLoot(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, true));
	}
	
	@Override
	public void setFire(int par1) {
		// nothing
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int j;
		int k;
		
		j = this.rand.nextInt(3 + par2);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(Items.ARROW, 1);
		}
		
		j = this.rand.nextInt(3 + par2);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(ZollernItems.shadowBone, 1);
		}
	}
	
	@Override
	public void dropLoot(boolean wasRecentlyHit, int lootModifier,
			DamageSource dmgSrc) {
		Random rand = new Random();
		if (rand.nextInt(100) <= 5) {
			this.dropItem(ZollernItems.shadowEssence, 1);
		}
	}
	
	@Override
	public float getEyeHeight() {
		return 1.6F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SKELETON_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_SKELETON_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SKELETON_DEATH;
	}
	
	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_SKELETON_STEP;
	}
	
	@Override
	protected EntityArrow getArrow(float p_190726_1_) {
		ItemStack itemstack = this
				.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
		
		if (itemstack.getItem() == Items.SPECTRAL_ARROW) {
			EntitySpectralArrow entityspectralarrow = new EntitySpectralArrow(
					this.world, this);
			entityspectralarrow.setEnchantmentEffectsFromEntity(this,
					p_190726_1_);
			return entityspectralarrow;
		} else {
			EntityArrow entityarrow = super.getArrow(p_190726_1_);
			
			if (itemstack.getItem() == Items.TIPPED_ARROW
					&& entityarrow instanceof EntityTippedArrow) {
				((EntityTippedArrow) entityarrow).setPotionEffect(itemstack);
			}
			
			return entityarrow;
		}
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.world.isDaytime() && !this.world.isRemote) {
			float f = this.getBrightness(1.0F);
			BlockPos blockpos = this.getRidingEntity() instanceof EntityBoat ? (new BlockPos(
					this.posX, Math.round(this.posY), this.posZ)).up()
					: new BlockPos(this.posX, Math.round(this.posY), this.posZ);
			
			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F
					&& this.world.canSeeSky(blockpos)) {
				boolean flag = true;
				ItemStack itemstack = this
						.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
				
				if (!itemstack.isEmpty()) {
					if (itemstack.isItemStackDamageable()) {
						itemstack.setItemDamage(itemstack.getItemDamage()
								+ this.rand.nextInt(2));
						
						if (itemstack.getItemDamage() >= itemstack
								.getMaxDamage()) {
							this.renderBrokenItemStack(itemstack);
							this.setItemStackToSlot(EntityEquipmentSlot.HEAD,
									ItemStack.EMPTY);
						}
					}
					
					flag = false;
				}
				
				// if (flag) {
				// this.setFire(8);
				// }
			}
		}
		
		super.onLivingUpdate();
	}
}