
/**
 * The tiles that are composing the Labyrinth board
 * @author georgela
 */
public class Tile
{
	/**
	 * The moveable attribute of a moveable tile (always moveable)
	 */
	private static final boolean DEFAULT_MOVEABLE = true;
	/**
	 * The spawn attribute of a moveable tile (never a spawn)
	 */
	private static final int DEFAULT_SPAWN = 0;
	
	private int orientation;
	private int treasure;
	private boolean moveable;
	private int spawn;
	
	
	Tile(int orientation, int treasure)
	{
		this.orientation = orientation;
		this.treasure = treasure;
		this.moveable = DEFAULT_MOVEABLE;
		this.spawn = DEFAULT_SPAWN;
	}
	
	Tile(int orientation, int treasure, boolean moveable, int spawn)
	{
		this.orientation = orientation;
		this.treasure = treasure;
		this.moveable = moveable;
		this.spawn = spawn;
	}
}
