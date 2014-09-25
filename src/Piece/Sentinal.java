package Piece;
import Exceptions.InvalidMoveExecption;
import Map.ChessBoard;


public class Sentinal extends Piece{

	
	public Sentinal(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}
	
	@Override
	public boolean isVaildValue(int postX, int postY, ChessBoard board)  {
		try {
			throw new InvalidMoveExecption();
		}catch(InvalidMoveExecption e) {
			
		}
		return false;
	}

	@Override
	public boolean isObstacle(int postX, int postY, ChessBoard board) {
		return true;
	}

}
