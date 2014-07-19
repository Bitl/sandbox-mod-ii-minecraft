package bitl.sandboxmod2;

import bitl.sandboxmod2.render.ItemRendererRubyBow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
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
	}
}
