package gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The menu for the Platform game.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see MainMenu
 * 
 * @author stefanboodt
 *
 */
public class Menu extends MainMenu {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = 6356076695236026162L;

	/**
	 * The listener to use.
	 */
	private final ActionListener listener;
	
	/**
	 * The dimensions of the button.
	 */
	public static Dimension buttondimension = new Dimension(100,80);
	
	/**
	 * Creates a menu.
	 */
	public Menu() {
		this(new MenuListener());
	}
	
	/**
	 * Creates a menu.
	 * @param listener the listener to use.
	 */
	public Menu(ActionListener listener) {
		super();
		this.listener = listener;
		setUp();
	}

	/**
	 * Creates a menu that has doublebuffered as it's double buffered value.
	 * @param doublebuffered true if you want the menu to be double buffered.
	 */
	public Menu(boolean doublebuffered) {
		super(doublebuffered);
		this.listener = new MenuListener();
		setUp();
	}

	/**
	 * Creates a menu with the given settings.
	 * @param width The width of the menu.
	 * @param height The height of the menu.
	 * @param doublebuffered The double buffered state of the menu.
	 */
	public Menu(int width, int height, boolean doublebuffered) {
		super(width, height, doublebuffered);
		this.listener = new MenuListener();
		setUp();
	}
	
	@Override
	protected void addStartButton() {
		final JButton start = new JButton("Start");
		try {
			addButton(start);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a button to the menu.
	 * @param button The button to add.
	 * @throws Exception If the button does not have a name.
	 */
	public void addButton(JButton button) throws Exception {
		final String command = button.getText();
		if (command == null || command.equals("")) {
			final String message = "Button did not have a text on it";
			throw new Exception(message);
		}
		button.setActionCommand(command);
		button.addActionListener(listener);
		button.setSize(buttondimension);
		this.add(button);
	}
	
	/**
	 * Gets the listener used for the buttons in the menu.
	 * @return The listener used by this class.
	 */
	public ActionListener getListener() {
		return listener;
	}
	
	@Override
	public void setUp() {
		if (listener != null) {
			super.setUp();
			// Only set them if the listener is not equal to null.
		}
	}
}
