package awt26.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class EmailLayout extends Frame implements LayoutService {
	//[멤버변수]
	//텍스트 필트- 한줄만 입력가능
	private TextField tfWriter,tfEmail,tfTitle;
	//텍스트 에리어- 여러줄 입력 가능
	private TextArea taMemo;
	//버튼
	private Button btnOk,btnCancel;

	//[생성자]	
	public EmailLayout() {
		//1]타이틀 설정
		setTitle("이메일 폼");
		setBackground(Color.CYAN);
		//2]레이아웃 변경		
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기
		setSize(450,650);
		setVisible(true);
	}

	@Override
	public void createComponent() {
		//텍스트 필드 생성]
		tfEmail = new TextField();
		tfTitle = new TextField();
		tfWriter= new TextField();
		//텍스트 에리어 생성]
		taMemo  = new TextArea();
		//버튼 생성]
		btnCancel = new Button("취소");
		btnOk     = new Button("확인");
	}
	@Override
	public void addComponent() {
		
		//북쪽
		Panel pnlNorth = new Panel(new BorderLayout());
		
		Panel pnlWestInNorth = new Panel(new GridLayout(4,1,0,5));	
		pnlWestInNorth.add(new Label("작 성 자"));
		pnlWestInNorth.add(new Label("이 메 일"));
		pnlWestInNorth.add(new Label("제      목"));
		pnlWestInNorth.add(new Label("내      용"));		
		pnlNorth.add("West",pnlWestInNorth);
		
		Panel pnlCenterInNorth =new Panel(new GridLayout(4,1,0,5));		
		pnlCenterInNorth.add(tfWriter);
		pnlCenterInNorth.add(tfEmail);
		pnlCenterInNorth.add(tfTitle);
		
		pnlNorth.add(pnlCenterInNorth);
		
		
		//중간
		Panel pnlCenetr = new Panel(new BorderLayout());
		pnlCenetr.add(taMemo);
		
		//남쪽
		Panel pnlSouth = new Panel(){
			@Override
			public Insets getInsets() {				
				return new Insets(10,10,10,10);
			}
		};
		pnlSouth.add(btnOk);
		pnlSouth.add(btnCancel);
		
		
		//프레임에 패널들 부착
		add("North",pnlNorth);
		add("Center",pnlCenetr);
		add("South",pnlSouth);
	}
	@Override
	public void addListener() {
		//원도우 리스너 프레임에 부착]
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				//프로그램 종료]
				System.exit(0);
			}
		});	
	}
	@Override
	public Insets getInsets() {
		
		return new Insets(40,18,18,18);
	}
	public static void main(String[] args) {
		new EmailLayout();
	}////////////////

}
