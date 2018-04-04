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

//방법2] 내부 클래스로 이벤트 핸들러구현
//하나의 이벤트에 대해서 이벤트 소스가 여려개인 경우 유리
public class EventHandlerByInnerClass extends Frame implements LayoutService {
	
	//[멤버 변수]
	private Button btnOk,btnExit;
	private TextField text;
	private Label lblMessage;
	
	//[생성자]
	public EventHandlerByInnerClass(){
		//1]타이틀 설정
		super("내부 클래스로 이벤트 핸들러 구현");
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
		//프레임에 WindowListener부착]
		addWindowListener(handler);
		//버튼에 ActionListener부착]
		btnOk.addActionListener(handler);
		btnExit.addActionListener(handler);
		//텍스트필드에 ActionListener부착]
		text.addActionListener(handler);
	}
	//이벤트 핸들러 인스턴스화]
	private EventHandler handler = new EventHandler();
	//내부 멤버 클래스 - 이벤트 핸들러로 구현
	public class EventHandler extends WindowAdapter implements ActionListener{
		//윈도우 이벤트처리]
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		//액션 이벤트 처리]	
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
		}/////////////////////////////////////
		
	}/////////////////////////////
	
	public static void main(String[] args) {
		new EventHandlerByInnerClass();		
	}//////////////////////////

}
