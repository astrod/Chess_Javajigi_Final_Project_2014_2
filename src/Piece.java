import java.util.LinkedList;


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
	
//	public LinkedList<Integer> calculateGredient(int postX, int postY) {
//		LinkedList <Integer> array = new LinkedList<Integer>();
//		int gredient = 0;
//		int flag = 0;
//		try {
//			gredient = (postX-xPos)/(postY-yPos);
//			if(gredient == 0) flag = postY - yPos;			
//			else flag = postX - xPos;
//		} catch(ArithmeticException e) {
//			gredient = INFI;
//			flag = postX - xPos;
//		} finally {
//			array.push(flag);
//			array.push(gredient);			
//		}
//		return array;
//	}
	//입력된 값이 유효하면 true, 아니면 false
	public abstract boolean isVaildValue(int postX, int postY);
	//장애물이 존재하면 true, 없으면 false
	public boolean isObstacle(int postX, int postY) {
		
		
		Direction dir = Direction.giveObject(gredient, flag);
		return board.search(dir, xPos, yPos, postX, postY);		
	}
}
