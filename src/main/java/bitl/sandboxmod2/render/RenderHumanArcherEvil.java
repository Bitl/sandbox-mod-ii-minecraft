package bitl.sandboxmod2.render;

import org.lwjgl.opengl.GL11;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHumanArcherEvil extends RenderBiped 
{
	private static final ResourceLocation textureLocation = new ResourceLocation(SandboxMod2.MODID + ":" + "textures/mobs/entityHumanArcherEvil.png");

	public RenderHumanArcherEvil(ModelBiped model, float shadowSize) 
	{
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return textureLocation;
	}

}