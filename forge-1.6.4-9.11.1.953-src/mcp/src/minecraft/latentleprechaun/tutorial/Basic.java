package latentleprechaun.experimentmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=BasicInfo.ID, name=BasicInfo.NAME, version=BasicInfo.VERSION)
@NetworkMod(clientSideRequired=true)
public class Basic {
	
		//generation declarations
		EventManager oreManager = new EventManager();
		//generation declarations end
	
	
		//block declarations
		public final static Block glowDirt = new GenericBlock(500, Material.ground).setHardness(0.2F).setResistance(0.3F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("glowDirt").setCreativeTab(CreativeTabs.tabBlock).setLightValue(0.5F);
		public final static Block glowOre = new GenericOre(501, Material.rock, "glowOre");
		//end of block declarations
	
		//item declarations
		public static Item glowIngot = new GenericIngot(2500);
		public static Item glowSword = new ItemSword(2501,EnumToolMaterial.EMERALD).setUnlocalizedName("glowSword").setCreativeTab(CreativeTabs.tabCombat).setTextureName(BasicInfo.ID.toLowerCase() + ":glowSword");
		public static Item mobLauncher = new MobLauncher(2502);
		//end of item declarations
	
        // The instance of my mod that Forge uses.
        @Instance(value = BasicInfo.ID)
        public static Basic instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide=BasicInfo.CLIENTPROX + "ClientProxy", serverSide=BasicInfo.COMMONPROX + "CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
        		proxy.registerRenderers();
        		
        		
        		//itemstacks and such
        		ItemStack glowDustStack = new ItemStack(Item.glowstone, 4);
        		ItemStack glowDirtStack = new ItemStack(Basic.glowDirt);
        		ItemStack stickStack = new ItemStack(Item.stick);
        		ItemStack glowIngotStack = new ItemStack(Basic.glowIngot);
        		ItemStack glowSwordStack = new ItemStack(Basic.glowSword);
        		ItemStack reddustStack = new ItemStack(Item.redstone);
        		ItemStack mobLauncherStack = new ItemStack(Basic.mobLauncher);
        		
        		//recipes
        		GameRegistry.addRecipe(glowSwordStack, " y ", " y ", " x ", 'y', glowIngotStack, 'x', stickStack);
        		GameRegistry.addRecipe(mobLauncherStack, "  i", " i ", "r  ", 'i', reddustStack, 'r', glowIngotStack);
        		
			
			
			//block registry
        		
        		//Glow Dirt registry
        		GameRegistry.registerBlock(glowDirt, "glowDirt");
        		LanguageRegistry.addName(glowDirt, "Glow Dirt");
        		MinecraftForge.setBlockHarvestLevel(glowDirt, "shovel", 1);
        		//End of Glow Dirt registry
			
        		//ore registry
        		GameRegistry.registerBlock(glowOre, "glowOre");
        		LanguageRegistry.addName(glowOre, "Glow Ore");
        		MinecraftForge.setBlockHarvestLevel(glowOre, "pickaxe", 3);
        			//ore ingot registry
        			GameRegistry.registerItem(glowIngot, "glowIngot");
        			LanguageRegistry.addName(glowIngot, "Glow Ingot");
        			//ore ingot registry end
        		//ore registry end
        			
        		//moblauncher
        			GameRegistry.registerItem(mobLauncher, "mobLauncher");
        			LanguageRegistry.addName(mobLauncher, "Mob Launcher");
        		//moblauncher registry end
        			
        		//glow sword
        			GameRegistry.registerItem(glowSword, "glowSword");
        			LanguageRegistry.addName(glowSword, "Glow Sword");
        		//glow sword registry end
        			
        			
        			
        		//generation registry
        			GameRegistry.registerWorldGenerator(oreManager);
        		//generation registry end
        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}