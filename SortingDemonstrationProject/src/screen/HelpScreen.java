package screen;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpScreen extends GeneralScreen{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea helpCenter;

	@Override
	public void createCenter() {
		helpCenter = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 950, 476);
		
		String lineSeparatorText =
"""
-------------------------------------------------------------------------------------------------------		
""";
		String projectInfoText =
"""
Project:\tDemonstration of sorting algorithms on an array
Algorithms:\tBubble sort, Heapsort, Shellsort
Class:\tObject-oriented Programming - 131678
Lecturer:\tPhD. Nguyen Thi Thu Trang
School:\tSchool of Information and Communication Technology
\tHanoi University of Science and Technology
Authors:\tData Science and Artificial Intelligence - K65
\tHoang Tran Nhat Minh\t20204883
\tNguyen Quang Minh\t20204884
\tNguyen Tran Xuan Manh\t20200385
\tDuong Vu Tuan Minh\t20209705
GitHub:\thttps://github.com/xmak9102/OOP.DSAI.20212.15
License:\tThis project is licensed under the GNU General Public License v3.0
""";

		String helpStartAlgoText = 
"""
To start an algorithm demonstration:
Step 1, create a new array:
      Method 1, randomize a new array:
            - Input a positive integer as the "Number of elements" in the array
            - Click "Randomize a new array"
      Method 2, input an array:
            - Click "Input an array"
            - Input all the elements of the integer array, separated by a space
            - Click "OK"
Step 2, start an algorithm:
      - Click "Bubble Sort", "Heapsort", or "Shellsort"
      - See the result on the left text field
Step 3:
      - To start another demonstration: restart from step 1
      - To quit: click "Quit" in "Menu" or click X button on the window  
""";
		
		String helpDemonstrationColorText =
"""
Color denotations in the result:
      - All elements of the array are initially colored in black
      - In each step, the two elements that are colored in red will be compared,
         they will be swapped if the first one is larger than the second one
      - In each step, if the first elements of the array are final,
         all of those elements are colored in green
""";
		
		String helpMenuText = 
"""
The menu:
      - "Sorting Application": see the main screen of the application
      - "Help": open help
      - "Quit": quit the application
""";
		
		
		helpCenter.setText(
				lineSeparatorText 
				+ addTwoStartSpacesEachLine(helpStartAlgoText)
				+ "\n" + lineSeparatorText
				+ addTwoStartSpacesEachLine(helpDemonstrationColorText)
				+ "\n" + lineSeparatorText
				+ addTwoStartSpacesEachLine(helpMenuText)
				+ "\n" + lineSeparatorText
				+ addTwoStartSpacesEachLine(projectInfoText)
				+ "\n" + lineSeparatorText.strip()
		);
		helpCenter.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		helpCenter.setEditable(false);
		scrollPane.setViewportView(helpCenter);
		
		contentPane.add(scrollPane);
	}
	
	public HelpScreen() {
		createMenuAndTitle();
		createCenter();
	}
	
	private String addTwoStartSpacesEachLine(String text) {
		return "  " + String.join("\n  ", text.split("\n"));
	}
}
