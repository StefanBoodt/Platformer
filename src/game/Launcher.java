package game;

import gui.GameWindow;

import java.io.IOException;

/**
 * This class launches the platformer game.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see GameWindow
 * 
 * @author stefanboodt
 *
 */
public class Launcher {
	
	/**
	 * The game window used in the game.
	 */
	public static GameWindow window;

	/**
	 * This method starts the program.
	 * @param args Ignored.
	 */
	public static void main(String[] args) {
		final String title = "Platformer";
		final String loc = "flagpole.png";
		try {
			window = GameWindow.createWindow(title, loc);
		} catch (IOException e) {
			// Try again without the window.
			window = new GameWindow(title, null);
		}
	}
}
