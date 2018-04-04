package controlstatement03;

import java.io.IOException;

public class WhileStatement {
	//while문:반복문으로 반복횟수가 정해져 있지 않을때
	//        주로 사용
	//형식:
	/*
		[초기식;]
		while(반복조건){
		 
		  반복조건이 참일때 실행할 문장;
		  [증감식;]
		  
		 }				 
				 
		 무한루프 처리]
		 while(true){
		 	실행할 문장;

		 }
	*/
	public static void main(String[] args) throws IOException {
		//while(int i=0){}//[x]초기식은 for문에서만 사용가능
		//1부터 10까지 누적합:while문 사용
		//누적합을 저장할 변수 선언]
		int sum=0;
		int i=1;//초기식]
		while(i<=10){//반복조건]
			sum+=i;//실행할 명령문]
			i++;//증감식]
		}
		System.out.println("1부터 10까지 누적합:"+sum);
		System.out.println("while문 이후의 i:"+i);
		/*
		문]1부터 1000까지 숫자중 3의 배수 이거나 5의 배수인
		   숫자의 합을 구해라
		   단, 3과5의 공배수인 경우 제외(while문 사용)
		*/
		sum=0;		
		i=1;//초기식
		while(i <=1000){//반복조건
			if(i % 3 ==0 ^ i % 5 ==0) sum+=i;//명령문
			i++;//증감식
		}
		System.out.println("1부터 1000까지(공배수 제외):"+sum);
		//사용자가 언제 ctrl+z를 입력할지 모르는 상황임으로
		//while문 사용]
		//read():사용자가 입력한 문자의 아스키 코드값 반환(1바이트씩 만 읽는다)
		/*
		System.out.println("문자열을 입력하세요?");		
		int ascii;//아스키 코드값 저장 변수
		String inputString="";//read()메소드가 읽은 문자를 누적할 변수
		while((ascii=System.in.read()) != -1){//ctrl + z를 누르면 -1
			//\r이나 \n은 문자열 누적에서 제외]
			if(ascii !=13 && ascii !=10){
				inputString+=(char)ascii;
			}
			//엔터키 눌렀을때 사용자가 입력한 문자열 그대로 출력]
			if(ascii==10){
				System.out.println(inputString);
				//문자열 다시 초기화]-다시 누적하기위해서
				inputString="";
			}
		}
		*/
		/*
		 * 1 0 0 0
		 * 0 1 0 0
		 * 0 0 1 0
		 * 0 0 0 1  while문으로...
		 */
		
		i=1;//바깥 while의 초기식
		int k=1;//안쪽 while의 초기식			
		while(i <=4){//행을 의미				
			//int k=1;//안쪽 while의 초기식			
			while(k<=4){//열을 의미
				if(i==k) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
				k++;//안쪽 while의 증가식
			}
			//k를 다시 1로 초기화 
			k=1;
			//줄바꿈
			System.out.println();			
			i++;//바깥while의 증가식
		}
		/*
		 
		  * 
		  * *
		  * * *
		  * * * *
		  * * * * *(while문으로)
		 */
		k=1;
		while(k<=5){
			 int j=1;
			 while(k >= j){				 
				System.out.printf("%-2c",'*');
				j++;
			 }
			 //줄바꿈
			 System.out.println();
			 k++;
		 }//////////////////////////
		/*
		  문]아래 형식대로 구구단을 출력
			2 * 1 = 2   3 * 1 = 3   4 * 1 = 4........9 * 1 = 9
			2 * 2 = 4   3 * 2 = 6   4 * 2 = 8........9 * 2 =18
			..
			..
			2 * 9 = 18  3 * 9 = 27  4 * 9 =36....... 9 * 9 = 1	
			
			while문으로...
	    */
		k=1;
		while(k<=9){
			 int j=2;
			 while(j<=9){
				 System.out.printf("%-2d * %-2d = %-3d",j,k,k*j);
				 j++;
			 }
			 System.out.println();
			 k++;
		 }
		
	}/////////////////main
	
}/////////////////////while
