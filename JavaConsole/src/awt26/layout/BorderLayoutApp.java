package awt26.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutApp  {
	
	private Frame frame;
	private Button[] buttons = new Button[5];
	private String[] buttonLabel= 
					{"첫번째 버튼",
					 "두번째 버튼",
					 "세번째 버튼",
					 "네번째 버튼",
					 "마지막 버튼"
					};
	//[생성자]
	public BorderLayoutApp(){
		//1]Frame객체 생성:기본 레이아웃 -BorderLayout
		//배치된 컴포넌트와 바깥 여백을 주기위한 
		//getInsets()메소드 오버라이딩
		//Container의 메소드
		/*
		 * 모든 컨테이너 계열 컴포넌트는 getInsets()를 
		 * 오버라이딩해서
		 * 배치된 컴포턴트와의 바깥 여백을 줄 수 있다
		 * 디폴트는 윗쪽,왼쪽,아래쪽,오른쪽 여백이 0이다.
		 */
		frame = new Frame("BorderLayout 학습"){
			//Insets(int top, int left, int bottom, int right)
			@Override
			public Insets getInsets() {
				//Insets(int top, int left, int bottom, int right)				
				//타이틀바 세로폭:30,왼쪽 오른쪽,아래 바 크기:8
				return new Insets(45,23,23,23);
			}
			
			
		};
		//2]레이아웃 변경-여백이 있는 BorderLayoutr으로
		//BorderLayout(int hgap, int vgap) 
		/*	※FlowLayout하고는 다르게 BorderLayout의
		 *   수평여백(hgap) 및 수직 여백(vgap)는 
		 *   컴포넌트와 컴포넌트 사이만 적용된다.
		 *   즉 컨테이너와 컴포넌트 사이의 여백은 적용이 안된다.
		 *   컴포넌트와 컨테이너 사이의 여백을 적용하기 위해서는
		 *   getInsets()메소드 오버라이딩해서 적용해라
		 */
		frame.setLayout(new BorderLayout(10, 15));
		
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]프레임 크기 및 보이기 설정
		frame.setSize(400,400);
		frame.setVisible(true);
	}	
	private void createComponent() {
		//버튼 컴포넌트 생성]
		for(int i=0;i < buttons.length;i++)
			buttons[i]= new Button(buttonLabel[i]);
		//레이아웃의 영향으로 적용 안됨]
		//buttons[0].setSize(100,100);
		/*
		 * 모든 컴포넌트의 setPreferredSize()메소드
		 * 
		 * -선호된 크기로 강제로 컴포넌트의 크기를 
		 *  조정하는 메소드
		 * -레이아웃의 영향을 받더라도 크기조절가능
		 * 
		 * 단, 레이아웃마다 다르다
		 * 
		 * FlowLayout:가로 세로 크기 모두 조절 가능
		 * BorderLayout:Center에 배치된 컴포넌트는 
		 *              적용 안됨.
		 *              North와 South에 배치된 컴포넌트:세로폭만 적용됨
		 *              East와 West:가로폭만 적용됨
		 *              
		 * GridLayout:전혀 적용 안됨. 
		 * 
		 */
		Dimension dimen = new Dimension(100,100);
		//가로/세로폭  모두 적용 안됨]
		buttons[4].setPreferredSize(dimen);
		//세로폭만 적용됨]
		buttons[2].setPreferredSize(dimen);
		buttons[3].setPreferredSize(dimen);
		//가로폭만 적용됨]
		buttons[0].setPreferredSize(dimen);
		buttons[1].setPreferredSize(dimen);
	}/////////////////////////////
	private void addComponent() {
		//버튼을 Frame에 부착]
		//경계 미 지정-무조건 Center에 부착됨.
		//            컨테이너 전체 영역을 차지함.
		//아래처럼 부착하면 최종적으로 마지막 부착한 버튼만 보임.
		//frame.add(buttons[0]);
		//frame.add(buttons[1]);
		//경계 지정해서 부착]
		frame.add("East",buttons[0]);
		frame.add(BorderLayout.WEST,buttons[1]);	
		frame.add("South",buttons[2]);	
		frame.add(BorderLayout.NORTH,buttons[3]);	
		frame.add("Center",buttons[4]);	
	}////////////////////////////////////
	private void addListener() {
		//원도우 종료 처리를 위한 프레임에 윈도우리스너 부착
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//System.out.println("닫기버튼 클릭");
				System.exit(0);
			}			
		});		
	}/////////////////////////////////////////////
	public static void main(String[] args) {
		new BorderLayoutApp();
	}

}
