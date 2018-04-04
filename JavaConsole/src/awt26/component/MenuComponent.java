package awt26.component;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JEditorPane;

import awt26.servcie.LayoutService;
/*
 * MenuBar는 프레임에 부착,단 프레임에 부착시
 * add()가 아니라 
 * setMenuBar()메소드로 프레임에 부착
 * 
 * Menu는 MenuBar에 add()메소드로 부착
 * 
 * MenuItem은 Menu에 add()메소드로 부착
 * 
 */
public class MenuComponent extends Frame implements LayoutService {

	//[멤버변수]
	private MenuBar bar;
	private Menu mFile,mEdit,mHelp,mSubmenu;
	//파일 메뉴에 붙일 메뉴아이템
	private MenuItem miOpen,miSave,miPrint,miExit;
	//편집 메뉴에 붙일 메뉴아이템
	private MenuItem miPaste,miCopy,miCut,miAll;
	//Help메뉴에 붙일 메뉴아이템
	MenuItem miVersion;
	//텍스트 편집창용
	private TextArea taMemo;
	//파일 열기/저장용 파일 다이얼로그
	private FileDialog fileDialog;
	//버전정보에 사용할 다이얼로그
	private Dialog dialog;
	//버전정보 다이얼 로그에 붙일 버튼
	private Button btnOk;
	
	
	public MenuComponent(){
		//1]타이틀 설정
		setTitle("메뉴관련 컴포넌트 연습");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(650,650);
		setVisible(true);
	}////////////////////////////
	@Override
	public void createComponent() {
		//Menu를 붙일 MenuBar생성]
		bar = new MenuBar();
		//Menu컴포넌트 생성]
		mFile = new Menu();
		mFile.setLabel("파일");
		mEdit = new Menu("편집");
		mHelp = new Menu("도움말",true);
		mSubmenu = new Menu("서브메뉴");
		//MenuItem컴포넌트 생성]
		miOpen = new MenuItem();
		miOpen.setLabel("열기");
		miSave = new MenuItem("저장",new MenuShortcut(KeyEvent.VK_S));
		miPrint = new MenuItem("인쇄");
		miExit = new MenuItem("끝내기",new MenuShortcut(KeyEvent.VK_X, true));
	
		miPaste = new MenuItem("붙여넣기");
		miCopy  = new MenuItem("복사");
		miCut   = new MenuItem("잘라내기");
		miAll   = new MenuItem("모두선택");
		
		miVersion = new MenuItem("메모장 버전");
		
		//다이얼그 생성]
		/* Dialog(Frame owner, String title, boolean modal) 
		 * modal이 true이면 모달,
		 * false이면 모달리스(modalless)
		 * 
		 * 모달로 띄우면 해당 다이얼로그를 닫기 
		 * 전까지 다른 UI를 클릭하거나
		 * 접근할수 없음.
		 * 
		 */
		dialog = new Dialog(this,"About Memo", true);
		dialog.setLayout(new FlowLayout());
		dialog.add(new Label("버전 1.0"));
		dialog.add(btnOk=new Button("확인"));
		dialog.setSize(300,200);
		
	}//////////////
	@Override
	public void addComponent() {
		//프레임에 메뉴바 부착]
		setMenuBar(bar);
		//메뉴바에 메뉴부착]
		bar.add(mFile);
		bar.add(mEdit);
		bar.add(mHelp);
		//메뉴에 메뉴아이템 부착]
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miPrint);
		//메뉴에 분리선 추가
		mFile.addSeparator();
		mFile.add(miExit);
		
		mEdit.add(miPaste);
		mEdit.add(miCopy);
		mEdit.add(miCut);
		mEdit.add(miAll);
		
		//Menu에 Menu를 붙이면 서브메뉴를 만들 수 있다.
		mEdit.add(mSubmenu);
		mSubmenu.add(new MenuItem("서브메뉴1"));
		mSubmenu.add(new MenuItem("서브메뉴2"));
		mSubmenu.add(new MenuItem("서브메뉴3"));
		
		mHelp.add(miVersion);
		
