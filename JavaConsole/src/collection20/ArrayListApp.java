package collection20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import console.academy.Student;

/*
ArrayList: List(인터페이스)계열의 컬렉션 클래스
- 중복 저장 가능
- 순서 있게 저장
- 데이타 꺼내올때: iterator()/get(index)
*/
public class ArrayListApp {

	public static void main(String[] args) {
		//1]List 계열 컬렉션 객체 생성
		ArrayList list = new ArrayList();
		//1-1]객체 저장:add() 계열
		/*
		list.add(Object obj):계속 추가되면서
		                        인덱스는 0부터 자동 부여
		list.add(int index,Object element);
		                     :계속 추가되면서 저장시
		                       인덱스 위치 부여 할 수 있다.
		                       인덱스번호 재배치됨.
		*/
		list.add("가산");//인덱스 0번방에 저장
		list.add("나산");//인덱스 1번방에 저장
		list.add("다산");//인덱스 2번방에 저장
		//인덱스 지정해서 객체 저장
		list.add(3,"라산");//인덱스 3번방에 저장
		//인덱스 지정시는 순차적으로 지정하거나
		//기존에 존재하는 인덱스로 지정
		//list.add(5,"마산");//[x]실행 오류
		list.add(list.size(),"마산");
		list.add(list.size(),"바산");
		System.out.println("중복 저장전 객체 수:"+list.size());
		//1-2]중복저장:허용
		System.out.println(list.add("다산")?"중복 저장됨":"중복저장 안됨");
		System.out.println("중복 저장후 객체 수:"+list.size());
		//1-3]출력
		System.out.println("[일반 for문]");
		for(int i=0; i < list.size();i++){
			Object obj=list.get(i);
			if(obj instanceof String){
				System.out.println(obj);
			}
		}/////////////////for
		System.out.println("[확장 for문]");
		for(Object obj : list){
			System.out.println(obj);			
		}
		System.out.println("[반복기 사용]");
		Iterator it=list.iterator();
		while(it.hasNext()) System.out.println(it.next());
		/*1-4]특정 위치의 인덱스에 저장된 객체를 대체:
	    set(int index,Object obj)
	    특정 인덱스위치에 객체 저장이되고
	    기존 객체는 삭제됨. 
	    */
		list.set(4, "마산대체");
		System.out.println("[set으로 객체 저장후]");
		for(Object obj : list){
			System.out.println(obj);			
		}
		list.add(4,"마산추가");
		System.out.println("[add으로 객체 저장후]");
		for(Object obj : list){
			System.out.println(obj);			
		}
		//1-5]검색
		System.out.println(list.contains("다산") ?"다산 있다":"다산 없다");
		System.out.println(list.contains("아산")?"아산 있다":"아산 없다");
		//1-6]삭제
		//방법1]인덱스로 삭제:Object remove(int index)
		//삭제된 객체(주소)를 반환
		//삭제후에는 자동으로 인덱스가 다시 부여된다.
		Object obj = list.remove(2);
		System.out.println("삭제된 객체:"+obj);
		//방법2]특정 위치의 인덱스 찾기:int indexOf(Object)
		int index = list.indexOf("다산");
		System.out.println("index="+index);
		list.remove(index);
		System.out.println("[다산 삭제후]");
		for(Object object : list){
			System.out.println(object);			
		}
		//방법3]인스턴스(주소)로 삭제:boolean remove(Object obj)
		System.out.println(list.remove("마산추가")?"삭제 성공":"삭제 실패");
		System.out.println(list.remove("마산대체")?"삭제 성공":"삭제 실패");
		System.out.println("[마산계열 삭제후]");
		for(Object object : list){
			System.out.println(object);			
		}
		//1-7]전체 삭제:
		//boolean removeAll(Collection<?> col) 
		//혹은void clear()
		//list.removeAll(list);
		list.clear();
		System.out.println("전체 삭제후 객체 수:"+list.size());
		//2]제너릭 지정:<Student>
		ArrayList<Student> list2= new ArrayList<Student>();
		//2-1]컬렉션에 저장할 객체 생성
		Student stu1 = new Student("가길동", 20, "2017학번");
		Student stu2 = new Student("나길동", 30, "2016학번");
		Student stu3 = new Student("다길동", 40, "2015학번");		
		Student stu4 = new Student("라길동", 50, "2014학번");		
		//2-1]객체 저장
		list2.add(stu1);
		list2.add(stu2);
		list2.add(stu3);
		list2.add(stu4);
		//중복 저장]
		list2.add(stu2);
		System.out.println("[중복 저장후]");
		for(Student s : list2) s.print();
		//인스턴스(주소)로 중복저장된 객체 삭제-하나만 삭제됨(인덱스가 빠른거)
		list2.remove(stu2);
		System.out.println("[중복 저장된 객체 삭제후]");
		for(Student s : list2) s.print();
		//2-2]출력
		System.out.println("[반복기 사용]");
		Iterator<Student> it2=list2.iterator();
		while(it2.hasNext()){
			/*Student s=it2.next();
			s.print();*/
			it2.next().print();
		}
		System.out.println("[일반 for문 사용]");
		for(int i=0;i < list2.size();i++) list2.get(i).print();
		System.out.println("[확장 for문 사용]");
		for(Student s : list2) s.print();
		//2-3]삭제
		//인덱스로 삭제]
		System.out.println("삭제된 객체의 이름:"+list2.remove(2).name);
		//인스턴스(주소)로 삭제]
		list2.remove(stu3);
		System.out.println("[삭제 후]");
		for(Student s : list2) s.print();
		/*문]사용자로부터 이름을 입력받아 그 이름으로 검색해서
		   인덱스 위치(indexOf사용)를 알아내서 해당 인덱스로
		   그 객체를 삭제하고 삭제된 객체의 정보(이름,나이,학번)를
		   출력하여라
		*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하세요?");
		String name = scanner.nextLine();
		
		int idx = -1;
		for(Student s : list2){
			if(s.name.equals(name)){
				idx=list2.indexOf(s);
				System.out.println("삭제된 객체:"+list2.remove(idx).get());
				break;
			}
		}
		if(idx == -1) System.out.println(name+"에 해당하는 객체가 없어요");
	}//////////main

}///////////class
