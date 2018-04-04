package exception21;

import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionBasicApp {
	//[멤버변수]
	static Date toDay;
	
	public static void main(String[] args)/*방법1] throws IOException */ {
		/*
		1]컴파일 에러(Checked Exception):
			- 컴파일시 발생하는 에러
			- Syntax에러 ,IOException,SQLException등
			- 컴파일이 안되면 실행이 안됨.
			- 컴파일 에러(외부 자원 사용시 발생하는 컴파일에러.
			  Syntax에러는 제외)는 던지거나(throws) 
			  직접 처리(try~catch절) 할 수 있다
			  (예외클래스(IOException)를 의미
			  ,Syntax오류(문법오류)는 수정해야 함)		
		*/
		//1-1]Syntax에러
		//Int num;//[x]해결책 I를 i로
		int num;//[o]
		if(true);{}
		//else{}[x]else는 항상 if 와 짝을 이루어야 한다
		//1-2]외부 자원 사용시 발생하는 예외
		//    해결책:예외를 던지거(throws절)나 직접처리(try~catch절 사용)
		/* 
	  	※자바에서는 외부에 있는 자원을 사용하고자 할때는
	   	무조건 예외를 발생시킨다.(컴파일 에러의 한 종류)
	   	read()는 IOExcpetion을 던진다.
	   	read()메소드를 호출한 쪽에서는 
	   	예외를 다시 던지거나 try~catch절로 직접
	   	예외를 처리해야 한다. 
	     

	     방법1]예외 던지기
	     호출한 메소드() throws 예외클래스{
	    
	     }
	    
	     */
		//System.in.read();//방법1으로 처리
		//방법2]try~catch절로 직접 예외 처리
		/*
		try {
			System.in.read();			
		} catch (IOException e) {}
		*/
		/*
		2]런타임에러(UnChecked Exception)
		- 컴파일시에는 체크가 안됨
		  실행시에만 발생되는 에러
		-  RuntimeException계열(
		   NullPointerException,ArithmeticException,
		   ArrayIndexOutOfBoundsException등)
		- main메소드에서는 throws해도 오류발생.
		  즉 직접 처리(try~catch절)해야만 한다
		  
		  ※예외 발생시 JVM은 해당 예외클래스를 인스턴스화 해서
		   예외 객체를 프로그램쪽에 전달한다.
		*/
		//[ArrayIndexOutOfBoundsException]:
		// 배열의 크기를 벗어난 인덱스 사용시.
		try{
			int[] array = new int[2];
			array[0] = 100;
			System.out.println("array[0]="+array[0]);
			array[1] = 200;
			System.out.println("array[1]="+array[1]);
			//런타임 예외가 발생한 지점부터 그 이후의 코드는 
			//실행이 안됨. 바로 catch절로 빠진다.]
			array[2] = 300;
			System.out.println("array[2]="+array[2]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("예외가 발생했어요");
			System.out.println("판매자에게 문의 하세요");
			System.out.println("예외 메시지:"+e.getMessage());
		}
		//[NumberFormatException]:숫자형식의 문자열을 
		//int형으로 변환시 해당 문자열이 숫자형식이 아닐때.
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("나이를 입력하세요?");
			/*Integer.parseInt(String)는 숫자 형식의 문자열이 아닌경우
			  NumberFormatException을 발생시킨다(던진다)
			*/
			/*
			String agestring = scanner.nextLine();
			int age = Integer.parseInt(agestring);
			*/
			/*
			 nextInt()는 숫자가 아닌 값을 입력했을때
			 InputMismatchException을 발생시킨다(던진다)			 
			 */
			int age = scanner.nextInt();
			System.out.println("당신의 10년후 나이:"+(age+10)+"살");
			
		}
		catch(NumberFormatException e){
			System.out.println("나이는 숫자만....");
			System.out.println("예외 메시지(NumberFormatException):"+e.getMessage());
		}
		catch(InputMismatchException e){
			System.out.println("나이는 숫자만 입력하세요");
			System.out.println("예외 메시지(InputMismatchException):"+e.getMessage());
		}
		/*
		[NullPointerException]:
		인스턴스 변수에 해당 객체의 메모리 주소가
		저장이 안된 경우에 .으로 	객체의 멤버에 접근할때
		발생		
		*/
		System.out.println("toDay="+toDay);
		try{
			System.out.println(toDay.getTime());
		}
		catch(NullPointerException e){
			System.out.println("toDay는 null입니다");
			System.out.println("예외메시지:"+e.getMessage());
		}
		/*
		 * "":빈 문자열,null아님
		 * null:null값. null이다
		 */	
		String emptystring ="";
		System.out.println("문자열의 길이:"+emptystring.length());
		try{
			String nullstring =null;		
			System.out.println("문자열의 길이:"+nullstring.length());
		}
		catch(NullPointerException e){
			System.out.println("nullstring은 null입니다");
			System.out.println("예외 메시지:"+e.getMessage());
		}
		//[ArithmeticException]:수학적 오류.
		try{
			int result=10;
			result/=0;
			System.out.println("0으로 나눈 결과 값:"+result);
		}
		catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없어요");
			System.out.println("예외메시지:"+e.getMessage());
		}
		Object object = new Object();
		try{
			String string = (String)object;
		}
		catch(ClassCastException e){
			//예외 메시지 출력방법]
			//1.사용자 임의 예외 메시지
			//System.out.println("형변환 할 수 없어요");
			//2.예외 클래스의 인스턴스 변수 이용:e.toString() 
			//  "예외클래스 : 예외메시지"  형태를 문자열로 반환
			//System.out.println(e.toString());
			//3.e.getMessage():예외메시지만 출력
			//System.out.println(e.getMessage());
			//4.e.printStackTrace();//개발시 주로 사용
			e.printStackTrace();
		}
	}////////////////main
}///////////////////class
