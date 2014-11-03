package collection;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import level.PlatformLevel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the world in the platform game.
 * 
 * @since 03-11-2014
 * @version 03-11-2014
 * 
 * @see World
 * 
 * @author stefanboodt
 *
 */
public class WorldTest {

	/**
	 * The world under test.
	 */
	private World world;
	
	/**
	 * Does some set up.
	 * @throws Exception If the set up fails.
	 */
	@Before
	public void setUp() throws Exception {
		final int wn = 1; // The world number
		setWorld(new World(wn));
	}

	/**
	 * Does some clean up.
	 * @throws Exception If the clean up fails.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests if the world number is 1.
	 */
	@Test
	public void testGetWorldNumberEqualsOne() {
		final int expected = 1;
		assertEquals(expected, getWorld().getWorldNumber());
	}
	
	/**
	 * Tests the {@link World#getLevels()} method.
	 */
	@Test
	public void testGetLevels() {
		Map<Integer, PlatformLevel> levels = new HashMap<Integer, PlatformLevel>();
		levels.put(1, new PlatformLevel(1,1));
		levels.put(2, new PlatformLevel(1,2));
		getWorld().setLevels(levels);
		assertEquals(levels, getWorld().getLevels());
	}
	
	/**
	 * Tests the {@link World#addLevel(PlatformLevel)} method.
	 */
	@Test
	public void testAddLevel() {
		getWorld().getLevels().clear();
		PlatformLevel level = new PlatformLevel(1,1);
		getWorld().addLevel(level);
		final int levels = 1;
		assertEquals(levels, getWorld().getLevels().size());
	}

	/**
	 * Requestst the world under test.
	 * @return The world the test is run on.
	 */
	protected World getWorld() {
		return world;
	}
	
	/**
	 * Sets the world under test to the given value.
	 * @param world Set the world under test.
	 */
	protected void setWorld(World world) {
		this.world = world;
	}
}
