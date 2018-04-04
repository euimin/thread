package console.academy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import comm.util.CommonUtility;

public class AcademyCollectionObjectLogic {
	//[멤버 상수]
	public static final int MAX_PERSON=3;//최대 인원수
	//[멤버 변수]
	List<Person> person;
	//[생성자]
	public AcademyCollectionObjectLogic(){
		//멤버 변수 초기화]
		person = new Vector<Person>();
		/*파일(FileRW.txt)에서 데이타를 읽어
		  person컬렉션에 객체를 저장 로직]
		  데이타 소스:파일-FileReader
		  데이타 목적지:컬렉션(메모리)-출력 스트림 불필요
		  
		  저장된 예]
		  이름:홍길동,나이:20,학번:2017
		  이름:박길동,나이:20,학번:2016
	 	  이름:김길동,나이:40,과목:자바
	 	  
	 	  힌트:과목 이나 학번 포함 여부로 학생인지
	 	       교사인지 판단.
	 	       실제 데이타는 String 클래스의 split메소드로
	 	       추출.
		 */
		fileToCollection();
		
	}
	private void fileToCollection() {
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/console/academy/object.txt"));
			person=(List<Person>)ois.readObject();
			ois.close();
		}
		catch(Exception e){}
	}/////////////////////////////////////
	//[멤버 메소드]
	/*
	 * 1]메뉴 출력용 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 */
	public void printMainMenu() {
		System.out.println("====================Main Menu===================");
		System.out.println("1.입력 2.출력 3.수정 4.삭제 5.검색 6.파일저장 9.종료");
		System.out.println("================================================");
		System.out.println("메인 메뉴번호를 입력하세요?");
	}////////////printMainMenu()
	/*
	 * 2]메뉴 번호 입력용 메소드
	 * 매개변수:NO
	 * 반환타입:int-메뉴번호
	 */	
	public int getMenuNumber() {
		/*문]메뉴번호를 숫자형식이 아닌 문자열을 입력시
		   "메뉴번호가 아닙니다"라는 메시지를 뿌려주고
		   정상적인 숫자형식의 문자열을 입력받을때까지
		   다시 메뉴번호를 입력받도록 하여라
		   힌트:CommonUtility클래스의 isNumber(String)메소드 사용
		*/   
		Scanner scanner = new Scanner(System.in);
		while(true){
			String numberString = scanner.nextLine();
			
			if(!CommonUtility.isNumber(numberString)){
				System.out.println("메뉴는 숫자만....");
				continue;
			}
			int menuNumber=0;
			try{
				menuNumber = Integer.parseInt(numberString);
			}
			catch(Exception e){
				System.out.println("메뉴번호 미 입력-다시 입력하세요");				
				continue;
			}
			return menuNumber;			
		}
		
		
	}//////////////////getMenuNumber()
	
	/*
	 * 3]메인 메뉴 번호에 따른 분기용 메소드
	 * 반환타입:void
	 * 매개변수:int(메인메뉴)
	 */
	public void seperateMainMenu(int mainMenu) {
		switch (mainMenu) {
			case 1://입력
				while(true){
					//서브메뉴 출력]
					printSubMenu();
					//서브메뉴번호 입력받기]
					int subMenu=getMenuNumber();
					//3번인 경우 입력받는 거 중지(메인 메뉴로 이동) 
					if(subMenu==3) break;					
					//학생이나 교사인 경우 입력처리]
					switch(subMenu){
						case 1:
						case 2:setPerson(subMenu);break;
						default:System.out.println("잘못된 서브메뉴번호 입니다");
					}
					/*
					if(!(subMenu ==1 || subMenu ==2)){
						System.out.println("잘못된 서브메뉴번호 입니다");
						continue;
					}						
					setPerson(subMenu);
					*/
				}
				break;
			case 2://출력
				printPerson();
				break;
			case 3://수정
				updatePerson();
				break;
			case 4://삭제
				deletePerson();
				break;
			case 5://검색
				searchPerson();
				break;
			case 6://파일저장
				savePersonToFile();
				break;
			case 9://프로그램 종료]
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 메뉴번호 입니다");
		}//////////////switch	
		
		
	}//////////////////////seperateMainMenu
	
	/*
	 * 4]서브 메뉴 출력용 메소드
	 * 반환타입:void
	 * 매개변수:NO
	 */
	private void printSubMenu() {
		System.out.println("====================Sub Menu===================");
		System.out.println("1.학생 2.교사 3.메인 메뉴로 이동");
		System.out.println("================================================");
		System.out.println("서브 메뉴번호를 입력하세요?");
		
	}/////////////////printSubMenu()
	/*
	 * 5]서브메뉴번호에 따른 학생 및 교사 데이타 입력용 메소드
	 * 반환타입:void
	 * 매개변수:int(서브메뉴)
	 */
	private void setPerson(int subMenu) {
		//정원 찼는지 여부 판단]		
		if(person.size()==MAX_PERSON){//정원이 찬 경우
			System.out.println("이미 정원이 찼어요!!!");
			return;
		}	
		//이름과 나이는 둘다 공통]
		Scanner scanner = new Scanner(System.in);
		System.out.println("[이름을 입력하세요?]");
		String name = scanner.nextLine();
		
		int age=0;
		while(true){
			System.out.println("[나이를 입력하세요?]");
			String stringAge = scanner.nextLine();
			try{
				age = Integer.valueOf(stringAge);
				break;
			}
			catch(Exception e){
				System.out.println("나이는 숫자만...");
			}
		}
		//학생 과 교사 구분해서 입력 받기]
		switch(subMenu){
		
			case 1://학생
				System.out.println("[학번을 입력하세요?]");
				String stNumber= scanner.nextLine();
				person.add(new Student(name, age, stNumber));
				break;
			case 2://교사
				System.out.println("[과목을 입력하세요?]");
				String subject= scanner.nextLine();
				person.add(new Teacher(name, age, subject));
		}///////switch
	}/////////////////setPerson
	/*
	 * 6]모든 학생 및 교사 출력용 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 *  
	 */
	private void printPerson() {
		System.out.println("[학생 및 교사 구분 없이 출력]");
		for(Person p:person) p.print();
		//문] 학생과 교사를 구분해서 출력하여라
		/*
		 *  [학생 목록]
		 *  이름:송정환,나이:28,학번:2014
		 *  이름:최연식,나이:28,학번:2015
		 *  [교사 목록]
		 *  이름:최철환,나이:30,과목:자바
		 * 
		 */
		System.out.println("[학생 및 교사 구분 해서 출력]");
		StringBuffer sbStudent = new StringBuffer("[학생목록]\r\n");
		StringBuffer sbTeacher = new StringBuffer("[교사목록]\r\n");
		for(Person p : person)			
				if(p instanceof Student)
					sbStudent.append(p.get()+"\r\n");
				else
					sbTeacher.append(p.get()+"\r\n");		
		//출력]
		System.out.println(sbStudent.toString()+sbTeacher);
	}///////////////printPerson()
	/*
	 * 7]이름으로 검색하는 메소드
	 * 매개변수:String(수정/삭제/검색용 타이틀)
	 * 반환타입:Person타입 
	 */
	Person getSearchByName(String title){
		Scanner scanner = new Scanner(System.in);
		System.out.println(title+"할 이름을 입력하세요?");
		String searchName = scanner.nextLine();
		for(Person p : person)
			//이름이 검색된 경우]
			if(p.name.equals(searchName))
				return p;
		//검색된 이름이 없는 경우]
		System.out.println(searchName+"으로 검색한 정보가 없습니다.");
		//검색한 이름이 없을 경우 null반환]		
		return null;
	}////////////////////getSearchByName
	//8]검색용 메소드
	private void searchPerson() {
		Person search=getSearchByName("검색");
		if(search != null) search.print();
	}
	//9]수정용 메소드
	private void updatePerson() {
		Person search=getSearchByName("수정");
		if(search != null){//수정할 사람이 검색된 경우]
			Scanner scanner = new Scanner(System.in);
			int age=0;
			while(true){
				System.out.println("바꾸고자하는 나이 입력?");
				String stringAge = scanner.nextLine();
				try{
					age = Integer.parseInt(stringAge);
					break;
				}
				catch(Exception e){
					System.out.println("나이는 숫자만...");
				}
			}
			
			
			//나이 수정]
			search.age = age;
			//학생과 교사 구분해서 입력받기]
			if(search instanceof Student){//학생
				System.out.println("바꾸고자 하는 학번 입력?");
				//학번 수정]
				((Student) search).stNumber= scanner.nextLine();
			}
			else{//교사
				System.out.println("바꾸고자 하는 과목 입력?");
				//과목 수정]
				((Teacher)search).subject= scanner.nextLine();
			}
			System.out.println(
					String.format("%s님이 수정되었어요!!!",search.name));
			
		}/////////////if		
	}///////////////updatePerson()
	//10]삭제용 메소드
	private void deletePerson() {
		Person search=getSearchByName("삭제");
		if(search !=null){//삭제할 대상이 있는 경우
			//반환받은 주소(search)와 Person형 배열 저장된 주소 비교]
			for(Person p: person){
				//주소가 같은 경우 해당 인덱스 방을 null로 설정]
				if(search.equals(p)){
					person.remove(p);
					System.out.println(search.name+"가(이) 삭제되었어요!!");
					break;
				}
			}
		}
	}/////////////deletePerson()
	/*
	 * 컬렉션에 저장된 데이타를 파일로 저장하는 로직]
	 * 데이타 소스:컬렉션(메모리)-입력스트림 불필요
	 * 데이타 목적지:파일(FileRW.txt)-FileWriter
	 * 
	 * 힌트:한명 저장시마다 끝에 \r\n추가 
	 * 이름:홍길동,나이:20,학번:2017
	 * 이름:박길동,나이:20,학번:2016
	 * 이름:김길동,나이:40,과목:자바
	 * 
	 */
	private void savePersonToFile() {
		if(person.size() ==0){
			System.out.println("저장된 객체가 없어요");
			return;
		}
		
		try {
			ObjectOutputStream oos =
					new ObjectOutputStream(
							new FileOutputStream("src/console/academy/object.txt")
							);
			oos.writeObject(person);
			System.out.println("저장되었습니다.");
		} 
		catch (IOException e) {
			System.out.println("파일 저장시 에러");
		}
		
		
	}///////////savePersonToFile()
	
}///////////////////AcademyLogic
