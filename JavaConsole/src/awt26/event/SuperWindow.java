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

public class SuperWindow extends Frame implements LayoutService {

	//[멤버변수]
	//static으로 선언
	//static TextField text;
	//다른 클래스에서 접근 가능하게 선언
	//TextField text;
	
	private TextField text;	
	
	public void setText(String text) {
		this.text.setText(text);
	}
	

	private Button btnSend,btnCreateChild;

	
	
	public SuperWindow(){
		//1]타이틀 설정
		super("부모 창");
		//2]레이아웃 변경
		 setLayout(new FlowLayout());
		//3]생성과 동시에 부착
		 addComponent();
		 //4]리스너 부착
		 addListener();
		//5]크기및 보이기 설정
		 pack();
		 setVisible(true);
	}//////////////////////////
	@Override
	public void createComponent() {}
	@Override
	public void addComponent() {
		add(text = new TextField(25));
		add(btnSend=new Button("전송"));
		add(btnCreateChild=new Button("자식창 띄우기"));		
	}
	@Override
	public void addListener() {
		//프레임에 윈도우 리스너 부착]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//버튼과 텍스트 필드에 액션 리스너 부착]
		btnSend.addActionListener(listener);
		btnCreateChild.addActionListener(listener);
		text.addActionListener(listener);
	}
	
	ChildWindow child;
	
	private ActionListener listener = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source == btnSend){
				if(child==null || !child.isVisible()){
					setTitle("자식창을 먼저 띄우삼!!!");
					return;
				}
				//자식창으로 데이타 전송
				child.getText().setText(text.getText());
			}
			else if(source == btnCreateChild){
				if(child == null)
					child=new ChildWindow(SuperWindow.this);
				else if(!child.isVisible()){
					child.setVisible(true);
				}
			}
			else{//텍스트 필드
				if(child==null || !child.isVisible()){
					setTitle("자식창을 먼저 띄우삼!!!");
					return;
				}
				//자식창으로 데이타 전송
				child.getText().setText(text.getText());
			}
		}
	};
	public static void main(String[] args) {
		new SuperWindow();
	}

}
