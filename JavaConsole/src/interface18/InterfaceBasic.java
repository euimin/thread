package interface18;
/*
-클래스가 객체의 설계도라면 인터페이스는 
 클래스의 설계도라 할 수 있다
 ※클래스는 인터페이스를 상속받을 수 있지만
  인터페이스는 클래스를 상속 받을 수 없다.
      
-자바는 단일 상속이 원칙이나 인터페이스를 이용해서
 다중 상속을 구현할 수 있다. 
 ,(콤마)로 구분해서 여러개의 인터페이스를 
 상속 받을 수 있다.

-추상클래스처럼 상속이 목적으로 상속받은 클래스는
 추상 메소드를 오버라이딩해야 하기때문에
 동일한 API(메소드)를 사용할 수 있다.
 
-멤버로는 추상메소드와 상수(final변수)로만 구성된다.
  
-접근지정자는 public과 default접근지정자만 가질 수 잇다
 modifier(static,final)는 가질 수 없다.
 
-인터페이스에 있는 추상메소드는 public과 abstract란 
 키워드를 생략한다.
	
	자식의 오버라딩 메서드에서는 반드시 public을 붙여야 한다.
	
 -인터페이스의 상수 또한 public static final을 생략해도,
  컴파일러가 자동으로 붙여준다.	 
  
  -클래스가 인터페이스를 상속받을때는 implements키워드
   인터페이스가 인터페이스를 상속받을때는 extends키워드
   
 - 인터페이스는 생성자가 없다.
   
*/
//interface MyInter{}//[o]default(package/생략형)접근지정자 사용
//static interface MyInter{}//[x]클래스와 동일
//final interface MyInter{}//[x]클래스와 다름
//abstract interface MyInter{}//[o]붙여도 되나 의미 없다.
//[인터페이스들]
interface MyInter1{
	//public MyInter1(){}//[x]생성자를 가질수 없다.
	//[멤버 상수]
	public static final int MAX_INT =Integer.MAX_VALUE;
	double MAX_DOUBLE = Double.MAX_VALUE;//public static final생략된거와 같다
	//[추상 메소드들]
	public abstract void noOmit();
	void omit();//public abstract이 생략된거와 같다
}
interface MyInter2{
	void omit();//추상 메소드]
}
abstract class AbstractClass implements MyInter1 {
	//[추상 메소드]
	/*
	추상 클래스안에서 추상 메소드 
	정의시에는 반드시 abstract키워드를 붙인다
	(단,인터페이스에서는 생략 가능)
	*/
	//void abstractMethod();//[X]
	
	abstract void abstractMethod();//[o]
}

class MyClass implements MyInter2,MyInter1{

	@Override
	public void noOmit() {
		System.out.println("noOmit()메소드");
	}
	/*
	 * 인터페이스에 동일한 이름의 추상메소드가 있는 경우
	 * 먼저 기술한 인터페이스의 추상 메소드만
	 * 오버라이딩 된다.
	 */
	
	@Override
	public void omit() {
		System.out.println("omit()메소드");
	}	
	//접근지정자가 부모와 같거나 부모보다 큰 접근지정자 사용
	//void omit(){}//[x]
	
}
//[인터 페이스가 인터페이스 상속 받을때]
//-extends키워드 사용
//-클래스와 다르게 ,(콤마)로 구분해서 여러개의
//인터페이스 상속 가능
interface MyInter3 extends MyInter1,MyInter2{
	void abstractNewMethod();//새롭게 확장한 추상 메소드]
}

class LastClass extends AbstractClass implements MyInter1,MyInter2{

	@Override
	public void noOmit() {}
	@Override
	public void omit() {}
	@Override
	void abstractMethod() {}
	
}
public class InterfaceBasic {

	public static void main(String[] args) {
		//1]인터페이스 역시 추상 클래스처럼
		//  인스턴스화(객체화,메모리생성) 불가
		//MyInter1 mi = new MyInter1();//[x]
		//2]이질화:
		//인터페이스명 인터페이스타입의 인스턴스변수 = new 자식클래스명();	
		MyInter1 mi = new MyClass();//[o]
		mi.omit();
		mi.noOmit();
		
		MyInter2 mi2 = new MyClass();//[o]
		/*
		 * noOmit()메소드는 MyInter2입장에서
		 * 는 MyClass에서 새롭게 확장한 메소드에 해당
		 * 그래서 .으로 접근불가
		 */
		((MyClass)mi2).noOmit();
		
		MyClass mc = (MyClass)mi2;
		
		System.out.println(mc instanceof MyClass);
		System.out.println(mc instanceof MyInter1);
		System.out.println(mc instanceof MyInter2);
		//인터페이스 상수 접근]
		//방법1]인터페이스명.상수
		System.out.println(MyInter1.MAX_INT);
		System.out.println(MyInter1.MAX_DOUBLE);
		//방법2]상속받은 클래스명.상수
		System.out.println(AbstractClass.MAX_INT);
		System.out.println(MyClass.MAX_INT);
		
		
	}//////////////main

}/////////////////class
