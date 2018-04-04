package awt26.layout;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
 * 한글 깨질때
 * 
 * -Dfile.encoding=MS949 추가
 * 
 */
public class FlowLayoutApp {
	//[멤버변수]
	private Frame frame;//컨테이너
	private Button btnFirst,btnSecond,btnThird;
	private TextField text;
	
	public FlowLayoutApp(){
		//Frame컨테이너 - 독립적인 컨테이너(기본 레이아웃-BorderLayout)
		//frame = new Frame();
		//1]원도우 타이틀 설정
		//frame.setTitle("FlowLayout학습");
		//1-1]인자 생성자로 타이틀 설정
		frame = new Frame("FlowLayout 공부");
		//2]레이아웃 변경(Frame에 부착시)
		//방법1]Frame레이아웃 변경-setLayout(LayoutManager)
		//기본 생성자로 FlowLayout생성
		//LayoutManager mgr = new FlowLayout();
		//인자 생성자로 FlowLayout생성 1]:new FlowLayout(int align)
		//LayoutManager mgr = new FlowLayout(FlowLayout.RIGHT);
		//인자 생성자로 FlowLayout생성 2]
		/*
		  new FlowLayout(int align,int hgap,int vgap) 
		     hgap:  컨테이너에 배치된 컴포넌트와 컴포넌트 
		             혹은 컴포넌트와 컨테이너의
		             경계사이의 수평 여백
		     vgap: 컨테이너에 배치된 컴포넌트와 컴포넌트 
		             혹은 컴포넌트와 컨테이너의
		             경계사이의 수직 여백
		*/		
		LayoutManager mgr = new FlowLayout(FlowLayout.RIGHT,30,50);
		//Frame을 BorderLayout에서 FlowLayout으로 변경]
		//frame.setLayout(mgr);
		
		//방법2]Panel 사용: 종속적인 컨테이너.단독 사용불가
		//Panel 기본 생성자로 생성]	
		//Panel panel = new Panel();
		//Panel 인자 생성자로 생성] Panel(LayoutManager)	
		Panel panel = new Panel(mgr);
		
		//3]컴포넌트 생성
		btnFirst = new Button("첫번째 버튼");
		btnSecond= new Button("두번째 버튼");
		btnThird = new Button();
		btnThird.setLabel("세번째 버튼");
		//text = new TextField();
		//text.setColumns(25);
		//컴포턴트 크기 설정]
		/*
		 * ※레이아웃의 영향을받기때문에
		 *   setSize()적용이 안된다.
		 *   만약 setSize()를 적용하려면 레이아웃을 해제 해야한다.
		 * 
		 * 레이아웃을 해제 하지않고 해당 레이아웃을 이용할때
		 * 강제적으로 크기를 변경하려면
		 * setPreferredSize()호출
		 * 
		 *  TextField의 가로폭 설정시에는
		 *  new TextField(int columns) 혹은 setColumns(int columns) 사용
		 * 
		 * 
		 */
		//아래는 setSize() 적용 안됨]
		//btnFirst.setSize(50,50);
		//text.setSize(50,50);
		text = new TextField();
		Dimension dimension = new Dimension(50, 50);
		btnFirst.setPreferredSize(dimension);
		//텍스트 필드에 아래 적용시에는 반드시
		//기본 생성자로 텍스트 필드 생성
		text.setPreferredSize(dimension);
		
		//4]컴포넌트 부착-add()메소드
		//방법1 일때] 컴포넌트를 프레임에 부착		
		//frame.add(btnFirst);
		//frame.add(btnSecond);
		//frame.add(btnThird);
		//frame.add(text);
		//방법2 일때] 컴포넌트를 패널에 부착
		panel.add(btnFirst);
		panel.add(btnSecond);
		panel.add(btnThird);
		panel.add(text);
		//패널을 프레임에 부착]
		frame.add(panel);
		
		
		//5]원도우 종료 처리를 위한 프레임에 윈도우리스너 부착
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//System.out.println("닫기버튼 클릭");
				System.exit(0);
			}			
		});
		//6]프레임 크기 설정
		frame.setSize(600,200);
		//7]프레임 보이기
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutApp();		
	}//////////////////main

}/////////////////////class
