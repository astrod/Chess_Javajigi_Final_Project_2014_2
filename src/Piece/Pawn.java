package Piece;
import java.io.IOException;

import Etc.PawnPromotionValue;
import Map.ChessBoard;

public class Pawn extends Piece{
	private boolean isTwoBlockMove;
	private boolean frontStraight = true;
	
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
		frontStraight = false;
		return false;
	}
	private boolean checkFrontOneBlock(int x, int y) {
		if(color == "W" && y == yPos && x-xPos == -1) return true;
		if(color == "B" && y == yPos && x-xPos == 1) return true;
		frontStraight = false;
		return false;
	}

	/* 실제로 유효한 것 : 대각선에 말이 있는 경우 잡을 수 있어야 한다.
	 * 구현해야 하는 기능 : 정면에 아군 말이 있으면 갈 수 없게 한다; 대각선에 적군 말이 있으면 움직일 수 있는 곳으로 간주한다.
	 */
	
	@Override
	public boolean isVaildValue(int postX, int postY, ChessBoard board) {	
		//입력한 값이 앞으로 가는 것인지 살핀다.
		if(postY == yPos) {
			if(isTwoBlockMove == true) {
				isTwoBlockMove = false;
				frontStraight = true;
				return checkFrontTowBlock(postX, postY);
			} else {
				frontStraight = true;
				return checkFrontOneBlock(postX, postY);
			}
		}
		//아닌 경우에는 입력한 값에 적이 있는지 살핀다.
		else {
			frontStraight = false;
			//적이 있다면 true, 아니면 false를 리턴한다.
			return board.isEnemy(postX, postY, color);
		}
	}
	
	@Override
	public void move(int x, int y, ChessBoard board) {
			//움직이는 위치에 말이 없다
			if(!board.isPiece(x, y)) {
				board.clearLocationWithoutExecption(xPos, yPos);			
				board.setPiece(x, y, this);
				xPos = x;
				yPos = y;
			//움직이면서 대각선의 적을 잡는다
			} else if(frontStraight == false){
				board.clearLocationWithoutExecption(xPos, yPos);			
				kill(x, y, board, this);
			//그냥 앞으로 간다. 즉 직선으로 가는데 앞에 적이 있다.
			} else {
				throw new IllegalArgumentException("그 방향으로 적을 공격할 수 없습니다.");
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
