package awt26.layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import awt26.servcie.LayoutService;
import jdbc25.service.IConnect;

/*
 * 컴포넌트의 크기 조정시 레이아웃을 해제하면
 * 컴포넌트의 크기를 사용자 임으로 조정 가능
 * (setSize()메소드로)
 * 단,컨테이너에 부착할때 컴포넌트의 X,Y좌표를 계산해서
 * setLocation()메소드나 setBounds()메소드를 이용해서
 * 컴포넌트의 위치를 설정해줘야 함.
 * 
 * 레이아웃 해제 방법]
 * 컨테이너.setLayout(null)  	  
 */
public class LayoutClearApp extends Frame implements LayoutService,IConnect {
	//[멤버 변수]
	//[데이타 베이스 관련]
	private Connection conn;
	private CallableStatement csmt;
	//[UI관련 컴포넌트]
	private TextField tfUser,tfPassword;
	private Button btnLogin;
	private static Label lblMessage;
	//[생성자]
	public LayoutClearApp(){
		//1]타이틀 설정-super("타이틀")혹은 setTitle("타이틀");
		super("레이아웃 해제");
		//2]레이아웃 변경-레이아웃 해제
		setLayout(null);
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(350,150);
		setVisible(true);
		//데이타베이스 연결]
		connect(ORACLE_URL,"USER1","USER1");
	}
	
	@Override
	public void createComponent() {		
		//텍스트 필드]
		tfUser = new TextField(20);
		tfPassword = new TextField();
		tfPassword.setColumns(20);
		//입력값을 특정 문자로 처리하도록 설정]
		tfPassword.setEchoChar('*');
		//버튼]
		btnLogin = new Button("로그인");
		//레이블]
		lblMessage = new Label();
		//레이블의 글자 색 설정-setForeground()
		lblMessage.setForeground(Color.RED);
		//글자 폰트 설정- Font(String name, int style, int size)  
		//                   (글꼴,스타일,크기)
		lblMessage.setFont(new Font("굴림체",Font.BOLD,25));
	}
	@Override
	public void addComponent() {	
		//레이아웃 해제시에는 반드시
		//해당 컴포넌트의 크기와 프레임에 부착할 위치를
		//지정한 후에 부착해야 보인다.	
		//add(btnLogin);//안보인다.
		//컴포넌트 크기 설정]
		Dimension d = new Dimension(200,25);
		tfUser.setSize(d);
		//프레임에 부착할 위치 설정] -좌측 상단이 0,0좌표
		tfUser.setLocation(18, 40);
		add(tfUser);
		
		tfPassword.setSize(d);
		tfPassword.setLocation(18, 70);
		add(tfPassword);
		
		//버튼 부착]
		//setSize()와 setLocation()을 동시에 처리하는
		//메소드:setBounds(int x,int y,int width,int height)
		btnLogin.setBounds(228,40,100, 55);
		add(btnLogin);
		//레이블 부착]
		lblMessage.setBounds(18, 105, 320, 25);
		add(lblMessage);
	}
	@Override
	public void addListener() {
		//원도우 리스너 프레임에 부착]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//데이타베이스 연결 끊기- 자원반납]
				close();
				//프로그램 종료]
				System.exit(0);
			}
		});	
		//버튼에  액션리스너 부착]
		btnLogin.addActionListener(new ActionListener() {	
			int clicked;
			@Override
			public void actionPerformed(ActionEvent e) {
				//lblMessage.setText("버튼 클릭했어요:"+ ++clicked);
				//사용자 입력 값 받기]
				user = tfUser.getText();
				password = tfPassword.getText();
				setTitle(String.format("아이디:%s,비번:%s",user,password));
				//쿼리 실행]
				execute();
				
			}
		});
		
	}
	public static void main(String[] args) {
		new LayoutClearApp();
		
	}
	//드라이버 메모리에 로딩]
	static{
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!!");
		}		
	}
	@Override
	public void connect(String url, String user, String password) {
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			lblMessage.setText("데이타베이스 연결 실패!!!!");
		}		
	}
	String user;
	String password;
	@Override
	public void execute() {
		try {
			csmt = conn.prepareCall("{call PROC_ISMEMBER(?,?,?)}");
			csmt.setString(1, user);
			csmt.setString(2, password);
			csmt.registerOutParameter(3,Types.NUMERIC);
			
			csmt.execute();
			int rtval=csmt.getInt(3);
			
			if(rtval == -1)
				lblMessage.setText("아이디가 일치하지 않아요");
			else if(rtval == 0)
				lblMessage.setText("아이디 일치/비번 불일치");
			else
				lblMessage.setText("회원님 즐감하세요");
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void close() {		
		try {
			if(csmt !=null) csmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {}
	}
	@Override
	public String getValue(String title) {return null;}
	@Override
	public String getQueryString() {return null;}

}
