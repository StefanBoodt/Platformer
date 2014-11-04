package game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the launcher.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see Launcher
 * 
 * @author stefanboodt
 *
 */
public class LauncherTest {

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
	 * Tests the launch class.
	 * @throws InterruptedException If the thread is interrupted.
	 */
	@Test
	public void testMain() throws InterruptedException {
		Launcher.main(new String[0]);
		final int time = 3;
		Thread.sleep(time);
		assertNotNull(Launcher.window);
	}
}
