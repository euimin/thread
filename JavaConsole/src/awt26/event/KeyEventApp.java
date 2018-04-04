package awt26.event;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class KeyEventApp extends Frame implements LayoutService {

	public static final int MOVE_DISTANCE=50;
	//[멤버변수]
	private Canvas canvas;
	
	public KeyEventApp(){
		//1]타이틀 설정
		setTitle("KeyEvent 연습");
		//2]레이아웃 변경	
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(416,538);
		setVisible(true);
	}
	@Override
	public void createComponent() {
		//캔바스 생성]
		canvas = new CanvasForKeyEvent();
		//배경색 설정]		
		//캔바스에 포커스 가도록 설정]
		canvas.setFocusable(true);
	}
	@Override
	public void addComponent() {
		//프레임에 캔바스 부착(Center)
		add(canvas);
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
		//캔바스에 키리스너 부착]
		canvas.addKeyListener(listener);	

	}
	private KeyListener listener = new KeyListener() {
		//메소드 호출 순서:
		//keyPressed -> keyTyped->keyReleased
		//타이핑과 과 관련된 키를 누를때(즉,엔터키/스페이스/백스페이스/DEL키도포함)
		@Override
		public void keyTyped(KeyEvent e) {			
			//System.out.println("keyTyped");
		}	
		//키를 눌렀다 뗏을때
		@Override
		public void keyReleased(KeyEvent e) {			
			//System.out.println("keyReleased");
		}	
		//키를 눌렀을때
		@Override
		public void keyPressed(KeyEvent e) {			
			//System.out.println("keyPressed");
			
			//클릭한 키보드 자판 문자
			char keyChar=e.getKeyChar();
			//클릭한 키보드 자판의 아스키코드값
			int keyCode=e.getKeyCode();
			setTitle(String.format("char:%c,code:%d",keyChar,keyCode));
			
			if(keyCode == KeyEvent.VK_UP){//↑ 
				if(((CanvasForKeyEvent)canvas).getyPos() > 0)
					((CanvasForKeyEvent)canvas).setyPos(((CanvasForKeyEvent)canvas).getyPos()-MOVE_DISTANCE);
			}
			else if(keyCode == KeyEvent.VK_DOWN){//↓
				if(((CanvasForKeyEvent)canvas).getyPos() < canvas.getHeight()-MOVE_DISTANCE)
					((CanvasForKeyEvent)canvas).setyPos(((CanvasForKeyEvent)canvas).getyPos()+MOVE_DISTANCE);
			}
			else if(keyCode == KeyEvent.VK_RIGHT){//→
				if(((CanvasForKeyEvent)canvas).getxPos() < canvas.getWidth()-MOVE_DISTANCE)
					((CanvasForKeyEvent)canvas).setxPos(((CanvasForKeyEvent)canvas).getxPos()+MOVE_DISTANCE);
			}
			else if(keyCode == KeyEvent.VK_LEFT){//←
				if(((CanvasForKeyEvent)canvas).getxPos() > 0)
					((CanvasForKeyEvent)canvas).setxPos(((CanvasForKeyEvent)canvas).getxPos()-MOVE_DISTANCE);
			}
			
			canvas.repaint();
			
		}
	};
	public static void main(String[] args) {
		new KeyEventApp();

	}

}
