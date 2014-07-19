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
        
        GameRegistry.addShapelessRecipe(new ItemStack(SandboxMod2.itemRuby, 9), new Object[]{
            new ItemStack(SandboxMod2.blockRubyBlock)
        });
        
        GameRegistry.addSmelting(SandboxMod2.blockRubyOre, new ItemStack(SandboxMod2.itemRuby), 0.1F);
        
    }
}
