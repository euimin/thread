package innerclass22;

import innerclass22.OuterStatic.InnerStatic;
/*
 * 
 * public class A {
 *  ※A클래스를 인스턴스화 할때  = 오른쪽의 new B()가 실행됨
 * 	B b = new B();
 *  즉 위는 아래코드와 동일하다
 *  B b;
 *  public A(){
 *  	b= new B();
 *  }
 *  ※JVM에서 클래스 로드시점에 = 오른쪽의 new C()가 실행됨
 *    즉 C클래스의 인스턴스형 멤버도 다른 정적 멤버들처럼
 *    클래스 로드할 시점에 메모리에 생긴다
 *  static C c = new C();
 * 
 * 
 * }
 
 */



/*
내부 정적 클래스:클래스안의 클래스로 class앞에 
                 static이 붙음
- 정적 멤버도 가질 수 있고
- 외부 클래스의 인스턴스형 멤버는 사용할 수 없다
- 외부클래스명$내부클래스명.class로 파일이 생긴다.
※ 원래 클래스 앞에는 static을 붙일 수 없으나 
   내부클래스는 가능하다
*/
class OuterStatic{
	//[외부의 인스턴스형 멤버]
	int outerInstanceVar;
	//내부 정적 클래스 타입 인스턴스화-외부 클래스의 생성자에서
	//인스턴스화 하는 것과 같다.
	InnerStatic inner = new InnerStatic();
	
	
	void outerInstanceMethod(){
		/*
		 * ※내부의 정적 멤버는 내부 클래스 인스턴스화 필요없이
		 *   내부클래스명.내부정적멤버명 으로 접근
		 * ※내부 클래스의 인스턴스형 멤버 접근:
		 *   내부 클래스를 인스턴스화 한후 접근
		 */
		//내부 클래스의 정적 멤버
		InnerStatic.innerStaticMethod();
		//내부 클래스의 인스턴스형 멤버
		inner.innerInstanceMethod();
	}
	//[외부의 정적 멤버]
	static int outerStaticVar;
	static int sameVar;
	static void outerStaticMethod(){
		//내부 클래스의 정적 멤버
		InnerStatic.innerStaticMethod();
		//내부 클래스의 인스턴스형 멤버
		//내부 클래스의 인스턴스형 멤버
		//inner가 인스터스형 멤버 임으로...X
		//inner.innerInstanceMethod();//[x]
		
	}
	//[내부 정적 클래스]
	//※내부 정적 클래스에서는 외부의 정적 멤버만 사용 가능]
	static class InnerStatic{
		
		//[내부의 인스턴스형 멤버]
		int innerInstanceVar;
		int sameVar;
		void innerInstanceMethod(){
			//outerInstanceMethod();//[x]
			//outerStaticMethod();//[o]
			//외부정적멤버변수 = 내부 멤버변수
			OuterStatic.sameVar = sameVar;
			
		}
		//[내부의 정적 멤버]※정적 멤버도 가질수 있다.
		static int innerStaticVar;
		static void innerStaticMethod(){
			//outerStaticMethod();//[o]
		}
	}
}


public class InnerStaticClass {

	public static void main(String[] args) {
		/*
		 * ※외부 클래스가 아닌 다른 클래스에서
		 * 내부 정적 클래스에 접근할때는 외부 클래스를
		 * 먼저 인스턴스화 할 필요없이 내부 정적 클래스의
		 * 인스턴스화가 가능하다.
	
		 */
		
		/*1]내부 정적 클래스의 정적 멤버에 접근할때는
		    외부클래스 객체 생성할 필요 없이
		    외부클래스명.내부클래스명.정적멤버
		*/		
		//내부클래스의 정적 멤버에 접근할때는 
		//외부클래스명.내부클래스명.정적멤버로 접근(인스턴스화 불필요)
		InnerStatic.innerStaticMethod();
		
		
		//2]내부 클래스의 인스턴스형 멤버 사용시
		//외부 클래스명.내부클래스명 인스턴스변수 = 
		//             new 외부 클래스명.내부클래스명();
		OuterStatic.InnerStatic inner =
				new OuterStatic.InnerStatic();
		
		System.out.println(inner.innerInstanceVar);
		inner.innerInstanceMethod();

	}/////////////////main
}////////////////////class
