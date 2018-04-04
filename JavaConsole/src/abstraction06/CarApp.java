package abstraction06;

import java.security.acl.Owner;

//자동차를 추상화하자]
class Car{
	//[멤버상수]
	public static final String AUTO="자동";
	public static final String MANUAL="수동";
	//[멤버변수]
	String carModel;//모델명
	int carYear;//연식
	String carGear=AUTO;//기어
	Person owner;//소유주
	//[멤버 메소드]
	void drive(){
		System.out.println(owner.name+"이 "+carModel+"을 운전한다.");
	}
	//프로그램 효율을 위한 멤버 메소드들]
	//멤버변수 초기화용 메소드]	
	void initialize(){
		carModel="람보르기니";
		carYear=2017;
		owner = new Person();
		owner.age=30;
		owner.name="홍길동";
		owner.weight=80;
	}
	//정보 출력용 메소드]
	void printCar(){
		System.out.println("[차량정보]");
		System.out.printf("모델명:%s%n",carModel);
		System.out.printf("연식:%d%n",carYear);
		System.out.printf("기어:%s%n",carGear);
		System.out.printf("==%s 차량 소유주 정보==%n",carModel);
		owner.printPerson();
		
	}//////////////////
}
public class CarApp {

	public static void main(String[] args) {
		/*
		Car클래스(설계도)로 	Car타입의 메모리 생성(객체화)
		즉 인스턴스화 		
		*/
		Car car1 = new Car();
		System.out.println("[멤버변수 초기화용 메소드 호출전]");
		System.out.println("car1.owner="+car1.owner);
		//car1.drive();//[x]NullPointerException발생.owner가 null
		System.out.println("[멤버변수 초기화용 메소드 호출후]");
		car1.initialize();
		car1.drive();
		car1.printCar();
		//초기화용 메소드(initialize) 호출하지 않고 직접 .(DOT)으로 접근해서
		//멤버변수에 데이타 저장]
		Car car2 = new Car();
		car2.carModel="제너시스";
		//클래스의 멤버(변수,메소드,상수...)에 
		//static이 붙으면
		//클래스명.멤버로 접근	
		car2.carGear= Car.AUTO;
		car2.carYear=2017;
		car2.owner =new Person();
		car2.owner.name="김길동";
		car2.owner.age=20;
		car2.owner.weight=70;
		car2.printCar();
	}///////////////////////main

}///////////////////////////class
