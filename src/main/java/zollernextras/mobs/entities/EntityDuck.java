package zollernextras.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zollernextras.items.ItemList;
import zollernextras.lib.Reference;

public class EntityDuck extends EntityAnimal {
	
	public float field_70886_e;
	public float destPos;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	
	public EntityDuck(World par1World) {
		super(par1World);
		this.setSize(0.3F, 0.7F);
		this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3,
				new EntityAITempt(this, 1.0D, Item.getItemById(295), false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	/** The time until the next egg is spawned. */
	public int timeUntilNextEgg;
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.45D);
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.field_70888_h = this.field_70886_e;
		this.field_70884_g = this.destPos;
		this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
		
		if (this.destPos < 0.0F) {
			this.destPos = 0.0F;
		}
		
		if (this.destPos > 1.0F) {
			this.destPos = 1.0F;
		}
		
		if (!this.onGround && this.field_70889_i < 1.0F) {
			this.field_70889_i = 1.0F;
		}
		
		this.field_70889_i = (float) (this.field_70889_i * 0.9D);
		
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}
		
		this.field_70886_e += this.field_70889_i * 2.0F;
		
		if (!this.isChild() && !this.worldObj.isRemote
				&& --this.timeUntilNextEgg <= 0) {
			this.playSound(
					"mob.chicken.plop",
					0.5F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.dropItem(ItemList.duckEgg, 1);
			this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		}
	}
	
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float par1) {
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound() {
		return Reference.MODID + ":duck.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return Reference.MODID + ":duck.hurt";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return Reference.MODID + ":duck.die";
	}
	
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.chicken.step", 0.15F, 1.0F);
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected Item getDropItem() {
		return ItemList.duckFeather;
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		
		for (int k = 0; k < j; ++k) {
			this.dropItem(ItemList.duckFeather, 1);
		}
		
		if (this.isBurning()) {
			this.dropItem(ItemList.cookedDuck, 1);
		} else {
			this.dropItem(ItemList.rawDuck, 1);
		}
	}
	
	public EntityDuck spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		return new EntityDuck(this.worldObj);
	}
	
	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	@Override
	public boolean isBreedingItem(ItemStack par1ItemStack) {
		return par1ItemStack != null
				&& par1ItemStack.getItem() instanceof ItemSeeds;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.spawnBabyAnimal(par1EntityAgeable);
	}
}