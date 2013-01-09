package mew.misc.huffman;

import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> {

	private ArrayList<E> arr;
	private int endPtr;
	
	public MinHeap(int size) {
		this.arr = new ArrayList<E>(size);
		this.endPtr = -1;
	}
	
	public void add(E elem){
		++endPtr;
		arr.add(elem);		
		adjustBottomToTop(endPtr);
	}

	public E get(){
		if(endPtr == -1){
			return null;
		}
		
		return arr.get(0);
	}
	
	public E remove(){
		E value = arr.remove(0);	// only one place to handle negative case. no code duplication
		
		if(endPtr >=1){
			arr.add(0, arr.remove(endPtr-1));
		}
		
		--endPtr;
		adjustTopToBottom(0);
		
		return value;
	}
	
	/**
	 * Always adjusts from posth position from array.
	 */
	private void adjustTopToBottom(int pos) {		
		if(pos <0 || pos > endPtr){	return;	}
		
		int lastParentNode = endPtr/2-1;
		
		while(pos <= lastParentNode){
			int minPtr = pos;
			if(pos*2+1 <= endPtr && arr.get(pos*2+1).compareTo(arr.get(minPtr)) < 0){
				minPtr = pos*2+1;
			}
			if(pos*2+2 <= endPtr && arr.get(pos*2+2).compareTo(arr.get(minPtr)) < 0){
				minPtr = pos*2+2;
			}
			if(minPtr != -1 && arr.get(minPtr).compareTo(arr.get(pos)) < 0){
				E temp = arr.get(pos);
				arr.set(pos, arr.get(minPtr));
				arr.set(minPtr, temp);
			}else {
				break;
			}
			
			pos = minPtr;
		}
	}
	
	private void adjustBottomToTop(int pos) {
		if(pos < 0 || pos > endPtr){
			return;
		}
		
		while(pos != 0){
			
			if(arr.get(pos).compareTo(arr.get((pos-1)/2)) < 0){
				E temp = arr.get(pos);
				arr.set(pos, arr.get((pos-1)/2));
				arr.set((pos-1)/2, temp);
			}else {
				break;
			}
						
			pos = (pos-1) / 2;
		}
		
	}
	
	public int getNoOfElements(){
		return this.endPtr+1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		
		
		for(int i=0 ; i<= endPtr ; ++i){
			sb.append(arr.get(i)+", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
