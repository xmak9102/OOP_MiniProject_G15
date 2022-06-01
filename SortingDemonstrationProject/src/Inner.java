import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;


public class Inner extends JFrame implements ActionListener{

	JMenuBar menuBar;	
	JMenu mainMenu;
	JMenu helpMenu;
	JMenu quitMenu;	
	JMenuItem Item1;
	JMenuItem Item2;
	JMenuItem Item3;
	JMenuItem quitItem;
	JMenuItem aboutItem;
	
	JLabel label;
	JLabel array;
	JLabel result;
	
	JTextField textField;
	
	JButton button1;
	JButton button2;
	JButton back;
	JButton execute;
	
	int no_of_elements;
	
	int max_no_of_elm = 10; //(for random) maximum number of elements
	int max_val_of_elm = 50; //(for random) maximum value of each element
	
	String in_text;
	
	
	String bubble_sort = new String("Bubble sort");
	String heap_sort = new String("Heap sort");
	String shell_sort = new String("Shell sort");
	
	String algorithm; //algorithm in use
	ArrayList<Integer> main_array; //array in use
	
	
	Inner(){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Group 15");
		this.setSize(600,500);
		this.setResizable(false);
		this.setLayout(null);		
		this.getContentPane().setBackground(Color.gray);
		this.setLocationRelativeTo(null);
		
		//-------Algorithm-------------
		label = new JLabel();
		label.setText("Algorithm");
		label.setBorder(BorderFactory.createLineBorder(Color.orange,3));
		//label.setHorizontalTextPosition(JLabel.CENTER);
		//label.setVerticalTextPosition(JLabel.CENTER);
		label.setForeground(Color.orange);
		label.setFont(new Font("MV Boli",Font.PLAIN,45));
		label.setBackground(Color.gray);
		label.setBounds(40, 10, 410, 50);

		
		//-------menuBar------------
		menuBar = new JMenuBar();
		
		mainMenu = new JMenu("Algorithms");
		helpMenu = new JMenu("Help");
		quitMenu = new JMenu("Quit");
		
		Item1 = new JMenuItem("Bubble sort");
		Item2 = new JMenuItem("Heap sort");
		Item3 = new JMenuItem("Shell sort");
		
		aboutItem = new JMenuItem("About");
		
		quitItem = new JMenuItem("Quit");
		
		Item1.addActionListener(this);
		Item2.addActionListener(this);
		Item3.addActionListener(this);
		quitItem.addActionListener(this);
		aboutItem.addActionListener(this);
		
		mainMenu.setMnemonic(KeyEvent.VK_A); //Alt + A
		helpMenu.setMnemonic(KeyEvent.VK_H); //Alt + H
		quitMenu.setMnemonic(KeyEvent.VK_Q); //Alt + Q
		
		Item1.setMnemonic(KeyEvent.VK_B); 
		Item2.setMnemonic(KeyEvent.VK_H); 
		Item3.setMnemonic(KeyEvent.VK_S); 
		quitItem.setMnemonic(KeyEvent.VK_Q); 
		aboutItem.setMnemonic(KeyEvent.VK_A);
		
		mainMenu.add(Item1);
		mainMenu.add(Item2);
		mainMenu.add(Item3);
		quitMenu.add(quitItem);
		helpMenu.add(aboutItem);
		
		menuBar.add(mainMenu);
		menuBar.add(helpMenu);
		menuBar.add(quitMenu);

		
		//--------Text_Area----------
		textField = new JTextField();
		textField.setBounds(40, 70, 300, 50);
		textField.setFont(new Font("Consolas", Font.PLAIN,35));
		textField.setForeground(new Color(0x1AEE10));
		textField.setBackground(Color.white);
		
		//------random-------
		button1 = new JButton("Random");
		button1.setFont(new Font("Ink Free",Font.BOLD,20));
		button1.setBounds(350, 70, 100, 50);
		button1.setForeground(Color.cyan);
		button1.setBackground(Color.black);
		button1.setBorder(BorderFactory.createEtchedBorder());
		button1.addActionListener(this);
		button1.setFocusable(false);
		
		//-------Create---------
		button2 = new JButton("Create");
		button2.setFont(new Font("Ink Free",Font.BOLD,20));
		button2.setForeground(Color.green);
		button2.setBackground(Color.black);
		button2.setBounds(200, 130, 100, 50);
		button2.setBorder(BorderFactory.createEtchedBorder());
		button2.addActionListener(this);
		button2.setFocusable(false);
		
		//-----Created_array-------
		array = new JLabel();
		array.setText("[------Created_array-----]");
		array.setForeground(Color.red);
		array.setFont(new Font("MV Boli",Font.PLAIN,35));
		array.setBackground(Color.black);
		array.setBounds(40, 195, 600,50);
		
		//------back-------		
		back = new JButton("Clear");
		back.setFont(new Font("Ink Free",Font.BOLD,20));
		back.setForeground(Color.orange);
		back.setBackground(Color.black);
		back.setBorder(BorderFactory.createEtchedBorder());
		back.setBounds(100, 260, 140, 50);
		back.addActionListener(this);
		back.setFocusable(false);
		
		//------Execute-------		
		execute = new JButton("Execute");
		execute.setFont(new Font("Ink Free",Font.BOLD,20));
		execute.setForeground(Color.green);
		execute.setBackground(Color.black);
		execute.setBorder(BorderFactory.createEtchedBorder());
		execute.setBounds(260, 260, 140, 50);
		execute.addActionListener(this);
		execute.setFocusable(false);
		
		//-------Result--------
		result = new JLabel();
		result.setText("Result");
		result.setForeground(Color.pink);
		result.setFont(new Font("MV Boli",Font.PLAIN,45));
		result.setBackground(Color.gray);
		result.setBounds(130, 340, 600, 50);
		
		
		//------------------
		this.setJMenuBar(menuBar);
		this.add(label);
		this.add(textField);
		this.add(button2);
		this.add(button1);
		this.add(array);
		this.add(back);
		this.add(execute);
		this.add(result);

		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == quitItem) {
			int answer = JOptionPane.showConfirmDialog(null, "Confirm to quit?");
			if(answer == 0) {System.exit(0);}
			}
		if(e.getSource() == aboutItem) {
			this.dispose();
			Information in4 = new Information();
			}
			
