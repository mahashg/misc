package mew.misc.toh.tree;

import mew.misc.toh.stack.TowerGameState;

public class TreeNode {
	private TowerGameState current;
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	public TreeNode(TowerGameState state) {
		if(state == null){
			System.err.println("Error !! Null State is allowed.");
		}
		
		current = state;
		generate();
	}
	
	/** Accessors and Mutators */
	public TowerGameState getCurrentValue(){
		return this.current;
	}
	
	public TreeNode getLeftNode(){
		return this.leftNode ;
	}
	
	public TreeNode getRightNode(){
		return this.rightNode;
	}

	void generate() {
		if(current == null){
			return;
		}
		
		int no = current.getNumBlocks();
		if(no <= 1){
			// No Further Child Generation requires.
			return;
		
		}else {
			TowerGameState leftNodeState = new TowerGameState(no-1, current.getVia(),
					current.getFrom(), current.getTo());
			TowerGameState rightNodeState = new TowerGameState(no-1, current.getTo(),
					current.getVia(), current.getFrom());
			
			this.leftNode = new TreeNode(leftNodeState);
			this.rightNode = new TreeNode(rightNodeState);
			
			this.leftNode.generate();
			this.rightNode.generate();
		}
		
	}
	
	public void traverse(){
		if(current.getNumBlocks() == 1){
			printMove();
			return;
		}
		
		leftNode.traverse();
		printMove();
		rightNode.traverse();
	}

	public void printMove() {
		System.out.println(current);	
	}
}
