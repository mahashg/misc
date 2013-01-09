package mew.misc.matrix.multorder;

import java.io.File;
import java.util.Scanner;

public class MultiplicationOrder {
	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(new File("matrix.txt"));
	
		int size = reader.nextInt();
		
		int[] row = new int[reader.nextInt()];
		int[] col = new int[reader.nextInt()];
		
		for(int i=0 ; i<size ; ++i){
			row[i] = reader.nextInt();
			col[i] = reader.nextInt();
		}
		
		processIt(row, col);
	}

	private static int processIt(int[] row, int[] col) {
		if(row == null || col == null){
			return -1;
		}
		
		if(row.length == 1){	return 0; }
		
		if(row.length == 2){	return row[0]*col[0]*col[1]; }
		
		
		int minValue = Integer.MAX_VALUE, minIndex=-1;
		
		for(int i=1 ; i<row.length ; ++i){
			int total = processIt(subArray(row, 0, i), subArray(col, 0, i));
			total += processIt(subArray(row, i, row.length), subArray(col, i, col.length));
			
			total += row[0]*row[i]*col[col.length-1];
		
			if(total < minValue){
				minValue = total;
				minIndex = i;
			}
		}
		
		return minValue;
	}

	private static int[] subArray(int[] col, int i, int i2) {
	
		return null;
	}
}
