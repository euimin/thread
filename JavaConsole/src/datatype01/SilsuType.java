package datatype01;

public class SilsuType {

	public static void main(String[] args) {
		//※실수형에서 디폴트 자료형은 double이다.				
		//규칙1]정수형보다는 실수형이 더 큰 그릇이다
		//long(정수형):8byte,float(실수형):4byte
		long ln =100;
		float f1 = 200;
		
		//long ln1=ln+f1;//[x]long형과 float형 연산결과는 float
		//방법1]연산결과인 float형에 저장
		float f2 = ln+f1;//[o]
		System.out.println("f2="+f2);
		//방법2]float형인 f1만 long형으로 형변환
		long ln1=ln+(long)f1;//[o]
		System.out.println("ln1="+ln1);
		//방법3]연산결과 전체를 long형으로 형변환
		ln1=(long)(ln+f1);
		System.out.println("ln1="+ln1);
		//tip)주로 소수점 이하를 제거하고자 할때
		//int 형으로 형변환하면 된다.
		float kor=99,eng=80,math=96;
		float avg = (kor+eng+math)/3;//float형과 int형 연산결과는 float형
		System.out.println("평균:"+avg);
		System.out.println("평균(소수점 제거):"+(int)avg);
				
		int kor1=99,eng1=80,math1=96;
		double avg1 =(kor1+eng1+math1)/3.0;//int형과 double형 상수(3.0) 연산결과는 double형
		System.out.println("평균:"+avg1);
		System.out.println("평균(소수점 제거):"+(int)avg1);
		/*
		규칙2]실수형에서 기본 데이타 타입은 double이다
		소수점이 붙으면 무조건 double형으로 인식
		단, 소수점이 붙지 않은 값은 float에 담을 수 있다.
		float f3 = 3.14;//[x] 3.14는 double형으로 인식됨
		컴파일러에게 소수점이 붙은 숫자를 float형으로 
		인식시키기 위해
		숫자 뒤에 f나 F를 붙인다.
		*/
		float f3 = 100;//[o]int형 상수 100을 float형 변수 f3에 저장
		//float f4 = 3.14;//[x]3.14는 double형 상수임으로 float형 변수에
        //저장불가
		//방법1]형변환(비 권장)
		float f4 = (float)3.14;
		System.out.println("f4="+f4);
		//방법2]실수 숫자뒤에 f 나 F(권장)
		f4 = 3.14F;//3.14는 float형 상수
		System.out.println("f4="+f4);
		//3]실수형도 같은 자료형끼리의 연산결과는
		//  같은 자료형,큰 자료형과 작은 자료형과의 
		//  연산결과는 큰 자료형.
		float ff1=100,ff2=99.9f,fresult;
		double dd1=100,dd2=99.9,dresult;
		
		fresult=ff1+ff2;//[o]연산결과는 float형
		System.out.println(fresult);
		
		dresult=dd1 + dd2;//[o]연산결과는 double형
		System.out.println(dresult);
		
		dresult=ff1+dd2;//[o]연산결과는 double형
		System.out.println(dresult);
		/*반지름이 10인 원의 면적을 구해라
		단,면적을 저장하는 변수의 타입을 3가지 형태의
		자료형에 저장하여 출력하여라
		원의 면적:반지름*반지름*3.14
		단,아래의  변수 radius 와 pi를 사용해서 구해라*/
		int radius =10;
		double pi=3.14;
		
		float farea;int iarea;double darea;
		
		iarea = (int)(radius*radius*pi);
		System.out.println("원의 면적(int):"+iarea);
		farea = radius*radius*(float)pi;
		System.out.println("원의 면적(float):"+farea);
		farea = (float)(radius*radius*pi);
		System.out.println("원의 면적(float):"+farea);
		darea =radius*radius*pi;
		System.out.println("원의 면적(double):"+darea);
		
	}////////////////main

}//////////////////class
