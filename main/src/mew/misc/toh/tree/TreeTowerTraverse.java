package mew.misc.toh.tree;

import mew.misc.toh.stack.TowerGameState;

public class TreeTowerTraverse {
	public static void main(String[] args) {
		TowerGameState startState = new TowerGameState(3, "C", "A", "B");
		TowerBinaryTree tree = new TowerBinaryTree(startState);
		
		tree.playRecursively();
		tree.playUsingStack();
		System.out.println("--End of Processing--");
	}
}
