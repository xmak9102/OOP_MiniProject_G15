package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Max_heap  {
	
	public Integer[] Heap;
    private int size;
    private int maxsize;
    
 
	
	public Max_heap(int passInNumberOfInstance) {		
		this.maxsize = passInNumberOfInstance;
        this.size = 0;
        Heap = new Integer[this.maxsize];
		}
	

	    private int parent(int pos) { return (pos - 1) / 2; }	 
	    private int leftChild(int pos) { return (2 * pos) + 1; }
	    private int rightChild(int pos){ return (2 * pos) + 2; }	 
	    private boolean isLeaf(int pos) {
	        if (pos > (size / 2) && pos <= size) {
	            return true;
	        }
	        return false;
	    }
	 
	    public void swap(int fpos, int spos) {   //swap index
	        int tmp;
	        tmp = Heap[fpos];
	        Heap[fpos] = Heap[spos];
	        Heap[spos] = tmp;
	        System.out.println("Swap " + Heap[fpos] + " with " + Heap[spos]);
	    }
	 
	    
	    private void maxHeapify(int pos){
	        if (isLeaf(pos))
	            return;
	 
	        if (Heap[pos] < Heap[leftChild(pos)]|| Heap[pos] < Heap[rightChild(pos)]) {
	 
	            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
	                swap(pos, leftChild(pos));
	                maxHeapify(leftChild(pos));
	            }
	            else {
	                swap(pos, rightChild(pos));
	                maxHeapify(rightChild(pos));
	            }
	        }
	    }
	 

	    public void insert(int element){
	        Heap[size] = element;
	        int current = size;
	        while (Heap[current] > Heap[parent(current)]) {
	            swap(current, parent(current));
	            current = parent(current);
	        }
	        size++;
	    }

	    
		public void print() {
			for (int i = 0; i<Heap.length;i += 1) {
	        	System.out.print(Heap[i] + " ");    	
	        }System.out.println("");
		}
	   
	 public void build_max(Integer[] arr) {
		 for (int i : arr) {
			 this.insert(i);
		 }
		 
	 }
	
}