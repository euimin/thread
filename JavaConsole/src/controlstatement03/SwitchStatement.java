package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class SwitchStatement {
	  //switch문:if문처럼 조건에따라서 분기하는 제어문
	  //형식:
	  /*  
	  정수식(산술식): 연산의 결과값이 byte/short/char/int타입으로 
	       나오는 식 long형은 해당 안됨.          
	       정수식은 산술식이거나 직접 변수를 정수식으로 
	       사용하거나
	       예] num % 5혹은 num 
	       
	               
	  switch(정수식 혹은 문자열){  
	   	case 값1 :
	     실행문장1;
	        break;
	    case 값2 :
	     실행문장2;
	        break;
	    ......
	    case 값n :
	     실행문장n;
	       // break;
	   
	    [default :
	     실행문장m;
	     [break;]
	    ]
	  }		  
	    
	  break문을 만나면 switch문 밖으로 빠져 나옴.   
	  범위를 가지고 분기할때는 주로 if문을 사용하고
	  수식의 결과값이 이산적일때 switch문 사용
	   
	 */ 
	public static void main(String[] args) throws IOException {
		//JDK 5.0부터 추가된 클래스:Scanner	
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요?");
		int inputNumber=scanner.nextInt();
		System.out.println("입력한 숫자:"+inputNumber);
		
		int remain = inputNumber % 3;
		System.out.println("[if문으로 나머지 판단]");
		if(remain == 0) System.out.println("나머지가 0");
		else if(remain == 1) System.out.println("나머지가 1");
		else System.out.println("나머지가 2");
		
		System.out.println("[switch문으로 나머지 판단]");
		switch (remain) {
			case 0:
				System.out.println("나머지가 0");
				break;
			case 1:
				System.out.println("나머지가 1");
				break;
			default:
				System.out.println("나머지가 2");				
		}/////switch
		//※switch문에는 정수식이나 문자열 혹은 변수가 와야함
		//  비교식이나 논리식 불가.
		//switch(inputNumber % 3 ==0){}//[x]
		//switch(inputNumber % 3 ==0 && inputNumber >=100){}//[x]
		byte b =15;
		switch(b){//변수가 와도 됨(단,타입은 byte/short/char/int형/String형 만 가능)
			case 1: System.out.println("b에 저장된 값은 1");
			/*
			case로 분기시 값 중복 불가
			case 2: System.out.println("b에 저장된 값은 2");
			case 2: System.out.println("b에 저장된 값은 2");
			*/
			/*
			 * break가 없는 경우:
			 * 먼저 해당  case를 찾고
			 * 해당 case아래 명령문들도 모두 차례로 실행됨.
			 * 고로 반드시 break를 추가해라
			 */
			case 15: System.out.println("b에 저장된 값은 15");
			case 20: System.out.println("b에 저장된 값은 20");
		}///////////switch
		
		long ln =10;
		//switch(ln % 3 ){}//[x]정수식이지만 연산결과가 long형이니까
		//switch(ln){}//[x]long형 변수도 안됨
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
		
		String subject="수학";
		switch(subject){//문자열도 가능[o]
			case "국어":System.out.println("과목은 국어");break;
			case "수학":System.out.println("과목은 수학");break;
			default:System.out.println("개설되지 않은 과목");
		}
		/*

		여러 case를 동시에 처리할때는
		case 값1:
		case 값2:
		case 값n: 실행문n; break;
		값1인경우,값2인경우, 값n인경우에도
		위의 실행문n이 실행됨.
		*/
		int number=100;
		switch(number){
			case 1:
			case 2:
			case 100:
			case 200:
				System.out.println("number는 1이거나 2이거나,100이거나 혹은 200");
				break;
			case 300:System.out.println("number는 300");			
		}
		System.out.println("[국어 점수 입력]");
		int kor = scanner.nextInt();
		System.out.println("[영어 점수 입력]");
		int eng = scanner.nextInt();
		System.out.println("[수학 점수 입력]");
		int math = scanner.nextInt();
		/*		
		문]평균을 구해서 90점이상 "A학점"출력
		                 80점이상 "B학점"출력
		                 70점이상 "C학점"출력
		                 60점이상 "D학점"출력
		                 60점미만 "F학점"을 출력하여라
		                 단,switch문 사용
		*/
		int avg = (kor+eng+math)/30;
		switch(avg){
			case 10:
			case 9:System.out.println("A학점");break;
			case 8:System.out.println("B학점");break;
			case 7:System.out.println("C학점");break;
			case 6:System.out.println("D학점");break;
			default:System.out.println("F학점");
		}
	}///////////////main

}///////////////////class
