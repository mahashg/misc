package mew.misc.toh.stack;

public class TowerGameState {
	private int numBlocks;
	private String to;
	private String from;
	private String via;
	
	public TowerGameState() {
		this.numBlocks = 0;
	}
	
	public TowerGameState(int numBlocks, String to, String from, String via) {	
		this.numBlocks = numBlocks;
		this.to = to;
		this.from = from;
		this.via = via;
	}

	public int getNumBlocks() {
		return numBlocks;
	}

	public void setNumBlocks(int numBlocks) {
		this.numBlocks = numBlocks;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	@Override
	public String toString() {
		return "StackState [numBlocks=" + numBlocks + ", from="
				+ from +" , to=" + to + ", via=" + via + "]";
	}	
}
