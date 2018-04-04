package innerclass22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InnerAnonymousEvent extends JFrame {
	
	JButton button1,button2,button3;
	
	
	public InnerAnonymousEvent(){
		setTitle("내부 익명 클래스로 이벤트 처리");
		setLayout(new FlowLayout());
		
		add(button1 = new JButton("1st 버튼"));
		add(button2 = new JButton("2nd 버튼"));
		add(button3 = new JButton("3rd 버튼"));
		
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		//버튼 이벤트 처리]
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button1, "첫번째 버튼 클릭");
			}			
		});
		button2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button2, "두번째 버튼 클릭");
				
			}
		});
		button3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button3, "세번째 버튼 클릭");
				
			}
		});
		
		pack();
		setVisible(true);
	}
	/*
	ActionListener listener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==button1)
				JOptionPane.showMessageDialog(button1, "첫번째 버튼 클릭");
			else if(e.getSource()==button2)
				JOptionPane.showMessageDialog(button2, "두번째 버튼 클릭");
			else
				JOptionPane.showMessageDialog(button3, "세번째 버튼 클릭");
			
		}
		
	};
	*/
	public static void main(String[] args) {
		new InnerAnonymousEvent();
		
	}

}
