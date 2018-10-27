package zollernextras.mobs.entities;

public interface IShadeEntity {
	
	public default boolean isShadowBeing() {
		return true;
	};
	
	public default boolean shouldAttackLightEntity() {
		return true;
	}
	
}