
public class Player {
	public void movePiece(int preX, int preY, int postX, int postY, ChessBoard board) {
		Piece target = ChessBoard.getPieceInLoc(preX-1, preY-1);
		target.move(postX-1, postY-1, board);
	}
}
