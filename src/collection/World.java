package collection;

import java.util.HashMap;
import java.util.Map;

import level.Level;
import level.PlatformLevel;

/**
 * The World class is a class that contains multiple levels. It also allows
 * players to select the levels and start playing them. It also knows what
 * to do when the player selects a level.
 * 
 * @since 31-10-2014
 * @version 03-11-2014
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
	private Map<Integer, PlatformLevel> levels;
	
	/**
	 * The world number. This number should be unique.
	 */
	private final int worldnumber;

	/**
	 * Creates a world with an empty set.
	 * @param worldnumber The number the world has.
	 */
	public World(int worldnumber) {
		this(worldnumber, new HashMap<Integer, PlatformLevel>());
	}
	
	/**
	 * Creates a world with the given levels.
	 * @param worldnumber The number the world has.
	 * @param levels The levels in this world.
	 */
	public World(int worldnumber, Map<Integer, PlatformLevel> levels) {
		setLevels(levels);
		this.worldnumber = worldnumber;
	}
	
	/**
	 * Sets the levels to the given value.
	 * @param levels The levels in this world.
	 */
	public void setLevels(Map<Integer, PlatformLevel> levels) {
		this.levels = levels;
	}
	
	/**
	 * Returns the levels used.
	 * @return The levels used.
	 */
	public Map<Integer, PlatformLevel> getLevels() {
		return levels;
	}
	
	/**
	 * Plays the level with the given name.
	 * @param levelname The name of the level.
	 */
	public void playLevel(Integer levelnumber) {
		getLevels().get(levelnumber).start();
	}
	
	/**
	 * Plays the level with the given name.
	 * @param levelname The name of the level.
	 */
	public void playLevel(int levelnumber) {
		playLevel(new Integer(levelnumber));
	}
	
	/**
	 * Gets the number of the world currently played.
	 * @return The world number.
	 */
	public int getWorldNumber() {
		return worldnumber;
	}
	
	/**
	 * Adds the given level to the world.
	 * @param level The level to add.
	 */
	public void addLevel(PlatformLevel level) {
		getLevels().put(level.getLevelNumber(), level);
	}
}
