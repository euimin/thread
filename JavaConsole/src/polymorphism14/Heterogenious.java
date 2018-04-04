package polymorphism14;
/*
 * 다형성:
 * 1]오버로딩- 같은 이름의 메소드를 한 클래스안에서
 *            여러개 정의 가능(양념-매개변수)
 * 2]오버라이딩 - 상속관계에서 부모의 메소드를
 *               리모델링(외관은 그대로 안에만 변경)
 *                
 * 
 * 3]Heterogenious(이질화)
	전제조건:두 클래스 사이에 상속관계가 
	         존재해야 함
			 부모타입 부모타입의인스턴스변수 
			 = new  자식타입의 메모리 할당
     예]
     부모타입의 인스턴스 변수에 자식타입의 메모리 할당해서
     그 주소를 저장
     Person person = new Student();

 *부모타입의 인스턴스 변수가 접근 할 수 있는 범위
 1]부모로터 상속받는 멤버
 2]자식에서 오버라이딩한 메소드가 우선 호출됨.
 
 ※자식에서 새롭게 정의한 멤버(변수,메소드등)는
   접근 불가.(오버로딩한 메소드도 포함)	
   
 ※잇점:메소드의 매개변수를 부모타입으로 정의시
        모든 자식타입을 저장할 수 있음으로
        자식 클래스 수만큼 메소드를 오버로딩 할 필요 없다
        예]Object클래스의 equals(Object)
        

 -Homogenious(동질화)
  같은 타입의 인스턴스 변수에 같은 타입의 
  메모리 주소를 저장
  예]
  Student st = new Student();
 */

class Parent{
	//멤버변수]
	int parentMember;
	//멤버메소드]
	void parentMethod(){
		System.out.println("부모의 메소드:parentMethod()");
	}
}/////////////Parent

class Child extends Parent{
	//[멤버 변수]
	int childMember;//자식에서 새롭게 확장한 변수
	//[멤버 메소드]
	void childMethod(){
		System.out.println("자식에서 새롭게 확장한 메소드:childMethod()");
	}
	//[Overriding]
	@Override
	void parentMethod() {
		System.out.println("[자식에서 오버라이딩한 메소드:parentMethod()");
	}
	//[Overloading]
	void parentMethod(int childMember) {
		this.childMember=childMember;
		System.out.println("[자식에서 오버로딩한 메소드:parentMethod(int childMember)");
	}
	
}//////////////////////Child

public class Heterogenious {

	public static void main(String[] args) {
		/*[동질화]
			인스턴스 변수로 모든 멤버에 접근가능
        	오버라이딩한 메소드가 존재할 경우
        	부모의 메소드가 아니라
        	오버라이딩한 메소드가 무조건 호출됨.
		 */
		Child child = new Child();
		//[멤버 변수류]
		child.parentMember=10;
		child.childMember=100;
		//[멤버 메소드류]
		child.childMethod();
		child.parentMethod();//오버라이딩된 메소드
		child.parentMethod(10);//오버로딩된 메소드		
		System.out.println("[Parent타입에 자식타입의 메모리 주소 복사]");
		Parent parent = child;//Heterogenious]
		//자식에서 새롭게 정의한 멤버는 접근 불가]
		parent.parentMember=1;
		parent.parentMethod();//오버라이딩된 메소드]
		//이질화]-자식에서 새롭게 정의 한 멤버(변수,메소드)
        //        부모타입의 인스턴스변수로 접근 불가
        //        단,부모타입의 인스턴스 변수를
		//        자식타입으로 형변환(강제적 형변환-다운캐스팅) 하면
		//        자식에서 새롭게 정의한 멤버 접근가능
		/*        ※ 동질화든 이질화든
		 *         오버라이딩한 메소드가 우선 호출된다.
		 */
		Parent parent2 = new Child();
		parent2.parentMember=100;
		parent2.parentMethod();
		//방법1]형변환후 바로 접근
		((Child)parent2).childMember=1;
		((Child)parent2).childMethod();
		((Child)parent2).parentMethod(10);//오버로딩된 메소드
		//방법2]자식타입의 인스턴스 변수에 담아서
				// 그 인스턴스 변수로 접근
		Child child1 = (Child)parent2;
		child1.childMember=1;
		child1.childMethod();
		child1.parentMethod(10);
	}////////////////main
}///////////////////class
