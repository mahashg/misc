package mew.misc.squaredivider;
class Grid{
	int x1, x2, y1, y2;
	int remX, remY;
	
	public void print() {
		//  
		System.out.println("[x1 = "+x1+", x2 = "+x2+", y1 = "+y1+", y2 = "+y2+", removed("+remX+", "+remY+")]");
	}
	
	public int getWidth() {
		return Math.abs(x2-x1) + 1;
	}
	public int getHeight() {
		return Math.abs(y2-y1) + 1;
	}
	
	public int getSize() {
		return (getWidth()*getHeight()-1);

	}
}

public class Divider {
	public static void divideWithOutCut(Grid gd){
		
		//System.out.println("Dividing grid"); gd.print();
		int size = gd.getSize();
		
		if(size == 0 || size % 3 != 0){
			return;
		}
		
		if(gd.getWidth() == 2 && gd.getHeight() == 2){
			gd.print();
			return;
		}
		int midX = (gd.x1 + gd.x2-1) / 2; // it shows end of top left cluster
		int midY = (gd.y1 + gd.y2-1) / 2; // it shows end of top left cluster

		//System.out.println("Mid Values: "+midX+", "+midY);
		boolean isLeft = midX >= gd.remX; // pt removed from left part of divison
		boolean isTop = midY >= gd.remY; // pt removed is from right part of divison

		Grid gd1 = new Grid();	// top left cluster
		gd1.x1 = gd.x1; gd1.x2 = midX; gd1.y1 = gd.y1 ; gd1.y2 = midY;
		if(isLeft && isTop){
			gd1.remX = gd.remX;
			gd1.remY = gd.remY;
		}else {
			gd1.remX = gd1.x2;
			gd1.remY = gd1.y2;
		}

		Grid gd2 = new Grid(); // bottom left cluster
		gd2.x1 = midX+1; gd2.x2 = gd.x2; gd2.y1 = gd.y1 ; gd2.y2 = midY;
		if(isLeft && !isTop){
			gd2.remX = gd.remX;
			gd2.remY = gd.remY;
		}else {
			gd2.remX = gd2.x1;
			gd2.remY = gd2.y2;
		}

		Grid gd3 = new Grid(); 	// top right cluster
		gd3.x1 = gd.x1; gd3.x2 = midX; gd3.y1 = midY+1; gd3.y2 = gd.y2;
		if(!isLeft && isTop){
			gd3.remX = gd.remX;
			gd3.remY = gd.remY;
		}else {
			gd3.remX = gd3.x2;
			gd3.remY = gd3.y1;
		}
		Grid gd4 = new Grid();	// bottom right cluster
		gd4.x1 = midX+1; gd4.x2 = gd.x2; gd4.y1 = midY+1; gd4.y2 = gd.y2;
		if(!isLeft && !isTop){
			gd4.remX = gd.remX;
			gd4.remY = gd.remY;
		}else {
			gd4.remX = gd4.x1;
			gd4.remY = gd4.y1;
		}

		divideWithOutCut(gd1);
		divideWithOutCut(gd2);
		divideWithOutCut(gd3);
		divideWithOutCut(gd4);
	}
	
	public static void main(String[] args) {
		Grid mainGrid = new Grid();
		mainGrid.x1 = 0; mainGrid.x2 = 7; mainGrid.y1 = 0; mainGrid.y2 = 7;
		mainGrid.remX = 3; mainGrid.remY = 3;
		divideWithOutCut(mainGrid);
		System.out.println("End of Processing..");
	}
}
