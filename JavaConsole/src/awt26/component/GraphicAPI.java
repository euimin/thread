package awt26.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;
/*
Canvas나 Container계열에 그림을 그릴때
paint(Graphics g)메소드가 담당
단, 직접 호출 불가능

개발자는 repaint()메소드 호출을 통해 paint()메소드를
호출되도록 할 수 있다.

즉 그림을 다시 그려야 할때 repaint()메소드 호출한다.

repaint()메소드 호출시 진행과정
----------------+-------------------------------------
개발자호출      | JVM내에서 자동 호출
----------------+---------------------------------------------
repaint()   ------>update(Graphics g) ->paint(Graphics g)호출됨
------------------------------------------------------------
update()하는 일:1. 배경색으로 먼저 모두 지운다
               2. paint()호출
                
                
paint()하는일 : 깨끗한 상태에서 다시 그림을 그린다.
*/
public class GraphicAPI extends Frame{

	public GraphicAPI(){
		//1]타이틀 설정
		super("그래픽 관련 API연습");
		//2]리스너부착]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//3]크기 및 보이기
		setSize(400,500);
		setVisible(true);
		
	}
	@Override
	public void paint(Graphics g) {
		//System.out.println("paint() called");
		/*
		 * Graphics의 drawXXX계열 메소드:색이 빈 도형을 그리는 메소드
		 *            fillXXX계열 메소드:색이 꽉찬 도형을 그리는 메소드
		 *            set계열:붓의 색깔을 바꾸거나 글자체등을 설정하는 메소드
		 * 
		 */
		//1]글자 그리기:drawString("문자열",X좌표,Y좌표)
		//(0,0)은 윈도우의 왼쪽 최상단
		//기본 붓으로 텍스트 그리기]
		g.drawString("JAVA", 10,40);
		//붓 색 및 굵기 설정]
		g.setColor(Color.RED);//붓 색을 검정에서 빨강으로 변경
		Font font = new Font("굴림체",Font.BOLD,30);
		g.setFont(font);
		g.drawString("JAVA"	,10,80);
		//붓 색만 변경
		g.setColor(new Color(0, 255, 0, 50));
		g.drawString("자바입니다", 10, 120);
		g.setColor(Color.RED);
		//draw계열 메소드]
		//선그리기]
		g.drawLine(10, 150, 200,150);
		//원 그리기]
		g.drawOval(10, 160, 50,50);
		//사각형 그리기]
		g.drawRect(10, 210, 50,50);
		//다각형 그리기]
		//xPoints:꼭지점의 x좌표의 int형 배열
		//yPoints:꼭지점의 y좌표의 int형 배열
		//nPoints:점의 개수
		int[] xPoints = {116,74,74,115,154,154};
		int[] yPoints ={38,53,88,107,88,53};
		int nPoints = xPoints.length;
		g.drawPolygon(xPoints, yPoints, nPoints);
		//fill계열 메소드]
		g.setColor(new Color(100,125,99));
		g.fillOval(10, 260, 50, 50);
		g.fillRect(10, 310, 50, 50);
		//이미지 표시]
		/* 1]Toolkit클래스를 이용해서 이미지를 메모리로 로드 */
		Image image=Toolkit.getDefaultToolkit().getImage("src/awt26/component/image.JPG");
		//2]drawImage(Image객체,x좌표,y좌표,
	    //          이미지를 그릴 컨테이너객체)메소드로 
	    //이미지를 그려준다.이미지 실제 크기대로 그려짐
		//g.drawImage(image,100,100,this);
		//이미지의 크기조정
		//drawImage(Image객체,x좌표,y좌표,
		//          이미지가로폭,이미지세로폭,
		//          이미지를 그릴 컨테이너객체)
		g.drawImage(image,100,100,50,50,this);
	}
	public static void main(String[] args) {
		new GraphicAPI();
	}

}
