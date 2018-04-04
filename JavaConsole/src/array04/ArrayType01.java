package array04;

import java.util.Scanner;

public class ArrayType01 {

	public static void main(String[] args) {
		/*
		배열:하나의 이름(배열명)으로 같은 자료형의 데이타를 
		     여러개 
		     저장할 수 있는 메모리 구조
		     (메모리가 연속적으로 생김).
			 참조형이다.		
		*/
		//1차원(선형) 배열]
		//1]배열 선언
		/*
		 * arrNum이라는 배열명으로
		   int형의 배열을 선언하는것
		   arrNum이라는 이름으로 Stack영역에
		   주소를 저장할 수 있는 메모리가 생김
		 */
		int[] arrNum;//혹은 int arrNum[];
		//arrNum=10;//[x]데이타 저장 불가
		//2]메모리 할당- 실제 값을 저장할 수 있는 메모리를
		//              heap영역에 생성하기 위해 
		//              new연산자 사용.
		/*
		 * int[5]에서 5는 배열 크기 즉 메모리의 개수다
		 * 	          
		 * new연산자:실제 데이타를 저장할 메모리를
		             heap영역에 할당하여라는 의미	   
		   
		 */
		arrNum = new int[5];
		//arrNum에는 실제 데이타를 저장하는 메모리의 주소가 저장됨.
		System.out.println("arrNum="+arrNum);
		//배열명[숫자] 를 배열요소명이라 함
		//숫자는 배열인덱스라고 한다.
		//배열에서 인덱스는 항상 0부터 시작
		//배열명[숫자] 즉 배열요소명은 변수처럼 사용할 수 있다.
		//3]배열의 초기화
		/*	
		배열은 초기화를 하지 않아도 
		해당 자료형의 기본값으로 설정된다.
		예] int :0,double:0.0 boolean:false,char:' '(빈값)
		    참조형:null등		
		 */
		System.out.println("[배열 초기화 전]");
		for(int index=0;index < 5;index++){
			System.out.printf("arrNum[%d]=%d%n",index,arrNum[index]);
		}
		/*
		 *-배열에 값 할당 할때
		 * 배열명[인덱스] = 값 혹은 변수;
		 *-배열에 있는값 읽어 올때
		 * 배열명[인덱스]		
		 * 배열명[인덱스]:배열요소명		 
		 * 배열의 인덱스는 0부터 시작
		 */
		//배열 초기화]-메모리 생성후 값 최초로 할당
		arrNum[0]=10;
		arrNum[1]=20;
		arrNum[2]=30;
		arrNum[4]=50;
		System.out.println("[배열 초기화 후]");
		for(int index=0;index < 5;index++){
			System.out.printf("arrNum[%d]=%d%n",index,arrNum[index]);
		}
		/*
		 *배열의 크기를 벗어난 인덱스는
		 *컴파일은 되지만 실행시 에러 
		 *ArrayIndexOutOfBoundsException: 5 
		 */		
		//arrNum[5]=100;//[x]실행시 에러
		int localvar;//지역변수
		//지역변수는 사용시 반드시 초기화 한 후 사용해야 하나
		//배열은 초기화를 하지않아도 해당 자료형으로
		//초기화가 되있기 때문에 사용가능
		//System.out.println(localvar);//[x]
		//4]출력
		/*
		 * 배열의 크기 얻기:배열명.length		
		 */
		System.out.println("배열의 크기:"+arrNum.length);
		
		for(int i=0;i < arrNum.length;i++){
			if(i != arrNum.length-1)//마지막 요소가 아닌경우
				System.out.printf("arrNum[%d]=%d,",i,arrNum[i]);
			else
				System.out.printf("arrNum[%d]=%d",i,arrNum[i]);
		}
		//5]배열선언과 동시에 메모리 할당
		String strArr[] = new String[3];
		System.out.println("[초기화 전 출력]");
		for(int i=0;i < strArr.length;i++){
			System.out.printf("strArr[%d]=%s%n",i,strArr[i]);
		}
		//String형 배열 초기화]
		strArr[0]="한국";
		strArr[1]="소프트웨어";
		strArr[2]="인재개발원";
		
		System.out.println("[초기화 후 출력]");
		for(int i=0;i < strArr.length;i++){
			System.out.printf("strArr[%d]=%s%n",i,strArr[i]);
		}
		//6]배열선언과 동시에 초기화
		/* {}를 이용해서 선언과 동시에 초기화 하면 
		 * 자동으로
		 * 메모리가 할당됨(heap영역에)
		 * ※배열선언후 나중에 초기화 형식{}는 안된다.
		 * 
		 */
		// 방법1] = {};
		//double[] dblArr = {10,3.14,100,99.9};//{}배열 초기화자 라한다
		//방법2] = new 자료형[]{}
		double[] dblArr = new double[]{10,3.14,100,99.9};		
		for(int i=0;i < dblArr.length;i++)
			System.out.printf("dblArr[%d]=%.2f%n",i,dblArr[i]);
		
		//boolean[] blArr;//boolean형 배열 선언
		//blArr={false,true,100> 10,1>2 && 5 < 2,false};//[x]선언후 초기화자로 초기화
		
		boolean[] blArr={false,true,100 > 10,1>2 && 5 < 2,false};//[o]
		for(int i=0;i < blArr.length;i++)
			System.out.printf("blArr[%d]=%b%n",i,blArr[i]);
		
		//7]메모리 할당시 배열의 크기는 변수로 대체 가능
		Scanner scanner = new Scanner(System.in);
		//Scanner클래스의 메소드 정리]
   		//nextInt():버퍼에 있는 엔터값(\r\n)은 읽지 않는다
   		//즉 사용자가 12(엔터)치면 버퍼에 1|2|'\r'|'\n'
   		//저장됨
   		//nextInt()는 숫자만 읽는다
   		//nextLine()는 버퍼에 남아 있는 엔터값도 읽는다  
		//엔터값 읽어서 버리자]
		//[학생 수만큼 이름 입력받기]
		System.out.println("학생수를 입력하세요?");
		int numberOfStudent = scanner.nextInt();
		//이름을 저장할 배열 선언 및 학생수 만큼 메모리 할당]
		String[] names = new String[numberOfStudent];
		//엔터값 읽어서 버리자
		scanner.nextLine();
		for(int i=0;i < names.length;i++){
			System.out.println(i+1+"번째 학생의 이름입력?");
			names[i] =scanner.nextLine();
		}/////////////////////////
		//출력]
		for(int i=0;i < names.length;i++){
			System.out.printf("%d번째 학생:%s%n",i+1,names[i]);
		}///for
		
		int[] jumsu ={90,99,75,66,100,89,78,67,45,90,56,999,109};
		//문]int형 배열에 저장된 점수의 총합과
		//   평균을 구해라 그리고 출력하여라.
		int sum=0;
		for(int i=0;i < jumsu.length;i++){
			sum+=jumsu[i];
		}
		System.out.printf("총합:%d,평균:%.2f%n",sum,(double)sum/jumsu.length);
		
		//문]상기 jumsu배열에 저장된 값 중 최대값을 구하여라.
		int max = jumsu[0];
		for(int i=1;i < jumsu.length;i++){
			if(max <= jumsu[i]) max =jumsu[i];
		}
		System.out.println("최대값:"+max);
		
		//문]일차원 배열을 크기 순서대로 재 배치후 출력하자.	
		for(int i=0;i < jumsu.length-1;i++){
			for(int k=i+1;k< jumsu.length;k++){
				if(jumsu[i] <= jumsu[k]){
					int temp = jumsu[i];
					jumsu[i] = jumsu[k];
					jumsu[k] = temp;
				}
			}
		}
		System.out.println("[큰값으로 재배치후 출력]");
		for(int i=0; i < jumsu.length;i++)
			System.out.printf("%-5d",jumsu[i]);
	}/////////////////main

}/////////////////////class
