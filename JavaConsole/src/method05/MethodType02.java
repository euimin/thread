package method05;

import java.io.IOException;
import java.util.Scanner;

/*
메소드 형식 2:매개변수는 없고 반환 값이 있는 경우

※ 메소드 형식2 은 주로
  사용자로부터 값을 입력받고 입력받은 값으로
  처리한 후 그 결과값을 반환하고자 할때
  주로 사용

접근지정자 [modifier] 반환자료형(반환타입) 메소드명(){
	   
	  처리할 일;
	  return 결과값;
}
	 
결과값을 메소드를 호출한 쪽에 반환 할때는
return이라는
키워드 사용
	 
*/
public class MethodType02 {
	//1]메소드 정의
	static int noParamYesReturn(){
		int sum=0;
		for(int i=1;i<=10;i++) sum+=i;
		//※반환타입이 void가 아닌 경우는 반드시
		//  값을 반환해야 한다.(return예약어로)
		//return;//[x]
		return sum;
		//Unreachable Code 에러
		//System.out.println("[return문 이후]");//[x]
	}/////////////////////////////
	/*사용자로부터 국영수 점수를 입력받아
	평균을 구해서 학점을 반환하는 메소드 정의
	예] "A학점","B학점"...*/
	static String getGrade(){
		String[] titles ={"국어","영어","수학"};
		//국영수 점수 저장용]
		int[] jumsu = new int[3];
		//총합 저장용]
		int total=0;
		//점수 입력받기 위한 클래스]
		Scanner scanner= new Scanner(System.in);
		
		for(int i=0; i < jumsu.length;i++){
			System.out.printf("%s점수를 입력하세요?%n",titles[i]);
			jumsu[i] = scanner.nextInt();
			total+=jumsu[i];
		}
		//방법1] 직접 return. break문 불필요
		/*
		switch(total/30){
			case 10:
			case 9:return "A학점";
			case 8:return "B학점";
			case 7:return "C학점";
			case 6:return "D학점";
			default: return "F학점";
		}/////////////
		*/
		//방법2]변수에 결과값 저장후 변수 반환
		String resultvalue;
		switch(total/30){
			case 10:
			case 9:resultvalue="A학점";break;
			case 8:resultvalue="B학점";break;
			case 7:resultvalue="C학점";break;
			case 6:resultvalue="D학점";break;
			default:resultvalue="F학점";
		}/////////////		
		return resultvalue;		
	}////////////////메소드
	/*문]사용자로부터 숫자 두개(Scanner)와 산술연산자(read()사용)를 입력받는 
	   메소드로
	   산술 결과는 메소드 안에서 바로 출력하고
	   산술 연산자 기호를 반환하는 메소드를 정의 해라.
	   그리고 main메소드에서 호출하여
	   사용자가 입력한 연산자를 출력하여라.*/
	static char getOperator() throws IOException{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 입력?");
		int firstNumber = scanner.nextInt();
		System.out.println("연산자 기호(+,-,*,/)를 입력?");
		char operator = (char)System.in.read();
		System.out.println("두번째 숫자 입력?");
		int secondNumber = scanner.nextInt();
		
		switch(operator){
			case '+':
				System.out.printf("%d + %d = %d%n",firstNumber,secondNumber,firstNumber+secondNumber);
				break;
			case '-':
				System.out.printf("%d - %d = %d%n",firstNumber,secondNumber,firstNumber-secondNumber);
				break;
			case '*':
				System.out.printf("%d * %d = %d%n",firstNumber,secondNumber,firstNumber*secondNumber);
				break;
			case '/':
				System.out.printf("%d / %d = %d%n",firstNumber,secondNumber,firstNumber/secondNumber);
				break;
			default:System.out.printf("잘못된 연산자 기호:%c%n",operator);
		}
		return operator;
	}//////////////////////
	
	public static void main(String[] args) throws IOException {
		//2]메소드 호출
		//방법1] 반환값 변수에 저장
		int returnvalue=noParamYesReturn();
		System.out.println("1부터 10까지 누적합:"+returnvalue);
		//방법2] 변수 미 사용:반환값 바로 출력
		System.out.println("1부터 10까지 누적합:"+noParamYesReturn());		
		System.out.println(getGrade());		
		System.out.println("연산자 기호:"+getOperator());
	}////////////////main
}////////////////////class
