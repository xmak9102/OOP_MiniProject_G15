package datacontroller;

import java.util.Random;

public class DataController {
	private final int NUMBER_OF_INSTANCE = 100;
	private int[] data = new int[NUMBER_OF_INSTANCE];
	
	public int[] getData() {
		return data;
	}

	public int getNUMBER_OF_INSTANCE() {
		return NUMBER_OF_INSTANCE;
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
	
	public void print() {
		System.out.println("Newly created data: ");
		for (int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
