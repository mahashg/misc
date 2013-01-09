package mew.misc.ternary;

public class Node {
	private Node left;
	private Node right;
	private Node middle;
	
	private Node parent;
	
	private char value;
	
	private boolean marked;
	
	public Node(char v) {
		this.value = v;
		this.left = null;
		this.right = null;
		this.middle = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getMiddle() {
		return middle;
	}
	
	public void setMiddle(Node middle) {
		this.middle = middle;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public  boolean isRoot(){
		return (this.parent == null);
	}
	
	public boolean isLeaf(){
		return ((this.left == null) &&
				(this.right == null) &&
				(this.middle == null));
	}
}
