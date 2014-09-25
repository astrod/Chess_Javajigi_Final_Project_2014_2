package Etc;
import Exceptions.AttackAllianceExecption;
import Exceptions.PickOtherPlayerPieceException;
import Map.ChessBoard;
import Piece.Piece;


public class Player {
	private String color;
	
	public Player(String color) {
		this.color = color;
	}
	
	public void movePiece(int preX, int preY, int postX, int postY, ChessBoard board) throws PickOtherPlayerPieceException {
	try {
		//대상을 가져온다.
		Piece target = ChessBoard.getPieceInLoc(preX, preY);
		//대상의 색과 플레이어의 색을 비교한다.
		if(target.getColor() != color) throw new PickOtherPlayerPieceException("적의 말을 선택하셨습니다.");
		//그곳이 이동할 수 있는 공간이지 살핀다.
		if(!target.isVaildValue(postX, postY, board)) throw new IllegalArgumentException("이동할 수 없는 곳입니다.");
		//목표지점과 사이에 물체가 있는지 살핀다.
		if(target.isObstacle(postX, postY, board)) throw new IllegalArgumentException("중간에 장애물이 있어 이동할 수 없습니다.");
		//isAliy는 아군이면 true, 적군이면 false를 리턴한다.
		if(board.isAliy(postX, postY, color)) throw new AttackAllianceExecption("움직이는 위치에 아군이 존재합니다.");

		target.move(postX, postY, board);		
	}catch(IllegalArgumentException e) {
		System.out.println("에러 메시지 : " + e.getMessage());
		throw new PickOtherPlayerPieceException();
	}catch(AttackAllianceExecption e) {
		System.out.println("에러 메시지 : " +e.getMessage());
		throw new PickOtherPlayerPieceException();
	}
	
	}
}

