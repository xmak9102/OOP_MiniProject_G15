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
		instanceInputTextField.setBounds(614, 23, 20, 20);
		contentPane.add(instanceInputTextField);
		instanceInputTextField.setColumns(10);
		
		JLabel instanceInputTextFieldLabel = new JLabel("Number of instances");
		instanceInputTextFieldLabel.setBounds(495, 26, 121, 14);
		contentPane.add(instanceInputTextFieldLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 471, 330);
		contentPane.add(scrollPane);
		
		
		//ColorPane helps us to change the colors of the text easily
		sortingColorPane = new ColorPane();
		sortingColorPane.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		sortingColorPane.setBackground(Color.WHITE);
		sortingColorPane.setText("Creating a new array to start sorting!");
		sortingColorPane.setEditable(false);
		scrollPane.setViewportView(sortingColorPane);
		
		JButton autoCreateArrayBtn = new JButton("Auto create array");
		autoCreateArrayBtn.addActionListener(new createArrayListener());
		autoCreateArrayBtn.setBounds(497, 46, 137, 23);
		contentPane.add(autoCreateArrayBtn);
		
		JButton selfCreateArrayBtn = new JButton("Self create array");
		selfCreateArrayBtn.setBounds(497, 80, 137, 23);
		contentPane.add(selfCreateArrayBtn);
		
		JLabel algorithmToChooseLabel = new JLabel("Algorithm\r\n to choose: ");
		algorithmToChooseLabel.setVerticalAlignment(SwingConstants.TOP);
		algorithmToChooseLabel.setHorizontalAlignment(SwingConstants.LEFT);
		algorithmToChooseLabel.setBounds(495, 122, 153, 18);
		contentPane.add(algorithmToChooseLabel);
		
		JButton bubbleSortBtn = new JButton("Bubble Sort");
		bubbleSortBtn.addActionListener(new choiceOfAlgorithmListener());
		bubbleSortBtn.setBounds(497, 151, 137, 23);
		contentPane.add(bubbleSortBtn);
		
		JButton shellSortBtn = new JButton("Shell Sort");
		shellSortBtn.addActionListener(new choiceOfAlgorithmListener());
		shellSortBtn.setBounds(497, 185, 137, 23);
		contentPane.add(shellSortBtn);
		
		JButton heapSortBtn = new JButton("Heap Sort");
		heapSortBtn.addActionListener(new choiceOfAlgorithmListener());
		heapSortBtn.setBounds(497, 219, 137, 23);
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
	public void writeLogsOnTextPane(ArrayList<HistoryLog> historyLogs) {
		sortingColorPane.setText("");
		sortingColorPane.setEditable(true);
		
		for (HistoryLog log: historyLogs) {
			sortingColorPane.append(Color.black, "[");
			sortingColorPane.append(Color.black, Integer.toString(log.getNumberOfIteration()));
			sortingColorPane.append(Color.black, "]\t");
			
			for (int item : log.getCurrentArr()) {
				//find the index
				int indexOfInt = 0;
				for (int i = 0; i < log.getCurrentArr().length; i++) {
					if (item == log.getCurrentArr()[i]) {
						indexOfInt = i;
					}
				}
				
				if (indexOfInt <= log.getCorrectFrom()-1) {
					sortingColorPane.append(Color.green, Integer.toString(item) + " ");
				}
				else if (item == log.getComparing()[0] || item == log.getComparing()[1]) {
					sortingColorPane.append(Color.red, Integer.toString(item) + " ");
				}
				else {
					sortingColorPane.append(Color.black, Integer.toString(item) + " ");
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
			int chosenNumberOfInstance = Integer.parseInt(instanceInputTextField.getText());
			if (btnCommand == "Auto create array") {
				dataController.setNUMBER_OF_INSTANCE(chosenNumberOfInstance);
				dataController.generateData();
				dataController.shuffleData();
				String str_arr = dataController.toString();
				sortingColorPane.setText("Newly created array : " + str_arr);
			}
			else {
				//need to be updated
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
						writeLogsOnTextPane(historyLogs);
					}
					else if(btnCommand == "Shell Sort") {
						chosenAlgorithm = new ShellSort(dataController.getData(), dataController.getNUMBER_OF_INSTANCE());
						chosenAlgorithm.sort();
						ArrayList<HistoryLog> historyLogs = chosenAlgorithm.getHistoryLogs();
						writeLogsOnTextPane(historyLogs);
					}
					else if(btnCommand == "Heap Sort") {
						chosenAlgorithm = new HeapSort(dataController.getData(), dataController.getNUMBER_OF_INSTANCE());
						chosenAlgorithm.sort();
						ArrayList<HistoryLog> historyLogs = chosenAlgorithm.getHistoryLogs();
						writeLogsOnTextPane(historyLogs);
					}
			}
		}
	}
}
