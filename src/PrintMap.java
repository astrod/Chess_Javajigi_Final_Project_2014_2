
public class PrintMap {

	public void print(Piece [][] array) {
		for (Piece[] pieces : array) {
			for (Piece piece : pieces) {
				if(piece == null) System.out.print("  " + "ㅣ");
				else System.out.print(piece.showSelf() + "ㅣ");
			}
			System.out.println("");
		}
	}
}
