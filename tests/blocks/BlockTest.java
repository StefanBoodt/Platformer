package blocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Block class.
 * 
 * @since 05-11-2014
 * @version 07-01-2015
 * 
 * @see Block
 * @see Assert
 * @see Mockito
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
		block.setRectangle(rec);
		assertEquals(rec, getBlock().getRectangle());
	}
	
	/**
	 * Tests if the X coordinate is returned correctly.
	 */
	@Test
	public void testGetX() {
		final Float expected = new Float(0);
		block.setLocation(expected, 10);
		assertEquals(expected, new Float(getBlock().getX()));
	}
	
	/**
	 * Tests if the Y coordinate is returned correctly.
	 */
	@Test
	public void testGetY() {
		final Float expected = new Float(10);
		block.setLocation(0, expected);
		assertEquals(expected, new Float(getBlock().getY()));
	}
	
	/**
	 * Tests if the width is returned correctly.
	 */
	@Test
	public void testGetWidth() {
		final Float expected = new Float(Block.WIDTH);
		block.setLocation(0, 0);
		assertEquals(expected, new Float(getBlock().getWidth()));
	}
	
	/**
	 * Tests if the height coordinate is returned correctly.
	 */
	@Test
	public void testGetHeight() {
		final Float expected = new Float(Block.HEIGHT);
		block.setLocation(0, 0);
		assertEquals(expected, new Float(getBlock().getHeight()));
	}
	
	/**
	 * Tests the {@link Block#setRectangle(Rectangle)} and the
	 * {@link Block#getRectangle()} method.
	 */
	@Test
	public void testCorrectRectangle() {
		final Rectangle rec = new Rectangle((int) getBlock().getX(), 
				(int) getBlock().getY(), (int) getBlock().getWidth(),
				(int) getBlock().getHeight());
		assertEquals(getBlock().getRectangle(), rec);
	}
	
	/**
	 * Test the {@link Block#move(float, float)} method.
	 */
	@Test
	public void testMoveX() {
		getBlock().setLocation(0, 0);
		final float dx = 10f;
		final float dy = 0.1f;
		getBlock().move(dx, dy);
		assertEquals(new Float(dx), new Float(getBlock().getX()));
	}
	
	/**
	 * Test the {@link Block#move(float, float)} method.
	 */
	@Test
	public void testMoveY() {
		getBlock().setLocation(0, 0);
		final float dx = 10f;
		final float dy = 0.1f;
		getBlock().move(dx, dy);
		assertEquals(new Float(dy), new Float(getBlock().getY()));
	}
	
	/**
	 * Tests the {@link Block#equals(Object)} methode.
	 */
	@Test
	public void testEqualsSameAdress() {
		assertEquals(getBlock(), getBlock());
	}
	
	/**
	 * Tests the {@link Block#equals(Object)} methode.
	 */
	@Test
	public void testEqualsObject() {
		assertFalse(getBlock().equals(new Object()));
	}
	
	/**
	 * Tests the {@link Block#equals(Object)} methode.
	 */
	@Test
	public void testEqualsNULL() {
		assertFalse(getBlock().equals(null));
	}
	
	/**
	 * Tests the {@link Block#equals(Object)} methode.
	 */
	@Test
	public void testEquals() {
		final Block expected = getBlock().clone();
		assertTrue(getBlock().equals(expected));
	}
	
	/**
	 * Tests the {@link Block#isVisible()} method.
	 */
	@Test
	public void testIsVisibleNegativeX() {
		getBlock().setLocation(-10f, 20f);
		assertFalse(getBlock().isVisible());
	}
	
	/**
	 * Tests the {@link Block#isVisible()} method.
	 */
	@Test
	public void testIsVisibleHighX() {
		getBlock().setLocation(10000f, 20f);
		assertFalse(getBlock().isVisible());
	}
	
	/**
	 * Tests the {@link Block#isVisible()} method.
	 */
	@Test
	public void testIsVisible() {
		getBlock().setLocation(10f, 20f);
		assertTrue(getBlock().isVisible());
	}
	
	/**
	 * Tests the {@link Block#draw(Graphics)} method.
	 */
	@Test
	public void testDrawInvisible() {
		getBlock().setLocation(-1, 10);
		Graphics g = mock(Graphics.class);
		verifyNoMoreInteractions(g);
		getBlock().draw(g);
	}
	
	/**
	 * Tests the {@link Block#getRemainingHits()} method.
	 */
	@Test
	public abstract void testGetRemainingHits();
	
	/**
	 * Tests the {@link Block#intersects(Line2D)} method.
	 */
	@Test
	public void testIntersectsLine() {
		getBlock().setLocation(10, 20);
		final Line2D line = new Line2D.Float(0,0,20,40);
		System.out.println(line.intersects(getBlock().getRectangle()));
		assertTrue(getBlock().intersects(line));
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
