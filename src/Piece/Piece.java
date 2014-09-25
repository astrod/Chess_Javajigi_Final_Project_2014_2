package Piece;
import Directions.Direction;
import Map.ChessBoard;



public abstract class Piece {
	protected int xPos;
	protected int yPos;
	protected String color;
	
	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	public String getColor() {
		return color;
	}
	//1. 움직이는 로직과 공격하는 로직을 분리한다.
	//2. 폰에 각각 따로 적용한다.

	public void move(int x, int y, ChessBoard board) {
			board.clearLocationWithoutExecption(xPos, yPos);			
			if(!board.isPiece(x, y)) {
				board.setPiece(x, y, this);
				xPos = x;
				yPos = y;
			} else {
				kill(x, y, board, this);
			}						
	}
	public void kill(int x, int y, ChessBoard board, Piece target) {
		board.clearLocationWithoutExecption(x, y);
		board.setPiece(x, y, target);
		xPos = x;
		yPos = y;
	}
	
	public String showSelf() {
		return this.color + this.getClass().toString().split("Piece.")[1].charAt(0);
	}
	
	//입력된 값이 유효하면 true, 아니면 false
	public abstract boolean isVaildValue(int postX, int postY, ChessBoard board);
	//장애물이 존재하면 true, 없으면 false
	public boolean isObstacle(int postX, int postY, ChessBoard board) {
		int degree = getDegree(postX, postY);
		Direction dir = Direction.giveObject(degree);
		return board.search(dir, xPos, yPos, postX, postY);
	}
	
	private int getDegree(int postX, int postY) {
		int unitX = postX - xPos;
		int unitY = postY - yPos;
		double cosSeta = (1*unitX+0*unitY)/Math.sqrt(unitX*unitX+unitY*unitY);
		int degree = (int)Math.toDegrees(Math.acos(cosSeta));
		if(xPos > 0) return degree;
		else if(xPos < 0) return (360-degree);
		else if(yPos > 0) return degree;
		else return 0;
	}

	public char showClassName() {
		return this.getClass().toString().split("Piece.")[1].charAt(0);
	}
	
	
}
