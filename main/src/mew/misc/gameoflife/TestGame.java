package mew.misc.gameoflife;

public class TestGame {
	public static void main(String[] args) {
		GameUniverse game = new GameUniverse();
		boolean[][] board = new boolean[][] 
		            {
						{true, true, false, false, true, false, true, false},
						{false, true, true, false, true, false, false, false},
						{true, false, true, false, true, false, true, false},
						{true, false, false, true, true, false, true, true},
						{false, false, true, false, true, false, false, false},
						{true, true, false, false, true, false, true, true},
						{true, false, false, true, true, false, true, true},
						{false, true, true, false, true, false, false, false}
					};
		
		game.configure(board);
		
		game.play(10);
		
	}
}
