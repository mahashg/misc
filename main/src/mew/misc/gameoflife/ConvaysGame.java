package mew.misc.gameoflife;

public class ConvaysGame {


	public static boolean[][] tick(boolean[][] matrix){
		
		boolean[][] retMatrix = new boolean[matrix.length][];
		
		for(int i=0 ; i<matrix.length ; ++i){			
			retMatrix[i] = new boolean[matrix[i].length];
			
			for(int j=0 ; j<retMatrix[i].length ; ++j){
				retMatrix[i][j] = getNextStateForCellUsingConvaysGameRule(matrix[i][j], countAliveNeighbours(matrix, i, j));
			}
		} // create return matrix
		
		return retMatrix;
	}
	
	public static void printWorld(boolean[][] matrix){
		for(int i=0 ; i<matrix.length ; ++i){
			for(int j=0 ; j<matrix[i].length ; ++j){
				String print = (matrix[i][j]) ? "1" : "0";
				System.out.print(print+", ");
			}
			System.out.println();
		}
	}


	/**
	 * The Method depicting rules of Convay's Game.
	 * 
	 */
	 static boolean getNextStateForCellUsingConvaysGameRule(boolean currentState, int aliveNeighbour) {
		
		if(aliveNeighbour == -1){
			// depicting error condition
			return false;
		}
		return ( (aliveNeighbour == 3) ||
				 (aliveNeighbour == 2 && currentState) 
			   );
	}
	
	private static int countAliveNeighbours(boolean[][] space, int row, int col){
		if(space == null || space.length <=row || space[row].length <= col){
			
			return -1;
		}
	
		// consider all 8 neighbours
		int countValue = count(space, row+1, col+1)
					+ count(space, row+1, col)
					+ count(space, row+1, col-1)
					+ count(space, row, col+1)
					+ count(space, row, col-1)
					+ count(space, row-1, col+1)
					+ count(space, row-1, col)
					+ count(space, row-1, col-1);
		
		return countValue;
	}

	private static int count(boolean[][] space, int i, int j) {
		// it is 0 if either its out of bound or its dead.
		if(i<0 || j<0 || space.length <= i ||
				space[i].length <= j || !space[i][j]){
			
			return 0;
		}
		return 1;
	}
}