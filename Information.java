import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Information extends JFrame implements ActionListener{

	JButton back;
	JLabel label;
	JFrame frame;
	
	Information(){
		frame = new JFrame();
		label = new JLabel("Overview of the Sorting program");
		back = new JButton();

			
		label.setBounds(50,0, 500,40);
		label.setFont(new Font("Ink Free", Font.BOLD,30));
		label.setForeground(Color.cyan);
			
		
			
		back.setText("Back");
		back.setFont(new Font("MV Boli", Font.PLAIN,40));
		back.setBounds(10,400, 510, 40);
		back.addActionListener(this);
		back.setForeground(Color.red);
		back.setFocusable(false);

		
		frame.add(label);
		frame.add(back);
		
			
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(550, 500));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			frame.dispose();
			inner in = new inner();
			
		}
		
	}
}
