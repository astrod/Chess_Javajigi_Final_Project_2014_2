package Piece;

import Map.ChessBoard;


public class King extends Piece{

	public King(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}

	@Override
	public boolean isVaildValue(int postX, int postY, ChessBoard board) {
			int flag = (xPos-postX)*(xPos-postX)+(yPos-postY)*(yPos-postY);
			if(flag == 1 || flag == 2) return true;
			return false;
	}
}
