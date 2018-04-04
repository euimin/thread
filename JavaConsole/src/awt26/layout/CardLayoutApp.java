package awt26.layout;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.component.TextComponentApp.Eventhandler;
import awt26.servcie.LayoutService;

public class CardLayoutApp extends Frame implements LayoutService {

	//[멤버변수]
	private CardLayout card;
	private Panel pnlRed,pnlGreen,pnlBlue;
	private Button btnPrev;
	
	public CardLayoutApp(){
		//1]타이틀 설정
		setTitle("카드 레이아웃/마우스이벤트 연습");
		//2]레이아웃 변경
		setLayout(card = new CardLayout());
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(400,400);
		setVisible(true);
	}
	@Override
	public void createComponent() {
		//패널 생성
		pnlRed = new Panel();
		pnlRed.setBackground(Color.RED);
		pnlGreen = new Panel();
		pnlGreen.setBackground(Color.GREEN);
		pnlBlue = new Panel();
		pnlBlue.setBackground(Color.BLUE);
		//버튼 생성
		btnPrev = new Button("이전");
	}
	@Override
	public void addComponent() {
		//프레임에 패널부착]
		add(pnlRed);
		add(pnlGreen);
		add(pnlBlue);
		//마지막 패널에 버튼 부착]
		pnlBlue.add(btnPrev);

	}
	@Override
	public void addListener() {
		//프레임에 원도우리스너 부착]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//패널에 마우스리스너 부착]
		pnlBlue.addMouseListener(handler);
		pnlGreen.addMouseListener(handler);
		pnlRed.addMouseListener(handler);
		//버튼에 액션리스너 부착]
		btnPrev.addActionListener(handler);

	}
	private EventHandler handler = new EventHandler();
	public class EventHandler implements MouseListener,ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			card.previous(CardLayoutApp.this);			
		}
		//MouseEvent발생시 자동으로 호출되는 콜백 메소드들]
		//마우스를 눌렀다 떼는데 누른지점에서
		//뗏을때만 호출됨
		@Override
		public void mouseClicked(MouseEvent e) {			
			//System.out.println("mouseClicked");
		}
		//마우스를 눌렀을때
		@Override
		public void mousePressed(MouseEvent e) {			
			//System.out.println("mousePressed");
			int which=e.getButton();
			if(which == MouseEvent.BUTTON1){
				setTitle("왼쪽 버튼 클릭");
				//다음 카드
				card.next(CardLayoutApp.this);
			}
			else if(which == MouseEvent.BUTTON2){
				setTitle("훨 마우스 클릭");
				//첫번째 카드로
				card.first(CardLayoutApp.this);
			}
			else if(which == MouseEvent.BUTTON3){
				setTitle("오른쪽 버튼 클릭");
				//이전카드로
				card.previous(CardLayoutApp.this);
			}
		}
		//마우스를 눌렀다 뗏을때
		@Override
		public void mouseReleased(MouseEvent e) {
			//System.out.println("mouseReleased");	
		}
		//영역에 들어 왓을때
		@Override
		public void mouseEntered(MouseEvent e) {
			//System.out.println("mouseEntered");
			
		}
		//영역을 벗어 낫을때
		@Override
		public void mouseExited(MouseEvent e) {
			//System.out.println("mouseExited");			
		}
		
	}//////////////////////////
	public static void main(String[] args) {
		new CardLayoutApp();
	}

}
