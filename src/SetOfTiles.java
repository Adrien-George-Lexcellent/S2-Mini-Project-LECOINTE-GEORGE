import java.util.ArrayList;
import java.util.Random;


public class SetOfTiles
{
	private final ArrayList<Tile> ListOfTiles;
		
	public SetOfTiles(){
		this.ListOfTiles = new ArrayList<Tile>();
		
		this.fillSetOfTiles();		
	}
	
	private void fillSetOfTiles(){
		
		Random random = new Random(); 
		int k=0;
		
		for (int i=0; i<34; i++){
			if (i < 12){
				this.ListOfTiles.add(i, new Tile(random.nextInt(1)+1, 0));
			}
			else if (i > 28){
				this.ListOfTiles.add(i, new Tile(random.nextInt(3)+7, k++));
			}
			else{
				while (k<12) this.ListOfTiles.add(i, new Tile(random.nextInt(3)+3, k++));
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