		//프레임에 텍스트에리어 부착]
		add(taMemo = new TextArea());
	}////////////////
	@Override
	public void addListener() {
		//프레임에 윈도우 리스너 부착
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//다이얼 로그에 윈도우 리스너 부착
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
			}
		});
		
		//다이얼 로그 안에 있는 버튼에 리스너 부착
		btnOk.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();				
			}
		});
		
		//메뉴아이템에 액션 리스너 부착
		miAll.addActionListener(listener);
		miCopy.addActionListener(listener);
		miCut.addActionListener(listener);
		miExit.addActionListener(listener);
		miOpen.addActionListener(listener);
		miPaste.addActionListener(listener);
		miPrint.addActionListener(listener);
		miSave.addActionListener(listener);
		miVersion.addActionListener(listener);

	}/////////////////////////////
	private ActionListener listener=
			new ActionListener() {
				String copyNCut;
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object source=e.getSource();
					if(source == miExit) System.exit(0);
					else if(source == miOpen){
						/*
						 * FileDialog도 Window계열임으로 보이려면
						 * setSize()와 setVisible(true)를 해주어야 함 
						 * 단, FileDialog는 운영체제에서 제공하는 
						 * 다이얼로그를 사용함으로 크기는 설정해봤자 적용 안됨
						 * FileDialog(Frame parent, String title, int mode) 
						 * 
						 * -사용자가 FileDialog의 X버튼이나 취소버튼 클릭시
						 *  dispose됨.
						 */	
						if(fileDialog ==null || fileDialog.getMode()==FileDialog.SAVE){
							fileDialog = new FileDialog(MenuComponent.this, "열기",FileDialog.LOAD);
						}
						//메소드로 타이틀 및 모드 설정]
						fileDialog.setTitle("Open File");
						fileDialog.setMode(FileDialog.LOAD);
						//초기 디렉토리 설정]
						fileDialog.setDirectory("C:\\CCH");
						//fileDialog.setSize(650,650);//크기적용이 안됨
						fileDialog.setVisible(true);
						//사용자가 선택한 디렉토리및 파일명 얻기
						//System.out.println("디렉토리:"+fileDialog.getDirectory());
						//System.out.println("파일:"+fileDialog.getFile());
						String directory = fileDialog.getDirectory();
						String filename  = fileDialog.getFile();
						if(filename !=null)	openFile(directory+filename);					
					}
					else if(source == miSave){
						if(fileDialog ==null || fileDialog.getMode()==FileDialog.LOAD){
							fileDialog = new FileDialog(MenuComponent.this);
							fileDialog.setTitle("저장");
							fileDialog.setMode(FileDialog.SAVE);							
						}
						fileDialog.setVisible(true);
						String directory = fileDialog.getDirectory();
						String filename  = fileDialog.getFile();
						if(filename !=null)	saveFile(directory+filename);					
					}
					else if(source == miPrint){
						try{
							JEditorPane pane 
								= new JEditorPane("text/plain", taMemo.getText());
							
							pane.print();
						}
						catch(PrinterException e1){
							setTitle("인쇄 오류:"+e1.getMessage());
						}
						
					}
					else if(source == miAll){
						taMemo.setSelectionStart(0);
						taMemo.setSelectionEnd(taMemo.getText().length());
					}
					else if(source == miCopy){
						copyNCut= taMemo.getSelectedText();
						///System.out.println(copyNCut);
					}
					else if(source == miPaste){
						//복사한 텍스트가 있다면
						if(copyNCut !=null && copyNCut.trim().length() !=0){
							//붙여넣을 위치 구하기
							int start = taMemo.getSelectionStart();
							int end   = taMemo.getSelectionEnd();
							//System.out.println(start+":"+end);
							//먼저 모든 내용을 버퍼에 담기]
							StringBuffer buffer = new StringBuffer(taMemo.getText());
							//커서가 위치한 곳에 붙여넣기
							if(start == end)//즉 특정 텍스트를 선택 안한 경우
								buffer.insert(start, copyNCut);
							else //특정 텍스트를 선택한 경우
								 //즉 선택한 텍스트를 복사한 텍스트로 교체
								buffer.replace(start, end, copyNCut);
							
							taMemo.setText(buffer.toString());
						}					
						
					}
					else if(source == miCut){
						//자를 시작점
						int start = taMemo.getSelectionStart();
						//자를 끝점
						int end  = taMemo.getSelectionEnd();
						//자른 내용 저장
						copyNCut = taMemo.getSelectedText();
						
						//자른 내용 반영
						StringBuffer buffer = new StringBuffer(taMemo.getText());						
						taMemo.setText(buffer.delete(start, end).toString());
						
					}
					else if(source == miVersion){
						if(!dialog.isVisible())
							dialog.setVisible(true);
					}
					
				}///////////////actionPerformed
				//파일 저장용]
				private void saveFile(String filename) {
					try{
						PrintWriter pw = 
								new PrintWriter(new FileWriter(filename),true);
						pw.write(taMemo.getText());
						pw.close();
					}
					catch(Exception e){
						setTitle("에러:"+e.getMessage());
					}
				}
				//파일 열기용]
				private void openFile(String filename) {
					//System.out.println(filename);	
					try{
						BufferedReader br =new  BufferedReader(
											new FileReader(filename));
						
						StringBuffer buffer = new StringBuffer();
						String data;
						while((data = br.readLine()) !=null){
							buffer.append(data+"\r\n");
						}
						taMemo.setText(buffer.toString());
						br.close();
					}
					catch(Exception e){
						setTitle("에러 발생:"+e.getMessage());
					}
				}
	};////////////////////////////////////////////
	
	public static void main(String[] args) {
		new MenuComponent();
	}

}
