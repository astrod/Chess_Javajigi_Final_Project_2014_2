package Exceptions;

public class InvalidMoveExecption extends Exception {

	public InvalidMoveExecption() {
		super("체스판 밖으로 이동을 시도하셨습니다.");
	}

	public InvalidMoveExecption(String string) {
		super(string);
	}
	
}
