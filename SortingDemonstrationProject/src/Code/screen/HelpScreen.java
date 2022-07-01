package screen;

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
		scrollPane.setBounds(20, 46, 600, 320);
		
		helpCenter.setText("Write about the help menu\n1\n2\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nJust testing the scroll, ignore it\n\n\n\n\n\nOk");
		scrollPane.setViewportView(helpCenter);
		
		contentPane.add(scrollPane);
	}
	
	public HelpScreen() {
		createMenuAndTitle();
		createCenter();
	}
}
