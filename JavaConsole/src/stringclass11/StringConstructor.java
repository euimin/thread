package stringclass11;

import java.util.Scanner;

import wrapperclass10.WrapperClass03;

public class StringConstructor {

	public static void main(String[] args) {
		//[String클래스의 생성자]
		//1]byte형 배열을 문자열로 변환
		//String(byte[] bytes) 생성자 이용
		//String(byte[] bytes,시작인덱스,길이)
		byte[] barr = {65,66,67,68,69,48};
		String barrToString = new String(barr);
		System.out.println("바이트형 배열을 문자열로 변환:"+barrToString);
		barrToString = new String(barr,2,3);
		System.out.println("바이트형 배열을 문자열로 변환(2인덱스부터 3개):"+barrToString);
		//1-1]문자열을 byte형 배열로:String 클래스의 getBytes()
		barr=barrToString.getBytes();
		for(int i=0;i < barr.length;i++)
			System.out.println(String.format("barr[%d]=%d",i,barr[i]));
		//2]char형 배열을 문자열로 변환
		//  생성자 혹은 static String valueOf(char[])이용
		//String(char[] value) 
		//String(char[] value, int offset, int count)
		char[] charr = {'H','I',' ','안','녕'};
		String charrToString = new String(charr);
		System.out.println("char형 배열을 문자열로 변환:"+charrToString);
		charrToString = new String(charr,3,2);
		System.out.println("char형 배열을 문자열로 변환(3인덱스부터 2개):"+charrToString);
		//2-1]문자열을 char형 배열로:String클래스의 toCharArray()
		charr=charrToString.toCharArray();
		for(int i=0;i < charr.length;i++)
			System.out.println(String.format("charr[%d]=%c",i,charr[i]));
		//3]아스키나 유니코드값이 저장된
		//  int형 배열을 문자열로 변환
		//String(int[] codePoints, int offset, int count) 
		int[] code ={50,51,65,66,44032,44033,94};
		String codeToString = new String(code,0,6);
		System.out.println("코드값(아스키/유니코드)을 문자열로 변환:"+codeToString);
		/*
		 * 문]Scanner클래스로 문자열를 입력받아
		 * (nextLine()사용) char형 배열로 변환해서
		 * 출력하고
		 * 또한 입력받은 문자열을 숫자로 변환해서 2배를 곱한
		 * 값을 출력 해라.단 입력받은 문자열이 숫자 형식이 아니면
		 * 숫자 형식일때까지 계속 입력받아서
		 * 위의 결과를 출력해라.		
		 */
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("입력?");
			//1]char형 배열로 변환후 출력
			String inputString=scanner.nextLine();
			charr = inputString.toCharArray();
			for(int i=0;i < charr.length;i++)
				System.out.println(String.format("charr[%d]=%c",i,charr[i]));
			//2]숫자 형식인지 판단후 숫자 형식이 아닌경우 
			//  다시 반복문 처음으로
			if(!WrapperClass03.isNumber(inputString)){
				System.out.println("숫자만...");
				continue;
			}
			//3]숫자형식인 경우 2배 곱한값 출력 후 바로 while문 빠져 나간다
			System.out.println("2배 곱한 값:"+Integer.parseInt(inputString)*2);
			break;
		}
	}///////////////main
}//////////////////class
