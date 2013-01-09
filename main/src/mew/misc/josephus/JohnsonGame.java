package mew.misc.josephus;

public class JohnsonGame {
	private int total;
	private int offset;
	int[] arr;
	
	public JohnsonGame(int total, int offset) {		
		this.total = total;
		this.offset = offset;
		
		init();
	}
	
	private void init(){
		arr = new int[total];
		for(int i=0 ; i<arr.length ; ++i){
			arr[i] = i+1;
		}
	}
	
	public void play(){		
		int count = 0;
		int currentIndex = offset-1;
		
		while(count < total){			
			//1. print current
			int value = arr[currentIndex];
			
			System.out.print(value+", ");
			
			//2. remove
			remove(currentIndex);
			
			//3. get next index to begin with
			currentIndex = getNextIndexFrom(currentIndex);
			
			++count; // for each round
		}
		
		System.out.println("--End of Processing--");
	}
	

	private void remove(int index){
		arr[index] = 0;
	}
	
	private int getNextIndexFrom(int currentIndex){
		int count = offset;
		int newIndex = currentIndex;	
		int startPt;
		
		while(count != 0){
			newIndex = (newIndex+1)%arr.length;
			
			startPt =  newIndex;
			while(arr[newIndex] == 0){
				newIndex = (newIndex+1)%arr.length;
				
				if(startPt == newIndex){
					return currentIndex;
				}
			}			
			--count;
		}
		
		return newIndex;
	}
	
	
	public static void main(String[] args) {
		JohnsonGame game = new JohnsonGame(7, 3);
		
		game.play();
	}
}
