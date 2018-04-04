package accessmodifier07.another;

import accessmodifier07.AccessModifierOne;

//AccessModifierOne과 다른 패키지 안에 있다.
//AccessModifierOne의 멤버(변수,메소드)에 접근해 보자
public class AccessModifierTwo {

	//[멤버 변수]
	//AccessModifierOne클래스는 다른  패키지안에 있기때문에
	//사용하려면 import해야한다.(단,접근지정자가 public이어야 한다)
	AccessModifierOne one;
	//[멤버 메소드]
	public void access(){
		/*
		 * AccessModifierOne 멤버중 private이 붙은 
		   멤버는 접근불가]-클래스가 서로 다름으로
		   또한 생략형 접근지정자가 붙은 멤버도 접근불가]-패키지가 다름으로
		
		 * private이 붙은 멤버는 주로 public이 붙은
		 * 멤버 메소드를 통해서 간접으로 호출할 수 있다.
		 * 직접 호출불가(접근이 안되니까)
		 * 
		 */
		one = new AccessModifierOne();		
		//one.privateVar=100;//[x]is not visible
		//one.packageVar=100;//[x]is not visible
		one.publicVar=100;
		
		//one.privateMethod();//[x]is not visible
		//one.packageMethod();//[x]is not visible
		one.publicMethod();//[o]
		
		//DefaultClass클래스는 접근지정자가 생략형이라
		//다른 패키지에서는 보이지 않음으로
		//import불가.즉 사용불가
		//DefaultClass df = new DefaultClass();//[x]
	}
	
}
