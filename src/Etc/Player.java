package Etc;
import Piece.Piece;


public class Player {
	public void movePiece(int preX, int preY, int postX, int postY, ChessBoard board) throws IllegalArgumentException{
	try {
		Piece target = ChessBoard.getPieceInLoc(preX, preY);
		if(!target.isVaildValue(postX, postY)) throw new IllegalArgumentException("이동할 수 없는 곳입니다."); 
		if(target.isObstacle(postX, postY, board)) throw new IllegalArgumentException("중간에 장애물이 있어 이동할 수 없습니다.");
		target.move(postX, postY, board);		
	}catch(IllegalArgumentException e) {
		System.out.println("에러 메시지 : " + e.getMessage());
		e.printStackTrace();
	}
	
	}
}

