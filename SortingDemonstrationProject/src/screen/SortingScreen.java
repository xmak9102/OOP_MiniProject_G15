package screen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import algorithm.Algorithm;
import algorithm.BubbleSort;
import algorithm.HeapSort;
import algorithm.ShellSort;
import colorpane.ColorPane;
import datacontroller.DataController;
import historylog.HistoryLog;

public class SortingScreen extends GeneralScreen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataController dataController;
	private Algorithm chosenAlgorithm;
	private JTextField instanceInputTextField;
	private ColorPane sortingColorPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingScreen frame = new SortingScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void createCenter() {
		instanceInputTextField = new JTextField();
		instanceInputTextField.setText("10");
		instanceInputTextField.setBounds(900, 123, 27, 20);
		contentPane.add(instanceInputTextField);
		instanceInputTextField.setColumns(10);
		instanceInputTextField.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel instanceInputTextFieldLabel = new JLabel("Number of instances");
		instanceInputTextFieldLabel.setBounds(775, 126, 121, 14);
		contentPane.add(instanceInputTextFieldLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 701, 486);
		contentPane.add(scrollPane);
		
		
		//ColorPane helps us to change the colors of the text easily
		sortingColorPane = new ColorPane();
		sortingColorPane.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		sortingColorPane.setBackground(Color.WHITE);
		sortingColorPane.setText("Creating a new array to start sorting!");
		sortingColorPane.setEditable(false);
		scrollPane.setViewportView(sortingColorPane);
		
		JButton autoCreateArrayBtn = new JButton("Auto create array");
		autoCreateArrayBtn.addActionListener(new createArrayListener());
		autoCreateArrayBtn.setBounds(777, 146, 137, 23);
		contentPane.add(autoCreateArrayBtn);
		
		JButton selfCreateArrayBtn = new JButton("Self create array");
		selfCreateArrayBtn.addActionListener(new createArrayListener());
		selfCreateArrayBtn.setBounds(777, 180, 137, 23);
		contentPane.add(selfCreateArrayBtn);
		
		JLabel algorithmToChooseLabel = new JLabel("Algorithm\r\n to choose: ");
		algorithmToChooseLabel.setVerticalAlignment(SwingConstants.TOP);
		algorithmToChooseLabel.setHorizontalAlignment(SwingConstants.LEFT);
		algorithmToChooseLabel.setBounds(775, 222, 153, 18);
		contentPane.add(algorithmToChooseLabel);
		
		JButton bubbleSortBtn = new JButton("Bubble Sort");
		bubbleSortBtn.addActionListener(new choiceOfAlgorithmListener());
		bubbleSortBtn.setBounds(777, 251, 137, 23);
		contentPane.add(bubbleSortBtn);
		
		JButton shellSortBtn = new JButton("Shell Sort");
		shellSortBtn.addActionListener(new choiceOfAlgorithmListener());
		shellSortBtn.setBounds(777, 285, 137, 23);
		contentPane.add(shellSortBtn);
		
		JButton heapSortBtn = new JButton("Heap Sort");
		heapSortBtn.addActionListener(new choiceOfAlgorithmListener());
		heapSortBtn.setBounds(777, 319, 137, 23);
		contentPane.add(heapSortBtn);
	}
	
	public SortingScreen() {
		dataController = new DataController();
		
		//all menu screen should have a menu and a title, Help screen also has this one.
		//from general screen
		createMenuAndTitle();
		
		createCenter();
	}
	
	//change the text in ColorPane with a history of algorithm's changing states
	public void writeLogsOnTextPane(ArrayList<HistoryLog> historyLogs, String nameChosenAlgorithm) {
		sortingColorPane.setText("");
		sortingColorPane.setEditable(true);
		sortingColorPane.append(Color.black, "Starting " + nameChosenAlgorithm.toLowerCase() + ":\n");
		
		for (HistoryLog log: historyLogs) {
			sortingColorPane.append(Color.black, "[");
			sortingColorPane.append(Color.black, Integer.toString(log.getNumberOfIteration()));
			sortingColorPane.append(Color.black, "]\t");
			
			for (int i = 0; i < log.getCurrentArr().length; i++) {
				
				if (i <= log.getCorrectFrom()-1) {
					sortingColorPane.append(Color.green, Integer.toString(log.getCurrentArr()[i]) + " ");
				}
				else if (i == log.getComparingIndex()[0] || i == log.getComparingIndex()[1]) {
					sortingColorPane.append(Color.red, Integer.toString(log.getCurrentArr()[i]) + " ");
				}
				else {
					sortingColorPane.append(Color.black, Integer.toString(log.getCurrentArr()[i]) + " ");
				}
			}
			sortingColorPane.append(Color.black, "\n");
		}
		
		sortingColorPane.append(Color.black, "\n\nFinish Sorting: [");
		for (int i = 0; i < chosenAlgorithm.getArr().length; i++) {
			if (i != 0) {
				sortingColorPane.append(Color.green, "  ");
			}
			sortingColorPane.append(Color.green, Integer.toString(chosenAlgorithm.getArr()[i]));
		}
		sortingColorPane.append(Color.black, "]");
		sortingColorPane.setEditable(false);
	}
	
	//Handle the create array command
	private class createArrayListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String btnCommand = e.getActionCommand();
			//lack of handling exception
			
			if (btnCommand == "Auto create array") {
				try {
					int chosenNumberOfInstance = Integer.parseInt(instanceInputTextField.getText());
					dataController.setNUMBER_OF_INSTANCE(chosenNumberOfInstance);
					dataController.generateData();
					dataController.shuffleData();
					String str_arr = dataController.toString();
					sortingColorPane.setText("Newly created array: " + str_arr);
				}
				catch (NumberFormatException error) {
					System.out.println(error);
					JOptionPane.showMessageDialog(null, "You need to specify the number of instance before auto create an array");
				}
			}
			else if (btnCommand == "Self create array"){
				String inputData = JOptionPane.showInputDialog("Enter the array, each item seperated by a space");
				try {
					inputData = inputData.strip();
					String[] inputStrArray = inputData.split(" ");
			        int[] inputIntArray = new int[inputStrArray.length];
			        for (int i = 0; i < inputStrArray.length; i++) {
			        	try {
			        		inputIntArray[i] = Integer.parseInt(inputStrArray[i]);
			        	}
			        	catch (NumberFormatException error){
			        		System.out.println(error);
			        		JOptionPane.showMessageDialog(null, "Your array is not created due to the NumberFormatException");
			        		inputIntArray = null;
			        	}
			        }
			        if (inputIntArray.length != 0) {
			        	dataController.setNUMBER_OF_INSTANCE(inputIntArray.length);
				        dataController.setData(inputIntArray);
				        String str_arr = dataController.toString();
				        sortingColorPane.setText("Newly created array: " + str_arr + "\nArray length: " + inputIntArray.length);
			        }
			        else {
			        	dataController.setData(null);
			        }
				}
				catch (NullPointerException error) {
					System.out.println("Cancel button pressed");
				}
			}
		}
	}
	
	
	private class choiceOfAlgorithmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String btnCommand = e.getActionCommand();
			if (dataController.getData() == null) {
				JOptionPane.showMessageDialog(null, "You must create an array first before sorting!");
			}
			else {
					if (btnCommand == "Bubble Sort") {
						chosenAlgorithm = new BubbleSort(dataController.getData(), dataController.getNUMBER_OF_INSTANCE());
						chosenAlgorithm.sort();
						ArrayList<HistoryLog> historyLogs = chosenAlgorithm.getHistoryLogs();
						writeLogsOnTextPane(historyLogs, "Bubble Sort");
					}
					else if(btnCommand == "Shell Sort") {
						chosenAlgorithm = new ShellSort(dataController.getData(), dataController.getNUMBER_OF_INSTANCE());
						chosenAlgorithm.sort();
						ArrayList<HistoryLog> historyLogs = chosenAlgorithm.getHistoryLogs();
						writeLogsOnTextPane(historyLogs, "Shell Sort");
					}
					else if(btnCommand == "Heap Sort") {
						chosenAlgorithm = new HeapSort(dataController.getData(), dataController.getNUMBER_OF_INSTANCE());
						chosenAlgorithm.sort();
						ArrayList<HistoryLog> historyLogs = chosenAlgorithm.getHistoryLogs();
						writeLogsOnTextPane(historyLogs, "Heap Sort");
					}
			}
		}
	}
}
