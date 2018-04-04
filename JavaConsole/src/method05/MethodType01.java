package method05;
/*
메소드(method):객체에서 행동을 의미
프로그래밍 관점에서 보면 어떤 일을 
처리하는(수행하는) 하나의 모듈.
※메소드는 class안에서 정의해야하고 
  메소드안에서는 메소드를 정의 할 수 없다
※메소드 정의시 반드시 반환타입(자료형)이 있어야 한다.
※메소드명은 변수 명명규칙처럼 만들면 된다. 
  소문자로 시작한다.
  의미있는 이름으로 지어라

[메소드 정의]	
			 
접근지정자(Access Modifier) [Modifier] 반환타입 메소드명(매개변수들){
			 
	처리할 일;
	[return 결과값;]	  
}
		  
*/
/*
[메소드 형식 1]
:매개변수도 없고 반환값도 없는 경우
결과값을 반환하지 않을때 반환 타입은 void
※주로 [출력하는 기능]을 담당한다.

접근지정자 [modifier] void 메소드명(){

	처리할 일;

}	
*/
public class MethodType01 {
	
	//1]메소드 정의
	static void noParamNoReturn(){
		System.out.println("=========메인 메뉴==========");
		System.out.println("1. NEW 2. CONTINUE 3. EXIT");
		System.out.println("===========================");
	}///////////////	
	//[x]동일한 클래스안에서 메소드명은 중복 불가
	//static void noParamNoReturn(){}//[x]
	//일만 안할뿐 메소드이다
	static void noParamNoReturn2(){}//[o]
	
	static void noParamNoReturn3(){
		int returnvalue=100;
		System.out.println("[return문 이전]");
		//의미:returnvalue변수에 저장된 값을 반환한다는 의미
		//반환타입이 void로 정의했기때문에 컴파일에러
		//즉 값을 반환할수 없다.
		//return returnvalue;//[x]
		//※반환타입이 void 인 메소드에서
		//  return;문은 주로 어떤 특정 조건하에서
		//  메소드를 빠저 나갈때 주로 사용한다.
		//return;//[o]값을 반환한다는 의미가 아니라 메소드를 바로 빠져 나가겠다는 의미
		//아래는 절대 실행이 안되므로 Unreachable Code에러	
		//System.out.println("[return문 이후]");//[x]
		
		if(returnvalue % 2==0){
			System.out.println("returnvalue는 짝수");
			return;
			
		}
		//아래는 절대 실행이 안되는 명령문이 아니라
		//if조건이 거짓일때는 실행
		//고로 Unreachable code에러가 발생하지 않는다
		System.out.println("returnvalue는 홀수");//[o]
		System.out.println("[return문 이후]");//[o]
	}/////////////////////////////	
	public static void main(String[] args) {
		//2]메소드 호출:메소드 원형 그대로 호출
		MethodType01.noParamNoReturn();
		noParamNoReturn2();
		noParamNoReturn3();
		
		//메소드안에서는 메소드 정의 불가
		//static void noParamNoReturn4(){}//[x]
		//noParamNoReturn3()메소드는 값을 반환하지 않기때문에
		//에러
		//int returnvalue=noParamNoReturn3();//[x]
		//System.out.println(noParamNoReturn3());//[x]
	}

}
