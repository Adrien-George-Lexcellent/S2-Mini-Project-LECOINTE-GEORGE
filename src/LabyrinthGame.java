/**
 * A Labyrinth game
 * Labyrinth game rules : https://www.ravensburger.com/uk/games/family-games/labyrinth/index.html
 * @author georgela
 * 
 */
public class LabyrinthGame
{

	// TODO  update comment (what is an "initialized" board?)
	/**
	 * create a new labyrinth game, initialize the game board and make the game ready to be played
	 */
	public LabyrinthGame()
	{
		LabyrinthBoard currentBoard = new LabyrinthBoard();
		
		// TODO what is the purpose of this field, it does not appear in constructor's specs?
		LabyrinthDeck currentDeck = new LabyrinthDeck();
	}
	
	// TODO detail comment (what is the main algorithm?)
	/**
	 * Launch the labyrinth 
	 */
	public void play()
	{
		System.out.println("The game just started");
		/* Actions realized during the game */
		// TODO fix debug message
		System.out.println("The game just started");
	}
	
}
