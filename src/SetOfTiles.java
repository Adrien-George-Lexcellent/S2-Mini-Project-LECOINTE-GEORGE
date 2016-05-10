import java.util.ArrayList;
import java.util.Random;


public class SetOfTiles
{
	private final ArrayList<Tile> ListOfTiles;
		
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
		
		for (int i=0; i<34; i++){
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
		}
	}
	
	public int length(){
		return this.ListOfTiles.size();
	}

	public Tile take(int index) throws IndexOutOfBoundsException{
		return this.ListOfTiles.remove(index);
	}


}
