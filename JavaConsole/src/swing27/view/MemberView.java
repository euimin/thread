package swing27.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import awt26.servcie.LayoutService;
import jdbc25.service.IConnect;
import swing27.model.MemberDTO;
import swing27.service.IMemberService;
import swing27.service.IMemberServiceImpl;

public class MemberView extends JFrame implements LayoutService {

	
	
	//[멤버변수]
	JButton[] buttons= new JButton[6];
	String[] buttonLabels={"입력","수정","삭제","검색","전체보기","아이디중복"};
	
	JTextField txtid,txtage,txtname;
	JPasswordField txtpwd;
	
	//테이블 관련]
	JTable table;
	DefaultTableModel model;
	
	Vector<Vector> datavector = new Vector<Vector>();
	Vector<String> columnvector=new Vector<String>();
	
	//데이타베이스 관련]
	IMemberService service;
	
	//JTable 레코드 선택여부 판단용]
	int selectedrow = -1;
	
	//검색 및 전체보기용 상수]
	public static final int ALL =1;//전체 보기
	public static final int SEARCH=2;//검색
	
	//아이디 중복 체크용]
	boolean isDuplicateClicked;
	
	//[생성자]
	public MemberView(){
		//타이틀 설정]
		super("회원관리 시스템");
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
	}
	@Override
	public void createComponent() {
		//버튼]
		for(int i=0;i < buttons.length;i++)
			buttons[i]= new JButton(buttonLabels[i]);
		//텍스트 필드]
		txtage = new JTextField(20);
		txtid  = new JTextField(20);
		txtname= new JTextField(20);
		//패스워드]
		txtpwd = new JPasswordField(20);
		//테이블]
		table = new JTable();
		//테이블의 데이타로 사용할 모델]
		model = new DefaultTableModel();
		
		//컬럼명 설정]
		columnvector.add("아이디");
		columnvector.add("비밀번호");
		columnvector.add("이름");
		columnvector.add("나이");
		columnvector.add("가입일");
		
		//데이타 베이스 연결]
		service = new IMemberServiceImpl(IConnect.ORACLE_URL,"SWING","SWING7777");
		
		//모델에 데이타 및 컬럼 설정]
		//model.setDataVector(datavector, columnvector);
		//테이블과 모델 바인딩]
		//table.setModel(model);
		
		//프로그램 최초 실행시 오라클의 데이타를
		//JTable에 뿌려주기
		setJTableData(ALL);
		
	}///////////////////////////
	@Override
	public void addComponent() {
		JPanel pnlWest = new JPanel(new BorderLayout());
		pnlWest.setBorder(new TitledBorder("입력화면"));
		
		JPanel pnlText = new JPanel(new GridLayout(12,1));
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		
		//1행]
		JPanel pnlUser = new JPanel(layout);
		pnlUser.add(new JLabel("아  이  디"));
		pnlUser.add(txtid);
		pnlUser.add(buttons[buttons.length-1]);
		pnlText.add(pnlUser);
		
		//2행]
		JPanel pnlPass = new JPanel(layout);
		pnlPass.add(new JLabel("비밀번호"));
		pnlPass.add(txtpwd);		
		pnlText.add(pnlPass);
		
		//3행]
		JPanel pnlName = new JPanel(layout);
		pnlName.add(new JLabel("이         름"));
		pnlName.add(txtname);		
		pnlText.add(pnlName);
		
		//4행]
		JPanel pnlAge = new JPanel(layout);
		pnlAge.add(new JLabel("나         이"));
		pnlAge.add(txtage);		
		pnlText.add(pnlAge);
		
		
		pnlWest.add(pnlText);
		
		JPanel pnlButton = new JPanel();
		for(int i=0;i < buttons.length-1;i++)
			pnlButton.add(buttons[i]);
		pnlWest.add("South",pnlButton);
		
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("회원명단 리스트"));		
		pnlCenter.add(new JScrollPane(table));
		
