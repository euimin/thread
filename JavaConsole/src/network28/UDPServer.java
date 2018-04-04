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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
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

public class UDPServer extends JFrame implements LayoutService {

	//UI용 컴포넌트]
	JTextArea txtHistory;
	JTextField txtMessage;
	//통신용 컴포너트]
	/*
	 * 자바로 UDP통신을 하려면 DatagramPacket과 DatagramSocket사용
	 * 
	 * DatagramPacket:데이타를 보내줄때나 혹은 받을때
	 *                사용하는 클래스로
	 *                이 클래스에 데이타를 바이트 형태로 저장한다.
	 *                
	 * DatagramSocket:DatagramPacket에 저장된 바이트 형태의
	 *                데이타를 보내때는 
	 *                DatagramSocket의 send(DatagramPacket)메소드
	 *                
	 *                데이타를 받을때는
	 *                DatagramSocket의 receive(DatagramPacket)메소드 호출
	 *                이때 받은 데이타를 담을 바이트형 배열을 마련해놓고
	 *                DatagramPacket에 설정해야 한다.
	 */
	
	DatagramSocket socket;
	DatagramPacket packet;
	
	public static final int PORT=9000;
	
	public UDPServer(){
		super("UDP 서버");
		createComponent();
		addComponent();
		addListener();
		setSize(600,550);
		setResizable(false);
		setVisible(true);		
	}
	@Override
	public void createComponent() {		
		//UI용 컴포넌트]
		txtHistory = new JTextArea();
		txtHistory.setEditable(false);
		txtMessage = new JTextField();
		//통신용 컴포넌트]	
		byte[] buf = new byte[1024];
		packet = new DatagramPacket(buf, buf.length);
		
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			JOptionPane.showMessageDialog(this, "서버 소켓 생성 실패:"+e.getMessage());
		}
		
	}
	@Override
	public void addComponent() {
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(txtHistory));
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		pnlSouth.setBorder(new TitledBorder("메시지 입력창"));
		pnlSouth.add(txtMessage);
		//프레임에 패널 부착
		add(pnlCenter);
		add("South",pnlSouth);
	}
	@Override
	public void addListener() {		
		//프레임에 윈도우 리스너 부착]
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				//프로그램 처음 실행시 메시지 입력 텍스트 필드에 포커스 주기
				txtMessage.requestFocus();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		
		//텍스트필드에 액션 리스너부착	
		txtMessage.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//데이타를 담을 DatagramPacket생성]
				//new DatagramPacket(보낼 데이타의 byte형 배열,
				//배열의 길이,보낼 아이피,보낼 포트)
				//1]보낼 데이타.
				byte[] buf=txtMessage.getText().getBytes();
				
				
				try {
					//2]보낼 주소
					InetAddress inet=InetAddress.getByName("localhost");
					//데이타 그램 패킷에 보낼 데이터 설정]		
					packet.setData(buf, 0,buf.length);
					packet.setPort(PORT);
					packet.setAddress(inet);
					//3]DatagramSocket의 send()메소드로 DatagramPacket에
					//  저장된 데이타를 전송
					socket.send(packet);
					txtHistory.append("UDPServer>"+txtMessage.getText()+"\r\n");
					//스크롤 자동으로 올라가게]
					SingleChatServer.autoScroll(txtHistory);
					//커서를 다시 입력 텍스트 필드로 가져오기
					txtMessage.requestFocus();
					//입력문자열 클리어
					txtMessage.setText("");
					
					
				} catch (Exception e1) {
					txtHistory.append("데이타 전송시 에러:"+e1.getMessage()+"\r\n");
				}
				
			}////////////////actionPerformed
		});
	}	
	public static void main(String[] args) {
		new UDPServer();
	}////////////////////////

}
