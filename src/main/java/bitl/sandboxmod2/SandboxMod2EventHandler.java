package bitl.sandboxmod2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;

public class SandboxMod2EventHandler 
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void updateFOV(FOVUpdateEvent event) 
	{
		ItemStack stack = (event.entity.isUsingItem() ? event.entity.getItemInUse() : null);
		if (stack != null) 
		{
			if (stack.getItem() == SandboxMod2.itemRubyBow) 
			{
				event.newfov = event.fov - 0.2F;
			}
		}
	}
}
