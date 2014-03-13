package latentleprechaun.experimentmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericIngot extends Item {

	public GenericIngot(int par1) {
		super(par1);
		setUnlocalizedName("glowIngot");
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setTextureName(BasicInfo.ID.toLowerCase() + ":glowIngot");
	}

}
