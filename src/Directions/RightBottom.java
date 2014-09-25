package Directions;
import Map.Row;
import Piece.Piece;

	
public class RightBottom extends Direction{

	@Override
	public boolean search(Row row, int xPos, int yPos, int postX, int postY) {
		for(int i=1; i<Math.abs(postX-xPos); i++) {
			Piece p = row.searchNext(yPos+i);
			if(p != null) return true; 
			row = row.getPostRow();
		}
		return false;
	}

}
