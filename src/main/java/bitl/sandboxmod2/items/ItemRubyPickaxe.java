package bitl.sandboxmod2.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemRubyPickaxe extends Item 
{
	private final int harvestLevel;
	private final float harvestFloat;
	
	public ItemRubyPickaxe() 
	{
		this.maxStackSize = 5;
        this.setMaxDamage(651);
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
		//super(field_150915_c);
		this.harvestLevel = 3;
		this.harvestFloat = 6.0F;
	}
	
	private int getHarvestLevel() 
	{
		return harvestLevel;
	}

	public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.obsidian ? this.getHarvestLevel() == 3 : (p_150897_1_ == SandboxMod2.blockCryingObsidian ? (p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ? (p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ? (p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ? (p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ? (p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ? (p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ? (p_150897_1_.getMaterial() == Material.rock ? true : (p_150897_1_.getMaterial() == Material.iron ? true : p_150897_1_.getMaterial() == Material.anvil)) : this.getHarvestLevel() == 3) : this.getHarvestLevel() >= 2) : this.getHarvestLevel() >= 1) : this.getHarvestLevel() >= 1) : this.getHarvestLevel() >= 2) : this.getHarvestLevel() >= 2) : this.getHarvestLevel() >= 2);
    }
	
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
		Material var3 = p_150893_2_.getMaterial();
		return var3 != Material.rock && var3 != Material.iron && var3 != Material.anvil ? super.func_150893_a(p_150893_1_, p_150893_2_) : harvestFloat;
    }
	
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
	{
		if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
		{
			p_150894_1_.damageItem(2, p_150894_7_);
		}

		return true;
	}
	
	/**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getAttributeModifiers(ItemStack par1ItemStack)
    {
        Multimap var1 = super.getAttributeModifiers(par1ItemStack);
        var1.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)5.0D, 0));
        return var1;
    }
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyPickaxe1"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyPickaxe2"));
        par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("attribute.RubyPickaxe3"));
        par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("attribute.RubyTools1"));
    }
}
