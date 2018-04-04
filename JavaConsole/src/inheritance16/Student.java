package inheritance16;

//[Student is a Person성립]
public class Student extends Person {
	//[멤버 변수]
	//이름과 나이와 주소는 상속받아서 재사용]
	//Student클래스에서 새롭게(확장)한 멤버변수	
	String studentNumber;
	//[생성자]
	//※자식의 모든 생성자(기본/인자)안에서는 기본적으로
	//  부모의 기본(디폴트) 생성자(super())를 호출환다.
	//기본 생성자]
	public Student(){
		//super();가 생략된거와 같다.생략시 자동으로 추가해줌
		/*
		this.name="이름 미상";
		age=1;
		addr="주소 미상";
		studentNumber ="학번 미정";
		*/
		this("이름 미상",1,"주소 미상","학번 미정");
		System.out.println("Student의 기본생성자");
	}
	//인자 생성자]
	public Student(String name,int age,String addr,String studentNumber){
		//부모의 인자 생성자를 지정하여 호출시에는
		//반드시 부모에 기본생성자를 정의해 두는게 유리하다
		super(name,age,addr);
		this.studentNumber = studentNumber;
		System.out.println("student의 인자 생성자");
	}
	//[멤버 메소드]
	//Person에서 정의한 메소드는 재사용
	//Student클래스에서 새롭게 추가한(확장)한 메소드
	void study(){
		System.out.println(String.format("나이가 %d살인 %s가 공부하다",age,this.name));
	}////////////////////////
	String getStudent(){
		return String.format("%s,학번:%s",getPerson(),studentNumber);
	}
	void printStudent(){
		System.out.println(getStudent());
	}
}
