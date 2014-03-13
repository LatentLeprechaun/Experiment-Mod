package latentleprechaun.experimentmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericOre extends Block {

	public GenericOre(int id, Material material, String unlocName) {
		super(id, material);
		
		setHardness(4.0F);
		setCreativeTab(CreativeTabs.tabBlock);
		setResistance(4.3F);
		setUnlocalizedName(unlocName);
		setStepSound(Block.soundStoneFootstep);
		setTextureName(BasicInfo.ID.toLowerCase() + ":glowOre");
		
	}

	public int idDropped(int metadata, Random random, int fortune){
		return Basic.glowIngot.itemID;
	}
	
}
