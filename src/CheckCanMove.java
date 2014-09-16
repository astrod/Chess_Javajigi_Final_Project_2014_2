
public class CheckCanMove {
	//대각선이 입력되었는가 확인 
	public boolean checkDiagonal(int x, int y, int curX, int curY) {
		int yAxisToDonw = curX+curY;
		int yAxisToUp = curY-curX;
		if(y-x == yAxisToUp || y+x == yAxisToDonw) return true;
		return false;
	}
	//직선이 입력되었는가 확인 
	public boolean checkStraight(int x, int y, int curX, int curY) {
		if(x == curX || y == curY) return true;
		return false;
	}
	//근접한 여덣 칸이 입력되었는가 확인 
	public boolean checkClose(int x, int y, int curX, int curY) {
		int flag = (curX-x)*(curX-x)+(curY-y)*(curY-y);
		if(flag == 1 || flag == 2) return true;
		return false;
	}
	
	//폰이 앞으로 두 칸 이동할 수 있는가?
	public boolean checkPawnFirstMove(int x, int y, Pawn target) {
		return target.checkFrontTowBlock(x, y);
	}
	
	
}

