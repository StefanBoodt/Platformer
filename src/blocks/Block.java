package blocks;

import game.*;
import gui.GameWindow;

import java.awt.Rectangle;
import java.awt.geom.*;

/**
 * The class all blocks must extend from.
 * 
 * @since 05-11-2014
 * @version 07-01-2015
 * 
 * @see Rectangle
 * @see Image
 * @see Cloneable
 * 
 * @author stefanboodt
 *
 */
public abstract class Block implements GameObject, Cloneable {

	/**
	 * The rectangle of the block.
	 */
	private Rectangle rectangle;
	
	/**
	 * X and Y position.
	 */
	private float x, y;
	
	/**
	 * width and height of the block. There can be 10 blocks horizontal
	 * and 15 blocks vertical in the screen.
	 */
	public static final int WIDTH = GameWindow.WIDTH / 15,
			HEIGHT = GameWindow.HEIGHT / 10;
	
	/**
	 * Creates a block with the given x and y position.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public Block(float x, float y) {
		this((int) x, (int) y);
		setLocation(x, y);
	}
	
	/**
	 * Creates a block with the given x and y position.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public Block(int x, int y) {
		this(new Rectangle(x,y,WIDTH, HEIGHT));
	}
	
	/**
	 * Creates a new block with the same location as this one.
	 * @param block The block to copy the location of.
	 */
	public Block(Block block) {
		this(block.x, block.y);
	}
	
	/**
	 * Creates a block with the given rectangle.
	 * @param rectangle The rectangle to be used.
	 */
	public Block(Rectangle rectangle) {
		rectangle.height = HEIGHT;
		rectangle.width = WIDTH;
		setRectangle(rectangle);
		setLocation(rectangle.getX(),rectangle.getY());
	}
	
	/**
	 * Sets the location of this Block.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
		rectangle.setLocation((int) x, (int) y);
	}
	
	/**
	 * Sets the location of this Block.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public void setLocation(double x, double y) {
		setLocation((float) x, (float) y);
	}

	/**
	 * Returns the rectangle.
	 * @return the rectangle of the block.
	 */
	public Rectangle getRectangle() {
		return rectangle;
	}

	/**
	 * Sets the rectangle of the block.
	 * @param rectangle the new rectangle.
	 */
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Block) {
			Block that = (Block) other;
			return this.getClass().equals(that.getClass())
					&& this.getRectangle().equals(that.getRectangle());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getRectangle().hashCode();
	}

	@Override
	public void move(float dx, float dy) {
		this.setLocation(getX() + dx, getY() + dy);
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getWidth() {
		return WIDTH;
	}

	@Override
	public float getHeight() {
		return HEIGHT;
	}
	
	/**
	 * Checks if the block is hit from below.
	 * @param hitter The object that hit the block.
	 * @return true if the block is hit by the given object.
	 */
	public boolean isHitFromBelow(GameObject hitter) {
		final float maxY = getY() + getHeight();
		Line2D line = new Line2D.Float(getX(), maxY,
				getX() + getWidth(), maxY);
		return hitter.intersects(line);
	}
	
	/**
	 * Checks if the block is hit from above.
	 * @param hitter The object that hit the block.
	 * @return true if the block is hit by the given object.
	 */
	public boolean isHitFromAbove(GameObject hitter) {
		Line2D line = new Line2D.Float(getX(), getY(),
				getX() + getWidth(), getY());
		return hitter.intersects(line);
	}
	
	@Override
	public boolean isVisible() {
		return getX() >= 0 && getX() <= GameWindow.WIDTH;
	}
	
	@Override
	public boolean intersects(Line2D line) {
		return getRectangle().intersectsLine(line);
	}
	
	/**
	 * Method to be called when the block is hit.
	 * @param hitter The hero that hit the block.
	 */
	public abstract void hit(Hero hitter);
	
	@Override
	public abstract Block clone();
}
