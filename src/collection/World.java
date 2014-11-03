package collection;

import java.util.HashSet;
import java.util.Set;

import level.Level;

/**
 * The World class is a class that contains multiple levels. It also allows
 * players to select the levels and start playing them. It also knows what
 * to do when the player selects a level.
 * 
 * @since 31-10-2014
 * @version 31-10-2014
 * 
 * @see Level
 * 
 * @author stefanboodt
 *
 */
public class World {
	
	/**
	 * The collection of levels of this world.
	 */
	private Set<Level> levels;

	/**
	 * Creates a world with an empty set.
	 */
	public World() {
		this(new HashSet<Level>());
	}
	
	/**
	 * Creates a world with the given levels.
	 * @param levels The levels in this world.
	 */
	public World(Set<Level> levels) {
		setLevels(levels);
	}
	
	/**
	 * Sets the levels to the given value.
	 * @param levels The levels in this world.
	 */
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}
}
