package zollernextras.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import zollernextras.items.storage.ItemQuiver;

public class InventoryQuiver implements IInventory {
	private String name = "Quiver";
	
	/** Defining your inventory size this way is handy */
	public static final int INV_SIZE = 2;
	public static final String tagName = "QuiverInventory";
	
	/**
	 * Inventory's size must be same as number of slots you add to the Container
	 * class
	 */
	private ItemStack[] inventory = new ItemStack[INV_SIZE];
	
	/** Provides NBT Tag Compound to reference */
	private final ItemStack invStack;
	
	public InventoryQuiver(ItemStack stack) {
		this.invStack = stack;
		if (!invStack.hasTagCompound()) {
			invStack.setTagCompound(new NBTTagCompound());
		}
		readFromNBT(invStack.getTagCompound());
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				markDirty();
			} else {
				setInventorySlotContents(slot, null);
			}
		}
		
		return stack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}
	
	@Override
	public String getInventoryName() {
		return name;
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return name.length() > 0;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public void markDirty() {
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
				inventory[i] = null;
		}
		writeToNBT(invStack.getTagCompound());
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// this will close the inventory if the player tries to move
		// the item that opened it, but you need to return this method
		// from the Container's canInteractWith method
		// an alternative would be to override the slotClick method and
		// prevent the current item slot from being clicked
		return player.getHeldItem() == invStack;
	}
	
	@Override
	public void openInventory() {
	}
	
	@Override
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return !(stack.getItem() instanceof ItemQuiver)
				&& stack.getItem() == Items.arrow;
	}
	
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList items = compound.getTagList(tagName,
				Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory()) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag(tagName, items);
	}
}