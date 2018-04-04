package inheritance16;
//[Teacher is a Person성립]
public class Teacher extends Person {
	//[멤버 변수]
	//이름과 나이와 주소는 상속받아서 재사용]
	//Teacher클래스에서 새롭게(확장)한 멤버변수
	String subject;
	//[생성자]
	//기본 생성자]
	public Teacher(){
		this("이름 미정",1,"주소 미정","과목 미정");
	}
	//인자 생성자]
	public Teacher(String name, int age, String addr,String subject) {
		super(name, age, addr);
		this.subject = subject;
	}
	//[멤버 메소드]
	//Person에서 정의한 메소드는 재사용
	//Teacher클래스에서 새롭게 추가한(확장)한 메소드
	void teach(){
		System.out.println(name+"샘이 "+subject+"를(을) 가르치다");
	}
	


	

	String getTeacher(){
		return String.format("%s,담당과목:%s",getPerson(),subject);
	}
	void printTeacher(){
		System.out.println(getTeacher());
	}
}
