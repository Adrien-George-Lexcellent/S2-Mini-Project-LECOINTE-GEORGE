/**
 * A Labyrinth game
 * Labyrinth game rules : https://www.ravensburger.com/uk/games/family-games/labyrinth/index.html
 * @author georgela
 * 
 */
public class LabyrinthGame
{
	/**
	 * the game board of the current game
	 */
	private final LabyrinthBoard currentBoard;
	
	/**
	 * the game deck of a current game
	 */
	private final LabyrinthDeck currentDeck;	
	
	/**
	 * prepare a new labyrinth game, create a new game board and a new shuffled deck of treasure cards
	 */
	public LabyrinthGame()
	{
		this.currentBoard = new LabyrinthBoard();
		this.currentDeck = new LabyrinthDeck();
	}
	
	// TODO rewrite main algorithm considering that only 
	// this method has control on what happens
	/**
	 * Until the game is finished{
	 *   DO
	 *   for each player{
	 *     the current player receive the remaining labyrinth piece
	 *     the current player is asked for a location to insert the labyrinth piece
	 *     while a objective treasure can be reached{
	 *       current player character is moved to treasure labyrinth piece
	 *       current player's objective treasure card is discarded
	 *       current player score is incremented
	 *       }
	 *     for each current player's card discarded{
	 *       if the treasure card deck is empty : return
	 *       else : a card from the deck is drawn and added to 
	 *       }
	 *     the current player's turn ends and the turn of the next player start 	 
	 *     }
	 *   }
	 * display highest score player with his score
	 */
	public void play()
	{
		System.out.println("The game just started");
		System.out.println(this.currentBoard);
		/* Actions realized during the game */
		System.out.println("The game just ended");

	}
	
}
