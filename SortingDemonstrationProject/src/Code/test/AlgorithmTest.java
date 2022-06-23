package test;

import algorithm.BubbleSort;
import algorithm.HeapSort;
import algorithm.ShellSort;
import datacontroller.DataController;

public class AlgorithmTest {
	public static void main(String[] args) {
		DataController dataController = new DataController();
		HeapSort heapSort;
		BubbleSort bubbleSort;
		ShellSort shellSort;
		int[] arr;
		int numberOfInstance;
		
		//---scene---
		
		dataController.generateData();
		dataController.shuffleData();
		arr = dataController.getData();
		numberOfInstance = dataController.getNUMBER_OF_INSTANCE();
		
//		heapSort = new HeapSort(arr);
//		heapSort.sort();
//		heapSort.print();
		
		
		//---------------------------
		//Bubble
		bubbleSort = new BubbleSort(arr, numberOfInstance);
		bubbleSort.print();
		bubbleSort.sort();
		bubbleSort.print();
		
		
		//refresh the data 
		dataController.shuffleData();
		arr = dataController.getData();
		
		//---------------------------
		//Shell
		shellSort = new ShellSort(arr, numberOfInstance);
		shellSort.print();
		shellSort.sort();
		shellSort.print();
		
		
		//refresh the data 
		dataController.shuffleData();
		arr = dataController.getData();
		
		//---------------------------
		//Heap
		heapSort = new HeapSort(arr, numberOfInstance);
		heapSort.print();
		heapSort.sort();
		heapSort.print();
	}
}