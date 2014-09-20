import java.util.LinkedList;


public class Queen extends Piece{

	public Queen(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}

	@Override
	public boolean isVaildValue(int postX, int postY) {
		int yAxisToDonw = xPos+yPos;
		int yAxisToUp = yPos-xPos;
		if(postY-postX == yAxisToUp || postY+postX == yAxisToDonw || postX == xPos || postY == yPos) return true;
		return false;
	}
}
