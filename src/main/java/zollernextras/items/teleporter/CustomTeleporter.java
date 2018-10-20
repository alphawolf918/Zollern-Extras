package zollernextras.items.teleporter;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CustomTeleporter extends Teleporter {
	
	private final WorldServer worldServer;
	private double x;
	private double y;
	private double z;
	
	public CustomTeleporter(WorldServer worldServer, double x, double y, double z) {
		super(worldServer);
		this.worldServer = worldServer;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public boolean makePortal(Entity entity) {
		return false;
	}
	
	@Override
	public boolean placeInExistingPortal(Entity pEntity, float rotationYaw) {
		this.worldServerInstance.getBlockState(new BlockPos((int) this.x, (int) this.y,
				(int) this.z)); // dummy load to maybe gen chunk
		
		pEntity.setPosition(this.x, this.y, this.z);
		pEntity.motionX = 0.0f;
		pEntity.motionY = 0.0f;
		pEntity.motionZ = 0.0f;
		return false;
	}
	
	@Override
	public void placeInPortal(Entity pEntity, float rotationYaw) {
		this.worldServerInstance.getBlockState(new BlockPos((int) this.x, (int) this.y,
				(int) this.z)); // dummy load to maybe gen chunk
		
		pEntity.setPosition(this.x, this.y, this.z);
		pEntity.motionX = 0.0f;
		pEntity.motionY = 0.0f;
		pEntity.motionZ = 0.0f;
	}
	
}