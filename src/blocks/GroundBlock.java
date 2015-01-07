package blocks;

import game.GameObject;
import game.Hero;
import game.PlatformGame;
import gui.GameWindow;

import java.awt.*;
import java.awt.geom.Line2D;
import java.net.URL;

import javax.swing.ImageIcon;

public class GroundBlock extends Block {

	private static Image img;
	
	public GroundBlock(int x, int y) {
		super(x, y);
		loadImage();
	}

	@Override
	public boolean isVisible() {
		return getX() >= 0 && getX() <= GameWindow.WIDTH;
	}

	@Override
	public void draw(Graphics g) {
		if (isVisible()) {
			g.drawImage(img, (int) getX(), (int) getY(), null);
		}
	}

	@Override
	public void hit(Hero hitter) {
		hitter.setDY(0);
		
	}

	@Override
	public void hit(GameObject hitter) {
		if (hitter instanceof Hero) {
			this.hit((Hero) hitter); 
		}
	}

	/**
	 * {@inheritDoc}
	 * Does nothing.
	 */
	@Override
	public void die() {
		
	}

	/**
	 * {@inheritDoc}
	 * This method returns {@link Integer#MAX_VALUE} as default argument.
	 */
	@Override
	public int getRemainingHits() {
		return Integer.MAX_VALUE;
	}
	
	/**
	 * Loads a image if none is loaded yet.
	 */
	protected void loadImage() {
		if (img == null) {
			URL imageURL = GroundBlock.class.getResource("groundblock.png");
			img = new ImageIcon(imageURL).getImage();
		}
	}
}
