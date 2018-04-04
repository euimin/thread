package awt26.component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.servcie.LayoutService;

public class CheckRadioChoiceApp extends Frame implements LayoutService {

	//[멤버변수]
	private Checkbox cbSpo,cbEnt,cbPol,cbEco;
	private Checkbox rbMan,rbWoman,rbTrans;
	private Choice choice;
	private TextArea taResult;
	private Button btnOk;
	
	public CheckRadioChoiceApp(){
		//1]타이틀 설정
		setTitle("Checkbox/Choice컴포넌트 연습");
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
		//체크 박스]
		cbEco = new Checkbox();
		cbEco.setLabel("경제");
		cbEnt = new Checkbox("연예");
		cbPol = new Checkbox("정치", true);
		cbSpo = new Checkbox("스포츠");
		//라디오 버튼]
		/*
		 * AWT에서는 라디오박스를 제공해주지 않음 
		 * 체크박스를 이용해서 라디오박스를 생성해야 함
		 * 
		 * CheckboxGroup클래스]
		   체크박스를 라디오박스로 만들어 주기위한 클래스
		 * 즉 체크박스를 그룹으로 묶어 하나 선택시 
		 * 기존에 선택된
		 * 아이템이 해제되도록 해주는 클래스
		 */
		CheckboxGroup group = new CheckboxGroup();
		
		rbMan = new Checkbox("남자");
		rbMan.setCheckboxGroup(group);
		rbWoman = new Checkbox("여자",true,group);
		rbTrans = new Checkbox("트랜스 젠더",group,false);
		//초이스]
		choice = new Choice();
		//아이템 add()메소드로 추가 ]
		choice.add("초등학교");
		choice.add("중학교");
		choice.add("고등학교");
		choice.add("대학교");
		
		//텍스트 에리어]
		/*
		 * AWT의 TextArea컴포넌트은 내용이 가로 세로로 
		 * 많아지면
		 * 자동으로 스크롤바가 생김.
		 * 단,Swing에서는 스크롤바가 생기지 않음.
		 * 
		 */
		taResult = new TextArea();
	}/////////////////
	@Override
	public void addComponent() {
		
		//북쪽 패널
		Panel pnlNorth = new Panel(new GridLayout(6,1));
		//1행
		pnlNorth.add(new Label("당신이 좋아하는 관심분야?"));
		//2행-체크박스
		Panel pnlCheckbox = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlCheckbox.add(cbEco);
		pnlCheckbox.add(cbEnt);
		pnlCheckbox.add(cbPol);
		pnlCheckbox.add(cbSpo);
		pnlNorth.add(pnlCheckbox);
		//3행
		pnlNorth.add(new Label("당신의 성별은?"));
		//4행-라디오버튼
		Panel pnlRadio = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlRadio.add(rbMan);
		pnlRadio.add(rbWoman);
		pnlRadio.add(rbTrans);		
		pnlNorth.add(pnlRadio);
		
		//5행
		pnlNorth.add(new Label("당신의 학력은?"));
		//6행
		Panel pnlChoice = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlChoice.add(choice);
		pnlNorth.add(pnlChoice);
		
		//가운데 패널
		Panel pnlCenter = new Panel(new BorderLayout());
		pnlCenter.add(taResult);
		
		//남쪽 패널
		Panel pnlSouth = new Panel();
		pnlSouth.add(btnOk=new Button("확인"));
		
		//프레임에 패널 부착]
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);
	}///////////
	@Override
	public void addListener() {
		//원도우 종료 처리]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//아이템을 가진 컴포넌트에 아이템 리스너 부착]
		cbEco.addItemListener(handler);
		cbEnt.addItemListener(handler);
		cbPol.addItemListener(handler);
		cbSpo.addItemListener(handler);
		
		rbMan.addItemListener(handler);
		rbTrans.addItemListener(handler);
		rbWoman.addItemListener(handler);
		
		choice.addItemListener(handler);
		//버튼에 액션 리스너 부착]
		btnOk.addActionListener(handler);
	}////////
	private EventHandler handler = new EventHandler();
	//이벤트 핸들러 클래스
	public class EventHandler implements ActionListener,ItemListener{
		StringBuffer buffer = new StringBuffer("[관심사항]정치");		
		String gender = "[성별]여자";
		String grade  = "[학력]초등학교";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			taResult.setText(
					String.format("%s%n%s%n%s",
							buffer,gender,grade));			
		}//////////////////////
		//ItemEvent발생시 자동으로 호출되는 콜백 메소드]
		/*
		 * Checkbox만 선택, 해제시에 ItemEvent발생
		 * 단,Choice나 CheckboxGroup을 이용한 라디오박스는
		 * 선택시에만 ItemEvent 발생. 
		 * 
		 * 선택된 Text를 얻어 올때는 e.getItem().toString();
		   혹은 e.getItem()
		 * 
		 */
		//아이템 선택 혹은 해제시 자동으로 호출되는 메소드]
		@Override
		public void itemStateChanged(ItemEvent e) {
			//System.out.println("ItemEvent Generated:"+e.getStateChange());	
			Object source=e.getSource();
			
			if(e.getStateChange() == ItemEvent.SELECTED){
				//System.out.println("SELECTED:"+e.getItem());
				if(source== rbMan || source == rbTrans || source==rbWoman)
					gender ="[성별]"+e.getItem();
				else if(source == choice)
					grade ="[학력]"+e.getItem();
				else
					buffer.append(e.getItem());
			}
			else if(e.getStateChange() == ItemEvent.DESELECTED){
				//System.out.println("DESELECTED:"+e.getItem());
				//[관심사항]경제연예스포츠
				int start =buffer.indexOf(e.getItem().toString()) ;
				int end   =start+e.getItem().toString().length();
				buffer.delete(start, end);
			}
		}////////////////
		
	}///////////////////////////////////////	
	@Override
	public Insets getInsets() {		
		return new Insets(40, 20, 20, 20);
	}
	public static void main(String[] args) {
		new CheckRadioChoiceApp();
	}//////////////

}
