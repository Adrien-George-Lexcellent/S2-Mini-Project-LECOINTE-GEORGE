import java.util.ArrayList;
import java.util.Random;

// TODO add javadoc comment
public class SetOfTiles
{
	// TODO add javadoc comment
	private final ArrayList<Tile> ListOfTiles;
		
	// TODO add javadoc comment
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
		int k=0;
		
		// TODO declare literals as constants
		for (int i=0; i<34; i++){
			if (i < 12){
				this.ListOfTiles.add(i, new Tile(random.nextInt(1)+1, 0));
			}
			else if (i >= 28){
				this.ListOfTiles.add(i, new Tile(random.nextInt(3)+7, k++));
			}
			else{
				if (k<6) this.ListOfTiles.add(i, new Tile(random.nextInt(3)+3, k++));
				else this.ListOfTiles.add(i, new Tile(random.nextInt(3)+3, 0));
			}
		}
		
	}
	// TODO add javadoc comment
	public int length(){
		return this.ListOfTiles.size();
	}
	
	// TODO add javadoc comment
	public Tile take(int index) throws IndexOutOfBoundsException{
		return this.ListOfTiles.remove(index);
	}


}
