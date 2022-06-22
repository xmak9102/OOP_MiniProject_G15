package algorithm;

public class HeapSort extends Algorithm {
	
	public HeapSort(int[] data) {
		super(data);
	}

	public void sort() {
		int n = arr.length;
		
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n , 1);
		}
		
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
	}
	
	public void heapify(int[] arr, int n, int i) {
		int parentNode = i;
		int left = 2*i;
		int right = 2*i + 1;
		
		if (left < n && arr[left] > arr[parentNode]) {
			parentNode = left;
		}
		
		if (right < n && arr[right] > arr[parentNode]) {
			parentNode = right;
		}
		
		if(parentNode != i) {
			int swap = arr[i];
			arr[i] = arr[parentNode];
			arr[parentNode] = swap;
			
			heapify(arr, n , parentNode);
		}
	}
}