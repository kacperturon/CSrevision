package crackingCodingInterviews.mineSweeper;

import java.util.Scanner;

public class Game {

	boolean lost = false;
	Board board;
	
	public Game(Board board) {
		this.board = board;
	}
	
	public static void main(String[] args) {
		Game g = new Game(new Board(12));
		g.start();
	}
	
	public void start() {
		board.initialise();
		while(!lost) {
			board.display();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("x: ");
			int x = sc.nextInt();
			System.out.println();
			System.out.print("y: ");
			int y = sc.nextInt();
			if(board.isBomb(x, y))
				lost = true;
		}
		board.display();
		System.out.print("You lost.");
		
	}
	

}
