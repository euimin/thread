package datatype01;
/*
 * 상수:저장된 값이 절대 변하지 않은 메모리의 한 종류
 * 선언방법:final 자료형 변수명=초기값;           
 * 상수 선언후 중간에 값을 변경하면 에러
 * 변수명(상수명)은 보통 대문자로 선언한다
 * 상수는 프로그램의 가독성을 높인다
 */	
//※클래스 안 이외에서 선언된 변수 나 상수를
//  지역변수 혹은 지역상수라 한다.
public class ConstantVariable {
	//클래스 안]
	//클래스안에서 상수를 선언할때는 
	//반드시 초기화 해야 한다.
	//final double PI;//[X]초기화 안해서
	
	public static final double PI =3.14;//[o]초기화,PI는 double형 상수
	
	//프로그램의 가독성을 높이기 위한 상수 선언
	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;
	
	
	
	public static void main(String[] args) {
		System.out.println(PI);//[O]	
		//※모든 상수는 프로그램 중간에 값 변경 불가
		//PI=3.141592653589793;//[X]
		/*메소드(지역)안에서 상수를 선언할때는 초기화를
		  사용전에만 해주면 된다.
		  보통 메소드(지역)안에서는 상수선언을 안함
		  주로 클래스안에서 상수 선언 함.*/
		final String NICKNAME;//[O]지역 상수
		//System.out.println(NICKNAME);//[X]초기화 안해서
		NICKNAME="한소인";//[O]지역 상수 초기화
		System.out.println(NICKNAME);//[O]
		//NICKNAME="자바";//[x]값 변경 불가
		
		int computer,user;
		computer =1 ;user=3;
		System.out.println("컴퓨터 WIN:가독성이 낮다");
		
		computer = SCISSORS;user=PAPER;
		System.out.println("컴퓨터 WIN:가독성이 높다");
	}////////// main

	


}////////////////// class
