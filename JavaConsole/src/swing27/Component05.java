package swing27;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import awt26.servcie.LayoutService;
/*
1]테이블 생성방법1 - 
		데이타가 변하지 않고 처음부터 있다고
         가정할때 사용
        JTable  table = 
       	new JTable(tableData,columnTitle);
                  
        tableData은 실제 데이타를 갖고 있는 Object타입의
        2차원배열이나 Vector컬렉션 타입
        columnTitle은 테이블 제목을 담고 있는 Object타입의
        1차원 배열
                  
2]테이블 생성방법2 -프로그램 중간에 데이터가 생성되는
                     경우에 기본 생성자로 테이블 생성
                    JTable는 내부적으로 DefaultTableModel을 
                     데이타로 사용한다

*/
public class Component05 extends JFrame implements LayoutService {

	//[멤버변수]
	JTable table;
	//테이블에 표시할 데이타]
	Object[][] tableData ={
			{"김길동",20,"가산",new Date()},
			{"나길동",25,"강남",new Date()},
			{"다길동",30,"강동",new Date()},
			{"박길동",10,"인천",new Date()}
	};
	//컬럼명으로 사용할 데이타]
	Object[] columnData ={"이름","나이","주소","가입일"};
	
	//Model에 해당하는 클래스
	DefaultTableModel model;
	//테이블의 데이타로 사용할 컬렉션
	Vector<Vector> dataVector = new Vector<Vector>();
	//테이블의 컬럼명으로 사용할 컬렉션
	Vector<String> columnVector = new Vector<String>();
	
	
	public Component05(){
		//1]타이틀 설정
		setTitle("Swing컴포넌트 연습05");
		//2]레이아웃 변경			
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		setSize(500,300);
		setVisible(true);
	}
	@Override
	public void createComponent() {
		//1]테이블 생성방법1- 데이타가 불변이라고 가정
		//JTable(Object[][] rowData, Object[] columnNames)
		//table = new JTable(tableData, columnData);
		/*
		  2]테이블 객체 생성 방법2- 주로 많이 쓰임 ,
		                            왜냐하면 데이타가 변함으로
		  2-1]JTable의 기본 생성자로 생성
		  */
		table = new JTable();
		table.setBackground(Color.YELLOW);
		//2-2]데이타를 갖고 있는 Model객체 생성-기본생성자
		model = new DefaultTableModel();
		//2-3-1]model에 데이타 및 컬럼명 설정(배열 사용)
		//레코드로 Object[][] 컬럼명으로 Object[]사용
		//model.setDataVector(tableData, columnData);
		
		//2-3-2]데이타 및 컬럼명으로 컬렉션 사용		
		//데이타준비]
		Vector firstVec = new Vector();
		firstVec.add("김길동");
		firstVec.add(40);
		firstVec.add("부산");
		firstVec.add(new Date());
		
		Vector secondVec = new Vector();
		secondVec.add("이길동");
		secondVec.add(30);
		secondVec.add("인천");
		secondVec.add(new Date());
		
		Vector thirdVec = new Vector();
		thirdVec.add("박길동");
		thirdVec.add(25);
		thirdVec.add("대구");
		thirdVec.add(new Date());
		
		dataVector.add(firstVec);
		dataVector.add(secondVec);
		dataVector.add(thirdVec);
		
		 //컬럼 데이타]
		columnVector.add("이름");
		columnVector.add("나이");
		columnVector.add("주소");
		columnVector.add("가입일");
		
		/*
		레코드로 Vector<Vector> 
		컬럼명으로 Vector<String>사용
		*/
		model.setDataVector(dataVector, columnVector);
		//2-4]model과 table을 바인딩-
		//    JTable객체의 setModel(TabletModel model)메소드 사용
		table.setModel(model);
		/*
		 [테이블 꾸미기]
		 테이블 객체의 getTableHeader() 메소드로 
		 테이블 헤더 정보를
		 얻는다.	 
		 */
		JTableHeader tableHeader= table.getTableHeader();
		//[1]헤더의 배경색 지정-setBackground()
		tableHeader.setBackground(Color.RED);
		//[2]컬럼명의 글자 색 변경-setForeground()	
		tableHeader.setForeground(Color.YELLOW);
		//[3]컬럼명에 폰트 설정-setFont()
		Font font = new Font("굴림체",Font.BOLD,16);
		tableHeader.setFont(font);
		//[4]컬럼명의 정렬순서 막기-setReorderingAllowed(false)
		tableHeader.setReorderingAllowed(false);
		//[5]컬럼명의 컬럼 가로 폭 변경 못하게-setResizingAllowed(false)
		tableHeader.setResizingAllowed(false);
		//[6]헤더의 세로폭 설정-setPreferredSize()
		//  단,헤더의 가로폭은 적용 안됨.
		tableHeader.setPreferredSize(new Dimension(10000,50));
		/*
		   컬럼에 대한 모양을 꾸미기 위해서는 
		   컬럼정보를 담고 있는
		   TableColumnModel객체를 테이블 객체로 
		   얻어 와야 한다.
		   
		   TableColumnModel객체는 
		   테이블객체.getColumnModel();
		   얻어 옴.
		   
		   TableColumnModel객체를통해서 컬럼의 가로폭 
		   및 컬럼에 있는
		   데이타의 정렬(좌,우,가운데),컬럼의 갯수 등을
		   구할 수 있다.      
		*/
		TableColumnModel columnModel= table.getColumnModel();

		//[7]컬럼폭 조정
		//[7-1]TableColumnModel의 getColumn(컬럼인덱스)로
	    //     TableColumn객체 얻기
		// 컬럼 수 얻기]JTable객체로도 가능(table.getColumnCount())		
		int columnCount=columnModel.getColumnCount();
		//System.out.println("컬럼수:"+columnCount);
		
		//TableColumn객체를 저장할 배열 선언
		TableColumn[] columns = new TableColumn[columnCount];
		for(int i=0;i < columnCount;i++)
			columns[i]=columnModel.getColumn(i);
		//가로폭 조정방법1]TableColumn객체의 
		//                setPreferredWidth()로 가로폭 설정.
		//columns[0].setPreferredWidth(90);//이름컬럼
		//columns[1].setPreferredWidth(20);//나이컬럼
		//columns[3].setPreferredWidth(200);//가입일컬럼
		//가로폭 조정방법2]
		//[7-3]TableColumn객체의 
		//     setWidth(가로폭)메소드로 가로폭 설정
		columns[0].setWidth(90);
		columns[1].setWidth(50);
		columns[3].setWidth(200);
		//7-3-1]setWidth한 후 JTableHeader객체의
		//setResizingColumn(TableColumn)해야 setWidth()
		//가 적용됨. 
		tableHeader.setResizingColumn(columns[0]);
		tableHeader.setResizingColumn(columns[1]);
		tableHeader.setResizingColumn(columns[3]);
		//TableColumnModel모델객체 나 JTable객체로 
		//컬럼의 개수  얻기 :getColumnCount()
		/*
		특정 컬럼만 정렬]
		정렬을 위한 DefaultTableCellRenderer생성:
		         TableCellRenderer인터페이스 구현
		1. DefaultTableCellRenderer dtcr = 
				new DefaultTableCellRenderer();
		2.정렬 타입 설정
		  dtcr.setHorizontalAlignment(JLabel.CENTER);	
		  설정된 정렬타입을 setCellRenderer()메소드로 정렬 처리
		  TableColumn객체의 setCellRenderer(dtcr)메소드로 정렬
		*/
		//1]DefaultTableCellRenderer객체 생성
		DefaultTableCellRenderer dtcr = 
				new DefaultTableCellRenderer();
		//2]정렬 설정
		dtcr.setHorizontalAlignment(JLabel.CENTER);	
		//3]각 컬럼에 DefaultTableCellRenderer적용
		for(int i=0;i < columnCount;i++){
			if(i !=2)
				columns[i].setCellRenderer(dtcr);
		}
		//[8]행의 세로폭 조절-테이블객체의 
		//   테이블객체.setRowHeight(행의폭)메소드로
		//   설정
		table.setRowHeight(30);
		//[9]레코드(행)의 특정 셀의 값 설정 및 값 읽기
	    /*
	     값 얻어 올때:
	     테이블객체.getValueAt(행인덱스, 컬럼인덱스);   
	     값 설정할때 :
	     table.setValueAt(설정할 값,행인덱스,컬럼인덱스);	    
	     */
		setTitle(table.getValueAt(1, 2).toString());
		//JTable에 표시되는 데이타만 변할뿐
		//데이타베이스는  수정이 안되 있다.
		//단,모델로 사용한 컬렉션의 데이타는 수정되 있다
		table.setValueAt("세종시", 1, 2);
		//변경값 확인]		
		for(Object value:secondVec) System.out.println(value);
		
		
		
	}
	@Override
	public void addComponent() {
		//프레임에 테이블 부착]
		/*
		 * ※테이블에  JScrollPane을 붙여야 컬럼명이 
		 *   표시된다. 
		 */
		add(new JScrollPane(table));
	}
	@Override
	public void addListener() {
		//종료]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Component05();
	}

}
