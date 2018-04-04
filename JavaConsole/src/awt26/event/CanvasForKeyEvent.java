package awt26.event;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//1]Canvas 상속
public class CanvasForKeyEvent extends Canvas {

	
	public static final int CHARACTER_WIDTH=50;
	public static final int CHARACTER_HEIGHT=50;
	//멤버변수]
	private int xPos,yPos;
	
	
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		
		this.yPos = yPos;
	}
	//2]paint()오버라이딩
	@Override
	public void paint(Graphics g) {
		//이미지 메모리로 로딩]
		Image image=Toolkit.getDefaultToolkit().getImage("src/awt26/event/terran.jpg");
		//이미지 표시
		g.drawImage(image,xPos,yPos, CHARACTER_WIDTH, CHARACTER_HEIGHT, this);
	
	}////////////////
}///////////////////////
