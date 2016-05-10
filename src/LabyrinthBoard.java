import java.util.Random;

/**
 * The board on which the labyrinth game is played
 * 
 * @author georgela
 */
public class LabyrinthBoard
{
	
	/**
	 * The standard size of a Labyrinth board, in rows and columns
	 */
	public static final int GRID_SIZE = 7;

	
	/**
	 * The name of the current game's tiles table
	 */
	private final Tile[][] currentTiles;
	
	/**
	 * A set containing all the mobile tiles for a labyrinth board
	 */
	private final SetOfTiles currentSetOfTiles;
	
	/**
	 * Create the board and place randomly movable tiles across it
	 */
	public LabyrinthBoard()
	{
		// TODO (done) think about it: currentBoard is declared as a local variable, it
		// can not be used
		// outside the constructor.
		
		this.currentTiles = new Tile[GRID_SIZE][GRID_SIZE];
		this.currentSetOfTiles = new SetOfTiles();
		
		this.initFixedTiles();
		
		
		this.initMobileTiles();
		
	}

	/**
	 * Initialize all fixed tiles at their respective positions with all their respective characteristics
	 */
	public void initFixedTiles()
	{
		int k=12;
		
		this.currentTiles[0][0] = new Tile(4, 0, false, 1);
		this.currentTiles[0][6] = new Tile(5, 0, false, 2);
		this.currentTiles[6][0] = new Tile(3, 0, false, 3);
		this.currentTiles[6][6] = new Tile(6, 0, false, 4);
		
		this.currentTiles[0][2] = new Tile(8, ++k, false);
		this.currentTiles[0][4] = new Tile(8, ++k, false);
		this.currentTiles[6][2] = new Tile(10, ++k, false);
		this.currentTiles[6][4] = new Tile(10, ++k, false);
		this.currentTiles[2][0] = new Tile(7, ++k, false);
		this.currentTiles[4][0] = new Tile(7, ++k, false);
		this.currentTiles[2][6] = new Tile(9, ++k, false);
		this.currentTiles[4][6] = new Tile(9, ++k, false);
		this.currentTiles[2][2] = new Tile(8, ++k, false);
		this.currentTiles[2][4] = new Tile(9, ++k, false);
		this.currentTiles[4][2] = new Tile(7, ++k, false);
		this.currentTiles[4][4] = new Tile(10, ++k, false);
	}
	
	/**
	 * For each row of the table :
	 *    if row number is even
	 *       only tiles on odd numbers lines are to be filled
	 *       fill them with a random tile form the set of mobile tiles
	 *    else
	 *       fill the whole row with tiles from the set of mobile tiles   
	 */
	private void initMobileTiles()
	{
		Random random = new Random();
		int k, i=0;
		
		while (i < 7){
			if (i%2 == 0){
				k=1;
				while (k < 7){
					this.currentTiles[i][k] = this.currentSetOfTiles.take(random.nextInt(this.currentSetOfTiles.length()-1));
					k=k+2;
				}
			}
			else{
				k=0;
				while (k < 7){
					this.currentTiles[i][k] = this.currentSetOfTiles.take(random.nextInt(this.currentSetOfTiles.length()-1));
					k=k+1;
				}
			}
		i=i+1;
		}
	}
	
	public void displayBoardStatus(){
		for (int i=0; i < GRID_SIZE; i++)
			for (int k=0; k < GRID_SIZE; k++)
				System.out.println(this.currentTiles[i][k].toString());
	}

	public void displayMoveStatus(){
		for (int i=0; i < GRID_SIZE; i++)
			for (int k=0; k < GRID_SIZE; k++)
				System.out.println(this.currentTiles[i][k].isMoveable());
	}
	
	public void displayWallStatus(){
		for (int i=0; i < GRID_SIZE; i++)
			for (int k=0; k < GRID_SIZE; k++)
				System.out.println(this.currentTiles[i][k].getWall());
	}
	
	public void displaySpawnStatus(){
		for (int i=0; i < GRID_SIZE; i++)
			for (int k=0; k < GRID_SIZE; k++)
				System.out.println(this.currentTiles[i][k].getSpawn());
	}
	
	public void displayTreasureStatus(){
		for (int i=0; i < GRID_SIZE; i++)
			for (int k=0; k < GRID_SIZE; k++)
				if (this.currentTiles[i][k].getTreasure() != 0){
					System.out.println(this.currentTiles[i][k].getTreasure());
				}
				
	}
	
	public void displayRemainingTile()
	{
		System.out.println(this.currentSetOfTiles.length());
		
		
	}
}
