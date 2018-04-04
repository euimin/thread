package constructor15;
/*
	1]생성자란?
    : 객체가 생성될 때(인스턴스화) 최초로 실행되는  메소드를 의미.
	2]생성자 특징
		- 생성자 이름은 클래스명과 동일해야 한다
		- 반환타입을 가져선 안된다.
		- 생성자의 접근지정자로는 주로 public속성
    3]생성자의 역할
		- 멤버 변수를 초기화 하는 일
		- 생성자를 구현하지 않았을 경우 컴파일러는 
		  default생성자를 제공해줌
	    - 생성자를 하나라도 구현했다면, 그 때는 컴파일러가 
		  default생성자를 제공 해주지 않는다.
		- 생성자를 다양하게 오버로딩 함으로써 다양한 초기값을 
			부여할 수 있다.*/

class Saram{
	
	String name;
	String lastJumin;
	//멤버변수 초기화용 멤소드]
	void initialize(String name,String lastJumin){
		this.name= name;
		this.lastJumin=lastJumin;
	}
	void print(){
		System.out.println(name+"은 "+(lastJumin.charAt(0)=='1' ? "남자":"여자"));
	}
}//////////////////////

class Saram2{
	
	String name;
	String lastJumin;
	
	public Saram2(){
		name="자바";
		lastJumin="1234567";
	}
	
	public Saram2(String name){
		this.name= name;
		lastJumin="2345678";
	}
	
	public Saram2(String name,String lastJumin){
		this.name= name;
		this.lastJumin=lastJumin;
	}
	
	void print(){
		System.out.println(name+"은 "+(lastJumin.charAt(0)=='1' ? "남자":"여자"));
	}
	
}
public class Constructor01 {

	public static void main(String[] args) {
		//인스턴스화/객체화/메모리 생성]
		//Saram saram = new Saram();
		/*
		//초기화용 메소드 호출시]
		saram.initialize("홍길동", "1234567");
		//정보 출력]
		saram.print();
		*/
		//초기화용 메소드 미 호출시]-NullPointerException발생
		//saram.print();
		
		//[인스턴스화]
		Saram2 saram = new Saram2("홍길동","1234567");
		//정보 출력]
		saram.print();
		
		Saram2 saram2 = new Saram2("홍길순");
		saram2.print();
		
		Saram2 saram3 = new Saram2();
		saram3.print();
	}

}
