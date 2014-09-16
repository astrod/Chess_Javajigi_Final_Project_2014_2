
public class ChessBoard {
	private static Piece[][] array = new Piece[8][8];
	private PrintMap printer = new PrintMap();
	
	public void printArray() {
		printer.print(array);
	}
	
	public boolean isPiece(int x, int y) {
		if(array[x][y] == null) return false;
		return true;
	}

	public void setPiece(int x, int y, Piece target) {
		array[x][y] = target;
	}

	public void removePreLocation(int xPos, int yPos) {
		array[xPos][yPos] = null;
	}

	public void clearLocation(int x, int y) {
		array[x][y] = null;
	}

	public static Piece getPieceInLoc(int preX, int preY) {
		return array[preX][preY];
	}

}
