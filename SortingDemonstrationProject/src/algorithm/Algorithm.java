package algorithm;

import java.util.ArrayList;

import historylog.HistoryLog;

public abstract class Algorithm implements Sortable{
	int[] arr;
	int numberOfIteration;
	int numberOfInstance;
	
	//keep a history tracks of changing states of a specify algorithm
	protected ArrayList<HistoryLog> historyLogs = new ArrayList<HistoryLog>();

	
	
	public int[] getArr() {
		return arr;
	}
	
	public int getNumberOfIteration() {
		return numberOfIteration;
	}
	
	public ArrayList<HistoryLog> getHistoryLogs() {
		return historyLogs;
	}
	
	//output a String of the current array
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != 0) {
				res.append(" ");
			}
			res.append(arr[i]);
		}
		res.append("]");
		return res.toString();
	}
	
	public String printHistoryLogs() {
		StringBuilder res = new StringBuilder();
		for (HistoryLog log: historyLogs) {
			res.append("[");
			for (int i = 0; i < log.getCurrentArr().length; i++) {
				if (i != 0) {
					res.append(" ");
				}
				res.append(log.getCurrentArr()[i]);
			}
			res.append("]\n");
			
			res.append("comParing array: [");
			for (int item: log.getComparing()) {
				res.append(item + " ");
			}
			res.append("]\n");
			res.append("comparing index array: [");
			for (int item: log.getComparingIndex()) {
				res.append(item + " ");
			}
			res.append("]\n");
			res.append("Number of iter: " + log.getNumberOfIteration() + "\n");
			res.append("Number of i: " + log.getCorrectFrom() + "\n");
		}
		return res.toString();
	}
	
	public Algorithm(int[] data, int passInNumberOfInstance) {
		arr = data;
		numberOfInstance = passInNumberOfInstance;
	}
}
