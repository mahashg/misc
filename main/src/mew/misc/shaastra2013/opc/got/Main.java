package mew.misc.shaastra2013.opc.got;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int nCase = read.nextInt();
		
		while(nCase > 0){
			int N = read.nextInt();
			int A = read.nextInt();
			int B = read.nextInt();
			
			int[] arr = new int[N];
			for(int i=0 ; i<N ; ++i){
				arr[i] = read.nextInt();
			}
			
			System.out.println(doProcessing(A, B, arr));
			--nCase;
		}
	}
	
	public static String doProcessing(int A, int B, int[] arr){
	
		int totalCount=0;
		for(int i=0 ; i< arr.length ; ++i){
			totalCount += countNoOfSteps(A, B, arr[i]);
		}
		if(totalCount % 2 == 0){
			return "WIN";
		}else {
			return "LOSS";
		}
	/*	while(true){
			if(!doNextStep(A, B, arr)){
				return "LOSS";
			}
			
			if(!doNextStep(A, B, arr)){
				return "WIN";
			}
		}*/
	}
	
	/*public static boolean doNextStep(int A, int B, int[] arr){
		int maxValue = Math.max(A, B);
		
		for(int i=0 ; i<arr.length ; ++i){
			
		}
	}*/
	
	public static int countNoOfSteps(int A, int B, int val){
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		
		int count=0;
		while(val < min){
			if(val > max){
				val -= max;
			} else {
				val -= min;
			}
			
			
			++count;
		}
		return count;
	}
}
