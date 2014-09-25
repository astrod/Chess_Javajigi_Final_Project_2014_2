package Directions;
import Map.Row;
import Piece.Piece;


public class Top extends Direction {

	//장애물이 존재하면 true, 없으면 false;
	@Override
	public boolean search(Row row, int xPos, int yPos, int postX, int postY) {
		for(int i=1; i<Math.abs(postX-xPos); i++) {
			Piece p = row.searchPre(yPos);
			if(p != null) return true; 
			row = row.getPreRow();
		}
		return false;
	}
}