		//프레임에 패널 부착]
		add("West",pnlWest);
		add(pnlCenter);
	}//////////////////////////
	@Override
	public void addListener() {
		//종료]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//데이타베이스 연결 종료]
				service.close();
				//프로그램 종료]
				System.exit(0);
			}
		});
		//버튼에 리스너 부착]
		for(int i=0;i < buttons.length;i++) 
			buttons[i].addActionListener(handler);
		//테이블에 마우스 리스너 부착]
		table.addMouseListener(handler);
		//아이디 입력창에 키 리스너 부착]
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				isDuplicateClicked=false;
			}			
		});	
		
	}//////////////////////////
	EventHandler handler = new EventHandler();	
	class EventHandler extends MouseAdapter implements ActionListener{
		
		//[유효성 체크용 메소드]
		boolean isValidate(){
			if(txtid.getText().trim().length()==0){
				JOptionPane.showMessageDialog(MemberView.this,"아이디를 입력하세요?");
				txtid.requestFocus();
				return false;
			}
			else if(String.valueOf(txtpwd.getPassword()).trim().equals("")){
				JOptionPane.showMessageDialog(MemberView.this,"비밀번호를 입력하세요?");
				txtpwd.requestFocus();
				return false;
				
			}
			else if(txtname.getText().trim().length()==0){
				JOptionPane.showMessageDialog(MemberView.this,"이름을 입력하세요?");
				txtname.requestFocus();
				return false;
			}
			else if(txtage.getText().trim().equals("")){
				JOptionPane.showMessageDialog(MemberView.this,"나이를 입력하세요?");
				txtage.requestFocus();
				return false;
			}
			else if(!txtage.getText().trim().equals("")){
				try {
					Integer.parseInt(txtage.getText());
				} 
				catch (Exception e) {
					JOptionPane.showMessageDialog(MemberView.this,"나이는 숫자만...");
					txtage.setText("");
					txtage.requestFocus();
					return false;
				}
			}
			return true;
		}//////////////////isValidate()
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			//아이디 수정 불가토록 설정]
			txtid.setEditable(false);			
			//클릭한 레코드의 인덱스 저장]
			selectedrow = table.getSelectedRow();
			//클릭한 레코드의 각 컬럼값을 텍스트필드에 설정]		
			txtid.setText(table.getValueAt(selectedrow, 0).toString());
			txtpwd.setText(table.getValueAt(selectedrow, 1).toString());
			txtname.setText(table.getValueAt(selectedrow, 2).toString());
			txtage.setText(table.getValueAt(selectedrow, 3).toString());
			
		}/////////////////////////mousePressed()
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source ==buttons[0]){//입력
				if(!isValidate()) return;
				//제대로 입력했다면 입력처리]
				if(!isDuplicateClicked){
					JOptionPane.showMessageDialog(MemberView.this,"아이디 중복 체크 요망");
					return;
				}
				//사용자 입력값]
				String id=txtid.getText().trim();
				String pwd =String.valueOf(txtpwd.getPassword()).trim();
				String name =txtname.getText().trim();
				String age =txtage.getText();				
				//DTO에 입력값 설정
				MemberDTO dto =new MemberDTO();
				dto.setId(id);
				dto.setAge(age);
				dto.setName(name);
				dto.setPwd(pwd);
				
				try{
					int affected=service.insert(dto);
					JOptionPane.showMessageDialog(MemberView.this,
							affected+"행이 입력됨");
					//입력 성공시]
					isDuplicateClicked=false;
					//JTable에 데이타 뿌리기
					setJTableData(ALL);
					//텍스트 클리어
					textClear();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(MemberView.this,
							"입력시 오류:"+e1.getMessage());					
				}
			}////입력
			else if(source ==buttons[1]){//수정
				if(selectedrow == -1){
					JOptionPane.showMessageDialog(MemberView.this,
							"수정할 레코드를 선택하세요");	
					return;
				}
				//레코드를 선택했다면 수정처리
				MemberDTO dto = 
						new MemberDTO(
								txtid.getText().trim(),
								String.valueOf(txtpwd.getPassword()).trim(),
								txtname.getText().trim(),
								txtage.getText(),
								null
								);
				try {					
					JOptionPane.showMessageDialog(MemberView.this,service.update(dto)+"행이 수정되었어요!");
					//수정 성공시]
					//레코드 선택용 변수 다시 -1로 초기화
					selectedrow = -1;					
					//JTable에 데이타 뿌리기
					setJTableData(ALL);
					//텍스트 클리어
					textClear();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(MemberView.this,"수정시 오류:"+e1.getMessage());
				}
			}/////////수정
			else if(source == buttons[2]){//삭제
				if(selectedrow == -1){
					JOptionPane.showMessageDialog(MemberView.this,
							"삭제할 레코드를 선택하세요");	
					return;
				}
				//삭제처리]
				int option=JOptionPane.showConfirmDialog(MemberView.this, "정말로 삭제?","삭제 확인창",JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION){
					MemberDTO dto = new MemberDTO();
					dto.setId(txtid.getText().trim());
					try{
						JOptionPane.showMessageDialog(MemberView.this,
								service.delete(dto)+"행이 삭제되었어요");
						//레코드 선택용 변수 다시 -1로 초기화
						selectedrow = -1;					
						//JTable에 데이타 뿌리기
						setJTableData(ALL);
						//텍스트 클리어
						textClear();
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(MemberView.this,"삭제시 오류:"+e1.getMessage());
					}
				}
				
			}////////삭제
			else if(source== buttons[3]){//검색
				//아이디나 이름으로 검색
				if(txtid.getText().trim().equals("") &&
						txtname.getText().trim().length()==0
						){
					JOptionPane.showMessageDialog(MemberView.this,
							"검색시 아이디나 이름을 입력하세요!!!");
					return;
				}
				//아이디 혹은 이름 입력시-검색처리
				setJTableData(SEARCH);
				
			}///검색
			else if(source== buttons[4]){//전체보기
				setJTableData(ALL);
			}///전체보기
			else{//아이디 중복
				if(txtid.getText().trim().length()==0){
					JOptionPane.showMessageDialog(MemberView.this,
							"아이디를 입력하세요!!");
					txtid.requestFocus();
					return;
				}
				//아이디 입력시 중복 체크	
				isDuplicateClicked = true;
				
				try {
					MemberDTO dto=service.selectOne(new MemberDTO(txtid.getText().trim(),null,null,null,null));
					if(dto != null){
						JOptionPane.showMessageDialog(MemberView.this,
								dto.getName()+"가 사용하는 아이디입니다");
						txtid.requestFocus();
					}
					else{
						JOptionPane.showMessageDialog(MemberView.this,
								"사용가능한 아이디 입니다");
						txtpwd.requestFocus();
					}
				
				} catch (Exception e1) {					
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(MemberView.this,
							"아이디 중복체크시 오류:"+ e1.getMessage());
				}
				
			}////////////////아이디 중복
			
		}/////////////////////////////actionPerformed()
		
	}//////////////EventHandler
	
	//JTable에 실제 데이타베이스의 SELECT 쿼리결과 연동]
	void setJTableData(int searchOrAll){
		try{
			if(searchOrAll == ALL){
				//전체 레코드 쿼리]
				datavector =service.selectList(null);
			}
			else{//검색
				MemberDTO dto = 
						new MemberDTO(
								txtid.getText().trim(),
								null, 
								txtname.getText().trim(),null,null);
				datavector =service.selectList(dto);
			}
			
			//모델에 데이타 및 컬럼 설정]
			model.setDataVector(datavector, columnvector);
			//테이블과 모델 바인딩]
			table.setModel(model);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this,"전체 레코드 쿼리시 오류:"+e.getMessage());
		}
	}//////////////////////////
	//입력 필드 클리용 메소드]
	void textClear(){
		//아이디 입력필드를 수정 가능토록 변경
		if(!txtid.isEditable()) txtid.setEditable(true);
		
		//클리어
		txtid.setText("");
		txtpwd.setText("");
		txtname.setText("");
		txtage.setText("");
		//아이디 입력창에 포커스 주기
		txtid.requestFocus();
	}

}
