package bitl.sandboxmod2;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingSandboxMod2 
{
	public static void loadRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemRubySword), new Object[]{
            " R ",
            " R ",
            " S ",
            'R', SandboxMod2.itemRuby, 'S', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemRubyPickaxe), new Object[]{
            "RRR",
            " S ",
            " S ",
            'R', SandboxMod2.itemRuby, 'S', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemRubyBow), new Object[]{
            " RS",
            "R S",
            " RS",
            'R', SandboxMod2.itemRuby, 'S', Items.string
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.blockRubyBlock), new Object[]{
            "RRR",
            "RRR",
            "RRR",
            'R', SandboxMod2.itemRuby
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.blockOldWoodenPlanks), new Object[]{
            "PPP",
            "PWP",
            "PPP",
            'W', Blocks.log, 'P', Blocks.planks
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.blockOldWoodenPlanks), new Object[]{
            "PPP",
            "PWP",
            "PPP",
            'W', Blocks.log2, 'P', Blocks.planks
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.blockCryingObsidian), new Object[]{
            "OOO",
            "OLO",
            "OOO",
            'O', Blocks.obsidian, 'L', Blocks.lapis_block
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemIronApple), new Object[]{
            "III",
            "IAI",
            "III",
            'I', Items.iron_ingot, 'A', Items.apple
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemDiamondApple), new Object[]{
            "DDD",
            "DAD",
            "DDD",
            'D', Items.diamond, 'A', Items.apple
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemMedkit), new Object[]{
            " S ",
            "IWI",
            "III",
            'W', Items.wheat_seeds, 'I', Items.iron_ingot, 'S', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemRapidFireBow), new Object[]{
            " WS",
            "WDS",
            " WS",
            'W', Items.stick, 'S', Items.string, 'D', Items.diamond
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemRapidFireBowRuby), new Object[]{
            " RS",
            "RDS",
            " RS",
            'R', SandboxMod2.itemRuby, 'S', Items.string, 'D', Items.diamond
        });
        
        GameRegistry.addRecipe(new ItemStack(SandboxMod2.itemGoldMedkit), new Object[]{
            " S ",
            "GWG",
            "GGG",
            'W', Items.wheat_seeds, 'G', Items.gold_ingot, 'S', Items.stick
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRuby, 9), new Object[]{
            new ItemStack(SandboxMod2.blockRubyBlock)
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRapidFireBow, 1), new Object[]{
            new ItemStack(Items.bow), new ItemStack(Items.diamond)
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRubyBow, 1), new Object[]{
            new ItemStack(Items.bow), new ItemStack(SandboxMod2.itemRuby)
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRapidFireBowRuby, 1), new Object[]{
            new ItemStack(SandboxMod2.itemRubyBow), new ItemStack(Items.diamond)
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRapidFireBowRuby, 1), new Object[]{
            new ItemStack(SandboxMod2.itemRapidFireBow), new ItemStack(SandboxMod2.itemRuby)
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRapidFireBowRuby, 1), new Object[]{
            new ItemStack(SandboxMod2.itemRapidFireBow), new ItemStack(SandboxMod2.itemRuby)
        });
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemGoldMedkit, 1), new Object[]{
            new ItemStack(SandboxMod2.itemMedkit), new ItemStack(Items.gold_ingot)
        });
        
        GameRegistry.addSmelting(SandboxMod2.blockRubyOre, new ItemStack(SandboxMod2.itemRuby), 0.1F);
        
    }
}
