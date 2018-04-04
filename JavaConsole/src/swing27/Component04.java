package swing27;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import awt26.servcie.LayoutService;

public class Component04 extends JFrame implements LayoutService {

	//[멤버변수]
	JList listLeft,listRight;
	JButton btnLeft,btnRight,btnOk;
	JTextArea taResult;
	
	Vector<String> vecLeft = new Vector<String>();
	Vector<String> vecRight = new Vector<String>();
	
	public Component04(){
		//1]타이틀 설정
		setTitle("Swing컴포넌트 연습04");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(500,650);
		setVisible(true);
	}
	@Override
	public void createComponent() {
		//리스트]
		listLeft = new JList();
		//컬렉션에 데이타 저장]
		vecLeft.add("지리산");
		vecLeft.add("한라산");
		vecLeft.add("설악산");
		vecLeft.add("태백산");
		vecLeft.add("덕유산");
		vecLeft.add("소요산");
		vecLeft.add("청계산");
		vecLeft.add("북한산");
		vecLeft.add("비슬산");
		vecLeft.add("도봉산");
		//리스트와 컬렉션 연결:setListData()]
		listLeft.setListData(vecLeft);

		listRight = new JList();
		//버튼]
		btnLeft = new JButton("<<");
		btnRight=new JButton(">>");
		btnOk  = new JButton("확인");		
		//텍스트 에리어]
		taResult = new JTextArea();
	}
	@Override
	public void addComponent() {
		JPanel pnlNorth = new MyPanel(new GridLayout(1,3));
		pnlNorth.setBorder(new TitledBorder("아이템 목록"));
		//북쪽 1열]
		pnlNorth.add(new JScrollPane(listLeft));
		//북쪽 2열]
		JPanel pnlNull = new MyPanel();
		pnlNull.setLayout(null);
		
		btnLeft.setBounds(50,30,50,35);
		pnlNull.add(btnLeft);
		btnRight.setBounds(50,65,50,35);
		pnlNull.add(btnRight);
		
		pnlNorth.add(pnlNull);
		
		//북쪽 3열]
		pnlNorth.add(new JScrollPane(listRight));
		
		
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("결과창"));
		pnlCenter.add(new JScrollPane(taResult));		
		
		JPanel pnlSouth = new MyPanel();
		pnlSouth.add(btnOk);
		
		//프레임에 패널부착]
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);
	}
	@Override
	public void addListener() {
		//종료]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//버튼에 액션 리스너 부착]
		btnLeft.addActionListener(listener);
		btnRight.addActionListener(listener);
		btnOk.addActionListener(listener);
		//리스트에 리스트셀렉션리스너 부착]
		listLeft.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//if(e.getValueIsAdjusting())
					//System.out.println("ListSelectionEvent Generated:"+e.getValueIsAdjusting());				
			}
		});
		
	}
	ActionListener listener= new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source =e.getSource();
			if(source == btnLeft){
				if(listRight.getSelectedIndices().length==0){
					JOptionPane.showMessageDialog(btnRight,"오른쪽에서 아이템 선택");
					return;
				}
				//왼쪽으로 아이템 이동
				List values=listRight.getSelectedValuesList();
				for(Object value:values){
					//왼쪽용 벡터에 아이템 추가
					vecLeft.add(value.toString());
					//오른쪽용 벡터에서 아이템 제거
					vecRight.remove(value);
				}
				//벡터와 리스트 연결
				listRight.setListData(vecRight);
				listLeft.setListData(vecLeft);		
			}
			else if(source == btnRight){
				if(listLeft.getSelectedIndices().length==0){
					JOptionPane.showMessageDialog(btnRight,"왼쪽에서 아이템 선택");
					return;
				}
				//오른쪽으로 아이템 이동
				List values=listLeft.getSelectedValuesList();
				for(Object value:values){
					//오른쪽용 벡터에 아이템 추가
					vecRight.add(value.toString());
					//왼쪽용 벡터에서 아이템 제거
					vecLeft.remove(value);
				}
				//벡터와 리스트 연결
				listRight.setListData(vecRight);
				listLeft.setListData(vecLeft);			
			}
			else{
				/*단일 선택
				System.out.println("Index:"+listLeft.getSelectedIndex());
				System.out.println("Value:"+listLeft.getSelectedValue());
				*/
				
				// 다중 선택(ctrl키와 함께 선택)
				/*
				int[] indexes =listLeft.getSelectedIndices();
				System.out.println(indexes.length);
				for(int index : indexes) System.out.println(index);
				List values=listLeft.getSelectedValuesList();
				for(Object value:values) System.out.println(value);
				*/
				if(vecLeft.size() ==0){
					JOptionPane.showMessageDialog(btnRight,"아이템이 없어요");
					return;
				}
				taResult.setText("");
				for(Object item:vecLeft)
					taResult.append(item+"\r\n");
				
			}
			
		}
	};/////////////////////////////////////	
	@Override
	public Insets getInsets() {		
		return new Insets(40, 20, 20, 20);
	}
	public static void main(String[] args) {
		new Component04();
	}

}
