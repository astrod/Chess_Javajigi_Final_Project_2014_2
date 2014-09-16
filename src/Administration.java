
public class Administration {
	private ChessBoard board;
	private Player playerOne;
	private Player playerTwo;
	
	public Administration() {
		board = new ChessBoard();
		playerOne = new Player();
		playerTwo = new Player();
		makePieces();
	}
	
	public void playerMove() {
		playerOne.movePiece(1, 1, 7, 1, board);
	}
	
	private void makePieces() {
		makePawn();
		makeRook();
		makeKnight();
		makeBishop();
		makeKing();
		makeQueen();
	}

	//(0, 3), (7, 3)
	private void makeQueen() {
		Queen q = new Queen(0, 3, "B");
		board.setPiece(0, 3, q);
		q = new Queen(7, 3, "W");
		board.setPiece(7, 3, q);
	}

	//(0, 4), (7, 4)
	private void makeKing() {
		King k = new King(0, 4, "B");
		board.setPiece(0, 4, k);
		k = new King(7, 4, "W");
		board.setPiece(7, 4, k);
	}

	private void makePawn() {
		for(int i=0; i<8; i++) {
			Pawn p = new Pawn(1, i, "B");
			board.setPiece(1, i, p);
		}
		for(int i=0; i<8; i++) {
			Pawn p = new Pawn(6, i, "W");
			board.setPiece(6, i, p);
		}
	}
	
	//(0,0),(7,7),(0,7),(7, 0)
	private void makeRook() {
		Rook r = new Rook(0, 0, "B");
		board.setPiece(0, 0, r);
		r = new Rook(7, 7, "W");
		board.setPiece(7, 7, r);
		r = new Rook(0, 7, "B");
		board.setPiece(0, 7, r);
		r = new Rook(7, 0, "W");
		board.setPiece(7, 0, r);
	}
	
	//(0, 1), (0, 6), (7,1), (7,6)
	private void makeKnight() {
		Knight k = new Knight(0, 1, "B");
		board.setPiece(0, 1, k);
		k = new Knight(0, 6, "B");
		board.setPiece(0, 6, k);
		k = new Knight(7, 1, "W");
		board.setPiece(7, 1, k);
		k = new Knight(7, 6, "W");
		board.setPiece(7, 6, k);
	}
	
	
	//(0,2), (0, 5), (7, 2), (7, 5)
	private void makeBishop() {
		Bishop b = new Bishop(0, 2, "B");
		board.setPiece(0, 2, b);
		b = new Bishop(0, 5, "B");
		board.setPiece(0, 5, b);
		b = new Bishop(7, 2, "W");
		board.setPiece(7, 2, b);
		b = new Bishop(7, 5, "W");
		board.setPiece(7, 5, b);
	}
	
	public void printMap() {
		board.printArray();
	}
}
