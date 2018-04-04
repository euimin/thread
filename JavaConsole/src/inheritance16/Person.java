package inheritance16;
/*	
클래스 상속:
*
* -단일 상속만 지원
* -IS A 관계 성립해야 한다.
*  자식 IS A 부모
* -extends 키워드 사용
* -private접근 지정자가 붙은 부모의 멤버는
*  상속은 받으나 접근 불가.
* 
* -형식]
* 
*   접근지정자 class 자식클래스명 extends 부모클래스명{
*  
*   }
*/

public class Person /* extends Object */ {//모든 클래스는 Object를 자동으로 상속받는다
	//[멤버 변수]
	String name;
	int age;
	String addr;
	/*
	 * ※모든 클래스의 생성자(기본,인자)안에는
	 *   기본적으로 super();를 호출한다.
	 *   즉 부모의 기본 생성자를 호출한다.
	 * 
	 *   고로 부모 클래스에서 인자 생성자 정의시에는
	 *   기본적으로 기본 생성자도 정의하자.
	 *   단, 자식클래스에서 super()가 아닌 부모의
	 *   인자 생성자를 호출하도록 정의 한다면
	 *   기본 생성자를 정의할 필요는 없다.
	 */
	//기본 생성자]	
	public Person(){
		//super();//Object의 기본 생성자 생략 된거와 같다.
		System.out.println("Person의 기본 생성자");
	}
	
	//인자 생성자]
	public Person(String name, int age, String addr) {
		//super();//Object의 기본 생성자
		this.name = name;
		this.age = age;
		this.addr = addr;
		System.out.println("Person의 인자 생성자");
	}
	//[멤버 메소드]
	String getPerson(){
		return String.format("이름:%s,나이:%d,주소:%s",name,age,addr);
	}
	

	void printPerson(){
		System.out.println(getPerson());
	}
}
