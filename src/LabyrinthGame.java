/**
 * A Labyrinth game
 * Labyrinth game rules : https://www.ravensburger.com/uk/games/family-games/labyrinth/index.html
 * @author georgela
 * 
 */
public class LabyrinthGame
{
	/**
	 * prepare a new labyrinth game, create a new game board and a new shuffled deck of treasure cards
	 */
	public LabyrinthGame()
	{
		// TODO think about it: why creating new object that are unusable after?
		new LabyrinthBoard();
	
		new LabyrinthDeck();
	}
	
	/**
	 * Until the game isn't finished{
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
	 *     the current player's turn ends and the turn of the next player	start 	 
	 *     }
	 *   }
	 * display highest score player with his score
	 */
	public void play()
	{
		System.out.println("The game just started");
		/* Actions realized during the game */
		System.out.println("The game just ended");
	}
	
}
