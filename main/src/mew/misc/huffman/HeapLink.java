package mew.misc.huffman;

public class HeapLink implements Comparable<HeapLink>{
        HeapLink left;
        HeapLink right;
        String value;
        int frequency;
        String code;

        HeapLink(String val, int freq){
        	this.value = val;
        	this.frequency = freq;
        	this.code = "";
        }
        HeapLink(HeapLink l, HeapLink r){
        	this.left = l;
        	this.right = r;
        	this.code = "";
        	
        	this.value = this.left.value + this.right.value;
        	this.frequency = this.left.frequency + this.right.frequency;
        }

        HeapLink getLeft(){	return this.left; }

        HeapLink getRight(){ return this.right;}

        String getValue() {	return this.value; }

        int getFrequency(){return this.frequency; }

        String getCode(){	return this.code;}
        void setCode(String c){this.code = c; propagate(c);}
        
        void propagate(String code){
        	if(this.left != null){
        		this.left.setCode(code + this.left.code);
        	}
        	
        	if(this.right != null){
        		this.right.setCode(code + this.right.code);
        	}
        }
        
		public void incrementFrequency() {
			this.frequency++;			
		}
		@Override
		public int compareTo(HeapLink o) {
			if(o == null){
				return 1;
			}
			
			if(this.frequency > o.frequency) { return 1;} 
			if(this.frequency == o.frequency){ return 0;}
			return -1;
		}

}
