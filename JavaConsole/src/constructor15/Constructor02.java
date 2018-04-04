package constructor15;



public class Constructor02 {

	public static void main(String[] args) {
		/*
		-Person클래스 객체화(인스턴스화/heap영역에 메모리 생성)
		
		클래스명 변수(인스턴스변수) = new 생성자();
		new의 의미:heap영역에 새롭게 메모리 생성
		
		1]기본(디폴트) 생성자 정의 전
		  인자 생성자를 정의하지 않은 경우 기본 생성자를 
		  자동으로 제공해줌.
		  인자 생성자 추가시에는 아래처럼 기본생성자로
		  객체 생성하려면 반드시 기본 생성자를 추가해라
		*/
		//기본 생성자로 객체 생성]
		Person person1 = new Person();
		System.out.println("[멤버변수 초기화용 메소드 호출 전]");
		person1.print();
		System.out.println("[멤버변수 초기화용 메소드 호출 후]");
		person1.initialize("홍길동", 20, "가산동");
		person1.print();
		//인자 생성자로 객체 생성]
		//생성과 동시에 멤버 변수 초기화됨.
		//개발자가 정의한 초기화용 메소드 호출 불필요
		System.out.println("[이름만 전달]");
		Person person2 = new Person("가길동");
		person2.print();
		System.out.println("[이름과 나이 전달]");
		Person person3 = new Person("나길동", 20);
		person3.print();
		System.out.println("[이름과 나이 그리고 주소 전달]");
		Person person4 = new Person("다길동",30,"청담동");
		person4.print();
	}//////////////////////main
}/////////////////////////class
