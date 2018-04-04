package awt26.component;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//1]Canvas를 성속받아 사용자정의 Canvas만들기
public class CustomCanvas extends Canvas{
	
	private Color color=Color.BLACK;
	private Font font = new Font("굴림체",Font.BOLD,20);
	
	public void setColor(Color color) {
		this.color = color;
	}	
	public void setFont(Font font) {
		this.font = font;
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.setFont(font);
		g.drawString("캔바스 입니다",this.getWidth()/2-50,getHeight()/2);
	}
}
