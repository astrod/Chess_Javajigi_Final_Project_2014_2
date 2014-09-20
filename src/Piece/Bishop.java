package Piece;


public class Bishop extends Piece{
	public Bishop(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}

	@Override
	public boolean isVaildValue(int postX, int postY) {
		int yAxisToDonw = xPos+yPos;
		int yAxisToUp = yPos-xPos;
		if(postY-postX == yAxisToUp || postY+postX == yAxisToDonw) return true;
		return false;
	}
}
