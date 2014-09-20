import java.util.ArrayList;


public class PrintMap {

	public void print(Block [][] array) {
		
		for(int i=1; i<9; i++) {
			for(int j=1; j<9; j++) {
				if(array[i][j] == null) System.out.print("  " + "ㅣ");
				else System.out.print(array[i][j].showSelf() + "ㅣ");
			}
			System.out.println("");
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
}
