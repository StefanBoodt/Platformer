package gui;

import static org.junit.Assert.*;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Menu class.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see Menu
 * 
 * @author stefanboodt
 *
 */
public class MenuTest {

	/**
	 * The menu under test.
	 */
	private Menu menu;
	
	/**
	 * Does some set up.
	 * @throws Exception If the set up fails.
	 */
	@Before
	public void setUp() throws Exception {
		final Menu menu = new Menu();
		setMenu(menu);
	}

	/**
	 * Does some clean up.
	 * @throws Exception If the clean up fails.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the {@link Menu#getListener()} method.
	 */
	@Test
	public void testGetListener() {
		final ActionListener expected = new Menu().getListener();
		assertEquals(expected, menu.getListener());
	}
	
	/**
	 * Tests the {@link Menu#addButton(javax.swing.JButton)} method.
	 * @throws Exception If the button does not have any text.
	 */
	@Test (expected = Exception.class)
	public void testAddButton() throws Exception {
		final JButton failure = new JButton();
		menu.addButton(failure);
	}

	/**
	 * Sets the menu under test.
	 * @param menu The new menu under test.
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	/**
	 * Returns the menu under test.
	 * @return The menu under test.
	 */
	public Menu getMenu() {
		return menu;
	}
}
