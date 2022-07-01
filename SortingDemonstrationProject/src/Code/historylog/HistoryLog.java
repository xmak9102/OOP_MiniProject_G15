package historylog;

/**
 * 
 * HistoryLog will record changes inside Algorithm.sort() method
 * Algorithm has an attribute ArrayList<HistoryLog> historyLogs (aggregation) that contains multiple HistoryLog
 * changes like the current array, which 2 integers are in comparison, which integers are correctly sorted will be recorded in HistoryLog  
 *
 */
public class HistoryLog {
	
	/*
	 * Understanding attributes: 
	 * currentArr: how the array looks like at the time of recorded (when a HistoryLog is created)
	 * comparing: item inside int arr which are in comparison
	 * comparingIndex: index of the item in comparing
	 * numberOfIteration: number of iteration passed at the time of recorded
	 * correctFrom: used to append text of green color to the screen, indicates from which index that the arr is correctly sorted
	 */
	private int[] currentArr;
	private int[] comparing;
	private int[] comparingIndex;
	private int numberOfIteration;
	private int correctFrom;
	
	
	public int[] getCurrentArr() {
		return currentArr;
	}


	public int[] getComparing() {
		return comparing;
	}


	public int[] getComparingIndex() {
		return comparingIndex;
	}


	public int getNumberOfIteration() {
		return numberOfIteration;
	}


	public int getCorrectFrom() {
		return correctFrom;
	}


	public HistoryLog(int[] currentarrArg, int[] comparingArg, int[] comparingIndexArg, int numberOfIterationArg, int i) {
		currentArr = currentarrArg;
		comparing = comparingArg;
		comparingIndex = comparingIndexArg;
		numberOfIteration = numberOfIterationArg;
		correctFrom = i;
		}
}
