package bitl.sandboxmod2.render;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHumanBase extends RenderBiped 
{
	private static final ResourceLocation textureLocation = new ResourceLocation(SandboxMod2.MODID + ":" + "textures/mobs/entityHumanBase.png");

	public RenderHumanBase(ModelBiped model, float shadowSize) 
	{
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return textureLocation;
	}

}
