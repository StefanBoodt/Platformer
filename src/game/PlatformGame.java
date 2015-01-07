package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

/**
 * The platform game played.
 * 
 * @since 04-11-2014
 * @version 04-11-2014
 * 
 * @see Game
 * 
 * @author stefanboodt
 *
 */
public class PlatformGame extends Game {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = -4570740718284182890L;
	
	/**
	 * The heros in the game.
	 */
	private final List<Hero> heros;
	
	/**
	 * Creates a platform game.
	 * @param heros The heros of the game.
	 */
	public PlatformGame(Hero...heros) {
		this(Arrays.asList(heros));
	}
	
	/**
	 * Creates a platform game.
	 * @param heros The heros of the game.
	 */
	public PlatformGame(List<Hero> heros) {
		this.heros = heros;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(100, 200, 500, 400);
	}
	
	@Override
	public void update() {
		if (!(this.isPaused())) {
			final long passed = this.getElapsedTime();
			repaint();
		}
	}
}
