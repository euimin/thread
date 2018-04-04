package awt26.component;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class TextComponentApp extends Frame implements LayoutService {

	//[멤버 변수]
	private Button btnCopy,btnReset;
	private TextField txtSrcUser,txtSrcPass,txtDestUser,txtDestPass;
	private Label lblMessage;
	//[생성자]
	public TextComponentApp(){
		//1]타이틀 설정
		setTitle("TextField컴포넌트 연습");
		//2]레이아웃 변경
		setLayout(new GridLayout(3,1));
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(450,250);
		setVisible(true);
	}
	@Override
	public void createComponent() {
		//※TextField의 컬럼수 설정은 레이아웃에 따라 다르다
		/*
		 * FlowLayout:적용됨.
		 * GridLayout:적용 안됨.
		 * BorderLayout:위치에 따라 다름. 
		 */
		//기본 생성자로 TextField객체 생성]
		txtSrcUser = new TextField();
		//메소드로 컬럼수 설정]
		txtSrcUser.setColumns(15);
		//메소드로 기본 텍스트 설정]
		txtSrcUser.setText("아이디");
		//인자 생성자로 텍스트와 컬럼수 설정]
		txtSrcPass = new TextField("비밀번호", 15);
		//텍스트 폰트 설정]
		//글자체 설정]Font("글꼴",int 글꼴스타일,int 글꼴크기)
		//글꼴은 C:\Windows\Fonts에 있는 서체
		Font font = new Font("굴림체",Font.BOLD,15);
		txtSrcUser.setFont(font);
		//글자색 변경]setForground(Color)
		txtSrcUser.setForeground(new Color(255,0,0));
		/*
		 * AWT에는 SWING처럼 PasswordChar컴포넌트가 없어서
		 * setEchoChar()메소드를 이용해서 사용자가 입력한 값을
		 * 특정 문자열로 처리할 수 있다.
		 */
		//txtSrcPass.setEchoChar('*');
		//인자 생성자로 컬럼수 설정]
		txtDestUser = new TextField(15);
		txtDestPass = new TextField(15);
		txtDestPass.setEchoChar('?');
		
		//기본 생성자로 버튼 생성]
		btnCopy = new Button();
		btnCopy.setLabel("복사");
		btnReset=new Button("초기화");
		
		lblMessage = new Label();
		lblMessage.setFont(new Font("굴림체",Font.BOLD|Font.ITALIC,12));
		lblMessage.setForeground(Color.GREEN);
	}
	@Override
	public void addComponent() {
		
		//첫번째 행]
		Panel  pnlFirst = new Panel();
		pnlFirst.add(new Label("아이디"));
		pnlFirst.add(txtSrcUser);
		pnlFirst.add(new Label("비밀번호"));
		pnlFirst.add(txtSrcPass);
		//두번째 행]
		Panel pnlSecond = new Panel();
		pnlSecond.add(btnCopy);
		pnlSecond.add(btnReset);
		pnlSecond.add(lblMessage);
		//세번째 행]
		Panel pnlThird = new Panel();
		pnlThird.add(new Label("아이디"));
		pnlThird.add(txtDestUser);
		pnlThird.add(new Label("비밀번호"));
		pnlThird.add(txtDestPass);
		
		
		//프레임에 각 패널 부착]
		add(pnlFirst);
		add(pnlSecond);
		add(pnlThird);
		
		
	}
	@Override
	public void addListener() {
		//프레임에 윈도우리스너 부착]
		addWindowListener(handler);
		//버튼에 액션리스너 부착]
		btnCopy.addActionListener(handler);
		btnReset.addActionListener(handler);
		//텍스트 필드에 포커스 리스너 부착]
		txtSrcUser.addFocusListener(handler);
		txtSrcPass.addFocusListener(handler);
	}
	private Eventhandler handler = new Eventhandler();
	//내부 멤버 클래스로 이벤트 핸들러 구현]
	public class Eventhandler extends WindowAdapter implements ActionListener,FocusListener{
		//윈도우 종료처리]
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		@Override
		public void windowOpened(WindowEvent e) {
			//포커스를 버튼에...
			btnCopy.requestFocus();
		}
		//[액션이벤트 처리용]
		//버튼클릭시 자동으로 호출되는 메소드
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source ==btnCopy){//복사
				txtDestUser.setText(txtSrcUser.getText());
				txtDestPass.setText(txtSrcPass.getText());
			}
			else{//초기화
				txtSrcUser.setText("아이디");
				txtSrcPass.setText("비밀번호");
				
				txtDestUser.setText("");
				txtDestPass.setText("");
			}
			
		}////////////////////////////////////////////
		//[포커스 이벤트 처리용]
		//포커스를 얻었을때 자동으로 호출되는 메소드
		@Override
		public void focusGained(FocusEvent e) {			
			setTitle("포커스를 얻다");
			Object source = e.getSource();
			if(source==txtSrcUser && 
					txtSrcUser.getText().trim().equals("아이디"))
				txtSrcUser.setText("");
			else if(source == txtSrcPass &&
					txtSrcPass.getText().trim().equals("비밀번호")
					)
				txtSrcPass.setText("");
		}
		//포커스를 잃었을때 자동으로 호출되는 메소드
		@Override
		public void focusLost(FocusEvent e) {
			setTitle("포커스를 잃다");
			Object source = e.getSource();
			if(source==txtSrcUser && 
					txtSrcUser.getText().trim().length()==0)
				txtSrcUser.setText("아이디");
			else if(source == txtSrcPass &&
					txtSrcPass.getText().trim().equals("")
					)
				txtSrcPass.setText("비밀번호");
		}	
		
	}/////////////////////////////
	
	public static void main(String[] args) {
		new TextComponentApp();
	}////////////////////////

}
