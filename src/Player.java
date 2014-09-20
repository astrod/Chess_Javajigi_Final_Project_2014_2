
public class Player {
	public void movePiece(int preX, int preY, int postX, int postY, ChessBoard board) throws IllegalArgumentException{
	try {
		if(!board.isVaildValue(preX, preY, postX, postY)) throw new IllegalArgumentException("이동할 수 없는 곳입니다."); 
		if(board.isObstacle(postX, postY, board)) throw new IllegalArgumentException("중간에 장애물이 있어 이동할 수 없습니다.");
		target.move(postX, postY, board);		
	}catch(IllegalArgumentException e) {
		System.out.println("에러 메시지 : " + e.getMessage());
		e.printStackTrace();
	}
	
	}
}

