package bitl.sandboxmod2.items;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ItemPrimedTNT extends Item 
{
	private static final IBehaviorDispenseItem dispenserBehavior = new BehaviorDefaultDispenseItem()
    {
		public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack)
	    {
	        EnumFacing var3 = BlockDispenser.func_149937_b(par1IBlockSource.getBlockMetadata());
	        double var4 = par1IBlockSource.getX() + (double)var3.getFrontOffsetX();
	        double var6 = (double)((float)par1IBlockSource.getYInt() + 0.2F);
	        double var8 = par1IBlockSource.getZ() + (double)var3.getFrontOffsetZ();
	        Entity var10 = ItemPrimedTNT.spawnCreature(par1IBlockSource.getWorld(), var4, var6, var8);

	        par2ItemStack.splitStack(1);
	        return par2ItemStack;
	    }
    };
	
	public ItemPrimedTNT() 
	{
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
    	BlockDispenser.dispenseBehaviorRegistry.putObject(this, dispenserBehavior);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
	{
		if (world.isRemote) 
		{
			return stack;
		} 
		else 
		{
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

			if (movingobjectposition == null) 
			{
				return stack;
			} 
			else 
			{
				if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) 
				{
					int i = movingobjectposition.blockX;
					int j = movingobjectposition.blockY;
					int k = movingobjectposition.blockZ;
					spawnCreature(world, (double) i, (double) j, (double) k);
					if (!player.capabilities.isCreativeMode) 
					{
						--stack.stackSize;
					}
				}

				return stack;
			}
		}
	}


	/**
	 * Spawns the creature specified by the egg's type in the location specified
	 * by the last three parameters. Parameters: world, entityID, x, y, z.
	 */

	public static EntityTNTPrimed spawnCreature(World world, double x, double y, double z) 
	{
		EntityTNTPrimed entity = new EntityTNTPrimed(world);
		entity.setLocationAndAngles(x, y+1, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		entity.fuse = entity.fuse + 20;
		world.spawnEntityInWorld(entity);
		world.playSoundAtEntity(entity, "game.tnt.primed", 1.0F, 1.0F);

		return entity;
	}
}