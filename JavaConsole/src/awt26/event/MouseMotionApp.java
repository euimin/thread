package awt26.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class MouseMotionApp extends Frame implements LayoutService {

	//[멤버변수]
	private Button[] buttons=new Button[7];
	private String[] buttonLabels={"RED","GREEN","BLUE","THIN","THICK","ERASER","CLEAR"};
	private Canvas canvas;
	
	//캔바스와 관련된 변수들]
	private Color color = Color.BLACK;
	private int width=10,height=10;
	private int xPos=-10,yPos=-10;
	private boolean isClear;
	
	public static final int THICKNESS=10;
	public static final int MAX_THICKNESS=100;
	
	
	public MouseMotionApp(){
		//1]타이틀 설정
		setTitle("MouseMotion(MouseEvent) 연습");
		//2]레이아웃 변경	
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(600,550);
		setVisible(true);
		setBackground(Color.BLACK);
	}
	@Override
	public void createComponent() {
		//버튼 생성]
		for(int i=0;i<buttonLabels.length;i++)
			buttons[i]= new Button(buttonLabels[i]);
		//캔바스 생성]
		canvas = new Canvas(){//1]Canvas를 상속받은 익명 클래스
			
			//2]paint()오버라이딩
			@Override
			public void paint(Graphics g) {
				if(!isClear){
					g.setColor(color);
					g.fillOval(xPos, yPos,width,height);
				}
				else{
					g.clearRect(0,0, getWidth(),getHeight());
					isClear=false;
				}
				
			}
			//배경색으로 지우지 못하도록 오버라이딩
			@Override
			public void update(Graphics g) {				
				paint(g);
			}
		};
		//캔바스 배경색 설정
		canvas.setBackground(Color.YELLOW);
		
	}
	@Override
	public void addComponent() {
		//버튼 부착용 패널]
		Panel pnlWest = new Panel(new GridLayout(7,1,0,5));
		pnlWest.setBackground(Color.BLACK);
		//패널에 버튼 부착
		for(int i=0;i<buttonLabels.length;i++)
			pnlWest.add(buttons[i]);
		
		//캔바스 부착용 패널]
		Panel pnlCenter = new Panel(new BorderLayout()){
			@Override
			public Insets getInsets() {				
				return new Insets(0, 10, 0, 0);
			}
		};
		pnlCenter.setBackground(Color.BLACK);
		//패널에 캔바스 부착
		pnlCenter.add(canvas);
		
		//프레임에 패널 부착
		add("West",pnlWest);
		add(pnlCenter);
	}
	@Override
	public void addListener() {
		//프레임에 원도우 리스너 부착]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//버튼에 액션 리스너 부착]
		for(int i=0;i<buttonLabels.length;i++)
			buttons[i].addActionListener(handler);
		//캔바스에 마우스모션리스너부착]
		canvas.addMouseMotionListener(handler);
	}////////////////////////////////
	EventHandler handler = new EventHandler();
	public class EventHandler implements MouseMotionListener,ActionListener {

		//마우스이벤트와 관련된 콜백 메소드들]
		//영역안에서 클릭후 드래그시
		@Override
		public void mouseDragged(MouseEvent e) {			
			//System.out.println("mouseDragged");
			//드래그한 지점의 X및 Y좌표
			setTitle("X좌표:"+e.getX()+",Y자표:"+e.getY());
			//드래그한 지점의 좌표를 캔바스의
			//X,Y좌표로 설정
			xPos = e.getX();
			yPos = e.getY();
			
			canvas.repaint();
		}
		//영역안에서 마우스 움직일때마다
		@Override
		public void mouseMoved(MouseEvent e) {			
			//System.out.println("mouseMoved");
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source==buttons[0]){//RED
				color = Color.RED;
			}
			else if(source==buttons[1]){//GREEN
				color = new Color(0,255,0);
			}
			else if(source==buttons[2]){//BLUE
				color = Color.BLUE;
			}
			else if(source==buttons[3]){//THIN
				if(width > THICKNESS){
					width-=THICKNESS;
					height-=THICKNESS;
				}
			}
			else if(source==buttons[4]){//THICK
				if(width <= MAX_THICKNESS ){
					width+=THICKNESS;
					height+=THICKNESS;
				}
			}
			else if(source==buttons[5]){//ERASER
				color = canvas.getBackground();
			}
			else{//CLEAR
				isClear=true;
				canvas.repaint();
				
			}
			
		}///////////////////////////////////////
		
	}///////////////////////////////////////////
	
	@Override
	public Insets getInsets() {
		
		return new Insets(40, 20, 20, 20);
	}
	public static void main(String[] args) {
		new MouseMotionApp();
	}

}
