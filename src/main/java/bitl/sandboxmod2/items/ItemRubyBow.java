package bitl.sandboxmod2.items;

import java.util.List;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.common.MinecraftForge;

public class ItemRubyBow extends Item
{
	public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};
    private IIcon[] iconArray;

    public ItemRubyBow()
    {
        this.maxStackSize = 1;
        this.setCreativeTab(SandboxMod2.tabSandboxMod2);
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0 || par3EntityPlayer.getHealth() == 20;

        if (var5 || par3EntityPlayer.inventory.hasItem(Items.arrow))
        {
            int var6 = this.getMaxItemUseDuration(par1ItemStack) - par4;
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

            if ((double)var7 < 0.1D)
            {
                return;
            }

            if (var7 > 1.0F)
            {
                var7 = 1.0F;
            }

            EntityArrow var8 = new EntityArrow(par2World, par3EntityPlayer, var7 * 2.0F);

            if (var7 == 1.0F)
            {
                var8.setIsCritical(true);
            }
            
            var8.setDamage(3.5D);
            //par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

            if (var5)
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
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }
    
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
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
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Items.arrow) || par3EntityPlayer.getHealth() == 20)
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        
        return par1ItemStack;
    }

    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getIconString() + "_standby");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int var2 = 0; var2 < this.iconArray.length; ++var2)
        {
            this.iconArray[var2] = par1IconRegister.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[var2]);
        }
    }

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) 
    {
            if (usingItem == null) { return itemIcon; }
            int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
            if (ticksInUse > 17) {
                return iconArray[2];
            } else if (ticksInUse > 13) {
                return iconArray[1];
            } else if (ticksInUse > 0) {
                return iconArray[0];
            } else {
                return itemIcon;
            }
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyBow1"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyBow2"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyBow2b"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyBow3"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyBow3b"));
        par3List.add(EnumChatFormatting.DARK_AQUA + StatCollector.translateToLocal("attribute.RubyBow4"));
        par3List.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("attribute.RubyTools1"));
    }
}
