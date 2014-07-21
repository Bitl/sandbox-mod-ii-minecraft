package bitl.sandboxmod2.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import bitl.sandboxmod2.SandboxMod2;

public class RenderHumanKnight extends RenderBiped 
{
	private static final ResourceLocation textureLocation = new ResourceLocation(SandboxMod2.MODID + ":" + "textures/mobs/entityHumanKnight.png");

	public RenderHumanKnight(ModelBiped model, float shadowSize) 
	{
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return textureLocation;
	}

}