import java.util.LinkedList;


public class ChessBoard {
	private static Block [][] array = new Block[10][10];
	private PrintMap printer = new PrintMap();
	private boolean canEnpassant = false;
	
	public ChessBoard() {
		
		for(int i=1; i<9; i++) {
			for(int j=1; j<9; j++) {
				Block b = new Block(i, j);
				array[i][j] = b;
			}
		}
		
		for(int i=1; i<9; i++) {
			for(int j=1; j<9; j++) {
				connect(i, j);
			}
		}
	}
	
	private void connect(int i, int j) {
		array[i][j].setTop(array[i-1][j]);
		array[i][j].setLeft(array[i][j-1]);
		array[i][j].setBottom(array[i+1][j]);
		array[i][j].setRight(array[i][j+1]);
		array[i][j].setleftTop(array[i-1][j-1]);
		array[i][j].setrightTop(array[i-1][j+1]);
		array[i][j].setleftBottom(array[i+1][j-1]);
		array[i][j].setRightBottom(array[i+1][j+1]);
	}

	public void printArray() {
		printer.print(array);
	}
	
	public boolean isPiece(int x, int y) {
		return !array[x][y].isEmpty();
	}

	public void setPiece(int x, int y, Piece target) {
		array[x][y].setPiece(target);
	}

//	public void removePreLocation(int xPos, int yPos, int postX, int postY) throws AttackAllianceExecption {
//		if(array[postX][postY] != null && array[xPos][yPos].getColor() == array[postX][postY].getColor()) throw new AttackAllianceExecption();			
//		else array[xPos][yPos] = null;
//	}

	public void clearLocationWithoutExecption(int x, int y) {
		array[x][y] = null;
	}

	public static Piece getPieceInLoc(int preX, int preY) {
		return array[preX][preY].getPiece();
	}

	public boolean isVaildValue(int preX, int preY, int postX, int postY) {
		return array[preX][preY].canMove(postX, postY);
	}

	public boolean isObstacle(int postX, int postY, ChessBoard board) {
		return array[postX][postY].isObstacle(postX, postY);
	}

	public boolean search(Direction dir, int xPos, int yPos, int postX,
			int postY) {
		// TODO Auto-generated method stub
		return false;
	}

//	public boolean search(Direction dir, int xPos, int yPos, int postX, int postY) {
//		return dir.search(array, xPos, yPos, postX, postY);
//	}	
}