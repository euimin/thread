package exception21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCatchApp {
	/*
	-catch절을 여러개 사용할 수 있다
	-여러개 사용시 자식 예외클래스부터 catch해야한다
	-부모 예외 클래스를 자식 예외 클래스보다 상위에
	 위치시켜놓으면 부모가 예외를 모두 잡아버리기 
	 때문에
	 자식예외클래스의 catch절에는 
	 unreacheable catch block이되어
	 컴파일이 안된다.		  
	*/
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		int[] array= new int[2];
		try{
			System.out.println("array[0]에 입력할 숫자?");
			array[0] = Integer.parseInt(scanner.nextLine());
			
			System.out.println("array[1]에 입력할 숫자?");
			array[1] = Integer.parseInt(scanner.nextLine());
			
			System.out.println("두 숫자 나누기:"+array[0]/array[1]);
			
			System.out.println("나이를 입력하세요?");
			int age = scanner.nextInt();
			System.out.println("당신의 10년후 나이:"+(age+10));
			
			array[3] =500;
		}
		/*
		아래처럼 여러개의 catch불락 사용시 부모클래스는
		항상 맨 아래에 위치 시켜라]  	
		catch(Exception e){
			System.out.println("예외가 발생했어요");
		}
		*/
		/*
		catch(NumberFormatException e){
			System.out.println("숫자만 입력하세요");
		}
		catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없어요");
		}
		catch(InputMismatchException e){
			System.out.println("나이는 숫자만....");
		}
		*/
		/*
		 * 모든 예외를 catch(Exception e)블락 하나로 다 잡을 수 
		 * 있으나
		 * 각각의 예외 클래스별로 예외처리를 세분화하기 
		 * 힘들다는 단점이 있다.
		 * 
		 */
		catch(Exception e){
			System.out.println("예외가 발생했어요");
		}
		
	}//////////////main
}/////////////////class
