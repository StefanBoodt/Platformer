package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens to the buttons in the menu.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see ActionListener
 * @see Menu
 * 
 * @author stefanboodt
 *
 */
public class MenuListener implements ActionListener {

	/**
	 * The undefined prefix for undefined actions.
	 */
	protected final static String UNDEFINED_PREFIX = "Undefined action: ";
	
	/**
	 * The listener for the buttons in the menu.
	 */
	public MenuListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String command = e.getActionCommand();
		switch (command) {
		case "Start":
			System.out.println(command + " is pressed");
			break;
		default:
			System.err.println(UNDEFINED_PREFIX + command);
		}
	}

	@Override
	public boolean equals(Object other) {
		return this.getClass().equals(other.getClass());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
