package Exceptions;

public class PickOtherPlayerPieceException extends Exception{
	public PickOtherPlayerPieceException(String input) {
		super(input);
	}
	
	public PickOtherPlayerPieceException() {
	}
}
