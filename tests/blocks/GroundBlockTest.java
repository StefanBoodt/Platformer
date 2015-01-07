package blocks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;

/**
 * Tests the GroundBlock class.
 * 
 * @since 07-01-2015
 * @version 07-01-2015
 * 
 * @see GroundBlock
 * @see BlockTest
 * 
 * @author stefanboodt
 *
 */
public class GroundBlockTest extends BlockTest {
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		GroundBlock block = new GroundBlock(0, 0);
		this.setBlock(block);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	public void testGetRemainingHits() {
		assertEquals(Integer.MAX_VALUE, getBlock().getRemainingHits());
	}
}
