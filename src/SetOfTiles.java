import java.util.ArrayList;
import java.util.Random;

// TODO (done) add javadoc comment
/**
 * A class representing a given set of the 32 moveable Tiles you get at the very beginning of every Labyrinth Game 
 * @author georgela
 */
public class SetOfTiles
{
	private static final int TOTAL_OF_MOVEABLE_CARDS = 34;
	private static final int NUMBER_OF_CORRIDORS = 12;
	private static final int NUMBER_OF_BENDS = 16;
	private static final int NUMBER_OF_CROSSINGS = 6;
	private static final int NUMBER_OF_BENDS_WITH_TREASURES = 6;
			
	
	// TODO (done) add javadoc comment
	/**
	 * The list in which the tiles tiles are stocked
	 */
	private final ArrayList<Tile> ListOfTiles;
		
	// TODO (done) add javadoc comment
	/**
	 * The builder of a Set of Tiles creating the frame of the class and calling a method to fill randomly the newly created Tiles List with Tiles matching the Labyrinth Games rules
	 */
	public SetOfTiles(){
		this.ListOfTiles = new ArrayList<Tile>();
		
		this.fillSetOfTiles();		
	}
	
	/**
	 * create the exhaustive list of all the mobile tiles that have to be affected
	 * 
	 * initialize a new pseudo-random number generator
	 * create the first 12 cards as straight corridors, with no treasures
	 * while i>=12 but still <28,
	 *    if  less than 6 angled corridors with treasures have been created 
	 *       create an angled corridors with the treasure whose index is 'k'
	 *    else
	 *       create an angled corridors without treasure
	 * then for the last 6 tiles (28 included to 34 excluded), create a three-way tile always with a treasure (whose index is in [6,11]) 
	 */
	private void fillSetOfTiles(){
		
		Random random = new Random(); 
		int k=1;
		
		// TODO (done) declare literals as constants

		for (int i=0; i < TOTAL_OF_MOVEABLE_CARDS; i++){
			if (i<NUMBER_OF_CORRIDORS){
				this.ListOfTiles.add(i, new Tile(random.nextInt(2), 0));
			}
			else {
				if (i<NUMBER_OF_CORRIDORS+NUMBER_OF_BENDS){
					if (i<NUMBER_OF_CORRIDORS+NUMBER_OF_BENDS_WITH_TREASURES){
						this.ListOfTiles.add(i, new Tile(random.nextInt(4)+2, k));
						k++;
					}
					else {
						this.ListOfTiles.add(i, new Tile(random.nextInt(4)+2, 0));
					}
				}
				else {
					this.ListOfTiles.add(i, new Tile(random.nextInt(4)+6, 0)); 
				}
			}
		}
		
		
		
		/*for (int i=0; i<34; i++){
			if (i < 12){
				this.ListOfTiles.add(i, new Tile(random.nextInt(1)+1, 0));
			}
			else if (i >= 28){
				this.ListOfTiles.add(i, new Tile(random.nextInt(3)+7, k));
				k++;
			}
			else{
				if (k<8) {
					this.ListOfTiles.add(i, new Tile(random.nextInt(3)+3, k));
					k++;
				}
				else {
					this.ListOfTiles.add(i, new Tile(random.nextInt(3)+3, 0));
				}
			}
		}*/
	}
	
	/**
	 * Method linking the SetOfTiles class and the ArrayList it uses to obtain the number of elements in the list
	 * @return Number of items in the list
	 */
	// TODO (done) add javadoc comment
	public int length(){
		return this.ListOfTiles.size();
	}
	
	/**
	 * Method using the remove() method of the List to get the item whose index is the index given in parameters and removes it from the List
	 * @param index
	 * @return The element removed from the list
	 * @throws IndexOutOfBoundsException
	 */
	// TODO (done) add javadoc comment

public Tile take(int index) throws IndexOutOfBoundsException{
		return this.ListOfTiles.remove(index);
	}


}
