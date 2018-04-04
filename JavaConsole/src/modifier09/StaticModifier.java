package modifier09;
/*
-멤버변수는 크게 정적멤버 변수와 인스턴스형 
 멤버변수로 나눈다
-멤버메소드도 정적메소드 와 인스턴스형 메소드로 나눈다.

-멤버변수나 멤버 메소드 앞에 static이라는 modifier가 
 붙으면
 정적 멤버 즉 정적 멤버변수이거나 정적 메소드이다.

 예] int age;//인스턴스형 멤버변수
     static int age;//정적 멤버변수
     
     public void method(){};//인스턴스형 메소드
     public static void method(){};//정적 메소드
     
     단,class앞에는 static을 붙일 수 없다

※ 정적멤버(변수 혹은 메소드)의 메모리는 JVM에서 
   클래스를 로드할 시점에 생기고
   인스턴스형 멤버는 JVM에서 인터프리터 할때 메모리가 
   생성된다.(즉 new연산자로 인스턴스화 할때 생긴다)
   
※ 클래스의 멤버에 접근시 접근 방법
	 
	 1]인스턴스형 멤버 : 인스턴스변수.멤버
	 
	   클래스명 인스턴스변수 = new 생성자();
	   인스턴스변수.멤버;
	  
	 2]정적 멤버 :클래스명.멤버

*/

//static class StaticClass{}//[x]

class MyStatic{
	//[멤버 변수]
	/*
	 * 인스턴스형 멤버변수-반드시 클래스를 
	 * 인스턴스화(객체화,heap영역에 메모리 생성)
	 * 하여 인스턴스변수로 접근
	 */
	//인스턴스형 멤버변수]
	int instanceVar;
	/*
	 * 정적 멤버변수:인스턴스화 할 필요 없이 
	 * 클래스명으로 접근
	 * 왜냐하면 JVM에서 클래스를 로드할때 
	 * 메모리가 이미 생성됨으로
	 */
	//정적 멤버 변수]
	static int staticVar;
	//[멤버메소드]
	//인스턴스형 메소드]
	void instanceMethod(){
		//인스턴스형 메소드 안에서는 
		//모든 멤버(인스턴스형 혹은 정적멤버)를 
		//사용할 수 있다.
		System.out.println("instanceVar="+instanceVar);
		System.out.println("staticVar="+staticVar);
		staticMethod();
		
	}
	//정적 메소드]
	static void staticMethod(){
		
		//정적멤버 메소드 안에서는 
		//인스턴스형멤버(변수,메소드등)를
		//사용할 수 없다.		
		//System.out.println("instanceVar="+instanceVar);//[x]
		//instanceMethod();//[x]
		System.out.println("staticVar="+staticVar);
	}
	
}
public class StaticModifier {
	
	//인스턴스형 멤버]
	int instanceMember;
	void instanceMethod(){}
	//정적 멤버]
	static int staticMember;
	static void staticMethod(){}
	
	public static void main(String[] args) {
		//MyStatic클래스의 정적 멤버 접근]-클래스명.정적멤버
		System.out.println(MyStatic.staticVar);
		MyStatic.staticMethod();
		//MyStatic클래스의 인스턴스형 멤버 접근]
		//-인스턴스변수.인스턴스형 멤버
		MyStatic ms = new MyStatic();
		
		System.out.println(ms.instanceVar);
		ms.instanceMethod();
		//아래처럼 정적 맴버도 인스턴스 변수로
		//접근 가능하나,인스턴스 멤버로 착각 할 수
		//있기때문에 아래처럼 접근하지은 않는다.
		ms.staticMethod();
		
		//StaticModifier의 멤버 접근]
		//정적멤버:클래스명.멤버로 접근하나 자기 클래스 안에서
		//접근하기 때문에 클래스명 보통 생략
		System.out.println(staticMember);
		staticMethod();
		/*
		 * ※정적 멤버는 인스턴스화된 객체마다
		 * 갖고 있는 멤버가 아니라
		 * 하나만 생성되서 모든 객체가 
		 * 공유한다.
		 * 그래서 공통으로 사용하는 변수나 메소드에
		 * 주로 static을 붙인다.
		 */
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		ms.instanceVar=10;
		ms1.instanceVar=100;
		ms2.instanceVar=1000;
		System.out.printf(
				"instanceVar출력]ms-%d,ms1-%d,ms2-%d%n",
				ms.instanceVar,ms1.instanceVar,ms2.instanceVar
				);
		//클래스명으로 접근하나 위와 같은 테스트를 위해서
		//인스턴스 변수로 접근하자
		ms.staticVar=10;
		ms1.staticVar=100;
		ms2.staticVar=1000;
		System.out.printf(
				"staticVar출력]ms-%d,ms1-%d,ms2-%d%n",
				ms.staticVar,ms1.staticVar,ms2.staticVar
				);
		
	}

}
