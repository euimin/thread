package datatype01;

public class TypeCasting {

	public static void main(String[] args) {
		/*
		1]자동 형변환:
		  작은 그릇의 데이타를->큰 그릇에 넣을때
		  형변환이 자동으로 일어남
		  즉 형변환 불필요 
		*/
		byte b1 =65;
		short s1;
		//b1의 저장된 값을 s1에 대입(복사)
        //자동 형변환 즉  b1이 2바이트로 변환되서
		//b1에 저장된값이 s1에 복사됨
		s1 = b1;//[o]자동 형변환
		System.out.printf("b1은 %d s1은 %d%n",b1,s1);
		//아래는 자동 형변환이 아님.
		int num1 = s1+ b1;//b1+s1의 연산결과가 int형임으로
        				  //int형을 int형에 대입하니까
		int num2 = num1;
		//단,char형(2바이트)에 byte형(1바이트)를
		//넣을 수 없다. 이때는 char형으로 형변환 해야함.
		//char ch1 = b1;//[x]
		char ch1 = (char)b1;
		System.out.printf("b1은 %d\tch1은 %c%n",b1,ch1);
		/*
		2]강제적 형변환:
		큰 그릇의 데이타->작은 그릇의 담을때
		캐스팅연산자를 사용:(자료형)
		-데이타 손실이 일어 날 수도 있다
		*/
		//데이타 손실이 안 일어나는 경우]
		//- 강제 형변환을 하더라도 충분히 담을 수
		//  있을때
		short s2 =100;
		byte b2 = (byte)s2;//강제적 형변환		
		System.out.printf("데이타 미 손실]s2:%d\tb2:%d%n",s2,b2);
		
		int num3;
		double dl=3.14;
		
		//num3 = dl;//[x]
		//강제적 형변환:소수점이 버려짐
		num3 = (int)dl;//[o]
		System.out.printf("데이타 손실]num3=%d,dl=%.2f%n",num3,dl);
		//int num4 = num3 + dl;//[x]num3+dl의 연산결과는 double
		//굳이 int형에 담고자한다면 형변환
		//방법1]연산결과 전체를 int형으로 형변환
		int num4 = (int)(num3 + dl);
		//방법2]double형만 int형으로 형변환
		int num5 = num3 + (int)dl;
		System.out.printf("num4=%d,num5=%d%n",num4,num5);
		
		char ch2='A',ch3;
		int num6=1;
		//ch3 = ch2 + num6;//[x]char형과 int형 연산결과는 int형
		//연산결과 전체를 char형으로 형변환
		ch3 = (char)(ch2 + num6);//[o]
		//ch3 = ch2 + (char)num6;//[x]char형과 char형 연산결과는 int형이니까
		System.out.printf("ch3=%c",ch3);
	}//////////////main
}//////////////////class
