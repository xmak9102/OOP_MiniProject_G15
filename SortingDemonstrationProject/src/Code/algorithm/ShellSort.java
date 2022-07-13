package algorithm;

import historylog.HistoryLog;

public class ShellSort extends Algorithm{
	//the idea is to sort on a partially sorted array
	public String sort() {
		int n = arr.length;
		this.numberOfIteration = 1;
		int correctIndexFrom = 0;
		
		//inner and outer refers to 2 integers in each iteration; inner < outer
		int inner, outer, temp;
		int interval = 1;
		
		//we can choose different interval but this is a very common way
		while(interval <= n / 3) {
			interval = interval * 3 + 1;
		}
		while (interval > 0) {
			for (outer = interval; outer < n; outer++) {
				temp = arr[outer];
				inner = outer;
				
				
				if (!(inner > interval - 1 && arr[inner - interval] >= temp)){
					//history log here
					
					//deep copy array at current state
					int[] currentArr = new int[arr.length];
					for(int k = 0; k < arr.length; k++){
						currentArr[k] = arr[k];
					}
					
					historyLogs.add(new HistoryLog(currentArr, new int[] {arr[inner - interval], arr[outer]}, new int[] {inner - interval, outer}, numberOfIteration++, correctIndexFrom));
//					System.out.println("For: " + Arrays.toString(currentArr));
				}
		
				while(inner > interval - 1 && arr[inner - interval] >= temp) {
					//history log here
					
					//deep copy array at current state
					int[] currentArr1 = new int[arr.length];
					for(int k = 0; k < arr.length; k++){
						currentArr1[k] = arr[k];
					}
				
					
					
					arr[inner] = arr[inner - interval];
					historyLogs.add(new HistoryLog(currentArr1, new int[] {arr[inner - interval], temp}, new int[] {inner - interval, outer}, numberOfIteration++, correctIndexFrom));
//					System.out.println("While: " + Arrays.toString(currentArr1));
						
					
					inner = inner - interval;
				}
				if (interval == 1) {
					correctIndexFrom++;
				}
				arr[inner] = temp;
			}
			interval = (interval - 1) / 3;
		}
		return "";
	}
	
	public ShellSort(int[] data, int passInNumberOfInstance) {
		super(data, passInNumberOfInstance);
	}
	
}
