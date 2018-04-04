package awt26.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class ChildWindow extends Frame implements LayoutService {

	//[멤버변수]
	private TextField text;
	
	public TextField getText() {
		return text;
	}
	private Button btnSend;
	
	SuperWindow superWindow;
	public ChildWindow(SuperWindow superWindow){
		//1]타이틀 설정
		super("자식 창");
		//2]레이아웃 변경
		 setLayout(new FlowLayout());
		//3]생성과 동시에 부착
		 addComponent();
		 //4]리스너 부착
		 addListener();
		//5]크기및 보이기 설정
		 pack();
		 setVisible(true);
		 
		 this.superWindow = superWindow;
	}//////////////////////////
	@Override
	public void createComponent() {}
	@Override
	public void addComponent() {
		add(text = new TextField(25));
		add(btnSend=new Button("전송"));		
	}
	@Override
	public void addListener() {
		//프레임에 윈도우 리스너 부착]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				/*1]
				 *System.exit(0):프로그램 전체가 종료 됨 
				 *실행중인 JVM이 종료됨
				 */
				//System.exit(0);
				
				//2]사용자에게 화면만 안 보일뿐 
				//  메모리(heap영역)에 존재 함
				//setVisible(false);
				//3]
				/* 메모리(자원)을 OS에게 모두 반납함 
				 * 보이지 않음 
				 * 부모에서 setVisible(true)시 OS에게 반납한 
				 * 메모리를 다시 heap영역으로
				 * 가져오게 됨.
				 * 여러개 프렘임중 특정 프레임만 
				 * 종료시키고자 할때 주로 사용. 
				 * dispose();
				 */
				dispose();
			}
		});
		//버튼과 텍스트 필드에 액션 리스너 부착]
		btnSend.addActionListener(listener);		
		text.addActionListener(listener);
	}
	private ActionListener listener = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			//부모의 TextField를 static으로 선언시
			//SuperWindow.text.setText(text.getText());
			//자식창 생성시 부모의 주소를 받을때
			//superWindow.text.setText(text.getText());
			//부모의 TextField를 private으로 선언시
			superWindow.setText(text.getText());
			
		}
	};
	
}
