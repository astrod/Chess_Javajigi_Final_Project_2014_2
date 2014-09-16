
public class Pawn extends Piece{

	public Pawn(int x, int y, String color) {
		xPos = x;
		yPos = y;
		this.color = color;
	}

	//폰이 처음 움직일 때 값이 제대로 입력되었는지 확인하는 메소드 
	public boolean checkFrontTowBlock(int x, int y) {
		if(color == "W" && y == yPos && (x-xPos == -1 || x-xPos == -2)) return true;
		if(color == "B" && y == yPos && (x-xPos == 1 || x-xPos ==2)) return true;
		return false;
	}
}
