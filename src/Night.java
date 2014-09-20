
public class Night extends Piece{

	public Night(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}

	@Override
	public boolean isVaildValue(int postX, int postY) {
		if(((postX - xPos)*(postX - xPos) + (postY-yPos)*(postY-yPos)) == 5) return true;
		return false;
	}

	@Override
	public boolean isObstacle(int postX, int postY, ChessBoard board) {
		return false;
	}
}
