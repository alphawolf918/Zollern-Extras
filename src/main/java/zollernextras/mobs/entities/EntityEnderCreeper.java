package zollernextras.mobs.entities;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import zollernextras.items.ZollernItems;
import zollernextras.items.teleporter.MessageTeleportToDimension;
import zollernextras.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEnderCreeper extends EntityCreeper {
	/**
	 * Time when this creeper was last in an active state (Messed up code here,
	 * probably causes creeper animation to go weird)
	 */
	private int lastActiveTime;
	
	/**
	 * The amount of time since the creeper was close enough to the player to
	 * ignite
	 */
	private int timeSinceIgnited;
	private final int fuseTime = 25;
	
	/** Explosion radius for this creeper. */
	private final int explosionRadius = 8;
	
	public EntityEnderCreeper(World par1World) {
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAICreeperSwell(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class,
				6.0F, 1.0D, 1.2D));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 4.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		.setBaseValue(0.294D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
		.setBaseValue(10.0D);
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	/**
	 * The number of iterations PathFinder.getSafePoint will execute before
	 * giving up.
	 */
	@Override
	public int getMaxSafePointTries() {
		return this.getAttackTarget() == null ? 3
				: 3 + (int) (this.getHealth() - 1.0F);
	}
	
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float par1) {
		
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		if (this.isEntityAlive()) {
			this.lastActiveTime = this.timeSinceIgnited;
			int i = this.getCreeperState();
			if (i > 0 && this.timeSinceIgnited == 0) {
				this.playSound("random.fuse", 1.0F, 0.5F);
			}
			this.timeSinceIgnited += i;
			if (this.timeSinceIgnited < 0) {
				this.timeSinceIgnited = 0;
			}
			if (this.timeSinceIgnited >= this.fuseTime) {
				this.timeSinceIgnited = this.fuseTime;
				if (!this.worldObj.isRemote) {
					this.worldObj.spawnParticle("portal", this.posX, this.posY,
							this.posZ, 4D, 4D, 4D);
					this.worldObj.playSoundEffect(this.posX, this.posY,
							this.posZ, "mob.endermen.portal", 2.0F,
							this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
					List players = worldObj.getEntitiesWithinAABB(
							EntityLivingBase.class, this.boundingBox.expand(
									3 + Math.floor(this.ticksExisted / 50), 2,
									3 + Math.floor(this.ticksExisted / 50)));
					Object[] playerArray = players.toArray();
					for (Object o : playerArray) {
						EntityLivingBase e = (EntityLivingBase) o;
						if (!(e instanceof EntityDragon)) {
							int entityId = e.getEntityId();
							if (!this.worldObj.isRemote) {
								PacketDispatcher.getSimpleNetworkWrapper()
								.sendToServer(
										new MessageTeleportToDimension(
												e.dimension == 0 ? 1
																: 0, entityId));
							}
						}
					}
					this.setDead();
				}
			}
		}
		super.onUpdate();
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return "mob.creeper.say";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return "mob.endermen.death";
	}
	
	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Params: (Float)Render tick. Returns the intensity of the creeper's flash when it is ignited.
	 */
	public float getCreeperFlashIntensity(float par1) {
		return (this.lastActiveTime + (this.timeSinceIgnited - this.lastActiveTime)
				* par1)
				/ (this.fuseTime - 2);
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected Item getDropItem() {
		return ZollernItems.enderShard;
	}
}