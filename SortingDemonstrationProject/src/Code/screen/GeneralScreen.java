package screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class GeneralScreen extends JFrame{
	/**
	 * An abstract screen that will have Sorting Screen and Help Screen inherit from this
	 */
	private static final long serialVersionUID = 1L;
	
	protected JPanel contentPane = new JPanel();
	
	public void createMenuAndTitle() {
		setBackground(Color.DARK_GRAY);
		setTitle("Sorting Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuBtn = new JMenu("Menu");
		menuBar.add(menuBtn);
		
		JMenuItem menuSorting = new JMenuItem("Sorting Application");
		menuBtn.add(menuSorting);
		menuSorting.addActionListener(new MenuListenter());
		
		JMenuItem menuHelp = new JMenuItem("Help");
		menuBtn.add(menuHelp);
		menuHelp.addActionListener(new MenuListenter());
		
		JMenuItem menuQuit = new JMenuItem("Quit");
		menuBtn.add(menuQuit);
		menuQuit.addActionListener(new MenuListenter());
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sorting Demonstration");
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setFont(new Font("Quicksand", Font.PLAIN, 33));
		lblNewLabel.setBounds(13, 4, 372, 35);
		contentPane.add(lblNewLabel);
	}
	
	public abstract void createCenter();
	
	private class MenuListenter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String btnCommand = e.getActionCommand();
			if (btnCommand == "Sorting Application") {
				try {
					SortingScreen frame = new SortingScreen();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				dispose();
			}
			else if (btnCommand == "Help"){
				try {
					HelpScreen frame = new HelpScreen();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				dispose();
			}
			else if (btnCommand == "Quit") {
				dispose();
			}
		}
	}
}
