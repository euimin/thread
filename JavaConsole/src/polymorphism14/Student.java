package polymorphism14;

import java.util.Date;

/*
 *오버라이딩(Overriding)-재정의
	상속시에 적용되는개념 즉 부모로부터 상속 받은 메소드를 
	재정의해서 사용하는 것
	    - 메소드명이 동일해야 한다.
	    - 메소드의 매개변수 갯수, 데이터타입이  같아야 한다.
	    - 메소드의 반환타입도 같아야 한다.
	    - 부모 메서드의 접근 지정자가 
	       public이거나 protected인 경우에만 오버라이딩이 된다.

	    - 부모 메서드가 default 지정자나 private지정자를 
	       가진 메서드를 오버라이딩 한경우
	       자식 고유의 메서드로 처리된다(오버라이딩 한 것이 아님)	
	       //단,default접근 지정자는 다른 패키지에서는
	//접근이 안됨으로 부모와 자식이 다른 패키지일 경우에만
	       //오버라이딩 한것이 아님.
	      //같은 패키지일 경우는 오버라이딩에 해당

	    - Exception의 경우 부모 클래스의 메소드와 동일하거나 
	       더 구체적인 Exception을
	       발생시켜야 한다.
 
 */
public class Student extends Person {
	//[멤버 변수]
	String stNumber;//자식에서 새롭게 확장한 멤버
	//[인자 생성자]
	public Student(String name, int age,String stNumber) {
		//멤버변수 초기화]
		super(name, age);
		this.stNumber = stNumber;
	}
	//[멤버 메소드]
	void study(){//자식에서 새롭게 확장한 멤버
		System.out.println(name+"가(이) 공부하다");
	}
	//자식에서 새롭게 정의한 메소드]
	//오버라이딩이 아님[x]
	//부모의  private이 붙은 메소드는 오버라이딩
	//절대불가(자식에서 안보이니까)	
	private void eat() {
		System.out.println("학생이 먹는다");
	}
	/*
	 * @Override:어노테이션
	 * -주석의 일종으로 컴파일러에게
	 *  해당 메소드가 오버라이딩된 메소드임을
	 *  알려주는 역할 
	 * 
	 */
	@Override
	public String sleep(int age){//접근지정자는 부모와 같거나 부모보다 넓어야 한다
		System.out.println("학생이 잔다");
		return null;
	}
	//오버로딩에 해당-부모의 walk는 오버라이딩 안하고
	//그대로 사용.매개변수 타입만 다르게해서 사용
	//자식에서 새롭게 확장한 메소드와 같다]
	int walk(int age){
		System.out.println("나이가 "+age+"살인 학생이 산책한다");
		return 0;
	}
	
	@Override
	public void exercise() {
		//부모의 메소드를 그대로 사용하도록
		//재정의
		//super.exercise();
		//부모의 메소드를 그대로 사용하지 않고
		//새롭게 정의
		System.out.println("학생이 운동한다.");
	}
	//오버라이딩이 아님[x].
    //정적 메소드는 오버라이딩 불가	
	static void staticMethod(){
		System.out.println("학생의 정적 메소드");
	}
	
	@Override
	String getPerson() {		
		return super.getPerson()+",학번:"+this.stNumber;
	}
	@Override
	void printPerson() {
		System.out.println(getPerson());
	}
	
	
	
	
}
