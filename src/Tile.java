/**
 * The tiles composing the Labyrinth board
 * @author georgela
 */
public class Tile
{
	/**
	 * The moveable attribute of a moveable tile (always moveable)
	 */
	private static final boolean DEFAULT_MOVEABLE = true;

	/**
	 * No moveable tile is a player spawn
	 */
	private static final int DEFAULT_SPAWN = 0;
	
	/**
	 * A value between 0 and 10, representing the category and rotation of the tile
	 */
	private int wall;

	/**
	 * A value between 0 and 24 representing the treasure present on the tile (0 : no treasures on the tile, 1-24 : the index of the treasure)
	 */
	private int treasure;
	
	/**
	 * Represent the ability of a tile to glide on the board (o = fix, 1 = mobile)
	 */
	private boolean moveable;
	
	/**
	 * Represent if whether or not a player start the game on this tile (0 : no, 1-4 : player number)
	 */
	private int spawn;
	
	/**
	 * The lite builder, creating mobile, non-spawn tiles, carrying a treasure or not, based on the category of tiles, used for all the mobile tiles. 
	 * @param wall
	 * @param treasure
	 */
	Tile(int wall, int treasure)
	{
		this.wall = wall;
		this.treasure = treasure;
		this.moveable = DEFAULT_MOVEABLE;
		this.spawn = DEFAULT_SPAWN;
	}
	
	/**
	 * The non-spawn location builder, creating a tile without player starting location and with all it's other attributes specified in the parameters, used for almost all the fixed tiles (at the only exception of spawn tiles)
	 * @param wall
	 * @param treasure
	 * @param moveable
	 */
	Tile(int wall, int treasure, boolean moveable)
	{
		this.wall = wall;
		this.treasure = treasure;
		this.moveable = moveable;
		this.spawn = DEFAULT_SPAWN;
	}

	/**
	 * The full builder, creating a tile with all it's attributes specified in the parameters, only for spawn locations
	 * @param wall
	 * @param treasure
	 * @param moveable
	 * @param spawn
	 */
	Tile(int wall, int treasure, boolean moveable, int spawn)
	{
		this.wall = wall;
		this.treasure = treasure;
		this.moveable = moveable;
		this.spawn = spawn;
	}
	
	public int getWall()
	{
		return wall;
	}

	public int getTreasure()
	{
		return treasure;
	}

	public boolean isMoveable()
	{
		return moveable;
	}

	public int getSpawn()
	{
		return spawn;
	}

	public String toString()
	{
		String asciiTile;
		String asciiTileContent;
		String asciiTileSpawn;
		String asciiTileTreasure;
		
		if (this.spawn == 0){
			asciiTileSpawn = "  ";
		}
		else {
			asciiTileSpawn = " " + this.spawn;
		}
		
		if (this.treasure == 0){
			asciiTileTreasure = "  ";
		}
		else{
			if (this.treasure <10){
				asciiTileTreasure = "0" + this.treasure;
			}
			else{
				asciiTileTreasure = "" + this.treasure;
			}
		}
		
		if ( this.wall == 0){
			asciiTileContent = "|" + asciiTileTreasure + " " + asciiTileSpawn + "|\n|-----|\n|     |";
		}
		if ( this.wall == 1){
			asciiTileContent = "|" + asciiTileTreasure + "|" + asciiTileSpawn + "|\n|  |  |\n|  |  |";
		}
		if ( this.wall == 2){
			asciiTileContent = "|" + asciiTileTreasure + "|" + asciiTileSpawn + "|\n|  +--|\n|     |";
		}
		if ( this.wall == 3){
			asciiTileContent = "|" + asciiTileTreasure + " " + asciiTileSpawn + "|\n|  +--|\n|  |  |";
		}
		if ( this.wall == 4){
			asciiTileContent = "|" + asciiTileTreasure + " " + asciiTileSpawn + "|\n|--+  |\n|  |  |";
		}
		if ( this.wall == 5){
			asciiTileContent = "|" + asciiTileTreasure + "|" + asciiTileSpawn + "|\n|--+  |\n|     |";
		}
		if ( this.wall == 6){
			asciiTileContent = "|" + asciiTileTreasure + "|" + asciiTileSpawn + "|\n|  +--|\n|  |  |";
		}
		if ( this.wall == 7){
			asciiTileContent = "|" + asciiTileTreasure + " " + asciiTileSpawn + "|\n|--+--|\n|  |  |";
		}
		if ( this.wall == 8){
			asciiTileContent = "|" + asciiTileTreasure + "|" + asciiTileSpawn + "|\n|--+  |\n|  |  |";
		}
		else {
			asciiTileContent = "|" + asciiTileTreasure + "|" + asciiTileSpawn + "|\n|--+--|\n|     |";
		}
		
		if (this.moveable == true){
			asciiTile = "+-----+\n"+asciiTileContent+"\n+-----+";
		}
		else {
			asciiTile = "O-----O\n"+asciiTileContent+"\nO-----O";
		}
		

		return asciiTile;
	}
}
