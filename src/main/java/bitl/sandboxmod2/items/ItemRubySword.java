package bitl.sandboxmod2.items;


import java.util.List;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemRubySword extends Item 
{
	public ItemRubySword() 
	{
		this.maxStackSize = 5;
        this.setMaxDamage(651);
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
	}
	
	public float func_150931_i()
    {
        return 8;
    }
	
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        if (p_150893_2_ == Blocks.web)
        {
            return 15.0F;
        }
        else
        {
            Material var3 = p_150893_2_.getMaterial();
            return var3 != Material.plants && var3 != Material.vine && var3 != Material.coral && var3 != Material.leaves && var3 != Material.snow ? 1.0F : 1.5F;
        }
    }
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}
	
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
	{
		if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
		{
			p_150894_1_.damageItem(2, p_150894_7_);
		}

		return true;
	}

	public boolean isFull3D()
	{
		return true;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public boolean func_150897_b(Block p_150897_1_)
	{
		return p_150897_1_ == Blocks.web;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubySword1"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubySword2"));
        par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("attribute.RubySword3"));
        par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("attribute.RubyTools1"));
    }
}
