package awt26.component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.PasswordAuthentication;

import javax.swing.JOptionPane;

import awt26.component.TextComponentApp.Eventhandler;
import awt26.servcie.LayoutService;

public class ListComponent extends Frame implements LayoutService {

	//[멤버변수]
	private List listSrc,listDest;
	private Button btnOk,btnLeft,btnRight;
	private TextArea taResult;
	
	public ListComponent(){
		//1]타이틀 설정
		setTitle("List컴포넌트 연습");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(400,600);
		setVisible(true);
	}/////////////////////////
	@Override
	public void createComponent() {		
		//리스트]
		/*
		 * 표시할 행의 수를 지정하지 않은 경우 디폴트로
		 * 4개의 행을 표시한다.단,레이아웃의 배치에 달라질 수 있다
		 * 즉 전체가 다 표시될 수도 있다.
		 * 다중 선택은 디폴트로 false(단일 선택)		
		 */
		//기본 생성자]
		//listSrc = new List();
		//인자 생성자 1]List(int rows)-보여줄 행의 수 설정.
		// 역시 레이아웃에 따라서 달라질수 있다.
		//listSrc  = new List(5);
		//인자 생성자 2] List(int rows,boolean multipleMode)-보여줄 행의 수,다중 선택 여부
		listSrc  = new List(5,true);
		//아이템 추가]-add()메소드 
		listSrc.add("비슬산");
		listSrc.add("태백산");
		listSrc.add("설악산");
		listSrc.add("대둔산");
		listSrc.add("소백산");
		listSrc.add("덕유산");
		
		listDest = new List(5,true);
		//버튼]
		btnOk =new Button("확인");
		btnLeft = new Button("<<");
		btnRight= new Button(">>");
	}
	@Override
	public void addComponent() {
		//북쪽]
		Panel pnlNorth = new Panel(new GridLayout(1, 3));		
		//1열
		pnlNorth.add(listSrc);
		//2열
		Panel pnlNull = new Panel(null);
		btnRight.setBounds(45,10,30,30);
		btnLeft.setBounds(45,40,30,30);
		pnlNull.add(btnRight);
		pnlNull.add(btnLeft);
		
		pnlNorth.add(pnlNull);
		//3열
		pnlNorth.add(listDest);		
		//가운데]
		Panel pnlCenter = new Panel(new BorderLayout()){
			@Override
			public Insets getInsets() {				
				return new Insets(10, 0,10, 0);
			}
		};		
		pnlCenter.add(taResult= new TextArea());
		//남쪽]
		Panel pnlSouth  = new Panel();		
		pnlSouth.add(btnOk);
		//프레임에 패널 부착
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);
		
		
		
	}
	@Override
	public void addListener() {
		//프레임에 윈도우 리스너 부착
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//리스트에는 액션리스너와 아이템리스너 부착]
		listSrc.addItemListener(handler);
		listSrc.addActionListener(handler);
		
		//버튼에 액션 리스너 부착]
		btnOk.addActionListener(handler);
		btnLeft.addActionListener(handler);
		btnRight.addActionListener(handler);
	}
	private EventHandler handler = new EventHandler();
	
	public class EventHandler implements ItemListener,ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object  source = e.getSource();
			if(source instanceof List){
				/*
				 * 더블 클릭하거나
				 * 아이템 선택후 엔터치거나
				 * 아이템 해제후(다중모드) 엔터시
				 * List에서 ActionEvent발생
				
				 */
				//taResult.append("리스트에서 액션이벤트 발생\r\n");
			}
			else{//버튼
				if(source == btnLeft){
					if(listDest.getSelectedItems().length ==0){
						JOptionPane.showMessageDialog(btnLeft,
								"오른쪽목록에서 먼저 아이템을 선택하세요!");
						return;						
					}
					//선택된 아이템들을 왼쪽 목록으로 이동
					String[] items=listDest.getSelectedItems();
					for(String item:items) {
						//왼쪽에 추가
						listSrc.add(item);	
						//오른쪽에선 삭제
						listDest.remove(item);
					}
				}
				else if(source == btnRight){
					if(listSrc.getSelectedItems().length ==0){
						JOptionPane.showMessageDialog(btnRight,
								"왼쪽목록에서 먼저 아이템을 선택하세요!");
						return;						
					}
					//선택된 아이템들을 오른쪽 목록으로 이동
					String[] items=listSrc.getSelectedItems();
					for(String item:items) {
						//오른쪽에 추가
						listDest.add(item);	
						//왼쪽에선 삭제
						listSrc.remove(item);
					}
				}
				else{
					if(listSrc.getItemCount()==0){
						JOptionPane.showMessageDialog(btnRight,
								"왼쪽목록에 아이템이 없어요!");
						return;
					}
					
					String[] items=listSrc.getItems();
					taResult.setText("");
					for(String item:items) 
						taResult.append(item+"\r\n");					
				}
			}
			
		}/////////////////
		@Override
		public void itemStateChanged(ItemEvent e) {
			/*
			 *e.getItem():선택된 아이템의 인덱스반환
			 *다중선택 모드일때:해제시에는 항상 마지막 선택한 아이템의
			 *                 인덱스 반환 
			 * 
			 */
			//System.out.println("ItemEvent Generated:"+e.getItem());	
			//List객체.isMultipleMode()로 다중선택여부 판단]
			//System.out.println("다중 선택 여부:"+listSrc.isMultipleMode());
			if(listSrc.isMultipleMode()){//다중 선택모드일때
				//List객체.getSelectedIndexes():선택된 인덱스들
				//List객체.getSelectedItems():선택된 아이템들
				/*
				int[] indexes=listSrc.getSelectedIndexes();
				String[] items=listSrc.getSelectedItems();
				
				taResult.setText("[선택된 인덱스들]\r\n");
				for(int index : indexes) taResult.append(index+"\r\n");
				taResult.append("[선택됨 아이템들]\r\n");
				for(String item:items) taResult.append(item+"\r\n");
				*/
			}
			else{//단일 모드 선택일때
				//List객체.getSelectedIndex():선택된 인덱스
				//List객체.getSelectedItem():선택된 아이템
				setTitle(String.format("인덱스:%d,아이템:%s",
						listSrc.getSelectedIndex(),
						listSrc.getSelectedItem()
						));
				
			}
		}////////////////////
		
	}//////////////////////////
	
	@Override
	public Insets getInsets() {		
		return new Insets(40,20,20,20);
	}
	public static void main(String[] args) {
		new ListComponent();
	}

}
