package datacontroller;

import java.util.Random;

public class DataController {
	private int NUMBER_OF_INSTANCE;
	private int[] data;
	
	public int[] getData() {
		return data;
	}

	public int getNUMBER_OF_INSTANCE() {
		return NUMBER_OF_INSTANCE;
	}

	public void setNUMBER_OF_INSTANCE(int nUMBER_OF_INSTANCE) {
		NUMBER_OF_INSTANCE = nUMBER_OF_INSTANCE;
		data = new int[NUMBER_OF_INSTANCE];
	}
	
	public void generateData() {
		for (int i = 1; i < NUMBER_OF_INSTANCE + 1; i++) {
			data[i-1] = i;
		}
	}
	
	public void shuffleData() {
		Random rand = new Random();
		
		for (int i = 0; i < NUMBER_OF_INSTANCE; i++) {
			int randomIndexToSwap = rand.nextInt(NUMBER_OF_INSTANCE);
			int temp = data[randomIndexToSwap];
			data[randomIndexToSwap] = data[i];
			data[i] = temp;
		}
	}
	
	//return the current array, either newly create or shuffle
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("[");
		for (int i = 0; i < data.length; i++) {
			if (i != 0) {
				res.append(" ");
			}
			res.append(data[i]);
		}
		res.append("]");
		return res.toString();
	}
}
