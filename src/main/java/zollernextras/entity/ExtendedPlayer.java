package zollernextras.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import zollernextras.lib.M;
import zollernextras.network.PacketDispatcher;
import zollernextras.network.client.SyncPlayerPropsMessage;
import zollernextras.proxies.CommonProxy;

public class ExtendedPlayer implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	/**
	 * The Player.
	 */
	private final EntityPlayer player;
	
	/**
	 * The Player's max health.
	 */
	private static double maxHealth = 20F;
	
	/**
	 * The Player's max jump height.
	 */
	private static double maxJump = 0.0D;
	
	/**
	 * The Player's fall resistance.
	 */
	private static double fallResistance = 0.0D;
	
	/**
	 * The Player's max defense.
	 */
	private static double maxDefense = 0D;
	
	/**
	 * The Player's max damage dealt.
	 */
	private static double maxDamage = 0D;
	
	/**
	 * The Player's max fortune. Fortune determines how much of an ore is
	 * dropped when harvested.
	 */
	private static double maxFortune = 0D;
	
	/**
	 * The Player's max intelligence. Determines crafting proficiency - higher
	 * levels produce more output.
	 */
	private static double maxIntelligence = 0D;
	
	/**
	 * The Player's current XP.
	 */
	private static double currentXP = 0.0D;
	
	/**
	 * How much XP the Player needs to reach the next stat level.
	 */
	private static double xpToNextLevel = 0.0D;
	
	/**
	 * The Player's current stat level.
	 */
	private static int currentLevel = 0;
	
	/**
	 * Set the max health for the Player.
	 * 
	 * @param health
	 */
	public void setMaxHealth(double health) {
		this.maxHealth = health;
	}
	
	/**
	 * Set the max jump height for the Player.
	 * 
	 * @param jump
	 */
	public void setMaxJump(double jump) {
		this.maxJump = jump;
	}
	
	/**
	 * Set the max defense for the Player.
	 * 
	 * @param defense
	 */
	public void setMaxDefense(double defense) {
		this.maxDefense = defense;
	}
	
	/**
	 * Set the max damage dealt for the Player.
	 * 
	 * @param damage
	 */
	public void setMaxDamage(double damage) {
		this.maxDamage = damage;
	}
	
	/**
	 * Set the max fortune for the Player. Fortune determines how much of an ore
	 * is dropped when harvested.
	 * 
	 * @param fortune
	 */
	public void setMaxFortune(double fortune) {
		this.maxFortune = fortune;
	}
	
	/**
	 * Set the max intelligence for the Player. This determines crafting
	 * proficiency - higher intelligence yields more product at a time.
	 * 
	 * @param intelligence
	 */
	public void setMaxIntelligence(double intelligence) {
		this.maxIntelligence = intelligence;
	}
	
	/**
	 * Set the Player's current level.
	 * 
	 * @param level
	 */
	public void setCurrentLevel(int level) {
		this.currentLevel = level;
	}
	
	/**
	 * Return the Player's current level.
	 * 
	 * @return currentLevel
	 */
	public int getCurrentLevel() {
		return this.currentLevel;
	}
	
	/**
	 * Returns the max health of the Player.
	 * 
	 * @return maxHealth
	 */
	public double getMaxHealth() {
		return this.maxHealth;
	}
	
	/**
	 * Returns the max jump of the Player.
	 * 
	 * @return maxJump
	 */
	public double getMaxJump() {
		return this.maxJump;
	}
	
	public double getMaxDefense() {
		return this.maxDefense;
	}
	
	/**
	 * Returns the max damage dealt of the Player.
	 * 
	 * @return maxDamage
	 */
	public double getMaxDamage() {
		return this.maxDamage;
	}
	
	/**
	 * Returns the max fortune of the Player.
	 * 
	 * @return maxFortune
	 */
	public double getMaxFortune() {
		return this.maxFortune;
	}
	
	public double getMaxIntelligence() {
		return this.maxIntelligence;
	}
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.setMaxHealth(maxHealth);
		this.setMaxJump(maxJump);
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
		this.maxDefense = properties.getDouble("maxDefense");
		this.maxDamage = properties.getDouble("maxDamage");
		this.maxFortune = properties.getDouble("maxFortune");
		this.maxIntelligence = properties.getDouble("maxIntelligence");
		this.currentLevel = properties.getInteger("currentLevel");
		M.Log("Loaded NBT data for " + EXT_PROP_NAME + ".");
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