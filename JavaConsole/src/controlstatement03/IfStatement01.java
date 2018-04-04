package controlstatement03;

import java.io.IOException;

public class IfStatement01 {

	public static void main(String[] args) throws IOException {
		//분기문:프로그램 흐름상  분기하고자 할때 
		//사용하는 제어문
		//if문/switch문 두 가지가 있다.
		//if문 기본형식 1]
		/*
		 조건식은 비교식내지 논리식이어야 한다.
		 즉 결과값이 true 아니면 false가 나오는 식이거나
		 직접 boolean값(true,false)을 줄 수 있다.

		 if(조건식){
		 	 조건식이 참일때 실행할 명령문;	
			 
		 }
		 
		 조건식이 참일때 실행할 문장이 하나이면 
		 {}생략가능하다
		 {}는 실행문들을 하나로 묶는 블락역할을 한다.	 
		 
		*/
		int num1=10;
		//1]산술식 하고 boolean값이 아닌 값은 조건식으로 불가
		//if(num1 % 2){}//[x]
		//if(num1){}//[x]
		//2]조건식은 비교식아니면 논리식 혹은 boolean 값( true,false)
		if(num1 % 2 == 0){System.out.printf("%d는 짝수%n",num1);}
		if(num1 % 2 != 0){System.out.printf("%d는 홀수%n",num1);}
		if(num1 % 2 == 0 && num1 >=10){
			System.out.printf("%d는 짝수이고 10보다 크거나 같다%n",num1);
		}
		
		if(true){System.out.println("항상 실행되는 명령문");}
		if(false){System.out.println("절대 실행이 안되는 명령문");}
		//2]if(조건식) ; 는 조건식이 참일때 
		//              수행할 명령문이 없음을 의미(조심)
		//아래 블락{}는 if문과 전혀 관련없이 실행된다.
		if(num1 % 2 != 0) ;
		{System.out.printf("%d는 홀수%n",num1);}
		//3]조건식이 참일때 수행할 문장이 
		//  하나인 경우 {}생략 가능
		if(num1 % 2 == 0) System.out.printf("%d는 짝수%n",num1);
		/*3-1]수행할 문장이 여러개인 경우 {}을 생략하면
	      의도하지 않은 결과를 초래할수 있다.
	      고로 조건식이 참일때 수행할 문장이 여러개인 경우는
	      반드시 {}로 묶어라.*/
		if(num1 % 2 != 0){
			System.out.printf("num1은 %d이다%n",num1);
			System.out.printf("%d는 홀수%n",num1);
		}
		/*
		System.in.read()메소드:
		             사용자 입력을 받을때까지
		             블락상태가 된다.
		             즉 다음 코드가 실행이 안된다.
		             입력한 문자의 아스키 코드값 반환.		
		*/
		/*
		System.out.println("한 문자를 입력하세요?");
		int asciiCode=System.in.read();
		System.out.println("사용자가 입력한 문자의 아스키 코드값:"+asciiCode);
		System.out.println("사용자가 입력한 문자:"+(char)asciiCode);
		*/
		
		System.out.println("한 문자를 입력하세요?");
		int asciiCode=System.in.read();
		
		//1]아스키 코드값을 알때
		/*
		boolean isNumber = asciiCode >=48 && asciiCode <=57;
		if(isNumber){
			System.out.println("입력한 문자는 숫자다");
		}
		if(!isNumber){
			System.out.println("입력한 문자는 숫자가 아니다");
		}
		*/
		//2]아스키 코드값을 모를때	
		/*
		boolean isNumber = asciiCode >='0' && asciiCode <= '9';
		if(isNumber){
			System.out.println("입력한 문자는 숫자다");
		}
		if(!isNumber){
			System.out.println("입력한 문자는 숫자가 아니다");
		}
		*/
		/*
		문]사용자가 입력한 문자가 알파벳이거나 숫자이면
		    "알파벳 혹은 숫자"라고 출력하고
		    아니면 "기타"라고 출력 하여라.
		    (아스키 코드값 모른다고 가정) else문 불가
		  참고로 영문 알파벳의
		  아스키 코드값은 대문자 A(65)~Z(90) ,소문자 a(97) ~z(122)
		*/
		boolean isNumber = asciiCode >='0' && asciiCode <= '9' ||
						   asciiCode >='A' && asciiCode <= 'Z' ||
						   asciiCode >='a' && asciiCode <= 'z';
		if(isNumber) System.out.println("알파벳 혹은 숫자");
		if(!isNumber) System.out.println("기타");
		
		System.out.println("한 문자 또 입력하세요?");
		//엔터값 스킵
		//System.in.skip(2);
		//스킵안하고 엔터값 읽어서 미 사용
		System.in.read();//\r읽는다-13
		System.in.read();//\n읽는다-10		
		char character=(char)System.in.read();
		System.out.println("입력문자:"+character);
		/*
		문]사용자가 입력한 값이 숫자인지 먼저 판단하고
		   숫자라면 2의 배수인지를 판단하여
		   2의 배수인 경우만 "2의 배수입니다"라고 출력하여라.
		   2의 배수가 아닌 경우 "2의 배수가 아니다"라고 출력
		   문자 '0'의 아스키 코드값:48
		        '1':49 '2':50
		*/
		//방법1]하나의 조건식안에서 논리 연산으로 처리
		/*
		boolean multiple =character >='0' && character <='9' 
				          && (character-'0') % 2==0;
		if(multiple) System.out.println("2의 배수");
		if(character >='0' && character <='9' 
		          && (character-'0') % 2!=0) 
			System.out.println("2의 배수가 아님");
		*/
		//방법2]if문 안의 if문으로 처리
		if(character >='0' && character <='9'){
			boolean isMultiple=(character - '0') % 2==0;
			if(isMultiple) System.out.println("2의 배수");
			if(!isMultiple) System.out.println("2의 배수가 아님");
		}
	}///////////////main

}///////////////////class
