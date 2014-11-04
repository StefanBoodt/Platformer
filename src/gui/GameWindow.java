package gui;

import game.Launcher;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * The window the game is in.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see Window
 * @see Menu
 * @see Level
 * 
 * @author stefanboodt
 *
 */
public class GameWindow extends Window {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = -5107797232675286246L;
	
	/**
	 * The width and height of the screen.
	 */
	private final int width = 1000, height = 800;
	
	/**
	 * The dimension of the game.
	 */
	private final Dimension gamedimension = new Dimension(width,height);
	
	/**
	 * Creates a game window.
	 * @param title The title of the window.
	 * @param icon The icon used for the program.
	 */
	public GameWindow(final String title, final Image icon) {
		super();
		this.setSize(gamedimension);
		final boolean visible = true;
		this.setTitle(title);
		this.setIconImage(icon);
		this.setVisible(visible);
	}

	@Override
	public void setDefaultMainMenu() {
		final Menu menu = new Menu(width, height, false);
		this.setScreen(menu);
	}
	
	/**
	 * Returns the new GameWindow that has the given title and icon.
	 * @param title The title of the window.
	 * @param loc The location of the icon. As specified by maven.
	 * @return A new GameWindow object.
	 * @throws IOException If the icon can not be read.
	 */
	public static GameWindow createWindow(final String title,
			final String loc) throws IOException {
		final URL iconurl = Launcher.class.getResource(loc);
		final Image icon = ImageIO.read(iconurl);
		return new GameWindow(title, icon);
	}
}
