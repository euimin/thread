package awt26;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowSample {

	public static void main(String[] args) {
		Frame window = new Frame();
		window.setTitle("내가 만든 윈도우 프로그램");
		window.setLayout(new FlowLayout());
		
		TextField field = new TextField(30);
		field.setBackground(Color.GREEN);
		field.setFont(new Font("굴림체", Font.BOLD|Font.ITALIC,20));
		field.setBackground(Color.RED);
		
		window.add(field);
		
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//window.setResizable(false);
		window.setLocation(200, 200);
		window.setSize(400,200);
		window.setVisible(true);
	}/////////////////////

}///////////////////////////
