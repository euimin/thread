package wrapperclass10;
//[AutoBoxing <->AutoUnBoxing]
/*
- 오토박싱 ,오토 언박싱은 JDK5.0 이상에서만 적용 됨 
- Wrapper클래스와 기본 자료형과의 관계에서 나온 개념

- 오토박싱 : 기본 자료형이 자동으로(Auto) 
         참조형(Wrapper클래스)으로
         바뀌는거
       예] int -> Integer
       
- 오토언박싱 :참조형(Wrapper클래스)이 
          기본 자료형으로 자동으로 
          바뀌는거

			 예] Integer -> int

*/
public class WrapperClass01 {
	
	
	public static void main(String[] args) {
		/* JDK 1.4이전 버전에서의 코딩 형태*/
		
		//기본 자료형으로 +  연산]
		int num1=10;
		int num2=20;
		
		int result = num1 + num2;
		System.out.println("result="+result);
		//Wrapper클래스로 + 연산]
		Integer num1obj = new Integer(10);
		Integer num2obj = new Integer(num2);
		//Integer resultobj=num1obj+ num2obj;[x]JDK1.4이전버전에서
		result=num1obj.intValue()+num2obj.intValue();//[o]JDK1.4이전버전에서
		System.out.println("result="+result);
		//기본 자료형은 멤버가 없다
		//num1.//[x]
		//num1을 Integer타입으로 변경해서 Integer클래스의 메소드 호출
		Integer num1object = new Integer(num1);//[o]JDK1.4이전버전에서
		System.out.println("10(num1)을 byte형 값으로 변경:"+num1object.byteValue());
		System.out.println("10(num1)을 이진수로 변경:"+Integer.toBinaryString(num1));
		/* JDK 5.0이후의 코딩 형태*/
		//int ->Integer:오토박싱이 일어남
		num1obj = num1;//JDK1.4이전 버전에서는 에러남
		num2obj = 20; //JDK1.4이전 버전에서는 에러남
		//Integer -> int형으로:오토 언박싱
		int num3 = num1obj;//JDK1.4이전 버전에서는 에러남
		
		Integer num3obj = 100;//오토 박싱(int형상수(100)->Integer)
		
		/*
		Wrapper클래스를 사용하는 이점:
		Wrapper클래스 안의 많은 메소드 사용가능
		고로 쉽게 정수를 이진수로 혹은 8진수로 쉽게 
		변환 가능 등등
		*/
		System.out.println("int형의 최대값:"+Integer.MAX_VALUE);
		System.out.println("int형의 최소값:"+Integer.MIN_VALUE);
		System.out.println("num1을 이진수로:"+Integer.toBinaryString(num1));
		System.out.println("num1을 8진수로:"+Integer.toOctalString(num1));
		System.out.println("num1을 16진수로:"+Integer.toHexString(num1));
		/*
		 자바의 모든 클래스들은 Object라는 
		 최상위 클래스로터
		 상속을 받는다 .
		 Wrapper클래스들은 Object부터 상속받은 
		 toString()메소드를
		 오버라이딩하여 인스턴스 변수 출력시 
		 주소가 아니라
		 실제 저장된 값이 반환되도록 오버라이딩 되었다.	  
		 */
		Integer numobj = new Integer(99);
		
		System.out.println("numobj="+numobj);//toString()이 생략된거와 같다
		System.out.println("numobj.toString()="+numobj.toString());
		System.out.println("numobj.hashCode()="+numobj.hashCode());
		/*원래 Object클래스의 toString()메소드는 
		  메모리 주소를 
		  아래와 같은 문자열로	반환하도록 정의됨.
		  패키지명1.패키지명2....클래스명@16진수체계의 메모리 주소
		*/
		WrapperClass01 wc = new WrapperClass01();
	
		System.out.println("wc="+wc);
		System.out.println("wc.toString()="+wc.toString());
		System.out.println("wc.hashCode()(10진수)="+wc.hashCode());
		System.out.println("wc.hashCode()(16진수)="+Integer.toHexString(wc.hashCode()));
		
		
	}////////////main

}//////////////class
