package zollernextras.items.food;

import net.minecraft.item.ItemFood;
import zollernextras.lib.M;

public class CookedFood extends ItemFood {
	
	private static boolean isWolfFavoriteMeat = false;
	
	public CookedFood(String strTexture) {
		super(10, 10F, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public void setDefaults(String strTexture) {
		M.setTab(this);
		M.setNameAndTexture(this, strTexture);
		setMaxStackSize(64);
	}
	
	public CookedFood(String strTexture, int par1) {
		super(par1, 10F, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public CookedFood(String strTexture, float par1) {
		super(10, par1, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public CookedFood(String strTexture, int par1, float par2) {
		super(par1, par2, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public CookedFood(String strTexture, boolean wolfFavorite) {
		super(10, 10F, wolfFavorite);
		this.setFavoriteWolfMeat(wolfFavorite);
		this.setDefaults(strTexture);
	}
	
	public static void setFavoriteWolfMeat(boolean par1) {
		isWolfFavoriteMeat = par1;
	}
	
	public static boolean getFavoriteWolfMeat() {
		return isWolfFavoriteMeat;
	}
	
	@Override
	public boolean isWolfsFavoriteMeat() {
		return getFavoriteWolfMeat();
	}
}