package zollernextras.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import zollernextras.lib.MainHelper;
import zollernextras.network.PacketDispatcher;
import zollernextras.network.client.SyncPlayerPropsMessage;
import zollernextras.proxies.CommonProxy;

public class ExtendedPlayer implements IExtendedEntityProperties {
	
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	private final EntityPlayer player;
	
	private static double maxHealth = 20.0F;
	private static double maxJump = 0.0D;
	private static double fallResistance = 0.0D;
	private static double maxDefense = 0.0D;
	private static double maxDamage = 1.0D;
	private static double maxFortune = 0.0D;
	private static double maxIntelligence = 0.0D;
	private static double maxSmelting = 0.0D;
	private static double maxHarvest = 0;
	private static double currentXP = 0.0D;
	private static double xpToNextLevel = 0.0D;
	private static int currentLevel = 1;
	
	public void setMaxHealth(double health) {
		this.maxHealth = health;
	}
	
	public void setMaxJump(double jump) {
		this.maxJump = jump;
	}
	
	public void setMaxFallResistance(double r) {
		this.fallResistance = r;
	}
	
	public void setMaxDefense(double defense) {
		this.maxDefense = defense;
	}
	
	public void setMaxDamage(double damage) {
		this.maxDamage = damage;
	}
	
	public void setMaxFortune(double fortune) {
		this.maxFortune = fortune;
	}
	
	public void setMaxIntelligence(double intelligence) {
		this.maxIntelligence = intelligence;
	}
	
	public void setMaxSmelting(double smelting) {
		this.maxSmelting = smelting;
	}
	
	public void setCurrentLevel(int level) {
		this.currentLevel = level;
	}
	
	public int getCurrentLevel() {
		return this.currentLevel;
	}
	
	public double getMaxHealth() {
		return this.maxHealth;
	}
	
	public double getMaxJump() {
		return this.maxJump;
	}
	
	public double getMaxDefense() {
		return this.maxDefense;
	}
	
	public double getMaxDamage() {
		return this.maxDamage;
	}
	
	public double getMaxFortune() {
		return this.maxFortune;
	}
	
	public double getMaxIntelligence() {
		return this.maxIntelligence;
	}
	
	public double getFallResistance() {
		return this.fallResistance;
	}
	
	public double getMaxSmelting() {
		return this.maxSmelting;
	}
	
	public int getLevel() {
		return this.currentLevel;
	}
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.setMaxHealth(maxHealth);
		this.setMaxJump(maxJump);
		this.setMaxFallResistance(fallResistance);
		this.setMaxDefense(maxDefense);
		this.setMaxDamage(maxDamage);
		this.setMaxFortune(maxFortune);
		this.setMaxIntelligence(maxIntelligence);
		this.setCurrentLevel(currentLevel);
	}
	
	private static final String getSaveKey(EntityPlayer player) {
		return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
	}
	
	public void copy(ExtendedPlayer props) {
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setDouble("maxHealth", this.maxHealth);
		properties.setDouble("maxJump", this.maxJump);
		properties.setDouble("fallResistance", this.fallResistance);
		properties.setDouble("maxDefense", this.maxDefense);
		properties.setDouble("maxDamage", this.maxDamage);
		properties.setDouble("maxFortune", this.maxFortune);
		properties.setDouble("maxIntelligence", this.maxIntelligence);
		properties.setInteger("currentLevel", this.currentLevel);
		compound.setTag(EXT_PROP_NAME, properties);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);
		this.maxHealth = properties.getFloat("maxHealth");
		this.maxJump = properties.getDouble("maxJump");
		this.fallResistance = properties.getDouble("fallResistance");
		this.maxDefense = properties.getDouble("maxDefense");
		this.maxDamage = properties.getDouble("maxDamage");
		this.maxFortune = properties.getDouble("maxFortune");
		this.maxIntelligence = properties.getDouble("maxIntelligence");
		this.currentLevel = properties.getInteger("currentLevel");
		MainHelper.Log("Loaded NBT data for " + EXT_PROP_NAME + ".");
	}
	
	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();
		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static final void loadProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy
				.getEntityData(getSaveKey(player));
		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
		PacketDispatcher.sendTo(new SyncPlayerPropsMessage(player),
				(EntityPlayerMP) player);
	}
	
	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME,
				new ExtendedPlayer(player));
	}
	
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
}