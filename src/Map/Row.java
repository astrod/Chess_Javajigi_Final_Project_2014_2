package Map;
import Piece.Piece;

public class Row {
	Piece [] array;
	Row preRow;
	Row postRow;
	PrintMap printer = new PrintMap();
	int number;
	
	public Row(Row preRow, Row postRow, int size, int number) {
		this.preRow = preRow;
		this.postRow = postRow;
		array = new Piece[size];
		this.number = number;
	}

	public void setPreRow(Row row) {
		this.preRow = row;
	}

	public void setPostRow(Row postRow) {
		this.postRow = postRow;
	}

	public Piece pickPiece(int preY) {
		return array[preY];
	}
	
	public void printRow() {
		printer.printRow(array);
	}

	public void setPiece(int j, Piece p) {
		array[j] = p;
	}

	//지정한 위치에 있는 말이 적군이면 true, 비어있거나 아군이면 false를 리턴한다.
	public boolean isEnemy(int postY, String color) {
		return (array[postY] != null && array[postY].getColor() != color) ? true : false; 
	}

	public void removeLocation(int y) {
		array[y] = null;
	}

	public Piece searchNext(int yPos) {
		return postRow.pickPiece(yPos);
	}
	
	public Piece searchPre(int yPos) {
		return preRow.pickPiece(yPos);
	}

	public Row getPostRow() {
		return postRow;
	}
	
	public boolean isEmpty(int yPos) {
		return array[yPos] == null ? true : false;
	}

	public Row getPreRow() {
		return preRow;
	}

	public boolean isPiece(int y) {
		return array[y] == null ? false : true;
	}

	public boolean isAliy(int postY, String color) {
		return (array[postY] != null && array[postY].getColor() == color) ? true : false;
	}

	public boolean checkKingAlive() {
		for (Piece piece : array) {
			if(piece != null && piece.showClassName() == 'K' ) return true;
		}
		return false;
	}
}
