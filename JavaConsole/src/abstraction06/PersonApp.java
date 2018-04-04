package abstraction06;
/*
[클래스의 객체 생성]
	클래스명 인스턴스변수 = new 클래스명();//클래스명()는 생성자
[클래스의 멤버 접근]
	인스턴스변수.멤버 
*/
public class PersonApp {

	public static void main(String[] args) {
		//1]Person타입의 인스턴스 변수 선언
		Person person1;//person1이라는 이름으로 
        			   //stack영역에 주소를 저장할 수 있는 메모리 생성
		//2]new연산자로 Person타입의 메모리를 heap영역에 생성(할당)
		//인스턴스변수 person1에는 heap영역에 생성된
		//Person타입의 메모리 주소가 저장됨.		
		/* new연산자의 의미]
		 * -Person클래스를 인스턴스화 한다
		 * -Person클래스를 객체화 한다
		 * -Person타입의 메모리를 heap영역에 생성한다
		 *  위 세가지는 모두 같은 의미
		 */
		person1 = new Person();	
		System.out.println("person1="+person1);
		person1.printPerson();
		//멤버 변수 초기화]		
		person1.age=20;
		person1.name="홍길동";
		person1.weight=80;
		System.out.println("[멤버변수에 값 할당 후]");
		person1.printPerson();
		person1.sleep();
		person1.eat();
		
		//3]인스턴스 변수 선언과 동시에 메모리 할당
		Person person2 = new Person();
		System.out.println("person2="+person2);
		System.out.println(person2.getPerson());
		//멤버변수에 데이타 저장]
		person2.name="박길동";
		person2.weight=3.4;
		System.out.println("[멤버변수 값 할당 후]");
		person2.printPerson();
		/*
		 * 자바에서는 new로 새롭게 할당한 메모리를
		 * 해제 할 필요가 없다.
		 * GC(Garbage Collector)가 돌아 다니다가
		 * 더 이상 사용되지 않는 메모리는 해제 하니까.
		 * 
		 */
		person2 = new Person();
		System.out.println("person2="+person2);
		person2.printPerson();
	}///////////////////main
}///////////////////////class
