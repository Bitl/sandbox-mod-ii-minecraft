package bitl.sandboxmod2.items;

import java.util.List;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemGoldMedkit extends Item 
{
	public float healthAmount;
	
	public ItemGoldMedkit() 
	{
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
		this.healthAmount = 5.0F;
	}
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if (!par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.getHealth() < par3EntityPlayer.getMaxHealth())
    	{
    		par3EntityPlayer.setHealth(par3EntityPlayer.getHealth() + this.healthAmount);
    		--par1ItemStack.stackSize;
    	}
        
        return par1ItemStack;
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.GoldMedkit1"));
    }
}
