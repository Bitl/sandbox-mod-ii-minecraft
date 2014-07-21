package bitl.sandboxmod2;

import bitl.sandboxmod2.entity.EntityHuman;
import bitl.sandboxmod2.entity.EntityHumanArcher;
import bitl.sandboxmod2.entity.EntityHumanArcherEvil;
import bitl.sandboxmod2.entity.EntityHumanBase;
import bitl.sandboxmod2.entity.EntityHumanBaseEvil;
import bitl.sandboxmod2.entity.EntityHumanKnight;
import bitl.sandboxmod2.entity.EntityHumanKnightEvil;
import bitl.sandboxmod2.render.ItemRendererRubyBow;
import bitl.sandboxmod2.render.RenderHuman;
import bitl.sandboxmod2.render.RenderHumanArcher;
import bitl.sandboxmod2.render.RenderHumanArcherEvil;
import bitl.sandboxmod2.render.RenderHumanBase;
import bitl.sandboxmod2.render.RenderHumanBaseEvil;
import bitl.sandboxmod2.render.RenderHumanKnight;
import bitl.sandboxmod2.render.RenderHumanKnightEvil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class SandboxMod2ClientProxy extends SandboxMod2CommonProxy
{
	@Override
	public void registerRenderInformation() 
	{
		MinecraftForgeClient.registerItemRenderer(SandboxMod2.itemRubyBow, new ItemRendererRubyBow());
		RenderingRegistry.registerEntityRenderingHandler(EntityHumanBase.class, new RenderHumanBase(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHumanBaseEvil.class, new RenderHumanBaseEvil(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new RenderHuman(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHumanArcher.class, new RenderHumanArcher(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHumanKnight.class, new RenderHumanKnight(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHumanArcherEvil.class, new RenderHumanArcherEvil(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHumanKnightEvil.class, new RenderHumanKnightEvil(new ModelBiped(), 0.5F));
	}
}
