package level;

import collection.World;
import level.Level;

/**
 * This level encapsulates a level in the platform game. It contains both a
 * start and a finish and includes a number of enemies to kill.
 * 
 * @since 03-11-2014
 * @version 03-11-2014
 * 
 * @see Level
 * @see World
 * 
 * @author stefanboodt
 *
 */
public class PlatformLevel extends Level {

	/**
	 * The number of the level.
	 */
	private final int levelnumber;
	
	/**
	 * Creates a level with the given number.
	 * @param worldnumber The number of the world.
	 * @param levelnumber The number of the level.
	 */
	public PlatformLevel(int worldnumber, int levelnumber) {
		this(worldnumber, levelnumber, "");
	}
	
	/**
	 * Creates a platform level with the given name.
	 * @param worldnumber The number of the world.
	 * @param levelnumber The number of the level.
	 * @param name The name of the level.
	 */
	public PlatformLevel(int worldnumber, int levelnumber, String name) {
		super(worldnumber + "-" + levelnumber + " "+ name);
		this.levelnumber = levelnumber;
	}
	
	/**
	 * Returns the level number.
	 * @return The number of the level.
	 */
	public int getLevelNumber() {
		return levelnumber;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
	}

}
