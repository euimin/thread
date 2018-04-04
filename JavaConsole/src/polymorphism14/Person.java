package polymorphism14;

import java.util.Date;

public class Person {
	//[멤버변수]
	String name;
	int age;
	//[생성자]
	//기본 생성자]
	public Person() {}
	//인자 생성자]
	public Person(String name, int age) {		
		this.name = name;
		this.age = age;
	}//////////////////////
	//[멤베메소드]
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep(int age){
		System.out.println("부모님이 주무신다");
		return null;
	}
	protected int walk(Date date){
		System.out.println("부모님이 산책하신다");
		return 0;
	}
	public void exercise(){
		System.out.println("부모님이 운동하신다.");
	}
	
	String getPerson(){
		return String.format("이름:%s,나이:%d",name,age);
	}
	void printPerson(){
		System.out.println(getPerson());
	}
	
	static void staticMethod(){
		System.out.println("부모님의 정적메소드");
	}
}//////////////////////
