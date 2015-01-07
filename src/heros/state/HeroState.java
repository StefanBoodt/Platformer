package heros.state;

import heros.AbstractHero;

import java.awt.Graphics;

import animations.Sprite;

/**
 * This class contains the Hero state.
 * 
 * @since 08-11-2014
 * @version 08-11-2014
 * 
 * @see Hero
 * @see Sprite
 * 
 * @author stefanboodt
 *
 */
public abstract class HeroState {
	
	/**
	 * The Sprite used.
	 */
	private Sprite sprite;
	
	/**
	 * Default hero states.
	 */
	private HeroState small, Super;
	
	/**
	 * Creates a new HeroState with the given sprite.
	 * @param sprite The sprite used.
	 */
	public HeroState(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Gets the amount of hits the player has left.
	 * @return The amount of hits left.
	 */
	public abstract int getRemainingHits();
	
	/**
	 * Makes the player hit.
	 */
	public abstract void hit();
	
	/**
	 * Draws the hero.
	 * @param g The hero that should be drawn.
	 * @param hero The hero to draw.
	 */
	public abstract void draw(Graphics g, AbstractHero hero);
	
	/**
	 * Sets the x to the given value.
	 * @param x The x used.
	 */
	public void setX(float x) {
		sprite.setX(x);
	}
	
	/**
	 * Sets the y to the given value.
	 * @param y The y used.
	 */
	public void setY(float y) {
		sprite.setY(y);
	}
	
	/**
	 * Gets the x used.
	 * @param x The x used.
	 */
	public float getX() {
		return sprite.getX();
	}
	
	/**
	 * Gets the y value.
	 * @return The y used.
	 */
	public float getY() {
		return sprite.getY();
	}
	
	/**
	 * Updates the hero state to be elapsedTime further than it was
	 * at the last update.
	 * @param elapsedTime The time that has elapsed.
	 */
	public void update(long elapsedTime) {
		sprite.update(elapsedTime);
	}
}
