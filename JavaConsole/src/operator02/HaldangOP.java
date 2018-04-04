package operator02;

public class HaldangOP {

	public static void main(String[] args) {
		/*
		  [할당(대입)연산자] 
		   = : 변수 = 값(변수) 
		      오른쪽에 있는 값을 왼쪽의 변수에 
		      할당(대입)한다.
		  [축약표현]
		  +=,-=,*=,%=..등등
		  변수1 += 값(변수2) => 변수1 = 변수1+값 혹은  
		  변수1 = 변수1+변수2 		  
		 */	
		//1]대입 연산자
		int num1;//변수 선언
		//※지역변수는 반드시 초기화후 사용
		//System.out.println(num1);//[x]
		//대입 연산자(=)로 초기화
		//대입 연산자의 오른쪽식이 항상 먼저 실행된후
		//그 결과값을 왼쪽의 변수에 대입
		num1=100;
		System.out.println(num1);//[o]
		int num2 ;
		num2 = num1;//변수에 저장된 값 대입
		//왼쪽에는 항상 변수가 와야 한다.
		//100 = num1 + num2;//[x]
		System.out.format("num1:%-4dnum2:%d%n",num1,num2);
		//2]축약표현
		//※산숫연산자에만 적용
		num1+=100;//num1 = num1 + 100
		System.out.format("num1:%-4dnum2:%d%n",num1,num2);
		num1%=num2;//num1=num1%num2
		System.out.format("num1:%-4dnum2:%d%n",num1,num2);
		num2*=2+10;//num2=num2 * (2+10)
		System.out.format("num1:%-4dnum2:%d%n",num1,num2);
		//num2 &&=num1;//num2= num2 && num1;//[x]
		boolean b1=false,b2=true;
		//b1 &&=b2;//b1=b1 && b2;//[x]
		/*
		증감연산자(단항 연산자):++(증가 연산자),--(감소연산자)
					++는 자기자신을 1증가시킨다
					--는 자기자신을 1감소시킨다.
					단독으로 쓰일때는 항이 증감연산자 
					앞에 붙거나 뒤에 붙거나 
					결과는 같다.
					하지만 다른 연산자와 결합할때는 
					++(--)변수:먼저 자신을 증감 시킨다
					변수++(--):다른 연산을 수행한후 자신을 
					증감시킨다.
	    */
		int num3=10;
		//단독으로 사용시]
		//변수명++(후위 연산자)
		//num3++;//num3=num3+1
		//++변수명(전위 연산자)
		++num3;//num3=num3+1
		//전위든 후위든 아래는 11출력
		System.out.printf("num3:%d%n",num3);
		//다른 연산과 함께 사용시]
		//후위 연산: 다른 연산을 먼저 수행한 후 
		//마지막에 자기자신을 1증가(++)시키거나 감소(--)시킨다.
		int num4=10;
		int result = num4 + num3++;
		//1]num4 + num3 = 10 + 11
		//2]result = 21
		//3]num3 = num3 +1 즉 num3는 12
		System.out.printf("result:%d,num3:%d%n",result,num3);
		// 전위 연산:자기자신을 먼저 1증가(++)시키거나 감소(--)시킨후 
		// 다른 연산 수행
		result = num4 + ++num3;
		//1]num3 = num3 +1 num3는 13
		//2]num4 + num3 = 10 + 13 
		//3]result = 23
		System.out.printf("result:%d,num3:%d%n",result,num3);
		
		int num5 =10;
		//println메소드의 매개변수에 
		//num5에 있는값이 대입(복사)된후
		//자기자신을 1증가시킨다
		System.out.println(num5++);//10
		System.out.println(num5);//11
	}/////////////main

}/////////////////class
