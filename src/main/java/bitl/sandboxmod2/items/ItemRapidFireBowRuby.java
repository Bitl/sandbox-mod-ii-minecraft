package bitl.sandboxmod2.items;

import java.util.List;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemRapidFireBowRuby extends Item
{
	public ItemRapidFireBowRuby() 
	{
		this.maxStackSize = 1;
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
	}
	
	/**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	boolean var5 = par3EntityPlayer.capabilities.isCreativeMode;
    	boolean var7 = par3EntityPlayer.getHealth() == par3EntityPlayer.getMaxHealth();
    	
        if (var5 || par3EntityPlayer.inventory.hasItem(Items.arrow) || var7)
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            EntityArrow var8 = new EntityArrow(par2World, par3EntityPlayer, 2.0F);
            var8.setDamage(3.5D);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
            if (var5 || var7)
            {
                var8.canBePickedUp = 2;
            }
            else
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(var8);
            }
        }
        
        return par1ItemStack;
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RapidFireBow1Ruby"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RapidFireBow2"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RapidFireBow2b"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RapidFireBow3Ruby"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RapidFireBow3Rubyb"));
        par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("attribute.RapidFireBows1"));
    }
}