package zollernextras.mobs.entities;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import zollernextras.items.ItemList;
import zollernextras.lib.DSource;

public class EntityShark extends EntityFish implements IMob, IAnimals {
	public EntityShark(World worldObj) {
		super(worldObj);
		this.setSize(this.width, this.height);
		this.tasks.addTask(6, new EntityAIAttackOnCollide(this, 6.0D, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 6, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this,
				EntityFish.class, 6, true));
		this.tasks.removeTask(ea);
		this.setHealth(60F);
		this.experienceValue = 140;
		this.scoreValue = 300;
	}
	
	@Override
	public Item getDropItem() {
		return ItemList.sharkLeather;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3 + par2) + 1;
		int l = (int) (Math.random() * Math.floor(4));
		Item droppedItem = l > 2 ? ItemList.sharkTooth : ItemList.sharkLeather;
		for (int k = 0; k < j; ++k) {
			this.entityDropItem(new ItemStack(droppedItem, 1, 0), 0.0F);
		}
	}
	
	protected boolean isValidLightLevel() {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		
		if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand
				.nextInt(32)) {
			return false;
		} else {
			int l = this.worldObj.getBlockLightValue(i, j, k);
			
			if (this.worldObj.isThundering()) {
				int i1 = this.worldObj.skylightSubtracted;
				this.worldObj.skylightSubtracted = 10;
				l = this.worldObj.getBlockLightValue(i, j, k);
				this.worldObj.skylightSubtracted = i1;
			}
			
			return l <= this.rand.nextInt(8);
		}
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.posY > 45.0D && this.posY < 63.0D
				&& this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL
				&& this.isValidLightLevel() && super.getCanSpawnHere();
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		player.attackEntityFrom(DSource.deathShark, 6.0F);
	}
}