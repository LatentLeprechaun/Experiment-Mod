package latentleprechaun.experimentmod;

import net.minecraft.entity.Entity;

public class CCLN {
	
	public static void twizzle(Entity par1entity){
		for(int n=0; n<3; n++){
			par1entity.motionY = 0.2F + n;
			par1entity.motionX = 0.2F + n;
			par1entity.motionZ = 0.2F + n;
			par1entity.motionX = -0.4F - n;
			par1entity.motionZ = -0.4F - n;
			par1entity.motionX = 0.4F + n;
		}
	}

}
