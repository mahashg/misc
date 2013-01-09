package mew.misc.gameoflife;

public class GameUniverse {
	private boolean[][] universeBoard;
	
	public GameUniverse() {
		universeBoard = null;		
	}
	
	public boolean configure(boolean[][] board){
		if(board == null){
			return false;
		}
		
		this.universeBoard = board;
		return true;
	}
	
	public void play(int generation){
		if(!this.isConfigured()){
			System.err.println("Error !! Game is not configured.");
			return ;
		}
		
		if(generation < 0){
			System.err.println("Error!! Number of Generation should be non-negative.");
			return;
		}
		
		boolean[][] tempBoard = universeBoard;
		for(int i=0 ; i<generation ; ++i){
			
			System.out.println("#################################");
			System.out.println("Generation: "+i);
			ConvaysGame.printWorld(tempBoard);
			
			tempBoard = ConvaysGame.tick(tempBoard);
		}
	
	}

	private boolean isConfigured() {

		return true;
	}
}
