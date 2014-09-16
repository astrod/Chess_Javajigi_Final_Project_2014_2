
public abstract class Piece {
	protected int xPos;
	protected int yPos;
	protected String color;
	
	public void move(int x, int y, ChessBoard board) {
		if(!board.isPiece(x, y)) {
			board.removePreLocation(xPos, yPos);
			board.setPiece(x, y, this);
			xPos = x;
			yPos = y;
		} else {
			kill(x, y, board, this);
		}
	}
	public void kill(int x, int y, ChessBoard board, Piece target) {
		board.removePreLocation(xPos, yPos);
		board.clearLocation(x, y);
		board.setPiece(x, y, target);
	}
	
	public String showSelf() {
		return this.color + this.getClass().toString().split(" ")[1].charAt(0);
	}
	
	public abstract boolean isObstacle();
}
