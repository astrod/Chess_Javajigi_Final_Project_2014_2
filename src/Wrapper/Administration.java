package Wrapper;


import java.util.Scanner;

import Etc.Player;
import Exceptions.PickOtherPlayerPieceException;
import Map.ChessBoard;
import Piece.Bishop;
import Piece.King;
import Piece.Night;
import Piece.Pawn;
import Piece.Queen;
import Piece.Rook;
import Piece.Sentinal;


public class Administration {
	private ChessBoard board;
	private boolean turnFlag = true;
	private Player playerOne;
	private Player playerTwo;
	
	public Administration() {
		board = new ChessBoard();
		playerOne = new Player("W");
		playerTwo = new Player("B");
		makePieces();
	}
	
	public void playerMove(int preX, int preY, int x, int y) {
		try {
			if(turnFlag == true){
				System.out.println("Black Turn");
				playerOne.movePiece(preX, preY, x, y, board);			
				turnFlag = false;
			} else {
				System.out.println("White Turn");
				playerTwo.movePiece(preX, preY, x, y, board);
				turnFlag = true;
			}			
		}catch(PickOtherPlayerPieceException e) {
			System.out.println("에러 메시지 : " + e.getMessage());
		}
		
	}

	private void makePieces() {
		makePawn();
		makeRook();
		makeKnight();
		makeBishop();
		makeKing();
		makeQueen();
		makeSentinal();
	}

	//(1, 4), (8, 4)
	private void makeQueen() {
		Queen q = new Queen(1, 4, "B");
		board.setPiece(1, 4, q);
		q = new Queen(8, 4, "W");
		board.setPiece(8, 4, q);
	}

	//(1, 5), (8, 5)
	private void makeKing() {
		King k = new King(1, 5, "B");
		board.setPiece(1, 5, k);
		k = new King(8, 5, "W");
		board.setPiece(8, 5, k);
	}

	private void makePawn() {
		for(int i=1; i<9; i++) {
			Pawn p = new Pawn(2, i, "B");
			board.setPiece(2, i, p);
		}
		for(int i=1; i<9; i++) {
			Pawn p = new Pawn(7, i, "W");
			board.setPiece(7, i, p);
		}
	}
	
	//(1,1),(8,8),(1,8),(8, 1)
	private void makeRook() {
		Rook r = new Rook(1, 1, "B");
		board.setPiece(1, 1, r);
		r = new Rook(8, 8, "W");
		board.setPiece(8, 8, r);
		r = new Rook(1, 8, "B");
		board.setPiece(1, 8, r);
		r = new Rook(8, 1, "W");
		board.setPiece(8, 1, r);
	}
	
	//(1, 2), (1, 7), (8,2), (8,7)
	private void makeKnight() {
		Night k = new Night(1, 2, "B");
		board.setPiece(1, 2, k);
		k = new Night(1, 7, "B");
		board.setPiece(1, 7, k);
		k = new Night(8, 2, "W");
		board.setPiece(8, 2, k);
		k = new Night(8, 7, "W");
		board.setPiece(8, 7, k);
	}
	
	
	//(1,3), (1, 6), (8, 3), (8, 6)
	private void makeBishop() {
		Bishop b = new Bishop(1, 3, "B");
		board.setPiece(1, 3, b);
		b = new Bishop(1, 6, "B");
		board.setPiece(1, 6, b);
		b = new Bishop(8, 3, "W");
		board.setPiece(8, 3, b);
		b = new Bishop(8, 6, "W");
		board.setPiece(8, 6, b);
	}
	
	public void makeSentinal() {
		for(int i =0; i<10; i++) {
			Sentinal s = new Sentinal(0, i, "N");
			board.setPiece(0, i, s);
		}
		for(int i =0; i<10; i++) {
			Sentinal s = new Sentinal(9, i, "N");
			board.setPiece(9, i, s);
		}
		for(int i =0; i<10; i++) {
			Sentinal s = new Sentinal(i, 0, "N");
			board.setPiece(i, 0, s);
		}
		for(int i =0; i<10; i++) {
			Sentinal s = new Sentinal(i, 9, "N");
			board.setPiece(i, 9, s);
		}
	}
	
	public void printMap() {
		board.printArray();
	}

	public void playGame() throws Exception {
		String message;
		Scanner scan = new Scanner(System.in);
		board.printArray();
		System.out.println("메시지를 입력하세요. 1,2,4,7과 같이 입력하시면 됩니다. 전자는 움직이고 싶은 말이고 후자는 움직일 위치입니다. 흰색부터 먼저 시작해서 번갈아가면서 하면 됩니다. 게임을 종료하시려면 exit를 입력해 주세요.");
		while(true) {
			if(!checkKingaLive()) {
				System.out.println("게임이 종료되었습니다.");
				break;
			}
			message =scan.nextLine();
			if(splitMessage(message)) {
				System.out.println("게임이 종료되었습니다.");
				break;
			}
			printMap();
		}
		
	}

	private boolean checkKingaLive() {
		return board.checkKingAlive();
	}

	private boolean splitMessage(String message) {
		if(message.equals("exit")) return true;
		try {
			String[] array =message.split(",");
			int preX = Integer.parseInt(array[0]);
			int preY = Integer.parseInt(array[1]);
			int postX = Integer.parseInt(array[2]);
			int postY = Integer.parseInt(array[3]);
			
			playerMove(preX, preY, postX, postY);			
		} catch(Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
		}
		return false;
	}
	
	
}
