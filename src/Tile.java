// TODO clean comment
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

	// TODO detail comment (not very understandable)
	/**
	 * The spawn attribute of a moveable tile (never a spawn)
	 */
	private static final int DEFAULT_SPAWN = 0;
	
	// TODO write comment
	private int orientation;

	// TODO write comment
	private int treasure;
	
	// TODO write comment
	private boolean moveable;
	
	// TODO write comment
	private int spawn;
	
	// TODO write comment
	Tile(int orientation, int treasure)
	{
		this.orientation = orientation;
		this.treasure = treasure;
		this.moveable = DEFAULT_MOVEABLE;
		this.spawn = DEFAULT_SPAWN;
	}
	
	// TODO write comment
	Tile(int orientation, int treasure, boolean moveable, int spawn)
	{
		this.orientation = orientation;
		this.treasure = treasure;
		this.moveable = moveable;
		this.spawn = spawn;
	}
}
