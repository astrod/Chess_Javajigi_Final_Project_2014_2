package Piece;
import Directions.Direction;
import Etc.ChessBoard;
import Exceptions.AttackAllianceExecption;



public abstract class Piece {
	public final int INFI = -10; 
	protected int xPos;
	protected int yPos;
	protected String color;
	
	public String getColor() {
		return color;
	}
	
	public void move(int x, int y, ChessBoard board) {
		try {
			board.removePreLocation(xPos, yPos, x, y);			
			if(!board.isPiece(x, y)) {
				board.setPiece(x, y, this);
				xPos = x;
				yPos = y;
			} else {
				kill(x, y, board, this);
			}						
		}catch(AttackAllianceExecption e) {
			System.out.println(e.getMessage());
		}
	}
	public void kill(int x, int y, ChessBoard board, Piece target) {
		board.clearLocationWithoutExecption(x, y);
		board.setPiece(x, y, target);
		xPos = x;
		yPos = y;
	}
	
	public String showSelf() {
		return this.color + this.getClass().toString().split(" ")[1].charAt(0);
	}
	
	//입력된 값이 유효하면 true, 아니면 false
	public abstract boolean isVaildValue(int postX, int postY);
	//장애물이 존재하면 true, 없으면 false
	public boolean isObstacle(int postX, int postY, ChessBoard board) {
		double degree = getDegree(postX, postY);
		Direction dir = Direction.giveObject(degree);
		return board.search(dir, xPos, yPos, postX, postY);
	}
	
	private double getDegree(int postX, int postY) {
		int unitX = postX - xPos;
		int unitY = postY - yPos;
		double cosSeta = (1*unitX+0*unitY)/Math.sqrt(unitX*unitX+unitY*unitY);
		double degree = Math.toDegrees(Math.acos(cosSeta));
		if(xPos > 0) return degree;
		else if(xPos < 0) return (360-degree);
		else if(yPos > 0) return degree;
		else return 0;
	}
	
	
}