		if(e.getSource() == Item1) {
			label.setText("Bubble sort");
			algorithm = bubble_sort;
			}
		if(e.getSource() == Item2) {
			label.setText("Heap sort");
			algorithm = heap_sort;
			}
		if(e.getSource() == Item3) {
			label.setText("Shell sort");
			algorithm = shell_sort;
			}
		
		if(e.getSource()==button1) { //random button
			Random random = new Random();
			no_of_elements = random.nextInt(max_no_of_elm) + 1;
			Integer[] main_array = new Integer[no_of_elements];
			for(int i = 0; i<main_array.length; i+=1) {
				main_array[i] = random.nextInt(max_val_of_elm) + 1;
			}
			in_text = new String("");
			for(int i = 0; i<main_array.length; i+=1) {
				in_text += main_array[i] + ",";
			}
			textField.setText(in_text);
			}
		
		if(e.getSource()==button2) { //create button
			String t = textField.getText();
			String pr_text = "[" + t + "]";
			array.setText(pr_text);
			
			Pattern integerPattern = Pattern.compile("-?\\d+");
			Matcher matcher = integerPattern.matcher(t);
			
			List<String> integerList = new ArrayList<>();
			while (matcher.find()) {
		        integerList.add(matcher.group());
		    	}
			main_array = new ArrayList<Integer>();
			for (int i = 0; i < integerList.size(); i+=1) {
				main_array.add(Integer.parseInt(integerList.get(i)));
				}
			}
		
		if(e.getSource()==back) {
			label.setText("Algorithm");
			array.setText("[------Created_array-----]");
			textField.setText("");
			result.setText("Result");
			algorithm = null;
			}
		
		
		//----------
		if(e.getSource()==execute) {
			
			if(algorithm.equals(bubble_sort)) {
				this.dispose();
				Bubble b1 = new Bubble();
			}
			else if(algorithm == heap_sort) {
				this.dispose();
				Heap b2 = new Heap();
			}
			else if(algorithm == shell_sort) {
				this.dispose();
				Shell b3 = new Shell();
			}
			
			else {
				Integer total = 0;
				for (int i = 0; i < main_array.size(); i+=1) {
					total += main_array.get(i); }
				result.setText("Total: "+ total.toString());
				}
				
		}
		
		
	}
}
