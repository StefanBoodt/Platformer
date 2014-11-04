package gui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;
import java.io.PrintStream;

import javax.swing.JButton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the menu listener class.
 * 
 * @see MenuListener
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @author stefanboodt
 *
 */
public class MenuListenerTest {

	/**
	 * The listener under test.
	 */
	private MenuListener listener;
	
	/**
	 * Does some set up.
	 * @throws Exception If the set up fails.
	 */
	@Before
	public void setUp() throws Exception {
		setListener(new MenuListener());
	}

	/**
	 * Does some clean up.
	 * @throws Exception If the clean up fails.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the {@link MenuListener#actionPerformed(ActionEvent)} method,
	 * with a completely odd command.
	 */
	@Test
	public void testOddCommand() {
		PrintStream err = System.err;
		PrintStream mocked = mock(PrintStream.class);
		try {
			final String command = "ni;nkmlmoi98uhjnbjabjsbdkn/.sdfjlskmnfkdnjn";
			System.setErr(mocked);
			listener.actionPerformed(new ActionEvent(new JButton(), 0, command));
			final String message = MenuListener.UNDEFINED_PREFIX + command;
			verify(mocked, atLeast(1)).println(message);
		}
		finally {
			System.setErr(err);
		}
	}

	/**
	 * Returns the listener under test.
	 * @return the listener used.
	 */
	public MenuListener getListener() {
		return listener;
	}

	/**
	 * Sets the listener under test.
	 * @param listener the new listener under test.
	 */
	public void setListener(MenuListener listener) {
		this.listener = listener;
	}

}
