package zollernextras.mobs.entities;

import java.util.List;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHogZombie extends EntityPigZombie {
	private static final UUID field_110189_bq = UUID
			.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = (new AttributeModifier(
			field_110189_bq, "Attacking speed boost", 0.45D, 0))
			.setSaved(false);
	
	/** Above zero if this PigZombie is Angry. */
	private int angerLevel;
	
	/** A random delay until this PigZombie next makes a sound. */
	private int randomSoundDelay;
	private Entity field_110191_bu;
	
	public EntityHogZombie(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(field_110186_bp).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(1.8D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(1.5D);
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	protected boolean isAIEnabled() {
		return false;
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		if (this.field_110191_bu != this.entityToAttack
				&& !this.worldObj.isRemote) {
			IAttributeInstance attributeinstance = this
					.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			attributeinstance.removeModifier(field_110190_br);
			
			if (this.entityToAttack != null) {
				attributeinstance.applyModifier(field_110190_br);
			}
		}
		
		this.field_110191_bu = this.entityToAttack;
		
		if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
			this.playSound(
					"mob.zombiepig.zpigangry",
					this.getSoundVolume() * 4.0F,
					((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}
		
		super.onUpdate();
	}
	
	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	@Override
	public boolean getCanSpawnHere() {
		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL
				&& this.worldObj.checkNoEntityCollision(this.boundingBox)
				&& this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
				&& !this.worldObj.isAnyLiquid(this.boundingBox);
	}
	
	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Anger", (short) this.angerLevel);
	}
	
	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	@Override
	protected Entity findPlayerToAttack() {
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = par1DamageSource.getEntity();
			
			if (entity instanceof EntityPlayer) {
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
						this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
				
				for (int i = 0; i < list.size(); ++i) {
					Entity entity1 = (Entity) list.get(i);
					
					if (entity1 instanceof EntityHogZombie) {
						EntityHogZombie entitypigzombie = (EntityHogZombie) entity1;
						entitypigzombie.becomeAngryAt(entity);
					}
				}
				
				this.becomeAngryAt(entity);
			}
			
			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}
	
	/**
	 * Causes this PigZombie to become angry at the supplied Entity (which will
	 * be a player).
	 */
	private void becomeAngryAt(Entity par1Entity) {
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(2 + par2);
		int k;
		
		for (k = 0; k < j; ++k) {
			this.dropItem(Items.rotten_flesh, 1);
		}
		
		j = this.rand.nextInt(2 + par2);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(Items.gold_nugget, 1);
		}
	}
	
	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer) {
		return false;
	}
	
	@Override
	protected void dropRareDrop(int par1) {
		this.dropItem(Items.iron_ingot, 1);
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected Item getDropItem() {
		return Items.rotten_flesh;
	}
	
	/**
	 * Makes entity wear random armor based on difficulty
	 */
	@Override
	protected void addRandomArmor() {
		this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
	}
	
	@Override
	public IEntityLivingData onSpawnWithEgg(
			IEntityLivingData par1EntityLivingData) {
		super.onSpawnWithEgg(par1EntityLivingData);
		this.setVillager(false);
		return par1EntityLivingData;
	}
}
