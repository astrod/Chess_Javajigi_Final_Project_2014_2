import java.io.IOException;
import java.util.LinkedList;


public class Pawn extends Piece{
	private boolean isTwoBlockMove;
	private boolean canKilld;
	private LinkedList<Integer> canKill;
	private int[][] canMove;
	
	public Pawn(int x, int y, String color) {
		isTwoBlockMove = true;
		xPos = x;
		yPos = y;
		this.color = color;
	}

	//폰이 처음 움직일 때 값이 제대로 입력되었는지 확인하는 메소드 
	private boolean checkFrontTowBlock(int x, int y) {
		if(color == "W" && y == yPos && (x-xPos == -1 || x-xPos == -2)) return true;
		if(color == "B" && y == yPos && (x-xPos == 1 || x-xPos ==2)) return true;
		return false;
	}
	private boolean checkFrontOneBlock(int x, int y) {
		if(color == "W" && y == yPos && x-xPos == -1) return true;
		if(color == "B" && y == yPos && x-xPos == 1) return true;
		return false;
	}

	/* 값이 유효한 지 검증하는 메서
	 * 1. 입력된 값이 앞으로 두 칸, 혹은 앞으로 한 칸이어야 한다.
	 * 2. 대각선에 적의 말이 있다면 먹을 수 있다.
	 * 3. 내 말이 
	 */
	
	
	public boolean isVaildValue(int postX, int postY, ChessBoard board) {
		if(board.isPiece(postX, postY) && color == "W" && postY-yPos == 1 || postY-yPos == -1)
		if(board.isPiece(postX, postY) && color == "W" && postY == yPos-1 && postX == xPos+1)
			
		
		if(isTwoBlockMove == true) {
			isTwoBlockMove = false;
			return checkFrontTowBlock(postX, postY);
		} else {
			return checkFrontOneBlock(postX, postY);
		}
	}
	
	@Override
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
		if(xPos == 1 || xPos == 8) {
			while(true) {
				try {
					System.out.println("변하고 싶은 말을 입력해 주십시오. R : 룩, Q : 퀸, N : 나이트, B: 비숍");
					pawnPromotion(board);
					break;
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}				
			}
		}
	}
	
	private void pawnPromotion(ChessBoard board) throws IOException {
		PawnPromotionValue input = new PawnPromotionValue((char)System.in.read());
		board.clearLocationWithoutExecption(xPos, yPos);
		Piece newPiece = input.putPiece(xPos, yPos, color);
		board.setPiece(xPos, yPos, newPiece);
	}
}
