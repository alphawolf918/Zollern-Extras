package zollernextras.mobs.entities;

import java.util.Calendar;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zollernextras.events.ZollernSoundEvents;
import zollernextras.items.ZollernItems;
import zollernextras.mobs.entities.ai.EntityAIMummyAttack;

public class EntityMummy extends EntityZombie implements IShadeEntity {
	
	public EntityMummy(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		
		if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD)
				&& entityLivingIn instanceof EntityVillager) {
			if (this.world.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) {
				return;
			}
			
			EntityVillager entity = (EntityVillager) entityLivingIn;
			EntityMummy entitymummy = new EntityMummy(this.world);
			entitymummy.copyLocationAndAnglesFrom(entity);
			this.world.removeEntity(entity);
			entitymummy.onInitialSpawn(
					this.world.getDifficultyForLocation(new BlockPos(entitymummy)),
					new EntityMummy.GroupData(false));
			entitymummy.setChild(entity.isChild());
			entitymummy.setNoAI(entity.isAIDisabled());
			
			if (entity.hasCustomName()) {
				entitymummy.setCustomNameTag(entity.getCustomNameTag());
				entitymummy.setAlwaysRenderNameTag(entity.getAlwaysRenderNameTag());
			}
			
			this.world.spawnEntity(entitymummy);
			this.world.playEvent((EntityPlayer) null, 1026, new BlockPos(this), 0);
		}
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZollernSoundEvents.ENTITY_MUMMY_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return ZollernSoundEvents.ENTITY_MUMMY_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZollernSoundEvents.ENTITY_MUMMY_DIE;
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
		if (this.rand.nextFloat() < (this.world.getDifficulty() == EnumDifficulty.HARD ? 0.05F
				: 0.01F)) {
			int i = this.rand.nextInt(3);
			
			if (i == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(
						Items.DIAMOND_SWORD));
			} else {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(
						ZollernItems.amaranthSword));
			}
		}
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
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMummyAttack(this, 1.4D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.4D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}
	
	@Override
	protected void applyEntityAI() {
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true,
				new Class[] { EntityPigZombie.class }));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class,
				true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class,
				false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this,
				EntityIronGolem.class, true));
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty,
			@Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		
		if (livingdata == null) {
			livingdata = new EntityMummy.GroupData(
					this.world.rand.nextFloat() < net.minecraftforge.common.ForgeModContainer.zombieBabyChance);
		}
		
		if (livingdata instanceof EntityMummy.GroupData) {
			EntityMummy.GroupData entityzombie$groupdata = (EntityMummy.GroupData) livingdata;
			
			if (entityzombie$groupdata.isChild) {
				this.setChild(true);
				
				if (this.world.rand.nextFloat() < 0.05D) {
					List<EntityDuck> list = this.world.<EntityDuck> getEntitiesWithinAABB(
							EntityDuck.class, this.getEntityBoundingBox().expand(5.0D, 3.0D, 5.0D),
							EntitySelectors.IS_STANDALONE);
					
					if (!list.isEmpty()) {
						EntityDuck entityduck = list.get(0);
						entityduck.setDuckJockey(true);
						this.startRiding(entityduck);
					}
				} else if (this.world.rand.nextFloat() < 0.05D) {
					EntityDuck entityduck1 = new EntityDuck(this.world);
					entityduck1.setLocationAndAngles(this.posX, this.posY, this.posZ,
							this.rotationYaw, 0.0F);
					entityduck1.onInitialSpawn(difficulty, (IEntityLivingData) null);
					entityduck1.setDuckJockey(true);
					this.world.spawnEntity(entityduck1);
					this.startRiding(entityduck1);
				}
			}
		}
		
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		
		if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()) {
			Calendar calendar = this.world.getCurrentDate();
			
			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F) {
				this.setItemStackToSlot(EntityEquipmentSlot.HEAD,
						new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN
								: Blocks.PUMPKIN));
				this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
			}
		}
		
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(
				new AttributeModifier("Random spawn bonus",
						this.rand.nextDouble() * 0.05000000074505806D, 0));
		double d0 = this.rand.nextDouble() * 1.5D * f;
		
		if (d0 > 1.0D) {
			this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(
					new AttributeModifier("Random zombie-spawn bonus", d0, 2));
		}
		
		if (this.rand.nextFloat() < f * 0.05F) {
			this.getEntityAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(
					new AttributeModifier("Leader zombie bonus",
							this.rand.nextDouble() * 0.25D + 0.5D, 0));
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(
					new AttributeModifier("Leader zombie bonus",
							this.rand.nextDouble() * 3.0D + 1.0D, 2));
			this.setBreakDoorsAItask(true);
		}
		
		return livingdata;
	}
	
	class GroupData implements IEntityLivingData {
		public boolean isChild;
		
		private GroupData(boolean p_i47328_2_) {
			this.isChild = p_i47328_2_;
		}
	}
}