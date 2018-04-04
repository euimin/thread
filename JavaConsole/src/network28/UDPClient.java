package network28;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.MarshalledObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationID;
import java.rmi.activation.ActivationInstantiator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import awt26.servcie.LayoutService;

public class UDPClient extends JFrame implements LayoutService {

	//UI용 컴포넌트]
	JTextArea txtHistory;

	//통신용 컴포넌트]   
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPClient(){
		super("UDP 클라이언트");
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
		
		//통신용 컴포넌트]		
		//소켓 먼저  생성]
		
		try {
			//생성시 어느 포트로 데이타를 받을지 설정]
			/*※서버에서 보내는 곳의 IP를 설정했기때문에
			  클라이언트는 무조건 받기만 하면된다.
			  즉 서버쪽 주소를 알필요 없다.*/
			socket = new DatagramSocket(UDPServer.PORT);
			//데이타를 읽는 스레드 start]
			new ReadThread().start();
		} catch (SocketException e) {
			JOptionPane.showMessageDialog(this, "클라이언트 소켓 생성 실패:"+e.getMessage());
		}
	}
	@Override
	public void addComponent() {
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(txtHistory));		
		//프레임에 패널 부착
		add(pnlCenter);
		
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
			
	}	
	
	class ReadThread extends Thread{
		void read(){
			if(socket != null){
				while(true){
					//1]서버에서 보낸 메시지를 담을 byte형 배열 준비
					byte[] buf =new byte[1024];
					//2]바이트형 배열에 메시지를 담아 달라고
					//  DatagramPacket생성
					packet = new DatagramPacket(buf,buf.length);
					
					try {
						//3]DatagramSocket의 receive()메소드로 데이타 받기
						socket.receive(packet);
						//4]패킷에 저장된 데이타를 가져오자
						byte[] bytes=packet.getData();
						//확인차 텍스트 에리어에 출력
						txtHistory.append(new String(bytes)+"\r\n");
						//자동 스크롤
						SingleChatServer.autoScroll(txtHistory);
					} 
					catch (IOException e) {
						txtHistory.append("소켓에 데이타 읽기시 오류:"+e.getMessage()+"\r\n");
						break;
					}
				}/////////////////			
			}///////////////
		}
		@Override
		public void run() {
			read();
		}
	}
	public static void main(String[] args) {
		new UDPClient();
	}////////////////////////

}
