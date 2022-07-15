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
		
		String text =
"""	
PROJECT:\tDemonstration of sorting algorithms on an array
Algorithms:\tBubble sort, Heapsort, Shellsort
From:\tSchool of Information and Communication Technology
\tHanoi University of Science and Technology
\tData Science and Artificial Intelligence (IT-E10) - K65
Authors:\tHoang Tran Nhat Minh - 20204883
\tNguyen Quang Minh - 20204884
\tNguyen Tran Xuan Manh - 20200385
\tDuong Vu Tuan Minh - 20209705

"""
;
		
		helpCenter.setText(text);
		helpCenter.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		helpCenter.setEditable(false);
		scrollPane.setViewportView(helpCenter);
		
		contentPane.add(scrollPane);
	}
	
	public HelpScreen() {
		createMenuAndTitle();
		createCenter();
	}
}
