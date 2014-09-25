package Directions;
import Map.Row;


public class Left extends Direction {

	//장애물이 존재하면 true, 없으면 false;
		@Override
		public boolean search(Row row, int xPos, int yPos, int postX, int postY) {
			for(int i=1; i<Math.abs(postX-xPos); i++) {
				if(!row.isEmpty(yPos-i)) return true;
			}
			return false;
		}
}
