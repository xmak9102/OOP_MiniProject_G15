package algorithms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Heap extends JFrame implements ActionListener{

	JLabel label;
	JButton back;
	
	Heap(){
		
		
		label = new JLabel("Heap sort algorithm");
		label.setBounds(50,0, 500,40);
		label.setFont(new Font("Ink Free", Font.BOLD,30));
		label.setForeground(Color.cyan);
		
		back = new JButton();
		back.setText("Back");
		back.setFont(new Font("MV Boli", Font.PLAIN,40));
		back.setBounds(10,400, 510, 40);
		back.addActionListener(this);
		back.setForeground(Color.red);
		back.setFocusable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Heap sort algorithm");
		this.setSize(550,500);
		this.setResizable(false);
		this.setLayout(null);		
		this.getContentPane().setBackground(Color.gray);
		this.setLocationRelativeTo(null);
		
		this.add(back);
		this.add(label);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			this.dispose();
			Inner in = new Inner();
			
		}
	
	}
}