package bitl.sandboxmod2.items;

import java.util.List;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemIronApple extends ItemFood
{
	public ItemIronApple(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) 
	{
		super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
	}

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.rare;
    }

    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if (!par2World.isRemote)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 4));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 3000, 0));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2000, 0));
        }
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	par3List.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("attribute.PotionItems1"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.IronApple1"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.IronApple2"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.IronApple3"));
    }
}