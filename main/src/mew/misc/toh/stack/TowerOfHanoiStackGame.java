package mew.misc.toh.stack;

import java.util.Stack;

public class TowerOfHanoiStackGame {
	TowerGameState initialState;
	
	public TowerOfHanoiStackGame() {
		initialState = new TowerGameState();
		initialState.setFrom("A");
		initialState.setTo("C");
		initialState.setVia("B");
		initialState.setNumBlocks(0);
	}

	public int play(){
		if(!this.isConfigured()){
			System.err.println("Error !! Game Not Configured.");
			return 0;
		}
		
		return playWithStack(initialState);
	}
	
	private int playWithStack(TowerGameState state){
		Stack<TowerGameState> stack = new Stack<TowerGameState>();
		int count = 0;
		stack.push(state);
		while(!stack.isEmpty()){
			TowerGameState currentState = stack.peek();
			
			if(currentState.getNumBlocks() <1){
				//TODO: It Should not come here..
				System.err.println("Error ! Number of Blocks cannot be "+currentState.getNumBlocks());
				
			} else if(currentState.getNumBlocks() == 1){
				
				TowerGameState firstState = stack.pop();				
				System.out.println(firstState);
				
				if(!stack.isEmpty()){
					TowerGameState secondState = stack.pop();
					System.out.println(secondState);
					
					// Push new State to the stack.
					TowerGameState newState = new TowerGameState();
					newState.setNumBlocks(secondState.getNumBlocks()-1);
					newState.setFrom(secondState.getVia());
					newState.setTo(secondState.getTo());
					newState.setVia(secondState.getFrom());
					
					stack.push(newState);
				}	
								
			} else {
				
				TowerGameState newState = new TowerGameState();
				newState.setNumBlocks(currentState.getNumBlocks()-1);
				newState.setFrom(currentState.getFrom());
				newState.setVia(currentState.getTo());
				newState.setTo(currentState.getVia());
				
				stack.push(newState);
			}				
			++count;
		}// end of while loop
		
		return count;
	}
	
	public boolean isConfigured() {
		return (this.initialState.getNumBlocks() > 0);
	}

	public boolean setNumberOfBlocks(int i) {
		if(i<=0){
			return false;
		}
		
		this.initialState.setNumBlocks(i);
		return true;
	}
	
	public int getNumberOfBlocks(){
		return this.initialState.getNumBlocks();
	}

}
