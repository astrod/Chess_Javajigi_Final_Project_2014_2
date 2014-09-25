package Map;
import java.util.ArrayList;

import Directions.Direction;
import Piece.Piece;


public class ChessBoard {
	private static ArrayList<Row> rowWrapper;
	
	//인스턴스 변수를 선언할 때 초기화해주는 것과 생성자 내부에서 초기화해주는 것의 차이가 있다. 나중에 질문할 것.
	public ChessBoard() {
		rowWrapper = new ArrayList<Row>();
		for(int i=0; i<10; i++) {
			Row row = new Row(null, null, 10, i);
			if(rowWrapper.isEmpty()) rowWrapper.add(row);
			else {
				row.setPreRow(rowWrapper.get(i-1));
				rowWrapper.get(i-1).setPostRow(row);
				rowWrapper.add(row);
			}
		}
	}
	
	public void printArray() {
		for(int i=1; i<9; i++) {
			rowWrapper.get(i).printRow();
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	public void clearLocationWithoutExecption(int x, int y) {
		rowWrapper.get(x).removeLocation(y);
	}

	public static Piece getPieceInLoc(int preX, int preY) {
		return rowWrapper.get(preX).pickPiece(preY);
	}

	//장애물이 존재하면 true, 없으면 false;
	public boolean search(Direction dir, int xPos, int yPos, int postX, int postY) {
		return dir.search(rowWrapper.get(xPos), xPos, yPos, postX, postY);
	}

	public void setPiece(int i, int j, Piece p) {
		rowWrapper.get(i).setPiece(j, p);
	}

	public boolean isPiece(int x, int y) {
		return rowWrapper.get(x).isPiece(y);
	}

	public boolean isEnemy(int xPos, int yPos, String color) {
			return rowWrapper.get(xPos).isEnemy(yPos, color);
	}

	public boolean isAliy(int postX, int postY, String color) {
		return rowWrapper.get(postX).isAliy(postY, color);
	}

	public boolean checkKingAlive() {
		boolean kingAliveBlack = false;
		boolean kingAliveWhite = false;
		
		for (Row row : rowWrapper) {
			if(!kingAliveBlack) {
				kingAliveBlack = row.checkKingAlive();
			}
			else if(!kingAliveWhite){
				kingAliveWhite = row.checkKingAlive();
			} else {
				break;
			}
		}
		return kingAliveBlack && kingAliveWhite;
	}

	
}