package algorithm;

import historylog.HistoryLog;

public class ShellSort extends Algorithm {
	@Override
	public String sort() {
		numberOfIteration = 0;
		
		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};  // Ciura gap sequence
		
		for (int gap: gaps) {
			
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				
				int j = i;
				for (; j - gap >= 0; j -= gap) {
					// log writing
					historyLogs.add(new HistoryLog(
							arr.clone(),
							new int[] {arr[j], arr[j-gap]},
							new int[] {j, j-gap},
							++numberOfIteration,
							0));
					if (arr[j - gap] > temp) {
						arr[j] = arr[j - gap];
						arr[j - gap] = temp;  // redundant in algorithm but needed for demonstration
					} else {
						break;
					}
				}
				// arr[j] = temp;  // this can be removed because of the redundancy above, lol
			}
		}
		
		return "";
	}
	
	public ShellSort(int[] data, int passInNumberOfInstance) {
		super(data, passInNumberOfInstance);
	}
	
}