import java.util.ArrayList;


public class SetOfTiles
{
	private final ArrayList<Tile> ListOfTiles;
	
	
	public SetOfTiles(){
		ListOfTiles = new ArrayList<Tile>();
		
		this.fillList();		
	}
	
	private void fillList(){

		for (int i=0; i<34; i++){
			if (i < 12){
				ListOfTiles.add(i, new Tile())
			}
		}
		
		
		
		
	}
	













}
