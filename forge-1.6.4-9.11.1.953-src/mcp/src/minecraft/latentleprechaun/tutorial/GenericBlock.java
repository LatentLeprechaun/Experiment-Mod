package latentleprechaun.experimentmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block {

	public GenericBlock(int id, Material material) {
		super(id, material);
		setTextureName(BasicInfo.ID.toLowerCase() + ":glowDirt");
	}

}
