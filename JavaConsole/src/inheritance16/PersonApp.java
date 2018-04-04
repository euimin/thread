package inheritance16;

public class PersonApp {

	public static void main(String[] args) {
		/*
		 * 생성자 호출 순서:
		 * 부모 생성자 -> 자식 생성자
		 */
		System.out.println("[기본 생성자로 객체 생성]");
		Student student1 = new Student();
		student1.printStudent();
		
		System.out.println("[인스턴스 변수로 초기화후]");
		//인스턴스 변수로 접근해서 멤버 초기화
		student1.name="홍길동";
		student1.age=20;
		student1.addr="가산동";
		student1.studentNumber="2017학번";
		student1.printStudent();
		
		System.out.println("[인자 생성자로 객체 생성]");
		
		Student student2 = new Student("김길동",	20,"사당동","2016학번");
		student2.printStudent();
		
		Teacher teacher = new Teacher("박자바",40,"인천","자바");
		System.out.println(teacher.getTeacher());
	}/////////////////////main

}/////////////////////////class
