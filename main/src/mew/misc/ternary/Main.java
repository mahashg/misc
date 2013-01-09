package mew.misc.ternary;

import java.util.List;



public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree();
		String[] insertArr = new String[] {"ab", "abc", "abd", "aba", "abe", "mahesh", "bhaskar", "bhaskara"};
		String[] searchArr = new String[] {"ab", "abcde", "abca", "abcd", "bhaskara"};
		String[] correctionArr = new String[]{"ab", "aba"};
		for(String str : insertArr){
			System.out.println("inserting: "+str+" as: "+tree.insert(str));
		}
		
		for(String str: searchArr){
			System.out.println("searching: "+str+" is present?: "+tree.find(str));
		}
		
		for(String correction : correctionArr){
			List<String> list = tree.findCorrectionsFor(correction);
			System.out.println("Finding correction for: "+correction);
			
			if(list.isEmpty()){
				System.out.println("No Correction Found!!!");
			}
			for(String str : list){
				System.out.print(str+"\t");
			}
			System.out.println();
		}
	}
}
