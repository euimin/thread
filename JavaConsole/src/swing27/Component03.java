package swing27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import awt26.servcie.LayoutService;
/*
이미지를 복사하는 프로그램]

JFileChooser(AWT의 FileDialog)를 이용해서 
이미지파일 을 열고
Copy.확장자 로 저장하는 프로그램

저장시 JProgressBar(AWT에는 없음)를 이용해서
진행율을 보이기.
JProgressBar주요메소드]
setStringPaintted(boolean):진행율 문자열로 표시
setMaxinum():최대값 설정
setMinimun();최소값 설정
getValue():현재까지 진행된 진행값 얻는다
setValue();프로그래바 진행 값  설정

*이미지 복사시 스레드 이용


 AWT에서 파일대화상자는 FileDialog이나
 SWING에서는 JFileChooser임
 또한 JFileChooser는 보여주기위해서
 setVisible(true)가 아니라
 showXXXXDialog()계열 메소드를 호출하면된다.
 JFileChooser주요 메소드]
 int showOpenDialog(Component parent):파일 열기
 int showSaveDialog(Component parent):파일 저장 
 String getName(File f) :파일명 반환
 File getSelectedFile() :선택된 파일반환(File타입)

*/
public class Component03 extends JFrame implements LayoutService {
	//[멤버변수]
	JButton btnOpen,btnCopy;
	JTextField txtPath;
	//이미지 표시할 레이블
	JLabel lblImage;
	//프로그래스 바]
	JProgressBar progress;
	
	//파일대화상자]
	JFileChooser fileDialog;
	
	File selectedFile;
	String extention;
	String extnames="GIF,BMP,JPG,PNG";
	public Component03(){
		//1]타이틀 설정
		setTitle("Swing컴포넌트 연습03");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(600,700);
		setVisible(true);
	}///////////////////////////////////	
	@Override
	public void createComponent() {
		//버튼]
		btnOpen = new JButton("열기");
		btnCopy = new JButton("복사");
		//텍스트 필드]
		txtPath = new JTextField();
		txtPath.setPreferredSize(new Dimension(420,30));
		//텍스트 수정 불가토록 설정]
		txtPath.setEditable(false);
		
		//프로그레스바]
		progress = new JProgressBar();
		progress.setPreferredSize(new Dimension(550,30));
		//진행율 텍스트로 표시]
		progress.setStringPainted(true);
		//최대값은 파일 크기에 따라 결정됨
		//progress.setMaximum(200);
		progress.setMinimum(0);
		//progress.setValue(100);
		//레이블]
		lblImage = new JLabel();
		
		//lblImage.setOpaque(true);
		//lblImage.setBackground(Color.YELLOW);
		//파일 대화상자]
		//유닉스나 윈도우식 디렉토리 표기 둘다 가능
		fileDialog = new JFileChooser("C:\\CCH");
		//파일 확장자 설정
		FileNameExtensionFilter filter
			= new FileNameExtensionFilter("이미지파일(*.bmp,*.gif,*.png,*.jpg)","bmp","png","gif","jpg");
		fileDialog.setFileFilter(filter);
		//파일 확장자 추가	
		filter = new FileNameExtensionFilter("텍스트 파일(*.txt)","txt");
		fileDialog.addChoosableFileFilter(filter);
		
	}
	@Override
	public void addComponent() {
		JPanel pnlNorth = new JPanel(new GridLayout(2,1));
		pnlNorth.setBorder(new TitledBorder("이미지 복사"));
		//북쪽 1행]
		JPanel pnlButton = new JPanel();
		pnlButton.add(txtPath);
		pnlButton.add(btnOpen);
		pnlButton.add(btnCopy);
		pnlNorth.add(pnlButton);
		//북쪽 2행]
		JPanel pnlProgress = new JPanel();
		pnlProgress.add(progress);
		pnlNorth.add(pnlProgress);
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("복사된 이미지"));
		pnlCenter.add(lblImage);
		
		//프레임에 패널 부착]
		add("North",pnlNorth);
		add(pnlCenter);
	}
	@Override
	public void addListener() {
		//종료]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//버튼에 리스너 부착]
		btnOpen.addActionListener(listener);
		btnCopy.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source==btnOpen){//열기
				int state=fileDialog.showOpenDialog(Component03.this);
				
				//System.out.println("state:"+state);
				//파일 선택후 열기버튼 클릭시]
				if(state == JFileChooser.APPROVE_OPTION){
					selectedFile=fileDialog.getSelectedFile();
					//확장자 구하기]
					//예]myfile.txt
					int index=selectedFile.getName().lastIndexOf(".")+1;
					extention=selectedFile.getName().substring(index);
					//System.out.println("확장자:"+extention);
					if(extnames.indexOf(extention.toUpperCase()) ==-1){
						JOptionPane.showMessageDialog(btnOpen,"이미지 파일 아닙니다");
						return;
					}
					//텍스트 필드에 파일경로 뿌리기]
					txtPath.setText(selectedFile.getAbsolutePath());
				}
			}
			else{//복사
				if(txtPath.getText().length()==0){
					JOptionPane.showMessageDialog(
							btnOpen,"먼저 이미지 파일을 선택하세요");
					return;
				}
				//이미지 복사 - 스레드로 구현]
				ImageThread thread = new ImageThread();
				thread.start();
			}
		}////////////////////actionPerformed
	};
	//이미지를 복사하는 스레드]
	class ImageThread extends Thread {
		
		@Override
		public void run() {
			copy();
		}
		private void copy() {
			//1]프로그레스바 최대값을 파일 크기로 설정
			progress.setMaximum((int)selectedFile.length());
			try{
				//2]이미지 복사(src/swing27/Copy.확장자)
				//  프로그레스바 진행율도 표시
				//입력 스트림 생성]
				BufferedInputStream bis =
						new BufferedInputStream(
								new FileInputStream(selectedFile));
			
				//출력 스트림 생성]
				BufferedOutputStream bos =
						new BufferedOutputStream(
								new FileOutputStream("src/swing27/copy."+extention)
								);
				//bis로 읽고 bos로 출력]
				int data;
				int totalByte=0;
				while((data=bis.read()) !=-1){
					totalByte++;
					bos.write(data);
					bos.flush();
					//진행율 표시]
					progress.setValue(totalByte);
				}
				//복사완료]
				//3]레이블에 복사된 이미지 뿌리기]
				// Toolkit을 이용해서 이미지를 메모리에 로딩시
				// BMP파일은 로드불가
				//Image image = Toolkit.getDefaultToolkit().getImage("src/swing27/copy."+extention);
				
				/* BMP파일도 로드할 수 있도록 수정 
		         * javax.imageio패키지의 ImageIO클래스의
		         * static BufferedImage read(File input)  
		         * 이용 
		         */
				Image image=ImageIO.read(new File("src/swing27/copy."+extention));
				//이미지크기를 레이블에 맞게 조정
				image=image.getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT);
				Icon icon = new ImageIcon(image);
				lblImage.setIcon(icon);
				bis.close();bos.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(btnCopy,"에러발생");
			}
			
		}
	}//////////////////////
	
	public static void main(String[] args){
		new Component03();
	}

}
