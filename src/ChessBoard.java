
public class ChessBoard {
	private static Piece[][] array = new Piece[10][10];
	private PrintMap printer = new PrintMap();
	private boolean canEnpassant = false;
	
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

	public void removePreLocation(int xPos, int yPos, int postX, int postY) throws AttackAllianceExecption {
		if(array[postX][postY] != null && array[xPos][yPos].getColor() == array[postX][postY].getColor()) throw new AttackAllianceExecption();			
		else array[xPos][yPos] = null;
	}

	public void clearLocationWithoutExecption(int x, int y) {
		array[x][y] = null;
	}

	public static Piece getPieceInLoc(int preX, int preY) {
		return array[preX][preY];
	}

	public boolean search(Direction dir, int xPos, int yPos, int postX, int postY) {
		return dir.search(array, xPos, yPos, postX, postY);
	}	
}