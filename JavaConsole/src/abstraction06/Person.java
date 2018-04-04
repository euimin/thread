package abstraction06;

import java.util.Date;

/*
[클래스 정의]
- 클래스명은 항상 대문자로 시작하자
- 클래스는 객체(Object)의 설계도
- 클래스는 여러 타입의 값을 저장 할 수 있는 자료형이다(자료구조다)
  즉 사용자 정의 자료형(데이타 타입)이다
- 인간 세계의 객체(사물,사건 ,개념,현상)에서 속성과 행동을 뽑아내서
  속성은 변수나 상수로 행동은 메서드로 뽑아내
  클래스를 정의하는것을 추상화라한다.

[클래스 정의 구문]

접근지정자 [modifier(지정자)] class 클래스명{
		 	//클래스의 멤버들
		 	멤버 상수
		 	멤버 변수
		 	멤버 메서드
		    클래스(내부 클래스)
		    인터페이스
		  
}
*/
//사람을 추상화 해보자
//즉 사람의 설계도를 만들어 보자
//즉 사람의 행동 과 속성 뽑아내서 행동은 메서드로 속성은 
//상수나 멤버변수로
/*
속성[멤버변수]
멤버변수는 해당 클래스와 has a 관계가 존재해야 한다.
멤버변수는 초기화를 하지 않으면 해당 자료형으로 초기화가 된다.
예] 참조형:null,int:0 ,double:0.0 ,boolean:false 등
멤버변수는 해당 클래스안의 
모든 메소드에서 사용이 가능하다

멤버변수 선언]
접근지정자 [modifier] 자료형 멤버변수명;
※멤버변수로 모든 데이타 타입
(기본 데이타 타입/배열/클래스등)이
올 수 있다.


단,지역변수 선언시에는 자료형 변수명;
*/

public class Person {
	//[멤버 변수 선언]
	//1]사람이라는 객체가 갖고 있는 
	//  속성(성질이나 상태):멤버변수
	//  has a 관계	
	public String name;//이름 속성-public 접근지정자 사용
	int age=1;//나이속성-생략형(패키지) 접근지정자 사용.선언과 동시에 초기화
	double weight;//몸무게 속성-생략형 접근지정자 사용
	
	//[멤버 메소드 정의]
	//사람이라는 객체가 갖고 있는 행동(행위):멤버 메소드
	public void sleep(){
		System.out.println(name+"이 자다");
	}
	void eat(){
		System.out.printf("나이가 %d살인 %s가 먹다.그러니 몸무게가 %.2f이지..%n",age,name,weight);
	}
	//프로그램 효율성을 위한 메소드들]
	String getPerson(){
		//return "["+name+"의 정보]\r\n나이:"+age+"\r\n몸무게:"+weight;
		return String.format("[%s의 정보]%n나이:%d%n몸무게:%.2f",name,age,weight);
	}
	void printPerson(){
		System.out.println(getPerson());
	}
}
