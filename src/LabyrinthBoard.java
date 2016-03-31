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
	
	private final SetOfTiles currentSetOfTiles;
	
	/**
	 * Create the board and place randomly movable tiles across it
	 */
	public LabyrinthBoard()
	{
		// TODO (done) think about it: currentBoard is declared as a local variable, it
		// can not be used
		// outside the constructor.
		
		currentTiles = new Tile[7][7];
		currentSetOfTiles = new SetOfTiles();
		
		this.initFixedTiles();
		
		
		this.initMobileTiles();
		
	}

	public void initFixedTiles()
	{
		this.currentTiles[0][0] = new Tile(4, 0, false, 1);
		this.currentTiles[0][6] = new Tile(5, 0, false, 2);
		this.currentTiles[6][0] = new Tile(3, 0, false, 3);
		this.currentTiles[6][6] = new Tile(6, 0, false, 4);
		
		this.currentTiles[0][2] = new Tile(8, 11, false, 0);
		this.currentTiles[0][4] = new Tile(8, 2, false, 0);
		this.currentTiles[6][2] = new Tile(10, 9, false, 0);
		this.currentTiles[6][4] = new Tile(10, 24, false, 0);
		this.currentTiles[2][0] = new Tile(7, 23, false, 0);
		this.currentTiles[4][0] = new Tile(7, 21, false, 0);
		this.currentTiles[2][6] = new Tile(9, 18, false, 0);
		this.currentTiles[4][6] = new Tile(9, 14, false, 0);
		this.currentTiles[2][2] = new Tile(8, 7, false, 0);
		this.currentTiles[2][4] = new Tile(9, 3, false, 0);
		this.currentTiles[4][2] = new Tile(7, 13, false, 0);
		this.currentTiles[4][4] = new Tile(10, 4, false, 0);
	}
	
	
	
	private void initMobileTiles()
	{
		int k, i=0;
		
		while (i <= 6){
			if (i%2 == 0){
				k=1;
				while (k<=6){
					//traitement de la case
					k=k+2;
				}
			}
			else{
				k=0;
				while (k<=6){
					//traitement de la case
					k=k+1;
				}
			}
		i=i+1;
		}
	}
	
	
}
