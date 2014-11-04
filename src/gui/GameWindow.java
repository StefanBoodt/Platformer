package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

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
	 * @param icons The icons used for the program.
	 */
	public GameWindow(final String title, final Image... icons) {
		super();
		this.setSize(gamedimension);
		List<Image> images = new ArrayList<Image>();
		for (Image icon: icons) {
			images.add(icon);
		}
		this.setIconImages(images);
		final boolean visible = true;
		this.setTitle(title);
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
			final String... locs) throws IOException {
		final int len = locs.length;
		Image[] icons = new Image[len];
		for (int i = 0; i < len; i++) {
			final URL iconurl = GameWindow.class.getResource(locs[i]);
			final Image icon = new ImageIcon(iconurl).getImage();
			icons[i] = icon;
		}
		return new GameWindow(title, icons);
	}
}
