package bitl.sandboxmod2.blocks;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRubyBlock extends Block
{
	public BlockRubyBlock()
	{
	    super(Material.iron);
	    this.setCreativeTab(SandboxMod2.tabSandboxMod2);
	}
}