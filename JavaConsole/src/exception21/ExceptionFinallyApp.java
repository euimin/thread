package exception21;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
finally절: 예외가 발생하든 안하든 실행 
           하고자하는 구문을
           기술.

1) try ~catch절
  -예외 직접 처리
2) try ~catch~finally절
	-예외 직접 처리후 반드시 실행할 문장도 처리
3) try ~finally절
	-예외는 던지고(throws) 예외가 발생하든 안하든 
   반드시 실행할 문장 처리

※  finally절안에 있는 명령문은        
   return문을 만나더라도 실행됨, 
   단,System.exit(0)를 만나면 당연히 실행안됨.
 
*/
public class ExceptionFinallyApp {
	 /*
	  [1.외부 자원 사용시 던지는 예외클래스들(컴파일 예외) 처리 방법]
	   1-1. 직접 처리하지 말고 던지자
	        해당 메소드명 옆에 throws 예외클래스명
	   1-2. 예외를 개발자가 직접 처리 try~catch절 이용
	  
	    try{
	     예외가 발생할 만한 코드    
	    }
	    catch(예외클래스 인스턴스변수){
	    
	     예외발생시 catch절에서 처리
	    } 
	    
	    
	    ※try는 단독으로 못쓰고 
	    try~catch 혹은 
	    try~finally절 혹은
	    try~catch~finally의 쌍으로 사용한다.
	   ※런타임예외는 던져봤자 의미 없다.
	    반드시 try~catch절로 직접 처리해야 한다
	  ※main메소드에서는 런타임예외는 반드시 try~catch
       컴파일예외는 던지거나 try~catch해도 됨.
	  */
	
	//컴파일 예외 발생하는 메소드]
	static void compile() throws IOException{
		System.out.println("문자 입력?");
		//방법1]예외를 던진다
		int ascii = System.in.read();
		System.out.println("입력 문자:"+(char)ascii);
		//방법2]직접 try~catch로 처리(다른 메소드에서 예외처리 불필요)
		/*
		try{
			int ascii = System.in.read();
			System.out.println("입력 문자:"+(char)ascii);
		}
		catch(IOException e){}
		*/
	}
	//런타임 예외 발생하는 메소드]
	static void runtime(){
		Integer.parseInt("백");
		
	}
	
	static void tryCatchFinally(){
		Scanner scanner = new Scanner(System.in);
		int age=Integer.MAX_VALUE;
		
		try{
			System.out.println("나이를 입력하세요?");			
			age = scanner.nextInt();
			//정상적으로 숫자 입력시]
			//return;//finally절 실행됨
			//System.exit(0);//바로 프로그램 종료.finally절 실행안됨
		}
		catch(InputMismatchException e){
			System.out.println("나이는 숫자만...");
		}
		finally {
			//아래는 예외가 발생하든 안하는 무조건 출력하자]
			System.out.println("당신의 10년후 나이:"+(10+age));
		}
	}///////////////////////
	static void tryFinally() throws IOException{
		try{
			compile();
		}
		finally {
			System.out.println("반드시 실행할 명령문");
		}
	}
	public static void main(String[] args) throws IOException /* throws IOException*/ {
		//컴파일 예외는 던지거나 try~catch하거나]
		//1]던지거나
		//compile();
		//2]try~catch
		/*
		try {
			compile();
		} catch (IOException e) {}
		*/
		//런타임 예외는 반드시 try~catch]
		try{
			runtime();
		}
		catch(Exception e){
			System.out.println("예외가 발생했어요");
		}
		
		tryCatchFinally();
		
		tryFinally();
	}/////////////main

}////////////////class
