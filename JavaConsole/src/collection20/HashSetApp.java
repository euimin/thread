package collection20;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import console.academy.Student;

/*
HashSet:Set(인터페이스)계열의 컬렉션 클래스 
-순서 없이 저장
-객체의 중복 저장 허용 안함.  
*/
public class HashSetApp {

	public static void main(String[] args) {
		//1]<?>제너릭표현에 타입을 지정 안 한경우] 
		//  -어느 타입이든 저장 가능.				
		//1-1]컬렉션 객체 생성
		HashSet set = new HashSet();
		//1-2]컬렉션에 저장할 객체 생성
		String stringObject1 ="JAVA";
		String stringObject2 =new String("WORLD");
		Date dateObject = new Date();
		int number =100;
		Student student = new Student("홍길동",20,"2017학번");
		//1-3]컬렉션에 객체 저장-boolean add(Object)
		System.out.println(set.add(stringObject1) ? "저장 성공!":"저장 실패!");
		set.add(stringObject2);
		set.add(dateObject);
		set.add(number);//오토박싱:1.4이전 버전에서는 add(new Integer(number));코딩
		set.add(student);
		//1-4]컬렉션에 저장된 객체수 얻기:int size()
		System.out.println("중복 저장 전]저장된 객체 수:"+set.size());
		//1-5]중복저장[x]-에러는 안나지만 저장이 안됨(즉 add()메소드가 false반환)
		System.out.println(set.add(stringObject1) ? "저장 성공!":"저장 실패");
		System.out.println("중복 저장 후]저장된 객체 수:"+set.size());
		//1-6]저장된 객체 꺼내오기
		//    -순서없이 저장됨(반복기를 통해서 꺼내오기)
		/*
		  Iterator의 주요 추상 메소드]
		  ※데이타가 순서 있게 저장된 자료구조(List 계열)
		   나 순서 없이 저장된 자료구조(Set계열)
		   에서 데이타를 꺼내올때 사용하는 타입(인터페이스)
		   단,확장 for문 써도 무방
		  
		  hasNext():꺼내올 객체가 있으면 true반환
		            없으면 false반환.               
		  hasNext()메소드로 판단후 
		  next()메소드로 꺼내온다               
		  */ 
		 //1-6-1]iterator()메소드로 Iterator타입의 인스턴스 얻기
		System.out.println("[반복기 사용]");
		Iterator it= set.iterator();
		while(it.hasNext()){//1-6-2]hasNext()로 꺼내올 객체의 유무여부 판단
			//꺼내올때는 next()메소드
			Object object=it.next();
			if(object instanceof String)
				System.out.println("String타입:"+object);
			else if(object instanceof Date)
				System.out.println("Date타입:"+object);
			else if(object instanceof Integer)
				System.out.println("Integer타입:"+object);
			else if(object instanceof Student)
				System.out.println("Student타입:"+"이름:"+((Student)object).get());
		}	
		
		//※모든 객체 꺼내온후 next()호출시 실행오류발생]
	    /* next()메소드 호출시마다 하나씩 꺼내온다
	     * 만약 컬렉션에 꺼내올 객체가 없는데 next()를
	     * 호출한다면 예외 발생
	     */
		//it.next();//[x]실행오류발생
		/*
	   	확장 for문: 배열이나 컬렉션에 저장된 값을 꺼내올때 
	                 사용하는  for문의 확장형    
	   	형식]
	   	for(자료형 객체를담을변수 : 배열명이나 혹은 컬렉션명){   
	   
	   	}
	     */ 		
		System.out.println("[확장 for문 사용]");
		for(Object  object:set){
			if(object instanceof String)
				System.out.println("String타입:"+object);
			else if(object instanceof Date)
				System.out.println("Date타입:"+object);
			else if(object instanceof Integer)
				System.out.println("Integer타입:"+object);
			else if(object instanceof Student)
				System.out.println("Student타입:"+"이름:"+((Student)object).get());
		}
		String[] mountains ={"비슬산","대둔산","치악산","설악산"};
		System.out.println("[일반 for문 사용]");
		for(int i=0; i < mountains.length;i++)
			System.out.println(String.format("%s",mountains[i]));
		System.out.println("[확장 for문 사용]");
		for(String  mt : mountains)
			System.out.println(String.format("%s",mt));
		//1-7]검색:boolean containts(Object e)
		System.out.println(set.contains(stringObject1) ? "stringObject1있다":"stringObject1없다");
		System.out.println(set.contains(number)?"number있다":"number없다");
		System.out.println(set.contains("Java") ?"Java있다" : "Java없다");
		//1-8]삭제:boolean remove(Object e)
		System.out.println(set.remove(stringObject2)?"삭제 성공!!":"삭제 실패!!");
		System.out.println(set.remove(stringObject2)?"삭제 성공!!":"삭제 실패!!");
		System.out.println("삭제 후 객체 수]"+set.size());
		//1-9]전체 삭제 :boolean removeAll(Collection c)
		//              void clear()
		//set.removeAll(set);
		set.clear();
		System.out.println("전체 삭제후 객체 수]"+set.size());
		//2]<?>표현 사용- 해당 타입(?)만 저장 가능
		HashSet<Student> set2 = new HashSet<Student>();
		//2-1]컬렉션에 저장할 객체 생성
		Student stu1 = new Student("가길동", 20, "2017학번");
		Student stu2 = new Student("나길동", 30, "2016학번");
		Student stu3 = new Student("다길동", 40, "2015학번");		
		//2-2]객체 저장
		set2.add(stu1);
		set2.add(stu2);
		set2.add(stu3);
		
		//set2.add(stringObject1);//[x]제너릭에 지정한 타입만 저장 가능
		System.out.println("저장된 객체 수:"+set2.size());
		System.out.println(set2.add(stu1) ? "중복 저장됨" :"중복 저장 안됨");
		//2-3]객체 꺼내오기
		System.out.println("[반복기 사용]");
		Iterator<Student> it2= set2.iterator();
		
		while(it2.hasNext()){
			/*
			    * next()메소드는 호출 할때마다 객체를
			    * 무조건 하나씩 꺼내온다
			    * 고로 아래는 반복 한번에
			    * 세개의 Student객체를 꺼내오는것
			    * 만약 더 이상 꺼내올 객체가 없는데
			    * next()를 호출하면
			    * java.util.NoSuchElementException예외 발생

			*/
			/*
			System.out.println(
					String.format("이름:%s,나이:%d,학번:%s",
							it2.next().name,
							it2.next().age,
							it2.next().stNumber
							));*/
			Student st=it2.next();
			/*
			System.out.println(
					String.format("이름:%s,나이:%d,학번:%s",
							st.name,
							st.age,
							st.stNumber
							));*/
			st.print();
		}
		System.out.println("[확장 for문 사용]");
		for(Student st:set2) st.print();
		//2-4]검색
		System.out.println(set2.contains(stu1) ? "stu1있다":"stu1없다");
		System.out.println(set2.contains(new Student("가길동",20,"2017학번")) ?"있다":"없다");
		//2-5]삭제
		/*
		System.out.println(set2.remove(stu1)?"삭제 성공":"삭제 실패");
		set2.clear();
		System.out.println("삭제후 객체 수:"+set2.size());
		*/
		 /*문]컬렉션 set2에 저장된 객체를
	      이름으로 검색하자.있는 이름으로 검색해 보고
	      없는 이름으로 검색해보자. 있으면 해당 학생의
	      정보를 출력하고 없으면 
	      "해당 학생이 없어요"라는 메시지 출력] 
	     */
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요?");
		String name = scanner.nextLine();
		
		boolean isExist = false;
		for(Student st : set2){
			if(name.equals(st.name)){
				st.print();
				isExist = true;
				break;
			}
		}
		if(!isExist) System.out.println("해당 학생이 없어요!!");
	}///////////////////main

}//////////////////////class
