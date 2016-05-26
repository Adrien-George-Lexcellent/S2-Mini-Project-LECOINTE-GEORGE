import java.util.Random;
/**
 * The board on which the labyrinth game is played
 * 
 * @author georgela
 */
public class LabyrinthBoard
{

	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	public static final int RIGHT_UP = 2;
	public static final int RIGHT_DOWN = 3;
	public static final int LEFT_DOWN = 4;
	public static final int LEFT_UP = 5;
	public static final int VERTICAL_RIGHT = 6;
	public static final int HORIZONTAL_DOWN = 7;
	public static final int VERTICAL_LEFT = 8;
	public static final int HORIZONTAL_UP = 9;

	
	
	// TODO (done) add javadoc comment
	/**
	 * The standard size of a Labyrinth board, in rows and columns
	 */
	public static final int GRID_SIZE = 7;

	
	/**
	 * The name of the current game's tiles table
	 */
	private final Tile[][] currentTiles;
	
	// TODO (done) add javadoc comment
	/**
	 * A set containing all the mobile tiles for a labyrinth board
	 */
	private final SetOfTiles currentSetOfTiles;
	
	/**
	 * Create the board and place randomly movable tiles across it
	 */
	public LabyrinthBoard()
	{
		
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
		
		this.currentTiles[0][0] = new Tile(RIGHT_DOWN, 0, false, 1);
		this.currentTiles[0][6] = new Tile(LEFT_DOWN, 0, false, 2);
		this.currentTiles[6][0] = new Tile(RIGHT_UP, 0, false, 3);
		this.currentTiles[6][6] = new Tile(LEFT_UP, 0, false, 4);
		
		this.currentTiles[0][2] = new Tile(HORIZONTAL_DOWN, ++k, false);
		this.currentTiles[0][4] = new Tile(HORIZONTAL_DOWN, ++k, false);
		this.currentTiles[6][2] = new Tile(HORIZONTAL_UP, ++k, false);
		this.currentTiles[6][4] = new Tile(HORIZONTAL_UP, ++k, false);
		this.currentTiles[2][0] = new Tile(VERTICAL_RIGHT, ++k, false);
		this.currentTiles[4][0] = new Tile(VERTICAL_RIGHT, ++k, false);
		this.currentTiles[2][6] = new Tile(VERTICAL_LEFT, ++k, false);
		this.currentTiles[4][6] = new Tile(VERTICAL_LEFT, ++k, false);
		this.currentTiles[2][2] = new Tile(HORIZONTAL_DOWN, ++k, false);
		this.currentTiles[2][4] = new Tile(VERTICAL_LEFT, ++k, false);
		this.currentTiles[4][2] = new Tile(VERTICAL_RIGHT, ++k, false);
		this.currentTiles[4][4] = new Tile(HORIZONTAL_UP, ++k, false);
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
		// TODO declare literals as constants
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
	
	public void insertTile(int line, int column) throws NotABorderTileException, NotAMoveableTileException {
		int lineTempTile;
		int columnTempTile;
		Tile tempTile;
		
		if ((line!=0 && line!=6) && (column!=0 && column!=6)){
			throw new NotABorderTileException();
		}
		if (!this.currentTiles[column][line].isMoveable()){
			throw new NotAMoveableTileException();
		}
		
		if (line==0){
			lineTempTile = GRID_SIZE-1;
		}
		else{
			if (line==6){
				lineTempTile = 0;
			}
			else{
				lineTempTile = line;
			}
		}
		
		if (column==0){
			columnTempTile = column+(GRID_SIZE-1);
		}
		else{
			if (column==6){
				columnTempTile = column-(GRID_SIZE-1);
			}
			else{
				columnTempTile = column;
			}
		}
		System.out.println(this.currentTiles[lineTempTile][columnTempTile].toString());
		tempTile = this.currentTiles[lineTempTile][columnTempTile];
		
		
		if (line%2==0){
			if (line==0){
				for (int i=GRID_SIZE-1; i>0; i--){
					currentTiles[i][column] = currentTiles[i-1][column];
				}
			}
			else{
				for (int i=0; i<GRID_SIZE-1; i++){
					currentTiles[i][line] = currentTiles[i+1][line];
				}
			}
		}
		else{
			if (column==0){
				for (int i=GRID_SIZE-1; i>0; i--){
					currentTiles[line][i] = currentTiles[line][i-1];
				}
			}
			else{
				for (int i=0; i<GRID_SIZE-1; i++){
					currentTiles[line][i] = currentTiles[line][i+1];
				}
			}
		}
		
		currentTiles[line][column] = this.currentSetOfTiles.take(0);
		
		this.currentSetOfTiles.store(tempTile);
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
		System.out.println(this.currentSetOfTiles.consult(0).toString());
	}
	
	public String toString()
	{
		String asciiBoard = "";
		
		for (int i=0; i<GRID_SIZE; i++){
			for (int line=0; line<5; line++){
				for (int k=0; k<GRID_SIZE; k++){
					asciiBoard += this.currentTiles[i][k].toString().split("\n")[line];
				}
				asciiBoard += "\n";
			}
			//asciiBoard += "\n";
		}
		return asciiBoard;
	}
}
