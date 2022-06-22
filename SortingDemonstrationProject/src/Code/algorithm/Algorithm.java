package algorithm;

public abstract class Algorithm implements Sortable{
	int[] arr;
	int numberOfIteration;
	
	
	public int[] getArr() {
		return arr;
	}
	public int getNumberOfIteration() {
		return numberOfIteration;
	}
	public void print() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public Algorithm(int[] data) {
		arr = data;
	}
}
