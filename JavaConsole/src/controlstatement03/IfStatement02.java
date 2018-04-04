package controlstatement03;

import java.io.IOException;

public class IfStatement02 {
	
	public static void main(String[] args) throws IOException {
		/*
		 * if문 기본형식2]
		 * if(조건식){
		 * 	조건식이 참일때 실행할 명령문;
		 * }		  
		 * else{
		 * 	조건식이 거짓일때 실행할 명령문;
		 * }		 * 
		 * 역시 실행할 명령문이 하나일때는 
		 * {} 생략 가능
		 */
		int num1 =100;
		System.out.println("[if문 형식 1로 짝/홀수 판단]");
		//조건식이 두번 실행됨.
		if(num1 % 2 ==0) System.out.println("짝수");
		if(!(num1 % 2 ==0)) System.out.println("홀수");
		
		System.out.println("[if문 형식 2로 짝/홀수 판단]");
		//조건식 한번만 실행됨.
		if(num1 % 2 ==0) System.out.println("짝수");
		else System.out.println("홀수");
		//[삼항연산자]
		/*
		 if ~else문과 같다.
		 코드를 짧게 표현할때 주로 사용(if ~else문 
		 대신에)
		 구문]
		 변수 = 조건식 ? 참일때 값 : 거짓일때 값 ;		  
		*/
		System.out.println("[삼항 연산자로 짝/홀수 판단]");
		String strResult  = num1 % 2 ==0 ? "짝수" :"홀수" ;
		System.out.println(strResult);
		System.out.println("[짝/홀수 판단후 짝수인 경우 100이상인지 판단-if~else구문]");
		
		if(num1 % 2==0){
			if(num1 >=100) System.out.println("num1은 짝수면서 100이상");
			else System.out.println("num1은 짝수면서 100미만");
		}
		System.out.println("[짝/홀수 판단후 짝수인 경우 100이상인지 판단-삼항연산자]");
		strResult = num1 % 2==0 ? num1 >=100 ?  "num1은 짝수면서 100이상"  :  "num1은 짝수면서 100미만"   :  ""   ;
		System.out.println(strResult);
		
		//※else는 항상 if문과 짝을 이루어야 한다. 단독 사용불가
		if(num1 % 2== 0)//{
			System.out.println("짝수");
			System.out.println("num1="+num1);//if문과 무관
		//}
		//else//[x]짝을 이루는 if문이 없다. 
			System.out.println("홀수");
			
		//문]한 문자를 입력받아 숫자인지 아닌지
		//   if ~else문 과 삼항 연산자를 이용하여 판단하여라.
		System.out.println("한 문자를 입력하세요?");
		char character=(char)System.in.read();
		System.out.println("[if~else문 사용]");
		if(character >='0' && character <='9'){
			System.out.println("숫자");
		}
		else{
			System.out.println("숫자가 아님");
		}		
		System.out.println("[삼항 연산자 사용]");
		strResult = character >='0' && character <='9'? "숫자" :"숫자가 아님";
		System.out.println(strResult);
		
		System.in.skip(2);//엔터값 스킵
		/*
		문]숫자인지 판단후 2의 배수를 판단하고
		   2의 배수면 "2의 배수"출력,아니면 "2의배수가 아님"출력
		   또한 숫자가 아니고
		   알파벳이라면 대소문자를 판단한후
		   대문자인경우 "대문자" 출력 소문자인 경우 
		   "소문자"출력
		   가정]숫자나 알파벳만 입력한다고 가정하자.
		*/	
		 System.out.println("또 입력?");
		 character=(char)System.in.read();
		 System.out.println("[if~else문 사용]");
		 if(character >='0' && character <='9'){
			if((character-'0') % 2 ==0)
				System.out.println("2의 배수");
			else
				System.out.println("2의 배수가 아님");
		 }
		 else{//알파벳인 경우
			if(character >='a' && character <='z')
				System.out.println("소문자");
			else
				System.out.println("대문자");
		 }	
		 System.out.println("[삼항 연산자 사용]");
		 
		 strResult =character >='0' && character <='9'? (character-'0') % 2 ==0  ? "2의 배수"  : "2의 배수가 아님"  : character >='a' && character <='z' ? "소문자"  : "대문자" ;
		 System.out.println(strResult);
		 
		 
	}//////////////////main
}///////////////////class
