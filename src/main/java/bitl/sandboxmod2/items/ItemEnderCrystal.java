package bitl.sandboxmod2.items;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemEnderCrystal extends Item 
{
	public ItemEnderCrystal() 
	{
		this.setCreativeTab(SandboxMod2.tabSandboxMod2);
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

	public static EntityEnderCrystal spawnCreature(World world, double x, double y, double z) 
	{
		EntityEnderCrystal entity = new EntityEnderCrystal(world);
		entity.setLocationAndAngles(x, y+1, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		world.spawnEntityInWorld(entity);

		return entity;
	}
	
}