package bitl.sandboxmod2;

import java.util.Random;

import bitl.sandboxmod2.blocks.BlockCryingObsidian;
import bitl.sandboxmod2.blocks.BlockOldWoodenPlanks;
import bitl.sandboxmod2.blocks.BlockRubyBlock;
import bitl.sandboxmod2.entity.EntityHuman;
import bitl.sandboxmod2.entity.EntityHumanArcher;
import bitl.sandboxmod2.entity.EntityHumanArcherEvil;
import bitl.sandboxmod2.entity.EntityHumanBase;
import bitl.sandboxmod2.entity.EntityHumanBaseEvil;
import bitl.sandboxmod2.entity.EntityHumanKnight;
import bitl.sandboxmod2.entity.EntityHumanKnightEvil;
import bitl.sandboxmod2.items.ItemDiamondApple;
import bitl.sandboxmod2.items.ItemEnderCrystal;
import bitl.sandboxmod2.items.ItemIronApple;
import bitl.sandboxmod2.items.ItemMedkit;
import bitl.sandboxmod2.items.ItemPrimedTNT;
import bitl.sandboxmod2.items.ItemRuby;
import bitl.sandboxmod2.items.ItemRubyBow;
import bitl.sandboxmod2.items.ItemRubyPickaxe;
import bitl.sandboxmod2.items.ItemRubySword;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SandboxMod2.MODID, version = SandboxMod2.VERSION)
public class SandboxMod2 
{
	public static final String MODID = "SandboxMod2";
	@Instance(MODID)
	public static SandboxMod2 instance;
    public static final String VERSION = "1.2.0";
    
    @SidedProxy(clientSide = "bitl.sandboxmod2.SandboxMod2ClientProxy", serverSide = "bitl.sandboxmod2.SandboxMod2CommonProxy")
	public static SandboxMod2CommonProxy proxy;
    
    //Items
    public static Item itemRuby;
    public static Item itemRubySword;
    public static Item itemRubyPickaxe;
    public static Item itemRubyBow;
    public static Item itemIronApple;
    public static Item itemDiamondApple;
    public static Item itemEnderCrystal;
    public static Item itemPrimedTNT;
    public static Item itemMedkit;
    //Blocks
    public static Block blockRubyBlock;
    public static Block blockRubyOre;
    public static Block blockOldWoodenPlanks;
    public static Block blockCryingObsidian;
    
    WorldGenSandboxMod2 worldgen = new WorldGenSandboxMod2();
    
