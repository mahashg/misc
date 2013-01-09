package mew.misc.toh.tree;

import java.util.Stack;

import mew.misc.toh.stack.TowerGameState;

public class TowerBinaryTree {
	TreeNode rootNode;
	
	public TowerBinaryTree(TowerGameState startState) {
		if(startState != null){
			rootNode = new TreeNode(startState);
		}
		
		// generate child nodes.
		generate();
	}
	
	private void generate(){
		if(rootNode != null){
			rootNode.generate();
		}
	}
	
	public void playRecursively(){
		rootNode.traverse();
	}
	
	public void playUsingStack(){
		Stack<TreeNode> stateStack = new Stack<TreeNode>();
		
		stateStack.push(rootNode);
		
		while(!stateStack.isEmpty()){
			TreeNode current = stateStack.pop();
			
			if(current.getCurrentValue().getNumBlocks() == 1){
				current.printMove();
				if(!stateStack.isEmpty()){
					current = stateStack.pop();
					current.printMove();
				}
			}
			else {
				stateStack.push(current.getRightNode());
				stateStack.push(current);
				stateStack.push(current.getLeftNode());
			}
		}// end of while loop
	}
	
}
