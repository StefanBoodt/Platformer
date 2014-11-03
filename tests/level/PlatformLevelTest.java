package level;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;

/**
 * This class tests the PlatformLevel class.
 * 
 * @since 03-11-2014
 * @version 03-11-2014
 * 
 * @see LevelTest
 * @see PlatformLevel
 * 
 * @author stefanboodt
 *
 */
public class PlatformLevelTest extends LevelTest {

	protected final int worldnumber = 2;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		final int levelnumber = 4;
		setLevel(new PlatformLevel(worldnumber, levelnumber));
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	public void testEqualsCopy() {
		final PlatformLevel lv = (PlatformLevel) getLevel(); 
		final int levelnumber = lv.getLevelNumber();
		final Level other = new PlatformLevel(worldnumber, levelnumber);
		assertEquals(lv, other);
	}

	@Override
	public void testHashCodeCopy() {
		final int levelnumber = ((PlatformLevel) getLevel()).getLevelNumber();
		final Level other = new PlatformLevel(worldnumber, levelnumber);
		assertEquals(other.hashCode(), getLevel().hashCode());
	}

}
