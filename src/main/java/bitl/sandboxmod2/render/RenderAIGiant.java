package bitl.sandboxmod2.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import bitl.sandboxmod2.SandboxMod2;
import bitl.sandboxmod2.entity.EntityAIGiant;

public class RenderAIGiant extends RenderLiving
{
    private static final ResourceLocation zombieTextures = new ResourceLocation(SandboxMod2.MODID + ":" + "textures/mobs/entityAIGiant.png");

    /** Scale of the model to use */
    private float scale;

    public RenderAIGiant(ModelBase par1ModelBase, float par2, float par3)
    {
        super(par1ModelBase, par2 * par3);
        this.scale = par3;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityAIGiant par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityAIGiant par1EntityGiantZombie)
    {
        return zombieTextures;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderCallback((EntityAIGiant)par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityAIGiant)par1Entity);
    }
}
