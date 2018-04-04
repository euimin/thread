package network28;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.MarshalledObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationID;
import java.rmi.activation.ActivationInstantiator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import awt26.servcie.LayoutService;

public class SingleChatClient extends JFrame implements LayoutService {

	//UI용 컴포넌트]
	JTextArea txtHistory;
	JTextField txtMessage,txtAddress;
	JButton btnConnect;
	//통신용 컴포너트]
	//※Socket클래스를 사용하면 이는 TCP통신이다.
    //※클라이언트는 서버와 연결할 한 개의 Socket만 필요하다	 
	//1]서버와 접속시 통신을 담당하는 소켓
	Socket socket;
	//서버와 연결된 소켓(socket)에 데이타를 읽고 쓰기위한
	//입출력 필터 스트림]
	DataInputStream dis;
	DataOutputStream dos;
	
	
	public SingleChatClient(){
		super("단일 채팅 클라이언트");
		createComponent();
		addComponent();
		addListener();
		setSize(600,550);
		setVisible(true);
		
	}
	@Override
	public void createComponent() {		
		//UI용 컴포넌트]
		txtHistory = new JTextArea();
		txtHistory.setEditable(false);
		txtMessage = new JTextField();
		txtAddress = new JTextField("127.0.0.1",30);
		btnConnect = new JButton("서버 연결");
		
	}
	@Override
	public void addComponent() {
		JPanel pnlNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlNorth.setBorder(new TitledBorder("서버 연결"));
		pnlNorth.add(txtAddress);
		pnlNorth.add(btnConnect);
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(txtHistory));
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		pnlSouth.setBorder(new TitledBorder("메시지 입력창"));
		pnlSouth.add(txtMessage);
		//프레임에 패널 부착
		add(pnlCenter);
		add("South",pnlSouth);
		add("North",pnlNorth);
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
		
		//텍스트필드 와 버튼에 액션 리스너부착
		btnConnect.addActionListener(listener);
		txtMessage.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source==btnConnect){//서버 연결
				
				try {
					//서버에 연결하기]
					socket = new Socket(txtAddress.getText().trim(), SingleChatServer.PORT);
					txtHistory.append("서버에 연결됨...\r\n");
					SingleChatServer.autoScroll(txtHistory);
					//연결된 소켓에서 데이타를 읽어 오기위한 스트림 생성]
					dis = new DataInputStream(socket.getInputStream());
					//연결된 소켓에 데이타를 쓰기위한 스트림 생성]
					dos = new DataOutputStream(socket.getOutputStream());
					//연결된 소켓에서 클라이언트가 전송한 데이타 읽는
					//스레드 스타트]
					new ReadThread().start();
					
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(SingleChatClient.this,"서버 연결 실패");
				}
			}
			else{//메시지 입력				
				//연결된 소켓에 데이타 쓰기]
				if(socket !=null){					
					try {
						//연결된 소켓에 데이타 쓰기]
						dos.writeUTF(txtMessage.getText());
						//확인용-텍스트에리어에 다시 출력]
						txtHistory.append("Client>"+txtMessage.getText()+"\r\n");
						//텍스트 클리어 및 포커스 주기
						txtMessage.setText("");
						txtMessage.requestFocus();
					} catch (IOException e1) {
						//※연결된 소켓에 데이타 쓸때 소켓이 끊어지면
						//  즉 클라이언트가 나가면 예외발생.
						txtHistory.append("서버가 연결을 끊어졌어요..\r\n");
					}
					finally {
						SingleChatServer.autoScroll(txtHistory);
						//autoScroll()메소드에 의해 txtHistory에 간 포커스를
						//입력 텍스트 필드로 다시 가져오기]
						txtMessage.requestFocus();
					}
				}//if
				
			}
		}
	};
	
	//서버와 연결된 소켓에 쓰여진 데이타를 읽기 위한 스레드]
	class ReadThread extends Thread{		
		void read(){
			if(socket !=null){//서버와 연결된 경우]
				while(true){
					try {
						txtHistory.append("Server>"+dis.readUTF()+"\r\n");
						
					} catch (IOException e) {
						txtHistory.append("서버가 연결을 끊었어요\r\n");
						break;
					}
					finally {
						SingleChatServer.autoScroll(txtHistory);
					}
					
				}//while				
			}//if
		}		
		@Override
		public void run() {
			read();
		}		
	}//////////////////////////	
	public static void main(String[] args) {
		new SingleChatClient();
	}

}
