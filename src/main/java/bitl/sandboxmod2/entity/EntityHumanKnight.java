package bitl.sandboxmod2.entity;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityHumanKnight extends EntityHumanBase
{
	public int swordType;
	public double followDistanceKnight = 1.25D;
	public double knightAttackDamage = 1.0D;
	
	public EntityHumanKnight(World par1World) 
	{
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityEnderman.class, 8.0F));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityGiantZombie.class, 8.0F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntitySilverfish.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntitySkeleton.class, 8.0F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntitySpider.class, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityWitch.class, 8.0F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityZombie.class, 8.0F));
		this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityHumanBaseEvil.class, 8.0F));
		this.tasks.addTask(12, new EntityAIWatchClosest(this, EntityDragon.class, 8.0F));
		this.tasks.addTask(13, new EntityAIWatchClosest(this, EntitySlime.class, 8.0F));
		this.tasks.addTask(14, new EntityAIWatchClosest(this, EntityBlaze.class, 8.0F));
		this.tasks.addTask(15, new EntityAIWatchClosest(this, EntityGhast.class, 8.0F));
		this.tasks.addTask(16, new EntityAIWatchClosest(this, EntityAIGiant.class, 8.0F));
		this.tasks.addTask(17, new EntityAILookIdle(this));
		this.tasks.addTask(18, new EntityAIAttackOnCollide(this, EntityEnderman.class, 1.2D, true));
		this.tasks.addTask(19, new EntityAIAttackOnCollide(this, EntityGiantZombie.class, 1.2D, true));
		this.tasks.addTask(20, new EntityAIAttackOnCollide(this, EntitySilverfish.class, 1.2D, true));
		this.tasks.addTask(21, new EntityAIAttackOnCollide(this, EntitySkeleton.class, 1.2D, true));
		this.tasks.addTask(22, new EntityAIAttackOnCollide(this, EntitySpider.class, 1.2D, true));
		this.tasks.addTask(23, new EntityAIAttackOnCollide(this, EntityWitch.class, 1.2D, true));
		this.tasks.addTask(24, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.2D, true));
		this.tasks.addTask(25, new EntityAIAttackOnCollide(this, EntityHumanBaseEvil.class, 1.2D, true));
		this.tasks.addTask(26, new EntityAIAttackOnCollide(this, EntityDragon.class, 1.2D, true));
		this.tasks.addTask(27, new EntityAIAttackOnCollide(this, EntitySlime.class, 1.2D, true));
		this.tasks.addTask(28, new EntityAIAttackOnCollide(this, EntityBlaze.class, 1.2D, true));
		this.tasks.addTask(29, new EntityAIAttackOnCollide(this, EntityGhast.class, 1.2D, true));
		this.tasks.addTask(30, new EntityAIAttackOnCollide(this, EntityAIGiant.class, 1.2D, true));
		this.tasks.addTask(31, new EntityAIMoveIndoors(this));
        this.tasks.addTask(32, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(33, new EntityAITempt(this, followDistanceKnight, Items.wooden_sword, false));
        this.tasks.addTask(34, new EntityAITempt(this, followDistanceKnight, Items.stone_sword, false));
        this.tasks.addTask(35, new EntityAITempt(this, followDistanceKnight, Items.iron_sword, false));
        this.tasks.addTask(36, new EntityAITempt(this, followDistanceKnight, Items.golden_sword, false));
        this.tasks.addTask(37, new EntityAITempt(this, followDistanceKnight, Items.diamond_sword, false));
        this.tasks.addTask(38, new EntityAITempt(this, followDistanceKnight, SandboxMod2.itemRubySword, false));
        this.tasks.addTask(39, new EntityAITempt(this, followDistanceKnight, Items.bow, false));
        this.tasks.addTask(40, new EntityAITempt(this, followDistanceKnight, SandboxMod2.itemRubyBow, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
		this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityHumanBaseEvil.class, 0, true));
		this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntitySlime.class, 0, true));
		this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityDragon.class, 0, true));
		this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityBlaze.class, 0, true));
		this.targetTasks.addTask(13, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
		this.targetTasks.addTask(14, new EntityAINearestAttackableTarget(this, EntityAIGiant.class, 0, true));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.knightAttackDamage);
	}
	
	public boolean isAIEnabled()
	{
		 return true;
	}
	
	protected void onHumanSpawn()
	{
		this.swordType = 0;
		this.addArmorHuman(3);
		this.selectSword();
		this.selectSwordDamage();
		this.setHumanRandomNameEx(StatCollector.translateToLocal("humanname.humanKnight"), "");
		this.setHumanArmorHealth();
	}
	
	public void selectSword()
    {
    	int swordSelector = this.rand.nextInt(7);
    	
		if (swordSelector == 1)
    	{
    		this.swordType = 1;
    	}
		else if (swordSelector == 2)
    	{
    		this.swordType = 2;
    	}
		else if (swordSelector == 3)
    	{
    		this.swordType = 3;
    	}
		else if (swordSelector == 4)
    	{
    		this.swordType = 4;
    	}
		else if (swordSelector == 5)
    	{
    		this.swordType = 5;
    	}
		else if (swordSelector == 6)
    	{
    		this.swordType = 6;
    	}
		else
    	{
    		this.swordType = 0;
    	}
    	
		if (this.swordType == 1)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.wooden_sword));
    	}
		else if (this.swordType == 2)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
    	}
    	else if (this.swordType == 3)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
    	}
    	else if (this.swordType == 4)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
    	}
    	else if (this.swordType == 5)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
    	}
    	else if (this.swordType == 6)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(SandboxMod2.itemRubySword));
    	}
		else if (this.swordType == 0)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.wooden_sword));
    	}
    }
	
	public void selectSwordDamage()
	{
		if (this.swordType == 1)
    	{
			this.knightAttackDamage = 2.0D;
    	}
		else if (this.swordType == 2)
    	{
			this.knightAttackDamage = 3.0D;
    	}
    	else if (this.swordType == 3)
    	{
    		this.knightAttackDamage = 4.0D;
    	}
    	else if (this.swordType == 4)
    	{
    		this.knightAttackDamage = 5.0D;
    	}
    	else if (this.swordType == 5)
    	{
    		this.knightAttackDamage = 6.0D;
    	}
    	else if (this.swordType == 6)
    	{
    		this.knightAttackDamage = 6.0D;
    	}
		else if (this.swordType == 0)
    	{
			this.knightAttackDamage = 2.0D;
    	}
	}
	
	/**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2)
    {
    	if (this.swordType == 1)
        {
    		this.func_145779_a(Items.wooden_sword, 1);
        }
    	else if (this.swordType == 2)
        {
    		this.func_145779_a(Items.stone_sword, 1);
        }
    	else if (this.swordType == 3)
        {
    		this.func_145779_a(Items.iron_sword, 1);
        }
    	else if (this.swordType == 4)
        {
    		this.func_145779_a(Items.golden_sword, 1);
        }
    	else if (this.swordType == 5)
        {
    		this.func_145779_a(Items.diamond_sword, 1);
        }
    	else if (this.swordType == 6)
        {
    		this.func_145779_a(SandboxMod2.itemRubySword, 1);
        }
    	else if (this.swordType == 0)
        {
    		this.func_145779_a(Items.wooden_sword, 1);
        }
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("SwordType", (short)this.swordType);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.swordType = par1NBTTagCompound.getShort("SwordType");
    }
}