package awt26.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import awt26.servcie.LayoutService;

//방법1]자기 자신이 이벤트를 처리하는 이벤트 핸들러가 됨
/* 
*  Frame을 확장(extends)했기때문에 Frame역할을 
*  함과 동시에
*  리스너를 구현(implements)했기때문에 
*  이벤트핸들러 역할도 함
* 
* 이벤트핸들러란?
* - 이벤트 발생시 이벤트를 처리하는 클래스
* - 어떤 클래스가 이벤트핸들러의 자격요건을 갖추려면
*   XXXListenr인터페이스나 XXXAdapter클래스를 상속받아야함
*   
*   XXX는 이벤트명
* 
*/
public class EventHandlerBySelf extends Frame implements LayoutService,WindowListener,ActionListener {
	
	//[멤버 변수]
	private TextField text;
	private Button btnOk,btnExit;
	private Label lblMessage;
	
	//[생성자]
	public EventHandlerBySelf(){
		//1]타이틀 설정
		super("자기 자신이 이벤트 핸들러");
		//2] 레이아웃 변경
		setLayout(new FlowLayout());
		//3]컴포넌트 생성		
		//4]컴포넌트 부착(생성과 동시에 부착)
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		//컨테이너에 올려진 컴포넌트들의 사이즈만큼 컨테이너의 크기를 설정하는 메소드:pack()
		pack();
		setVisible(true);
	}///////////////////////
	@Override
	public void createComponent() {}
	@Override
	public void addComponent() {	
		//생성과 동시에부착]
		add(text = new TextField(20));
		add(btnOk = new Button("확인"));
		add(btnExit=new Button("프로그램 종료"));
		add(lblMessage=new Label("                                               "));
	}
	@Override
	public void addListener() {
		//프레임에 WindowEvent를 처리하기위한
		//WindowListener부착 :addXXXListener()메소드
		//XXX는 이벤트명]
		this.addWindowListener(this);
		
		//버튼에 ActionEvent를 처리하기위한 ActionListener부착]
		btnExit.addActionListener(this);
		btnOk.addActionListener(this);
		//텍스트필드에 리스너 부착]
		//텍스트 필드에서 포커스가 있는 상태에서 엔터치면 ActionEvent 발생
		text.addActionListener(this);
	}
	public static void main(String[] args) {		
		new EventHandlerBySelf();
	}
	
	//윈도우 이벤트 발생시 자동으로 호출되는 메소드들]
	@Override
	public void windowOpened(WindowEvent e) {
		// 프로그램 처음 실행시 한번만 호출됨	
		System.out.println("windowOpened()");		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		//시스템 메뉴중 종료버튼[x] 클릭시
		System.out.println("windowClosing()");
		System.exit(0);		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// 개발자가 dispose()메소드 호출후 윈도우가 닫혔을 때
		System.out.println("windowClosed()");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		//아이콘화 되었을 때 즉 시스템 메뉴중 최소화 버튼 클릭시 
		//시스템 트레이바에 아이콘으로 존재할때	
		System.out.println("windowIconified");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		//아이콘화 되었다가 다시 윈도우가보일때, 
		//즉 트레이바에 아이콘 클릭시	
		System.out.println("windowDeiconified");		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// 윈도우가 화면에보일때
		System.out.println("windowActivated()");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// 윈도우가 화면에서 사라질때
		System.out.println("windowDeactivated()");		
	}
	
	
	//액션이벤트 발생시 자동으로 호출되는 메서드
	//아래  actionPerformed메소드안에 ActionEvent발생시 처리할 코드작성]	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("ActionEvent발생");		
		//이벤트 소스 파악방법1]-버튼에만 적용 시킬때
		//String getActionCommand();
		// event.getActionCommand()]
		// 버튼인 경우:버튼의 텍스트 반환
		// 텍스트 필드 인 경우:텍스트에 입력한 값 반환 
		/*
		String command=e.getActionCommand();
		if("확인".equals(command))
			lblMessage.setText("확인버튼 클릭");
		else if("프로그램 종료".equals(command))
			lblMessage.setText("프로그램 종료 버튼 클릭");
		else
			lblMessage.setText("텍스트 필드에서 발생");
			*/
		//이벤트 소스 파악방법 2]-해당 컴포넌트가 하나인 경우 주로 사용(타입으로 비교)
	    // event.getSource():이벤트가 발생한 이벤트 소스를 Object타입으로 반환
		/*
		Object source=e.getSource();
		if(source instanceof Button)
			lblMessage.setText("버튼 클릭");
		else if(source instanceof TextField)
			lblMessage.setText("텍스트 필드");
			*/
		// 이벤트 소스 파악방법3 - 가장 많이 사용		
		//event.getSource()로 어어와서 주소비교(==)
		Object source=e.getSource();
		if(source == btnExit){
			lblMessage.setText("종료버튼");
			//개발자가 dispose()메소드 호출시 WindowEvent가 발생하며
			//windowClosed(WindowEvent e)가 자동 호출됨.
			//하는일:사용된 모든 자원(메모리)을 OS에게 반납.
			dispose();
		}
		else if(source == btnOk)
			lblMessage.setText("확인버튼");
		else if(source == text)
			lblMessage.setText("텍스트 필드");
	}
}
