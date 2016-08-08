package zollernextras.mobs.entities.boss;

import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zollernextras.ZollernExtrasMod;
import zollernextras.items.ZollernItems;
import zollernextras.lib.Treasures;
import zollernextras.lib.ZEChestGenHooks;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityScorpion;

public class EntityShadowAlien extends EntityMob implements IBossDisplayData {
	
	private int maxHealth = 1000;
	private int xp = 2000;
	private double attackDamage = 8.0D;
	
	public EntityShadowAlien(World world) {
		super(world);
		this.setSize(this.width * .5f, this.height * .5f);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityGolem.class,
				8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 2.0D, false));
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this,
				EntityIronGolem.class, 4.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 10, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityGolem.class, 10, true));
		this.experienceValue = this.xp;
		this.scoreValue = this.xp;
		this.stepHeight = 2F;
		this.setCanPickUpLoot(true);
		if (world != null && !world.isRemote) {
			this.addRandomArmor();
		}
	}
	
	@Override
	protected String getLivingSound() {
		return ZollernModInfo.MODID + ":shadowalien.say";
	}
	
	@Override
	protected String getHurtSound() {
		return ZollernModInfo.MODID + ":shadowalien.hurt";
	}
	
	@Override
	protected String getDeathSound() {
		return ZollernModInfo.MODID + ":shadowalien.die";
	}
	
	@Override
	public void fall(float par1) {
	}
	
	@Override
	public void onLivingUpdate() {
		Random rand = new Random();
		int randInt = rand.nextInt(800);
		if (randInt <= 10) {
			double health = this.getHealth();
			if (health < maxHealth && health > 0 && !this.isDead) {
				int randHealthInt = rand.nextInt(10) >= 5 ? 10 : 20;
				health += randHealthInt;
				this.setHealth((float) health);
			}
		}
		if (rand.nextInt(4632) <= 16 && this.getHealth() <= 500) {
			if (!this.worldObj.isRemote) {
				EntityScorpion scorpion = new EntityScorpion(this.worldObj);
				scorpion.setLocationAndAngles(this.posX, this.posY, this.posZ,
						0, 0);
				this.worldObj.spawnEntityInWorld(scorpion);
			}
		}
		if (this.getHealth() <= 250 && rand.nextInt(1000) <= 10) {
			double atkDmg = this.getEntityAttribute(
					SharedMonsterAttributes.attackDamage).getBaseValue();
			double maxAtkDmg = this.attackDamage * 2;
			if (atkDmg < maxAtkDmg) {
				this.attackDamage += 0.1D;
				this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
						.setBaseValue(this.attackDamage);
			}
		}
		super.onLivingUpdate();
	}
	
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		super.attackEntityAsMob(p_70652_1_);
		return true;
	}
	
	@Override
	protected Entity findPlayerToAttack() {
		double searchRadius = 40.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this,
				searchRadius);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(1000);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(this.attackDamage);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public void onDeath(DamageSource par1) {
		super.onDeath(par1);
		if (attackingPlayer != null) {
			ZollernExtrasMod.proxy.sendChatMessage(attackingPlayer,
					"The beast has fallen!!");
		}
		Treasures.spawnChest(worldObj, rand, (int) this.posX,
				(int) this.posY - 1, (int) this.posZ, false,
				ZEChestGenHooks.SHADOW_SHRINE);
	}
	
	@Override
	public void addRandomArmor() {
		super.addRandomArmor();
		Random rand = new Random();
		ItemStack witherSword = new ItemStack(ZollernItems.witherSword);
		if (ZollernHelper.getRNGChance(5, 10)) {
			witherSword.addEnchantment(Enchantment.power, 5);
		}
		if (ZollernHelper.getRNGChance(5, 15)) {
			witherSword.addEnchantment(Enchantment.unbreaking, 3);
		}
		if (ZollernHelper.getRNGChance(5, 20)) {
			witherSword.addEnchantment(Enchantment.looting, 3);
		}
		if (ZollernHelper.getRNGChance(5, 15)) {
			witherSword.addEnchantment(Enchantment.sharpness, 5);
		}
		this.setCurrentItemOrArmor(0, witherSword);
	}
	
	@Override
	public boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
	}
	
	@Override
	public int getTotalArmorValue() {
		return 20;
	}
	
	@Override
	protected void dropRareDrop(int par1) {
		this.entityDropItem(new ItemStack(ZollernItems.heartForce), 0.0f);
	}
	
	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		float health = this.maxHealth;
		if (health <= maxHealth / 2) {
			int randInt = new Random().nextInt(50);
			this.setHealth(this.maxHealth / 2 + randInt);
		}
	}
	
	@Override
	public IEntityLivingData onSpawnWithEgg(
			IEntityLivingData par1EntityLivingData) {
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
		this.addRandomArmor();
		return par1EntityLivingData;
	}
	
}