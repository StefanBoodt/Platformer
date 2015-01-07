package blocks;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Block class.
 * 
 * @since 05-11-2014
 * @version 05-11-2014
 * 
 * @see Block
 * 
 * @author stefanboodt
 *
 */
public abstract class BlockTest {

	/**
	 * Block under test.
	 */
	private Block block;
	
	/**
	 * Does some set up.
	 * @throws Exception If the set up fails.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Does some clean up.
	 * @throws Exception If the clean up fails.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the {@link Block#hashCode()} method.
	 */
	@Test
	public void testHashCode() {
		final int reccode = block.getRectangle().hashCode();
		assertEquals(reccode, block.hashCode());
	}
	
	/**
	 * Tests if the {@link Block#hashCode()} method is the same if
	 * it is calculated twice.
	 */
	@Test
	public void testHashCodeSame() {
		assertEquals(block.hashCode(), block.hashCode());
	}
	
	/**
	 * Tests the {@link Block#setRectangle(Rectangle)} and the
	 * {@link Block#getRectangle()} method.
	 */
	@Test
	public void testGetRectangle() {
		final Rectangle rec = new Rectangle();
		assertEquals(rec, getBlock().getRectangle());
	}

	/**
	 * Set the block under test.
	 * @param block The new block under test.
	 */
	protected void setBlock(Block block) {
		this.block = block;
	}
	
	/**
	 *Requests the block under test.
	 * @return The block under test.
	 */
	protected Block getBlock() {
		return block;
	}
}
