package mew.misc.ternary;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private Node root;
	private int noOfNodes;
	
	public Tree() {
		this.root = null;
		this.noOfNodes = 0;
	}
	
	public boolean insert(String valueString){
		
		if(valueString == null){
			return false;
		}
		
		Node current = root;
		current = insertCharAtNode(current, valueString.charAt(0));
		for(int i=1 ; i<valueString.length() ; ++i){
			current = insertRestCharAtNode(current, valueString.charAt(i));
		}
		
		if(current != null){
			current.setMarked(true);	// mark it as end of a word
		}
		return true;
		
	}// end of insert

	public boolean find(String valueString){
		Node current = findNode(valueString);
		
		if(current == null){
			return false;
		}
		
		return current.isMarked();
	}
	
	public List<String> findCorrectionsFor(String valueString){
		Node current = findNode(valueString);
		
		if(current == null){
			return new ArrayList<String>();
		}
		
		List<String> list = getCandidatesFor(current, valueString.substring(0, valueString.length()-1));
		return list;
	}

	private Node insertRestCharAtNode(Node currentNode, char currentChar){
		if(currentNode == null){
			return null;
		}
		
		Node valueNode = new Node(currentChar);
		if(currentNode.getMiddle() == null){
			currentNode.setMiddle(valueNode);
			valueNode.setParent(currentNode);
			++noOfNodes;
			return valueNode;
		}
		else {
			currentNode = currentNode.getMiddle();
			return insertCharAtNode(currentNode, currentChar);
		}		
	}
	
	private Node findNode(String valueString){
		if(valueString == null){
			return null;
		}
		
		Node current = root;
		current = findNodeWithChar(current, valueString.charAt(0));
		if(current == null){
			return null;
		}
		for(int i=1; i<valueString.length(); ++i){
			current = findRestNodeWithChar(current, valueString.charAt(i));
			
			if(current == null){
				return null;
			}
		}
		
		return current;
	}
	
	private Node findRestNodeWithChar(Node currentNode, char currentChar) {
		if(currentNode == null){
			return null;
		}

		if(currentNode.getMiddle() == null){
			return null;
		}
		else {
			currentNode = currentNode.getMiddle();
			return findNodeWithChar(currentNode, currentChar);
		}
	}

	private List<String> getCandidatesFor(Node currentNode, String halfPart){
		List<String> candidates = new ArrayList<String>();
		
		if(currentNode == null){
			return candidates;
		}
		
		if(currentNode.isLeaf()){
			// its leaf node. you cant go further down
			candidates.add(halfPart+currentNode.getValue());
			return candidates;
		}
		
		if(currentNode.isMarked()){
			// its marked node represents one word.
			candidates.add(halfPart+currentNode.getValue());
		}
		
		
		if(currentNode.getLeft() != null){
			candidates.addAll(getCandidatesFor(currentNode.getLeft(), halfPart));
		}
		
		if(currentNode.getMiddle() != null){
			candidates.addAll(getCandidatesFor(currentNode.getMiddle(), halfPart+currentNode.getValue()));
		}
		
		if(currentNode.getRight() != null){
			candidates.addAll(getCandidatesFor(currentNode.getRight(), halfPart));
		}
		return candidates;
	}

	private Node insertCharAtNode(Node currentNode, char value){
		Node valueNode = new Node(value);
		Node previousNode; // = currentNode;
		
		if(currentNode == null){
			if(root == null){
				root = valueNode;
				return root;
			}else {
				return null;
			}
		}
		while(currentNode != null){
			previousNode = currentNode;
			
			if(currentNode.getValue() < value){
				// goto left
				currentNode = currentNode.getLeft();
			
				if(currentNode == null) { 
					previousNode.setLeft(valueNode);
					valueNode.setParent(previousNode);
					++noOfNodes;
					
					return valueNode;
				}
			} else if(currentNode.getValue() > value){
				// goto right
				currentNode = currentNode.getRight();
				
				if(currentNode == null) { 
					previousNode.setRight(valueNode);
					valueNode.setParent(previousNode);
					++noOfNodes;
				
					return valueNode;
				}
			} else if(currentNode.getValue() == value){
				// self
				return currentNode;
			}
		}// end of loop
		return null;
	}

	private Node findNodeWithChar(Node currentNode, char value) {
		if(currentNode == null){
			return null;
		}
		
		while(currentNode != null){
			if(currentNode.getValue() == value){
				return currentNode;
				
			} else if(currentNode.getValue() < value){
				currentNode = currentNode.getLeft();
				
			}else if(currentNode.getValue() > value){
				currentNode = currentNode.getRight();
			
			}
		}
		
		return null;
	}
	
	public int getNoOfNodes(){ return this.noOfNodes; }
}
