package method05;

import java.util.Scanner;

//메소드 형식 4:매개변수도 있고 반환값도 있는 경우
/*
접근지정자 [modifier] 반환타입 메소드명(매개변수들){

처리할 일;
return 결과값;   
} 
가장 활용빈도가 높은 메소드 타입]  
*/
public class MethodType04 {
	/*
	  * 인원수를 매개변수로 전달받아
	  * 인원수만큼 나이를 사용자로부터 입력받고
	  * 그 나이를 합을 반환하는 메소드 정의 
	  */
	 //1]메소드 정의
	static int getTotalOfAge(int personCount){
		Scanner scanner=new Scanner(System.in);
		int total=0;
		for(int i=0;i < personCount;i++){
			System.out.println(i+1+"번째 사람의 나이 입력?");
			total+=scanner.nextInt();
		}
		return total;
	}///////////////////
	/*문]매개변수로 두 숫자와 연산자(+,-,*,/,%)를
	전달 받아서 그 결과값을 반환하는 메소드를 정의해라
	그리고 main메소드에서 호출하여 
	그 결과값을 확인 하여라.반환타입은 int형*/
	static int getCalc(int num1,int num2,char op){
		switch(op){
			case '+':return num1+num2;
			case '-':return num1-num2;
			case '*':return num1*num2;
			case '/':return num1/num2;
			case '%':return num1%num2;
			default:return Integer.MAX_VALUE;
		}
	}
	/*
	 * 문]여러개의 숫자를 입력받아서 그 중에
	 *    최대값을 구하는 메소드를 정의하자
	 *    단, 숫자의 개수는 매개변수로 입력받고
	 *    숫자의 개수 만큼 사용자로부터 숫자를
	 *    입력(Scanner)받아 최대값을 구해 
	 *    그 최대값을 반환하는 메소드이다.
	 *    그리고 main에서 호출하여 최대값을
	 *    출력하여라. 	
	 */
	static int getMaxNumber(int numberCount){
		Scanner scanner=new Scanner(System.in);
		int max=0;//최대값 저장용
		int inputNumber;//입력받은 숫자 저장용
		for(int i=0;i < numberCount;i++){
			System.out.println(i+1+"번째 숫자 입력?");
			//처음 입력값 max에 저장
			if(i==0) max= scanner.nextInt();
			else{
				inputNumber=scanner.nextInt();
				if(max <= inputNumber) max =inputNumber;
			}
		}		
		return max;		
	}///////////////////
	
	public static void main(String[] args) {
		//2]메소드 호출
		//int totalOfAge = getTotalOfAge(2);
		//System.out.println("2명의 나이 합계:"+totalOfAge);
		//System.out.println("3명의 나이 합계:"+getTotalOfAge(3));
		int result=getCalc(10,20,'#');
		if(result == Integer.MAX_VALUE)
			System.out.println("잘못된 연산자 기호입니다");
		else
			System.out.println("연산결과:"+result);
		
		System.out.println("최대값:"+getMaxNumber(3));
	}////////main

}////////////class
