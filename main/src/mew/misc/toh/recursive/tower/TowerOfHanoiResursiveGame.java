package mew.misc.toh.recursive.tower;
/**
 * Tower of Hanoi Game Recursive Version.
 * @author Dinesh
 *
 */
public class TowerOfHanoiResursiveGame {

	private int numberOfBlocks;

	public TowerOfHanoiResursiveGame() {
		this.numberOfBlocks = 0;
	}

	public int play(){
		if(!this.isConfigured()){
			System.err.println("Error in playing. Game Not Configured properly !!");
			return 0;
		}
		
		return playRecursively(this.numberOfBlocks, "A", "C", "B");
		
	}
	
	private int playRecursively(int blockNum, String from,
			String to, String via) {
		
		if(blockNum <= 0){
			return 0;
		}
		
		int count = playRecursively(blockNum-1, from, via, to);
		printStep(blockNum, to, from, via);
		playRecursively(blockNum-1, via, to, from);
		/*playRecursively(blockNum-1, from, to, via)*/
		return 2*count + 1;
	}

	private void printStep(int blockNumber, String to, String from, String via){
		System.out.println(blockNumber+" Block moved from "+from+" to "+to+", via "+via+".");
	}
	
	private boolean isConfigured(){
		return (this.getNumberOfBlocks() > 0);
	}
	
	public int getNumberOfBlocks() {
		return numberOfBlocks;
	}

	public void setNumberOfBlocks(int numberOfBlocks) {
		this.numberOfBlocks = numberOfBlocks;
	}
}
