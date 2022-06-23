package algorithm;

public class BubbleSort extends Algorithm {
	public void sort() {
		int n = arr.length;
		this.numberOfIteration = 0;
		
		for (int i = 0; i < n-1; i++) {
			for (int j = n - 1; j > i; j--) {
				this.numberOfIteration++;
				if (arr[j] < arr[j-1]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public BubbleSort(int[] data, int passInNumberOfInstance) {
		super(data, passInNumberOfInstance);
	}
}