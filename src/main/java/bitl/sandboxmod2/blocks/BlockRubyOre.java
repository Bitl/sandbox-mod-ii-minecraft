package bitl.sandboxmod2.blocks;

import java.util.Random;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockRubyOre extends Block
{
	public BlockRubyOre()
	{
	    super(Material.rock);
	    this.setCreativeTab(SandboxMod2.tabSandboxMod2);
	}
}