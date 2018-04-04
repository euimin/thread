package abstract17;
/*
[추상클래스-불완전한 설계도]
1]class 앞에 abstract(modifier)를 붙이면 
  그 클래스는 추상 클래스가 된다
2]어떤 클래스가 추상 메소드를 가지면 
  그 클래스를 반드시
  추상 클래스로 만들어 줘야 한다 
  단, 추상 메소드가 없어도 abstract만 붙이면 
  추상 클래스가 될 수 있다.
  
  ※추상 메소드란?
    - 메소드 앞에 abstract키워드가 붙은 것
    - 메소드 원형만 있고 구현부가 없는것
      예] 접근지정자 abstarct 반환타입 메소드명([매개변수]);
    - 추상메소드는 오버라이딩이 목적이다
 
3]추상 클래스는 인스턴스화 할 수 없다.즉 메모리에 객체를
  생성할 수 없다 즉 new연산자로 메모리를 할당 할 수 없다.   
  
4]추상클래스는 상속이 목적이다
5]추상 클래스를 상속받은 자식클래스(sub class)에서는
   만약 추상 클래스가(super class) 하나라도 추상 메소드를
   가지고 있다면 반드시 오버라이딩 해야 한다
   즉 동일한 API를 사용할 수 있다.
   
6]만약 자식클래스에서 부모클래스의 추상메소드를 오버라이딩 하지
   않으려면 자식도 추상 클래스로 만들어야 한다
   
7] 추상클래스는 new해서 인스턴스화 할 수 없지만
   추상클래스 타입의 인스턴스 변수에 
   자식클래스의 메모리를 할 당 할 수 있다(Heterogenious)
   
*/

//추상 클래스1]-추상 메소드가 없는 추상 클래스
abstract class NoHavingAbsMethod{
	//[멤버상수]
	public static final int MAX_INT=Integer.MAX_VALUE;
	//[멤버변수]
	int instanceVar;
	static int staticVar;
	//[멤버 메소드]
	void instanceMethod(){}
	static void staticMethod(){}
}

class NoHavingChild extends NoHavingAbsMethod{
	//[멤버변수]
	int newVar;
	/*추상 메소드를 가지지 않은 추상 클래스를 
	  상속받은 경우
	  강제적으로 오버라이딩 할 의무는 없다.
	  정적 메소드는 오버라이딩 불가
	 */
	//[강제사항 아님-임의로 오버라이딩 한것임]
	@Override
	void instanceMethod() {}
	
}
//추상클래스2]- 추상 메소드를 가진 클래스
abstract class HavingAbsMethod{
	//메소드 정의 규칙에 어긋남]구현부{}가 없어서....
	//void absMethod(int number);//[x]
	//추상 메소드로 정의]
	/*
	 * 추상 메소드를 멤버로 가지면 그 클래스는 
	 * 반드시 추상 클래스가 되야 한다.
	 */
	abstract void absMethod(int number);
}
class HavingChild extends HavingAbsMethod{
	//[의무적으로 오버라이딩한 메소드]
	@Override
	void absMethod(int number) {
		System.out.println("HavingChild에서 오버라이딩한 메소드:absMethod(int number)");		
	}
	void newMethod(){
		System.out.println("HavingChild에서 새롭게 확장한 메소드:newMethod()");		
	}
	
}
/*
추상클래스3]
추상메소드를 가진 추상 클래스를 상속받은
자식클래스에서 의무적으로 오버라이딩 안하려면
자식클래스도 추상 클래스로 만들어 주면 된다.
*/
abstract class HavingChildNoOverriding extends HavingAbsMethod{
	//[자식에서 새롭게 확장한 추상 메소드]
	abstract void abstractNewMethod();
}
class HavingNewChild extends HavingChildNoOverriding{

	@Override
	void abstractNewMethod() {}
	@Override
	void absMethod(int number) {}
	
}
public class AbstractClassBasic {

	public static void main(String[] args) {
		//추상 클래스는 인스턴스화 불가]-자식타입으로는 객체생성 가능
		//NoHavingAbsMethod na = new NoHavingAbsMethod();//[x]	
		NoHavingChild nc =new NoHavingChild();//동질화]
		
		//2.추상클래스 타입의 인스턴스 변수에
		//  자식클래스 타입의 메모리 할당-이질화]
		HavingAbsMethod ham = new HavingChild();
		//오버라이딩한 메소드]
		ham.absMethod(100);
		//자식에서 새롭게 확장한 멤버]
		((HavingChild)ham).newMethod();
		//두 클래스 간에는 상속관계가 존재하지 않음으로
		//주소 대입 연산 불가 및 형변환도 불가
		//HavingChild hc = new HavingNewChild();//[X]
		
		NoHavingAbsMethod nam = new NoHavingChild();//[o]
		((NoHavingChild)nam).newVar=100;
		nam.instanceMethod();//오버라이딩 된 메소드]
		//추상클래스의 정적멤버:(자식혹은 부모)클래스명.정적멤버
		System.out.println(NoHavingAbsMethod.MAX_INT);
		System.out.println(NoHavingChild.MAX_INT);
	}///////////////////main
}///////////////////////class
