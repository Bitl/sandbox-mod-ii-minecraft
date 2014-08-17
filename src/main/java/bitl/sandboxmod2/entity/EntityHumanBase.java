package bitl.sandboxmod2.entity;

import java.util.Calendar;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntityHumanBase extends EntityMob
{
	public int armorType = 0;
	public static final String[] HumanName = new String[] {"Steve", "Jeb", "Markus", "Nathan", "Michael", "Steve?", "August", "Tony", "Henry", "Creeper", "Enderman", "Not Herobrine", "Heavy", "Medic", "Demoman", "Spy", "Scout", "Sniper", "Soldier", "Pyro", "Engineer", "Butter", "Gordon", "Alex", "Alyx", "Eli", "John", "Saxton Hale", "Bill", "Francis", "Louis", "Zoey", "Coach", "Nick", "Ellis", "Rochelle", "Judith", "Chell", "Jim", "Jimmy", "Mike", "Wallace", "Doug", "Cave", "Helena", "Harold", "Henry", "Ivan", "Richard", "Isaac", "Lauren", "Arne", "Sam", "Samuel", "Sheckley", "Simmons", "Adrian", "Barney", "Odell", "Azian", "Wheatley", "Greg", "Griggs", "Grigori", "GLaDOS", "Miller", "Atlas", "P-Body", "Notch", "Dinnerbone", "Bob", "Halsey", "Sarge", "Griff", "Caboose", "Will", "William", "Church", "Leonard", "Chris", "Christopher", "Daniel", "Dan", "jeb_", "Not Bitl", "Booker", "Elizabeth", "Emmet", "Wyldstyle", "Vitruvius", "Jack", "Eleanor", "Augustus", "Benny", "Rantis", "Leonardo", "Raphael", "Michelangelo", "Donatello", "Don", "Raph", "Donny", "Donnie"};
	
	public EntityHumanBase(World par1World) 
	{
		super(par1World);
		this.onHumanSpawn();
		this.experienceValue = 2;
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
	
	public boolean attackEntityAsMob(Entity par1Entity)
    {
        float var2 = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int var3 = 0;

        if (par1Entity instanceof EntityLivingBase)
        {
            var2 += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)par1Entity);
            var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)par1Entity);
        }

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if (var4)
        {
            if (var3 > 0)
            {
                par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)var3 * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);

            if (var5 > 0)
            {
                par1Entity.setFire(var5 * 4);
            }

            if (par1Entity instanceof EntityLivingBase)
            {
                EnchantmentHelper.func_151384_a((EntityLivingBase)par1Entity, this);
            }

            EnchantmentHelper.func_151385_b(this, par1Entity);
        }

        return var4;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
    }
    
    protected void onHumanSpawn()
	{
	}
	
	/**
	 * 1 = Uses Minecraft's default armor function, 
	 * 2 = Uses EntityHumanBase's custom armor function, 
	 * 3 = Randomizes between the two.
	 */
	
	public void addArmorHuman(int par1)
	{
		if (par1 == 1)
		{
			this.addRandomArmor();
		}
		else if (par1 == 2)
		{
			this.addRandomArmorHuman();
		}
		else if (par1 == 3)
		{
			int choiceChooser = this.rand.nextInt(3);
			
			if (choiceChooser == 1)
			{
				this.addRandomArmor();
			}
			else if (choiceChooser == 2)
			{
				this.addRandomArmorHuman();
			}
		}
	}
	
	public void addRandomArmorHuman()
    {
		int armorChooser = this.rand.nextInt(5);
		
		if (armorChooser == 1)
    	{
	    	this.armorType = 1;
    	}
		else if (armorChooser == 2)
    	{
	    	this.armorType = 2;
    	}
		else if (armorChooser == 3)
    	{
	    	this.armorType = 3;
    	}
    	else if (armorChooser == 4)
    	{
	    	this.armorType = 4;
    	}
    	else
    	{
    		this.armorType = 0;
    	}
		
		if (this.armorType == 1)
    	{
			this.setCurrentItemOrArmor(1, new ItemStack(Items.leather_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.leather_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.leather_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.leather_boots));
    	}
		else if (this.armorType == 2)
    	{
			this.setCurrentItemOrArmor(1, new ItemStack(Items.golden_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.golden_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.golden_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.golden_boots));
    	}
		else if (this.armorType == 3)
    	{
			this.setCurrentItemOrArmor(1, new ItemStack(Items.iron_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.iron_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_boots));
    	}
    	else if (this.armorType == 4)
    	{
    		this.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
    	}
    }
	
	public void setHumanArmor(int par1)
	{
		this.armorType = par1;
		
		if (this.armorType == 1)
    	{
			this.setCurrentItemOrArmor(1, new ItemStack(Items.leather_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.leather_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.leather_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.leather_boots));
    	}
		else if (this.armorType == 2)
    	{
			this.setCurrentItemOrArmor(1, new ItemStack(Items.golden_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.golden_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.golden_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.golden_boots));
    	}
		else if (this.armorType == 3)
    	{
			this.setCurrentItemOrArmor(1, new ItemStack(Items.iron_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.iron_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_boots));
    	}
    	else if (this.armorType == 4)
    	{
    		this.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
	    	this.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
	    	this.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
	    	this.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
    	}
	}
	
	public void setHumanArmorHealth()
	{
		if (this.armorType == 1)
    	{
			this.setHealth(this.getMaxHealth() + 10);
    	}
		else if (this.armorType == 2)
    	{
			this.setHealth(this.getMaxHealth() + 15);
    	}
		else if (this.armorType == 3)
    	{
			this.setHealth(this.getMaxHealth() + 20);
    	}
    	else if (this.armorType == 4)
    	{
    		this.setHealth(this.getMaxHealth() + 30);
    	}
    	else if (this.armorType == 0)
    	{
    		this.setHealth(this.getMaxHealth());
    	}
	}
	
	/**
     * Makes entity wear random armor based on difficulty
     */
    protected void addRandomArmor()
    {
        if (this.rand.nextFloat() < 0.15F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ))
        {
            int var1 = this.rand.nextInt(2);
            float var2 = 0.1F;

            if (this.rand.nextFloat() < 0.095F)
            {
                ++var1;
            }

            if (this.rand.nextFloat() < 0.095F)
            {
                ++var1;
            }

            if (this.rand.nextFloat() < 0.095F)
            {
                ++var1;
            }

            for (int var3 = 3; var3 >= 0; --var3)
            {
                ItemStack var4 = this.func_130225_q(var3);

                if (var3 < 3 && this.rand.nextFloat() < var2)
                {
                    break;
                }

                if (var4 == null)
                {
                    Item var5 = getArmorItemForSlot(var3 + 1, var1);

                    if (var5 != null)
                    {
                        this.setCurrentItemOrArmor(var3 + 1, new ItemStack(var5));
                    }
                }
            }
        }
    }

    /**
     * Params: Armor slot, Item tier
     */
    public static Item getArmorItemForSlot(int par0, int par1)
    {
        switch (par0)
        {
            case 4:
                if (par1 == 0)
                {
                    return Items.leather_helmet;
                }
                else if (par1 == 1)
                {
                    return Items.golden_helmet;
                }
                else if (par1 == 2)
                {
                    return Items.iron_helmet;
                }
                else if (par1 == 3)
                {
                    return Items.diamond_helmet;
                }

            case 3:
                if (par1 == 0)
                {
                    return Items.leather_chestplate;
                }
                else if (par1 == 1)
                {
                    return Items.golden_chestplate;
                }
                else if (par1 == 2)
                {
                    return Items.iron_chestplate;
                }
                else if (par1 == 3)
                {
                    return Items.diamond_chestplate;
                }

            case 2:
                if (par1 == 0)
                {
                    return Items.leather_leggings;
                }
                else if (par1 == 1)
                {
                    return Items.golden_leggings;
                }
                else if (par1 == 2)
                {
                    return Items.iron_leggings;
                }
                else if (par1 == 3)
                {
                    return Items.diamond_leggings;
                }

            case 1:
                if (par1 == 0)
                {
                    return Items.leather_boots;
                }
                else if (par1 == 1)
                {
                    return Items.golden_boots;
                }
                else if (par1 == 2)
                {
                    return Items.iron_boots;
                }
                else if (par1 == 3)
                {
                    return Items.diamond_boots;
                }

            default:
                return null;
        }
    }
	
	public void setHumanName(String par1)
	{
		this.setCustomNameTag(par1);
	}
	
	public void setHumanRandomName()
	{
		this.setCustomNameTag(this.HumanName[this.rand.nextInt(this.HumanName.length)]);
	}
	
	/**
	 * Argument 1: Prefix,
	 * Argument 2: Suffix
	 */
	
	public void setHumanRandomNameEx(String par1, String par2)
	{
		this.setCustomNameTag(par1 + this.HumanName[this.rand.nextInt(this.HumanName.length)] + par2);
	}
	
	public EntityItem func_145779_a(Item p_145779_1_, int p_145779_2_)
    {
        return this.func_145778_a(p_145779_1_, p_145779_2_, 0.0F);
    }

    public EntityItem func_145778_a(Item p_145778_1_, int p_145778_2_, float p_145778_3_)
    {
        return this.entityDropItem(new ItemStack(p_145778_1_, p_145778_2_, 0), p_145778_3_);
    }

    /**
     * Drops an item at the position of the entity.
     */
    public EntityItem entityDropItem(ItemStack par1ItemStack, float par2)
    {
        if (par1ItemStack.stackSize != 0 && par1ItemStack.getItem() != null)
        {
            EntityItem var3 = new EntityItem(this.worldObj, this.posX, this.posY + (double)par2, this.posZ, par1ItemStack);
            var3.delayBeforeCanPickup = 10;
            this.worldObj.spawnEntityInWorld(var3);
            return var3;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("ArmorType", (short)this.armorType);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.armorType = par1NBTTagCompound.getShort("ArmorType");
    }
}
