package swing27;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	public 	MyPanel(){
		setBackground(Color.WHITE);
	}
	public MyPanel(LayoutManager mgr){
		super(mgr);
		setBackground(Color.WHITE);
	}
	
}
