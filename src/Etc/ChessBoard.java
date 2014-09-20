package Etc;
import java.util.LinkedList;

import Directions.Direction;
import Exceptions.AttackAllianceExecption;
import Piece.Piece;


public class ChessBoard {
	private static Piece[][] array = new Piece[10][10];
	private PrintMap printer = new PrintMap();
	private boolean canEnpassant = false;
	
	public void printArray() {
		printer.print(array);
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

	public void setPiece(int i, int j, Piece p) {
		array[i][j] = p;
	}

	public boolean isPiece(int x, int y) {
		return array[x][y] == null ? false : true;
	}	
}