    public static CreativeTabs tabSandboxMod2 = new CreativeTabs("SandboxMod2")
    {
    	public Item getTabIconItem()
    	{
    		return itemRubySword;
    	}
    
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	System.out.println("Pre-initializing 'Sandbox Mod 2' version "+SandboxMod2.VERSION);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing 'Sandbox Mod 2' version "+SandboxMod2.VERSION);
        itemRuby = new ItemRuby().setUnlocalizedName("itemRuby").setTextureName(SandboxMod2.MODID + ":" + "itemRuby");
    	GameRegistry.registerItem(itemRuby, itemRuby.getUnlocalizedName().substring(5));
    	itemRubySword = new ItemRubySword().setUnlocalizedName("itemRubySword").setTextureName(SandboxMod2.MODID + ":" + "itemRubySword");
    	GameRegistry.registerItem(itemRubySword, itemRubySword.getUnlocalizedName().substring(5));
    	itemRubyPickaxe = new ItemRubyPickaxe().setUnlocalizedName("itemRubyPickaxe").setTextureName(SandboxMod2.MODID + ":" + "itemRubyPickaxe");
    	GameRegistry.registerItem(itemRubyPickaxe, itemRubyPickaxe.getUnlocalizedName().substring(5));
    	itemRubyBow = new ItemRubyBow().setUnlocalizedName("itemRubyBow").setTextureName(SandboxMod2.MODID + ":" + "itemRubyBow");
    	GameRegistry.registerItem(itemRubyBow, itemRubyBow.getUnlocalizedName().substring(5));
    	itemIronApple = new ItemIronApple(4, 1.2F, false).setUnlocalizedName("itemIronApple").setTextureName(SandboxMod2.MODID + ":" + "itemIronApple");
    	GameRegistry.registerItem(itemIronApple, itemIronApple.getUnlocalizedName().substring(5));
    	itemDiamondApple = new ItemDiamondApple(4, 1.2F, false).setUnlocalizedName("itemDiamondApple").setTextureName(SandboxMod2.MODID + ":" + "itemDiamondApple");
    	GameRegistry.registerItem(itemDiamondApple, itemDiamondApple.getUnlocalizedName().substring(5));
    	itemEnderCrystal = new ItemEnderCrystal().setUnlocalizedName("itemEnderCrystal").setTextureName(SandboxMod2.MODID + ":" + "itemEnderCrystal");
    	GameRegistry.registerItem(itemEnderCrystal, itemEnderCrystal.getUnlocalizedName().substring(5));
    	itemPrimedTNT = new ItemPrimedTNT().setUnlocalizedName("itemPrimedTNT").setTextureName(SandboxMod2.MODID + ":" + "itemPrimedTNT");
    	GameRegistry.registerItem(itemPrimedTNT, itemPrimedTNT.getUnlocalizedName().substring(5));
    	itemMedkit = new ItemMedkit().setUnlocalizedName("itemMedkit").setTextureName(SandboxMod2.MODID + ":" + "itemMedkit");
    	GameRegistry.registerItem(itemMedkit, itemMedkit.getUnlocalizedName().substring(5));
    	blockRubyBlock = new BlockRubyBlock().setBlockName("blockRubyBlock").setBlockTextureName(SandboxMod2.MODID + ":" + "blockRubyBlock").setHardness(5.0F).setResistance(10.0F);
    	GameRegistry.registerBlock(blockRubyBlock, blockRubyBlock.getUnlocalizedName().substring(5));
    	blockRubyOre = new BlockRubyBlock().setBlockName("blockRubyOre").setBlockTextureName(SandboxMod2.MODID + ":" + "blockRubyOre").setHardness(3.0F).setResistance(5.0F);
    	GameRegistry.registerBlock(blockRubyOre, blockRubyOre.getUnlocalizedName().substring(5));
    	blockOldWoodenPlanks = new BlockOldWoodenPlanks().setBlockName("blockOldWoodenPlanks").setBlockTextureName(SandboxMod2.MODID + ":" + "blockOldWoodenPlanks").setHardness(2.0F).setResistance(5.0F);
    	GameRegistry.registerBlock(blockOldWoodenPlanks, blockOldWoodenPlanks.getUnlocalizedName().substring(5));
    	blockCryingObsidian = new BlockCryingObsidian().setBlockName("blockCryingObsidian").setBlockTextureName(SandboxMod2.MODID + ":" + "blockCryingObsidian").setHardness(2.0F).setResistance(5.0F);
    	GameRegistry.registerBlock(blockCryingObsidian, blockCryingObsidian.getUnlocalizedName().substring(5));
    	CraftingSandboxMod2.loadRecipes();
    	GameRegistry.registerWorldGenerator(worldgen, 0);
    	registerEntityEgg(53, 30837, 2332416);
    	registerEntityEgg(63, 0, 4734347);
    	registerEntityEgg(64, 7237230, 4734347);
    	registerEntityEgg(97, 14144467, 5653556);
    	registerEntityEgg(99, 4802889, 14144467);
    	registerEntity(EntityHuman.class, "entityHuman", 44975, 12422002);
    	registerEntity(EntityHumanArcher.class, "entityHumanArcher", 44975, 5651507);
    	registerEntity(EntityHumanKnight.class, "entityHumanKnight", 44975, 10592673);
    	registerEntity(EntityHumanArcherEvil.class, "entityHumanArcherEvil", 2243405, 5651507);
    	registerEntity(EntityHumanKnightEvil.class, "entityHumanKnightEvil", 2243405, 10592673);
    	//This guy doesn't exist....YET! - Bitl
    	//registerEntity(EntityHerobrine.class, "entityHerobrine", 44975, 14144467);
    	registerEntityNoEgg(EntityHumanBase.class, "entityHumanBase");
    	registerEntityNoEgg(EntityHumanBaseEvil.class, "entityHumanBaseEvil");
        MinecraftForge.EVENT_BUS.register(new SandboxMod2EventHandler());
        proxy.registerRenderInformation();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	System.out.println("Initialized 'Sandbox Mod 2' version "+SandboxMod2.VERSION);
    }
    
    public static void registerEntity(Class entityClass, String name, int primaryColor, int secondaryColor)
    {
    	int entityID = EntityRegistry.findGlobalUniqueEntityId();
    	EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
    	EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
    
    public static void registerEntityEgg(int entityID, int primaryColor, int secondaryColor)
    {
    	EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
    
    public static void registerEntityNoEgg(Class entityClass, String name)
    {
    	int entityID = EntityRegistry.findGlobalUniqueEntityId();
    	EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
    }
}
