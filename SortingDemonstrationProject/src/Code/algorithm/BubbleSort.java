package algorithm;

import historylog.HistoryLog;

public class BubbleSort extends Algorithm {
	
	public String sort() {
		int n = arr.length;
		this.numberOfIteration = 0;
		
		
		StringBuilder res = new StringBuilder();
		res.append("Non-sorted array: ");
		res.append(this.toString());
		res.append("\n\n");
		
		for (int i = 0; i < n-1; i++) {
			for (int j = n - 1; j > i; j--) {
				this.numberOfIteration++;
				res.append(String.format("Comparing: \t Comparing %s at index %s to %s at index %s\n", arr[j], j, arr[j-1], j-1));
				int[] currentArr = new int[arr.length];
				for(int k = 0; k < arr.length; k++){
					currentArr[k] = arr[k];
				}
				historyLogs.add(new HistoryLog(currentArr, new int[] {arr[j], arr[j-1]}, new int[] {j, j-1}, numberOfIteration, i));
				if (arr[j] < arr[j-1]) {
					res.append(String.format("Swapping: \t Since the int at index %s is larger than the number at index %s, we swap these two numbers\n", j-1, j));
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
				else {
					res.append("No Swapping: \t It has correctly placed, so nothing swap\n");
				}
				res.append(String.format("Printing: \t Array at iteration %s ", numberOfIteration));
				res.append(this.toString() + "\n");
			}
		}
		
		res.append("\n\nSorted array: ");
		res.append(this.toString());
		res.append("\n");
		return res.toString();
	}
	
	
	
	public BubbleSort(int[] data, int passInNumberOfInstance) {
		super(data, passInNumberOfInstance);
	}
}