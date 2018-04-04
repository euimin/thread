package wrapperclass10;

import java.util.Scanner;

public class WrapperClass03 {
	
	public static boolean isNumber(String strage) {	
		//Character클래스의 codePointAt()사용]
		/*
		for(int i=0;i < strage.length();i++){
			if(!Character.isDigit(Character.codePointAt(strage, i))) 
				return false;
		}
		*/
		//String클래스의 codePointAt()사용]
		for(int i=0;i < strage.length();i++){
			int ascii=strage.codePointAt(i);
			if(!(ascii >='0' && ascii <='9')) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		/*JDK 1.4 이전 버전의 코딩 형태*/
		char ch='A';
		//반드시 new연산자 사용]
		Character chobj = new Character(ch);
		char chResult=(char)(chobj.charValue()+1);
		System.out.println("chResult="+chResult);
		/*JDK 5.0 이후 버전의 코딩 형태*/
		//인스턴스 변수에 직접 데이터 대입가능]
		chobj = 'C';//오토박싱 char->Character형으로
		
		chResult = (char)(chobj+1);//오토 언박싱 Character->char형으로
		System.out.println("chResult="+chResult);
		/*
		[Character클래스의 주요 메소드]
		1]static int codePointAt(CharSequence seq, 
		                         int index)  
		:문자열에서 index에 해당하는 위치의 한 문자의
		 아스키 코드값을 반환한다.(index는 0부터 시작) 
		
		*/
		System.out.println(Character.codePointAt("ABCD",2));
		//2]static boolean isDigit(char ch)  
		//  static boolean isDigit(int codePoint)  
		//  :어느 한 문자가 숫자인지 아닌지 판단하는 
		//   메소드.
		System.out.println(Character.isDigit('A') ? "숫자다" : "숫자가 아니다");
		System.out.println(Character.isDigit(50) ? "숫자다" : "숫자가 아니다");
		System.out.println(Character.isDigit('2') ? "숫자다" : "숫자가 아니다");
		System.out.println(Character.isDigit('가') ? "숫자다" : "숫자가 아니다");
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요?");
		String strage = scanner.nextLine();
		if(isNumber(strage)){
			System.out.println("당신의 10년후 나이:"+(Integer.parseInt(strage)+10));
		}
		else 
			System.out.println("나이는 숫자만....");*/
		
		
		//3]static boolean isLetter(char ch)  
		//:문자인지 아닌지(언어(한글,한문,영어,일본어등)에 해당하는 것만) 판단하는메소드
		System.out.println("[isLetter메소드]");
		System.out.println(Character.isLetter('가'));
		System.out.println(Character.isLetter('A'));
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetter('家'));
		System.out.println(Character.isLetter('#'));
		System.out.println(Character.isLetter('9'));
		//4]static boolean isWhitespace(char ch)  
		//:공백문자인지 판단하는 메소드
		System.out.println(Character.isWhitespace('A'));
		System.out.println(Character.isWhitespace(' '));
		
		String whiteString = " H  E L  L O   ";
		int whitecount=0;
		for(int i=0; i < whiteString.length();i++){
			if(Character.isWhitespace(Character.codePointAt(whiteString, i))){
				whitecount++;
			}
		}///////////
		System.out.println("총 공백수:"+whitecount);
		//5]대소문자를 판단하는 메소드
		//  (영문자에만 적용)
		//static boolean isLowerCase(char ch)  
		//static boolean isUpperCase(char ch)
		//알파벳이 아닌 문자에 적용시 모두 false반환
		System.out.println("[isLowerCase/isUpperCase메소드]");
		System.out.println(Character.isLowerCase('A'));//false
		System.out.println(Character.isLowerCase('a'));
		System.out.println(Character.isUpperCase('A'));
		System.out.println(Character.isUpperCase('a'));
		System.out.println(Character.isUpperCase('가'));
		System.out.println(Character.isUpperCase('1'));
		
		/*
		  문]아이디를 입력받는데 영문자 소문자 와 숫자로만 
		     입력받아야한다
		     대문자가 포함되면
		     "잘못 입력했어요"라고 출력하고 
		     제대로된 아이디를 입력 받을때까지
		     계속 입력 받도록 하여라.		
		     단,숫자로 시작해서도 안된다 즉 숫자로 시작한 아이디를
	          입력 했을때도
		     "잘못 입력했어요" 라고 출력 하시오		     
		     hint]아이디 입력받을때 Scanner의 nextLine사용
		          String클래스의 toCharArray()사용
		 */
		/*
		Scanner scanner = new Scanner(System.in);		
		while(true){
			System.out.println("아이디를 입력하세요?");
			String nickname = scanner.nextLine();
			//"KIM"  => charr[0]='K',charr[1]='I',charr[2]='M'
			char[] charr=nickname.toCharArray();			
			boolean isCorrect =true;
			for(int i=0;i < charr.length;i++){			
				if(Character.isDigit(charr[0]) || (!Character.isLowerCase(charr[i]) && !Character.isDigit(charr[i]))){
					System.out.println("잘못 입력했어요");
					isCorrect=false;
					break;
				}			
			}///////////////////////////		
			if(isCorrect){ 
				System.out.println("당신의 아이디는 "+nickname);
				break;
			}
		}/////////////////////////////////////
		*/
		//6]대문자를 소문자로 , 소문자를 대문자로
		//static char toUpperCase(char ch)  
		//static char toLowerCase(char ch) 
		System.out.println("[toLowerCase/toUpperCase메소드]");
		System.out.println(Character.toUpperCase('a'));
		System.out.println((char)Character.toUpperCase(97));///'a'->'A'
		System.out.println(Character.toLowerCase('A'));
		System.out.println((char)Character.toLowerCase(65));
		System.out.println(Character.toLowerCase('가'));//가
		System.out.println(Character.toLowerCase(9));//9
		
		//문]사용자로부터 문자열(영문자)을 입력받아서
		//   대문자는 소문자로,소문자는 대문자로 변경하여
		//   출력하여라
		//   예]Hello입력 => hELLO출력
		Scanner scanner = new Scanner(System.in);
		System.out.println("대소문자 구분없이 입력하세요?");
		String alphabet = scanner.nextLine();
		char[] charr=alphabet.toCharArray();
		String alphabetString="";
		for(int i=0; i < charr.length;i++){
			if(Character.isLowerCase(charr[i])){
				//1]
				//System.out.print(Character.toUpperCase(charr[i]));
				//2]
				charr[i]=Character.toUpperCase(charr[i]);
				//3]
				//alphabetString+=Character.toUpperCase(charr[i]);
			}
			else{
				//1]
				//System.out.print(Character.toLowerCase(charr[i]));
				//2]
				charr[i]=Character.toLowerCase(charr[i]);
				//3]
				//alphabetString+=Character.toLowerCase(charr[i]);
			}
			//2]번째로 할때 출력
			System.out.printf("%c",charr[i]);
		}
		//3]번째로 할때 출력
		//System.out.println(alphabetString);		
		//문]위의 최종 변환된 문자열을 거꾸로 출력하여라
		//   예]Hello ->hELLO -> OLLEh출력
		System.out.println("\r\n[거꾸로 출력]");
		for(int i=charr.length-1; i >=0;i--)
			System.out.printf("%c",charr[i]);
		/*
		 ※모든 Wrapper클래스는 기본 자료형을 
	    String형으로
		변환 해줄 수 있는 아래와 같은 메소드를
		공통으로 갖고 있음
		String toString()  
		static String toString(기본 자료형 타입)  
		 */
		int num=100;
		//정적 메소드 사용]
		System.out.println("\r\n"+Integer.toString(num)+100);//100=>"100"
		//인스턴스 메소드 사용]
		Integer obj = num;//오토박싱]
		System.out.println(obj.toString()+100);
		
		short s= 100;
		System.out.println(Short.toString(s)+100);		
		System.out.println(Short.valueOf(s).toString()+100);
		//문자 '가'를 문자열 "가"변경
		ch ='가';
		System.out.println(Character.toString(ch)+1);
		System.out.println(Character.valueOf(ch).toString()+1);
		//논리값 false를 문자열 "false"로 변경
		boolean b = false;
		System.out.println(Boolean.toString(false)+true);
		System.out.println(Boolean.valueOf(b).toString()+true);
		/*
		 * 모든 Wrapper클래스에는 valueOf()계열 
		 * 메소드를
		 * 가지고 있다
		 * 
		 * static Wapper클래스 valueOf(기본형)
		 *  기본형을 참조형으로(오토박싱 지원으로 의미없음)
		 * 
		 * static Wapper클래스 valueOf(String):
		 * 숫자형식의 문자열을
		 * Wrapper클래스로
		 * 
		 */
		//※ 래퍼클래스.parse계열 많이 사용
		String intstr="100";
		//문자열 "100"을 숫자 100으로 변경
		System.out.println(Byte.parseByte(intstr)+100);
		System.out.println(Short.parseShort(intstr)+100);
		System.out.println(Integer.parseInt(intstr)+100);
		System.out.println(Integer.valueOf(intstr)+100);
		//문자열 "true"를 논리값 true로

		String boolstr="TrUe";  
		System.out.println(Boolean.parseBoolean(boolstr) && true);
		System.out.println(Boolean.valueOf(boolstr) && false);
		
	}//////////////////////main

}/////////////////////////class
