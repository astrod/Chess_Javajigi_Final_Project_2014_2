package Piece;
import java.util.LinkedList;


public class Rook extends Piece{
	
	public Rook(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}

	@Override
	public boolean isVaildValue(int postX, int postY) {
		if(xPos == postX || yPos == postY) return true;
		return false;
	}
}
