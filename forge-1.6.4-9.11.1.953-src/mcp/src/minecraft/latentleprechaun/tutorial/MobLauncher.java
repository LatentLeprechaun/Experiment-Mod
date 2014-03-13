package latentleprechaun.experimentmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MobLauncher extends Item {

	public MobLauncher(int id) {
		super(id);
		setMaxStackSize(1);
		setUnlocalizedName("mobLauncher");
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName(BasicInfo.ID.toLowerCase() + ":mobLauncher");
	}
	@Override
	
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target) {
		if(!target.worldObj.isRemote){
			if(target instanceof EntityCreeper || target instanceof EntityZombie || target instanceof EntitySkeleton || target instanceof EntitySpider){
				
				if(!target.isAirBorne){
					CCLN.twizzle(target);
				}
					
			} else {
				player.addChatMessage("Nope!");
			}
		}
		
		return false;
	}
}
