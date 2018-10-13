package zollernextras.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.ZollernExtrasMod;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;

public class ZollernPotions extends Potion {
	
	/**
	 * Protects the Player from Shadow damage. Also applied to an entity when
	 * whacked with a weapon enchanted with the custom Enlightened enchantment,
	 * which will damage shadow (IShadeEntity) mobs.
	 */
	public static Potion radiance;
	
	/**
	 * Causes viral harm to the Player, and spreads to any other Players around
	 * them.
	 */
	public static Potion infected;
	
	/**
	 * Protects the Player from Corruption damage.
	 */
	public static Potion antiCorruption;
	
	// Radiance variables.
	public static final int radianceTime = 6000;
	public static final float shadowDamage = 5.0f;
	
	// Infection variables.
	public static final int infectionTime = 200;
	public static final float infectionDamage = 2.0F;
	
	// Anti-Corruption variables.
	public static final int antiCorruptionTime = 6000;
	
	public static int totalEntries = 0;
	
	// The color of our Potion's liquid. Included here for convenience.
	protected int potionColor = 0xffffff;
	
	/**
	 * Instantiate a new Potion type for this mod.
	 * 
	 * @param potionName
	 *            The name of the Potion.
	 * @param potionIsBadEffect
	 *            Whether or not the Potion is a bad (harmful) effect.
	 * @param potionEffectiveness
	 *            The effectiveness of the Potion.
	 * @param potionLiquidColor
	 *            The color of the Potion's liquid.
	 */
	public ZollernPotions(String potionName, boolean potionIsBadEffect,
			int potionEffectiveness, int potionLiquidColor) {
		super(potionIsBadEffect, potionLiquidColor);
		
		// Add our mod's ID on to the actual Potion name, to prevent any future
		// compatibility issues.
		this.setPotionName(ZollernModInfo.modId + "_" + potionName);
		
		// Apply the specified liquid color.
		this.setLiquidColor(potionLiquidColor);
		
		// This part is probably pointless, considering we tell it not to use an
		// icon at all. But let's play it safe.
		this.setIconIndex(0, 0);
		
		// Increment the total number of potions.
		this.totalEntries++;
	}
	
	// Make sure you call this init BEFORE your items or it will crash when you
	// use a custom potion!
	public static void init() {
		ZollernHelper.logInfo("Initializing new Potion effects..");
		
		// Now let's actually initialize them.
		radiance = new ZollernPotions("radiance", false, 13458603, 0xeeee00);
		infected = new ZollernPotions("infected", true, 13615421, 0x000000);
		
		ZollernHelper.logInfo("Successfully loaded " + totalEntries
				+ " new Potion effects.");
	}
	
	/**
	 * This is where we actually program the 'effect' for the Potion. Note: We
	 * must call this manually! I do it through the LivingUpdate event in the
	 * Minecraft Forge event bus. Note that I call this through the proxy, just
	 * to be on the safe side.
	 */
	@Override
	public void performEffect(EntityLivingBase par1LivingBase, int par2Amplifier) {
		if (par1LivingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par1LivingBase;
			
			// Sending it through the proxy eliminates any client-on-server
			// issues we may have.
			ZollernExtrasMod.proxy.doPotionEffect(player, this);
		}
	}
	
	/**
	 * Returns the color of the potion's liquid.
	 */
	@Override
	public int getLiquidColor() {
		return this.potionColor;
	}
	
	/**
	 * Sets the liquid color for the Potion.
	 * 
	 * @param par1PotionColor
	 */
	public Potion setLiquidColor(int par1PotionColor) {
		this.potionColor = par1PotionColor;
		return this;
	}
	
	// This just gets rid of those status icons that our Potion could have.
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() {
		return false;
	}
}