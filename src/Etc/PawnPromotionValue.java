package Etc;
import java.io.IOException;

import Piece.Bishop;
import Piece.Night;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;


public class PawnPromotionValue {
	char value;
	
	public PawnPromotionValue(char input) throws IOException {
		value = input;
		if(value != 'B' && value != 'Q' && value != 'N' && value != 'R') throw new IOException("잘못된 값을 입력하셨습니다.");	
	}

	public Piece putPiece(int x, int y, String color) {
		if(value == 'B') return new Bishop(x, y, color);
		else if(value == 'Q') return new Queen(x, y, color);
		else if(value == 'N') return new Night(x, y, color);
		else if(value == 'R') return new Rook(x, y, color);
		return null;
	}
	
}
