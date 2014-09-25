package Map;
import Piece.Piece;


public class PrintMap {

	public void printRow(Piece [] array) {
		for(int i =1; i<9; i++) {
			if(array[i] == null) System.out.print("  "+ "ㅣ");
			else System.out.print(array[i].showSelf() + "ㅣ");
		}
		System.out.println("");		
	}
}
