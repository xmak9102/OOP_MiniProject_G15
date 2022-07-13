package algorithm;

import historylog.HistoryLog;
import java.lang.Math;


//historyLogs.add(new HistoryLog(currentArr, new int[] {arr[j], arr[j-1]}, new int[] {j, j-1}, numberOfIteration, i));

public class HeapSort extends Algorithm {
	
	int ito = 0; //no_of_elements_in_true_order
	int numberOfIteration = 0;
	int[] my_arr = arr;
	
	 
	public HeapSort(int[] data, int passInNumberOfInstance) {
		super(data, passInNumberOfInstance);
	}
	
	public static boolean checkMinHeap(int[] A) { //check an array in min-heap or not
        if (A.length <= 1) {
            return true;
	        }       
        for (int i = 0; i <= (A.length - 2) / 2; i++) {
            if (A[i] > A[2*i + 1] || (2*i + 2 != A.length && A[i] > A[2*i + 2])) {
                return false;
            		}
        		}
        	return true;
    	}
	
	int parent(int i) { return Math.floorDiv(i, 2); }
	int leftChild(int i) { return (2 * i) + 1; }
	int rightChild(int i) { return (2 * i) + 2;}
	
    void swap(int i, int j, int[]arr) {		
        int tmp;
        tmp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = tmp;  
        }

    public void minHeapify(int[] arr,int i) { //build min heap arr from index i

   		int[] newarr = new int[arr.length-i];
        for (int j = 0; j < newarr.length; j += 1) {
        	newarr[j] = arr[j+i];
        }
        
   		while (!checkMinHeap(newarr)) {
   			
   		int starting_index = (int) Math.floor((newarr.length)/2 - 1) ;
   		for (int j = starting_index; j >= 0; j -= 1) {
   			
   			int sw = 0;
   			if ( (int) rightChild(j) >= newarr.length) { sw = leftChild(j); } //if == happens, rightChild is not exist
   			else { sw = newarr[leftChild(j)]<newarr[rightChild(j)] ? leftChild(j):rightChild(j); }
   			
   			//-------------
   			int[] currentArr = new int[my_arr.length];
			for(int k = 0; k < my_arr.length; k++){
				currentArr[k] = my_arr[k];
			}
   			numberOfIteration +=1;
   			historyLogs.add(new HistoryLog(currentArr, 
   					new int[] {arr[j+i], arr[sw+i]}, new int[] {j+i, sw+i}, numberOfIteration, ito));
   			//-------------
   			
   			if ((int) rightChild(j) >= newarr.length) { //if == happens, rightChild is not exist
   				if(newarr[j]>newarr[leftChild(j)]) {
   					 swap(j,sw, newarr);
   					 swap(j+i, sw+i, my_arr);
   			          }	
   				}
   			else if (newarr[j]>newarr[leftChild(j)] || newarr[j]> newarr[rightChild(j)]){
   		         swap(j,sw, newarr);
   		         swap(j+i, sw+i, my_arr);
   		       		}
   				}
   			}ito += 1;	
   		}
	
	public String sort() {
		
		for (int i = 0; i < my_arr.length-1 ; i += 1) {
			minHeapify(my_arr, i);			
			}
		
		return null;
		}
}