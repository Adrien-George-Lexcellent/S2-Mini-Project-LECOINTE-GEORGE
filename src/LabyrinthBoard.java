/**
 * The board on which the labyrinth game is played
 * 
 * @author georgela
 */
public class LabyrinthBoard
{
	/**
	 * The name of the current game's tiles table
	 */
	private final Tile[][] currentTiles;
	/**
	 * Create the board and place randomly movable tiles across it
	 */
	public LabyrinthBoard()
	{
		// TODO (done) think about it: currentBoard is declared as a local variable, it
		// can not be used
		// outside the constructor.
		currentTiles = new Tile[7][7];
		
		
		
	}
}
