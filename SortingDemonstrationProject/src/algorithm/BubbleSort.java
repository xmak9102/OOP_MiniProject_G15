package algorithm;

import historylog.HistoryLog;

public class BubbleSort extends Algorithm {
	
	public void sort() {
		int n = arr.length;
		this.numberOfIteration = 0;
		
		for (int i = 0; i < n-1; i++) {
			for (int j = n - 1; j > i; j--) {
				this.numberOfIteration++;
				int[] currentArr = new int[arr.length];
				for(int k = 0; k < arr.length; k++){
					currentArr[k] = arr[k];
				}
				historyLogs.add(new HistoryLog(currentArr, new int[] {arr[j], arr[j-1]}, new int[] {j, j-1}, numberOfIteration, i));
				if (arr[j] < arr[j-1]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
				else {
				}
			}
		}
	}
	
	public BubbleSort(int[] data, int passInNumberOfInstance) {
		super(data, passInNumberOfInstance);
	}
}