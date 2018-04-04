package awt26.event;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

//방법3]익명(무명) 클래스로 이벤트 핸들러 구현
/*
* - 처리할 이벤트가 적은 경우 즉 이벤트 소스가 한두 개인 경우
* - 이벤트 소스가 무엇인지 구분할 필요가 없음.
*/
public class EventHandlerByAnonymous extends Frame implements LayoutService{
	//[멤버 변수]
	private Button btnOk,btnExit;
	private TextField text;
	private Label lblMessage;
	//[생성자]	
	public EventHandlerByAnonymous(){
		//1]타이틀 설정
		super("익명 클래스로 이벤트 핸들러 구현");
		//2] 레이아웃 변경
		setLayout(new FlowLayout());
		//3]컴포넌트 생성		
		//4]컴포넌트 부착(생성과 동시에 부착)
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		pack();
		setVisible(true);
	}

	@Override
	public void createComponent() {}

	@Override
	public void addComponent() {
		//생성과 동시에부착]
		add(text = new TextField(20));
		add(btnOk = new Button("확인"));
		add(btnExit= new Button("프로그램 종료"));
		add(lblMessage = new Label("                                           "));
		lblMessage.setBackground(Color.YELLOW);		
	}
	@Override
	public void addListener() {
		//방법1] 각 이벤트 소스별로 익명 클래스 작성	
		//프레임-윈도우 이벤트 발생
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/*
		//각각의 버튼 - 액션이벤트 발생
		btnOk.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트 필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
				//텍스트 필드에 있는 문자열 삭제
				text.setText("");
				//텍스트 필드에 포커스주기
				text.requestFocus();		
			}
		});
		
		btnExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		//텍스트 필드
		text.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트 필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
				//텍스트 필드에 있는 문자열 삭제
				text.setText("");
				//텍스트 필드에 포커스주기
				text.requestFocus();	
				
			}
		});
		*/
		//※이벤트 소스가 여러개인 경우,내부 멤버 클래스를 사용하거나
		//  아래처럼 멤버변수에 익명 클래스 생성해서 저장
		//방법2] 부모타입의 인스턴스 변수 = 자식타입의 메모리(익명 클래스)
		btnOk.addActionListener(listener);
		btnExit.addActionListener(listener);
		text.addActionListener(listener);
	}//////////////////////////////////////////////////
	private ActionListener listener=new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj == btnOk){
				//텍스트 필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
				//텍스트 필드에 있는 문자열 삭제
				text.setText("");
				//텍스트 필드에 포커스주기
				text.requestFocus();
			}
			else if(obj == btnExit){
				System.exit(0);
			}
			else{
				//텍스트 필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
				//텍스트 필드에 있는 문자열 삭제
				text.setText("");
				//텍스트 필드에 포커스주기
				text.requestFocus();
			}
		}
	};
	
	public static void main(String[] args) {
		new EventHandlerByAnonymous();
	}/////////////////////
}/////////////////////////////////
