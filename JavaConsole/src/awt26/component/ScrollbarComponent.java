package awt26.component;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class ScrollbarComponent extends Frame implements LayoutService {

	//[멤버변수]
	private Canvas canvas;
	private Scrollbar sbRed,sbGreen,sbBlue;
	
	public ScrollbarComponent(){
		//1]타이틀 설정
		setTitle("스크롤바 컴포넌트 연습");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(600,450);
		setVisible(true);
	}////////////////////////////
	@Override
	public void createComponent() {
		canvas = new Canvas();
		//스크롤바 생성]
		/*
		Scrollbar(int orientation, --스크롤바의 방향(수직 혹은 수평)
		 			int value,--bar의 최초 위치 값
		 			int visible,--bar의 크기 값(bar의 가로폭)
		 			int minimum,-- 스크롤바의 최소값 
		 			int maximum) --스크롤바의 최대값		
		Scrollbar의 주요 메소드:
		int getValue():bar가 위치한 값을 얻어옴
		void setValue(int newValue) :bar의 위치값 설정
		*/
		sbRed = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		//양쪽 화살표를 마우스클릭시 이동 단위거리
		sbRed.setUnitIncrement(10);
		//sbRed.setValue(100);
		sbGreen = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		sbBlue = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,265);
		
		//캔바스의 배경색 지정
		canvas.setBackground(new Color(0,0,0));
	}
	@Override
	public void addComponent() {
		//캔바스 부착]
		Panel pnlCenter = new Panel(new BorderLayout()){
			@Override
			public Insets getInsets() {				
				return new Insets(0, 0, 10, 0);
			}
		};
		pnlCenter.add(canvas);
		
		//스크롤바 부착]
		Panel pnlSouth = new Panel(new GridLayout(3,1,0,5));
		pnlSouth.add(sbRed);
		pnlSouth.add(sbGreen);
		pnlSouth.add(sbBlue);
		
		//프레임에 부착]
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
		
		//스크롤바에 리스너 부착]
		sbBlue.addAdjustmentListener(listener);
		sbGreen.addAdjustmentListener(listener);
		sbRed.addAdjustmentListener(listener);
	}
	private AdjustmentListener listener = new AdjustmentListener() {
		
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {			
			setTitle(String.format(
					"R:%d,G:%d,B:%d",
					sbRed.getValue(),
					sbGreen.getValue(),
					sbBlue.getValue()
					));
			canvas.setBackground(new Color(
					sbRed.getValue(),
					sbGreen.getValue(),
					sbBlue.getValue()));
			
		}
	};
	
	@Override
	public Insets getInsets() {		
		return new Insets(40, 20, 20, 20);
	}
	public static void main(String[] args) {
		new ScrollbarComponent();
	}

}
