package heros;

import java.awt.Graphics;

import game.GameObject;
import game.Hero;
import heros.state.HeroState;

/**
 * Abstract class providing default functionality for the Heros
 * for this game.
 * 
 * @since 04-11-2014
 * @version 07-01-2015
 * 
 * @see Hero
 * 
 * @author stefanboodt
 *
 */
public abstract class AbstractHero implements Hero {
	
	/**
	 * The amount of lives lost.
	 */
	private int lives;
	
	/**
	 * The state the hero is in.
	 */
	private HeroState state;
	
	/**
	 * Creates an Abstract hero.
	 */
	public AbstractHero() {
		super();
	}
	
	@Override
	public void hit(GameObject hitter) {
		
	}

	@Override
	public void die() {
		lives--;
	}

	@Override
	public int getRemainingHits() {
		return state.getRemainingHits();
	}

	@Override
	public void move(float dx, float dy) {
		state.setX(state.getX() + dx);
		state.setY(state.getY() + dy);
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		state.draw(g, this);
	}
	
	@Override
	public void update(long elapsedTime) {
		state.update(elapsedTime);
	}
}
