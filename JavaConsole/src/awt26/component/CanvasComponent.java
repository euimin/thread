package awt26.component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class CanvasComponent extends Frame implements LayoutService {

	//[멤버변수]
	private Canvas canvas;
	private Button btnFont,btnColor;
	//캔바스의 가로폭/세로폭 저장
	private int width,height;
	
	private Color color=Color.BLACK;
	private Font font = new Font("굴림체",Font.BOLD,20);
	//[생성자]
	public CanvasComponent(){
		//1]타이틀 설정
		setTitle("캔바스 컴포넌트 연습");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(550,400);
		setVisible(true);
		//캔바스의 가로폭/세로폭 구하기
		//반드시 보더레이이웃에 부착한 경우는
		//프레임의 크기를 결정한 후에
		//캔바스의 크기가 결정되니까
		width = canvas.getWidth();
		height= canvas.getHeight();
	}//////////////////////////
	@Override
	public void createComponent() {	
		//방법1]익명 클래스로 구현
		/*
		canvas = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.setColor(color);
				g.setFont(font);
				g.drawString("캔바스 입니다",width/2-50,height/2);
			}
			
		};
		*/
		//방법2]Canvas를 상속받은 별도의 외부클래스로 구현
		canvas = new CustomCanvas();
		
		//System.out.println("Width:"+canvas.getWidth());
		canvas.setBackground(Color.YELLOW);
	}
	@Override
	public void addComponent() {
		//캔바스 부착]
		Panel pnlCenter = new Panel(new BorderLayout());
		pnlCenter.add(canvas);
		
		//버튼부착]
		Panel pnlSouth = new Panel(){
			@Override
			public Insets getInsets() {				
				return new Insets(10,0,0,0);
			}
		};
		pnlSouth.add(btnFont = new Button("폰트 변경"));
		pnlSouth.add(btnColor = new Button("색상 변경"));
		//프레임에 패널 부착
		add(pnlCenter);
		add("South",pnlSouth);
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
		
		//각 버튼에 액션리스너 부착
		btnColor.addActionListener(new ActionListener() {
			
			boolean toggle =false;			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				방법1일때]
				if(!toggle) color= Color.RED;
				else color= Color.BLACK;
				*/
				//방법2 일때]
				if(!toggle) 
					((CustomCanvas)canvas).setColor(Color.RED);
				else
					((CustomCanvas)canvas).setColor(Color.BLACK);
				toggle = !toggle;
				canvas.repaint();
			}
		});
		
		btnFont.addActionListener(new ActionListener() {
			boolean toggle = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				/*방법1일때]
				if(!toggle)
					font= new Font("휴먼옛체",Font.BOLD | Font.ITALIC,15);
				else
					font=new Font("굴림체",Font.BOLD,20);				
				*/
				//방법2일때]
				if(!toggle)
					((CustomCanvas)canvas).setFont(new Font("휴먼옛체",Font.BOLD | Font.ITALIC,15));
				else
					((CustomCanvas)canvas).setFont(new Font("굴림체",Font.BOLD,20));	
				toggle = !toggle;
				
				canvas.repaint();
				
			}
		});

	}
	//프레임과 여백 주기]
	@Override
	public Insets getInsets() {		
		return new Insets(40, 20, 20, 20);
	}
	public static void main(String[] args) {
		new CanvasComponent();
	}

}
