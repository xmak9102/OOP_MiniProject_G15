package algorithm;

public class ShellSort extends Algorithm{
	
	public ShellSort(int[] data) {
		super(data);
	}

	//the idea of this sorting algorithm is to use insertion sort on a partially sorted array.
	public void sort() {
		int n = arr.length;
		this.numberOfIteration = 0;
		
		//inner and outer refers to 2 integers in each iteration 
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
				while(inner > interval - 1 && arr[inner - interval] >= temp) {
					arr[inner] = arr[inner - interval];
					inner = inner - interval;
				}
				arr[inner] = temp;
			}
			interval = (interval - 1) / 3;
		}
	}
}
