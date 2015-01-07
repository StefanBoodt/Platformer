package blocks;

import game.GameObject;
import game.Hero;

import java.awt.*;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * A block that is usually found on or in the ground. This is a type of
 * block that does not have much gimmicks and is found on a really regular
 * basis. It has an easy to calm look that does not distract the player much.
 * 
 * @since 07-01-2015
 * @version 07-01-2015
 * 
 * @see Block
 * @see Image
 * @see GameObject
 * 
 * @author stefanboodt
 *
 */
public class GroundBlock extends Block {

	private static Image img;
	
	public GroundBlock(int x, int y) {
		super(x, y);
		loadImage();
	}
	
	public GroundBlock(Block block) {
		super(block);
		loadImage();
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
	
	@Override
	public Block clone() {
		return new GroundBlock(this);
	}
}
