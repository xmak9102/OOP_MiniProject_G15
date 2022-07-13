package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.Max_heap;


	public class Heap_test {
		
	static int ito = 0; //no_of_elements_in_true_order
	static ArrayList<Integer[]> history_log = new ArrayList<Integer[]>(); 
	
	public static void main(String[] arg) {
       Integer[] arr = {5,3,17,10,84,19,6,22,9};
       System.out.println("Input array: " + arr.toString());
       System.out.println("");
                
       history_log.add(arr);
       
       
       for (int j = 0; j < arr.length; j += 1) {
       Max_heap maxHeap = new Max_heap(history_log.get(history_log.size()-1).length);    
       maxHeap.build_max(history_log.get(history_log.size()-1)); 
       maxHeap.print();
       System.out.println("");
       maxHeap.swap(0, history_log.get(history_log.size()-1).length-1);
       ito += 1;
       maxHeap.print();
       System.out.println("");
       
       System.out.println("Remove last element");
       Integer[] arr_temp = new Integer[history_log.get(history_log.size()-1).length-1];
       for (int i = 0; i < arr_temp.length; i += 1) {
    	   arr_temp[i] = maxHeap.Heap[i];
    	   System.out.print(maxHeap.Heap[i] + " ");
       }
       System.out.println("");
       history_log.add(arr_temp);
       }
 
        
    }
}
