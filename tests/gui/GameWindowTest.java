package gui;

import static org.junit.Assert.assertTrue;

import java.awt.Image;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests the window under test.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see WindowTest
 * @see GameWindow
 * 
 * @author stefanboodt
 *
 */
public class GameWindowTest extends WindowTest {
	
	/**
	 * The image on the class.
	 */
	protected static Image image;
	
	/**
	 * Loads the images.
	 * @throws Exception If the image can not be loaded.
	 */
	@BeforeClass
	public static void enter() throws Exception {
		image = ImageIO.read(GameWindowTest.class.getResource("flagpole.png"));
	}
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		setWindow(new GameWindow("Platformer", image));
	}

	@Override
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests if the window is visible.
	 */
	@Test
	public void testVisible() {
		assertTrue(getWindow().isVisible());
	}
	
	/*
	@Test
	public void crap() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		sc.next();
		sc.close();
	} /* Funny comments.*/
}
