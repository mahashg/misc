package mew.misc.huffman;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private final static String fileName = "big.txt";
	public static void main(String[] args) {
		ArrayList<HeapLink> heapList = new ArrayList<HeapLink>();
		
		//1. init frequncy count
		for(char ch = 'a' ; ch<= 'z' ; ++ch){
			heapList.add(new HeapLink(ch+"", 0));
		}
		
		// 2. fill the frequncy table with values.
		readFrequncyFromFile(fileName, heapList);

		/*for(HeapLink link : heapList){
			System.out.println(link.getValue()+", "+link.getFrequency() + ", "+link.getCode());
		}*/
		// 3. construct heap data structure and fill it up with values.
		MinHeap<HeapLink> heap = new MinHeap<HeapLink>(heapList.size());
		
		for(HeapLink currentLink : heapList){
			heap.add(currentLink);
		}
				
		while(heap.getNoOfElements() > 1){
			HeapLink first = heap.remove();
			HeapLink second = heap.remove();
			
			first.setCode("0");
			second.setCode("1");
			
/*
			System.out.println(first.getValue()+", "+first.getCode());
			System.out.println(second.getValue()+", "+second.getCode());*/
			heap.add(new HeapLink(first, second));			
		}
		

		for(HeapLink link : heapList){
			System.out.println(link.getValue()+", "+link.getFrequency() + ", "+link.getCode());
		}
		
		System.out.println("End of Processing.");
		
	}
	
	private static void readFrequncyFromFile(String filename,
			ArrayList<HeapLink> heapList) {
		Scanner reader ;
		try {
			reader = new Scanner(new File(filename));
		
			while(reader.hasNext()){
				String line = reader.nextLine();
				line = line.toLowerCase().replaceAll("[^a-z]", "");
				
				for(int i=0 ; i<line.length() ; ++i){
					char ch = line.charAt(i);
					heapList.get(ch-'a').incrementFrequency();					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
