package innerclass22;
/*
 * 익명 클래스]
 * -이름이 없는 클래스
 * -GUI프로그래밍 시 주로 사용(이벤트 처리하기 위해서)
 * -부모클래스의 메소드를 오버라이딩하는 것이 주된 용도
 * -마치 클래스 정의시 형태가 메소드를 정의하는 것과
 *  유사하다(생성자이용) *  
 *  형식]
 *  부모클래스명 인스턴스변수 = 
 *  new 부모클래스명()
 *  {
 *  
 *  
 *  };//반드시 ;을 붙여라
 * 
 */
class Person{
	String name;
	public Person(String name) {		
		this.name = name;
	}
	void print(){
		System.out.println("이름:"+name);
	}
	
}//////////////////////////////
class Student extends Person{
	String stNumber;//자식에서 새롭게 확장한 멤버변수]

	public Student(String name,String stNumber) {
		super(name);
		this.stNumber = stNumber;
	}
	//자식에서 새롭게 확장한 멤버 메소드]
	String get(){
		return String.format("학번:%s",stNumber);
	}
	//[오버라이딩]
	@Override
	void print() {		
		super.print();
		System.out.println(get());
	}
	
	
}
//[추상 클래스]
abstract class AbstractClass{
	abstract void abstractMethod();
}
//[인터 페이스]
interface Inter{
	void abstractMethod();
}

public class InnerAnonymousClass {

	public static void main(String[] args) {
		//[이름이 있는 자식클래스의 일반적인 이질화 형태]
		Person person = new Student("홍길동", "2017학번");
		person.print();
		//[자식에서 새롭게 확장한 멤버 접근]-형변환(다운캐스팅)
		((Student)person).stNumber="2018학번";
		System.out.println(((Student)person).get());
		//[ Person을 상속받은 익명 클래스 정의 및 생성]
		/*
		Person타입의 인스턴스변수에 Person을 상속받은
		익명클래스를 생성해서 그 주소를 할당
		new Person(){};=>new 무명 extends Person{};
		-이름이 없기때문에 부모클래스의
		 이름를 빌려서 생성했다고 생각하자
		 */
				
		Person anony = new Person("박길동"){
			//[멤버변수]
			int newvar;//익명클래스에서 새롭게 확장한 멤버
			//[멤버 메소드]
			void newmethod(){
				System.out.println("익명 클래스에서 새롭게 확장한 멤버");
			}
			@Override
			void print() {
				newvar=100;
				newmethod();
				System.out.println("익명 클래스에서 오버라이딩:"+newvar);
			}			
		};
		
		anony.print();
		//[자식에서 새롭게 정의한 멤버 접근]
		//다운캐스팅:(자식클래스명)부모타입인스턴스변수
		//클래스명이 없음으로 다운캐스팅 불가
		//고로 자식에서 새롭게 정의한 멤버 접근 불가
		//※고로 익명클래스는 오버라이딩이 목적
		Student anony_student = new Student("박길동","2000학번"){
			
			int age=1;
			
			@Override
			String get() {				
				return super.get()+",나이:"+age;
			}

			@Override
			void print() {				
				System.out.println("이름:"+name+","+get());
			}			
		};
		System.out.println("[학생 상속받은 익명 클래스]");
		anony_student.print();
		//추상 클래스를 상속받은 익명 클래스]
		//new 무명 extends AbstractClass(){}
		AbstractClass ac = new AbstractClass(){
			@Override
			void abstractMethod() {
				System.out.println("추상 메소드 오버라이딩");				
			}			
		};
		ac.abstractMethod();
		//인터페이스를 상속받은 익명 클래스]
		//new 무명 implements Inter(){} 	
		Inter inter = new Inter(){
			@Override
			public void abstractMethod() {
				System.out.println("추상 메소드 오버라이딩:인터페이스");
				
			}			
		};
		inter.abstractMethod();
	}///////////////////main

}//////////////////////class
