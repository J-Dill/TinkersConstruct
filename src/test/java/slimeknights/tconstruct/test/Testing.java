package slimeknights.tconstruct.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jjtparadox.barometer.Barometer;
import com.jjtparadox.barometer.TestUtils;
import com.jjtparadox.barometer.tester.BarometerTester;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.world.block.BlockSlimeDirt;

@RunWith(BarometerTester.class)
public class Testing {
	World world;

  @Before
  public void setUp() {
      world = Barometer.getServer().getEntityWorld();
  }
  
  @Test
  public void testPlacement() {
    if (Blocks.CHEST != null) {
      BlockPos pos = new BlockPos(0, 0, 0);
      world.setBlockState(pos, Blocks.CHEST.getDefaultState());
      IBlockState state = world.getBlockState(pos);
      Block block = state.getBlock();
      assertEquals(block, Blocks.CHEST);
      TileEntity tile = world.getTileEntity(pos);
      assertSame(tile.getClass(), TileEntityChest.class);
  } else {
      fail("Blocks.CHEST is null");
  }
  }

}
