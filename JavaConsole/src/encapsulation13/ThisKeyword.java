package encapsulation13;
/*
this:  자기자신의 클래스를 지칭한다
      -인스턴스형 멤버에 접근할때 사용하는 
        키워드(반드시 메소드안에서 사용)
      - this 키워드는 정적 메서드안에서 
        사용할 수 없다.
      - 즉 static 안붙은 인스턴스형 메소드 안에서만
        사용가능.	       
      - ※지역변수와 멤버변수 구분할때 주로 사용   

 */
public class ThisKeyword {
	//this;//[x] 항상 인스턴스형 메소드 안에서만 사용가능
	//[인스턴스형 멤버]
	int instanceVar,anotherInstanceVar;
	void instanceMethod(){
		//this는 인스턴스형 메소드 안에서 사용가능
		//this.하면 자기자신의 모든 멤버(인스턴스형,정적)가
		//뜬다.
		System.out.println(this.instanceVar);//[o]
		//정적멤버도 this키워드로 접근 가능하지만
		//클래스명.정적멤버로 접근하라고
		//경고가 나온다.	 
		System.out.println(this.staticVar);//[△]경고. 정적인 방법으로 접근해야 함
		System.out.println(staticVar);//[o]경고 안뜸
	}
	//[정적 멤버]
	static int staticVar;
	static void staticMethod(){
		//this.//[x]정적 메소드 안에서는 사용 불가
	}
	//지역변수와 멤버변수 구분할때 주로 사용 예]
	void initialize(int instanceVar,int staticVar,int another){
		//※지역변수와 멤버변수가 같은 지역안에서 사용될때
		//  이름이 같은 경우 지역변수가 우선한다.
		//  매개변수 = 매개변수; 멤버변수 초기화 안됨.
		//instanceVar = instanceVar;
		//지역변수와 멤버변수를 구분하기 위해서  this키워드 사용
		//멤버변수 = 매개변수;멤버변수 초기화 됨.
		this.instanceVar = instanceVar;
		//정적 멤버와 지역변수가 동일할때는 this가 아닌
		//클래스명으로 접근해서 구분해라
		//this.staticVar = staticVar;//[△]경고 표시
		ThisKeyword.staticVar=staticVar;//[O]경고 표시 안뜸
		//지역변수와 멤버변수 구분이 가능할때는
	    //this는 생략 가능
		anotherInstanceVar=another;
	}////////////////////////////////////
	public static void main(String[] args) {
		//[인스턴스화]
		ThisKeyword key = new ThisKeyword();
		//[멤버변수 초기화]
		key.initialize(100, 1000, 10000);
		System.out.println("[멤버변수 초기화 후]");
		System.out.println("인스턴스형 멤버변수 intanceVar="+key.instanceVar);
		System.out.println("정적멤버변수 staticVar="+staticVar);
		System.out.println("anotherInstanceVar="+key.anotherInstanceVar);
	}//////////////////////main
	
}//////////////////////////class
