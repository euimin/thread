package polymorphism14;

public class OverridingApp {

	public static void main(String[] args) {
		/* 인스턴스 변수:Student타입(자식)
		 * 메모리 : Student타입(자식)
		 */
		Student student = new Student("가길동",20,"2017학번");
		System.out.println("[자식타입의 인스턴스 변수-오버라이딩한 메소드들]");
		student.exercise();
		student.sleep(20);
		System.out.println(student.getPerson());
		student.printPerson();
		System.out.println("[자식타입의 인스턴스 변수-자식(Student)에서 새롭게 확장한 메소드들]");
		student.study();
		student.walk(20);//오버로딩한 메소드]
		Student.staticMethod();
		/* 인스턴스 변수:Person타입(부모)
		 * 메모리 : Student타입(자식)
		 * 
		 */
		/*
		 * ※인스턴스 변수가 부모타입든 자식타입든
		 *   무조건 오버라이딩한 메소드가 호출된다.
		 *   단, 오버라이딩을 하지 않았다면 당연히
		 *   상속받은 부모의 메소드가 호출된다.
		 *   
		 * ※만약 오버라이딩한 메소드호출시 
		 *   부모의 메소드를 사용하고자 한다면
		 *   super키워드로 접근해서 재정의 하면된다.
		 *   
		 */
		
		Person person = new Student("나길동",30,"2016학번");
		
		
		System.out.println("[부모타입의 인스턴스 변수-오버라이딩한 메소드들]");
		person.exercise();
		person.sleep(0);
		System.out.println(person.getPerson());
		person.printPerson();
		System.out.println("[부모타입의 인스턴스 변수-자식(Student)에서 새롭게 확장한 메소드들]");
		//person.study();//[x]undefined 컴파일 오류
		//person.walk(20);//[x]
		//※부모타입의 인스턴스 변수로 자식에서 새롭게 확장한
		//  멤버(변수,상수,메소드등)에 접근하려면 형변환 해야 한다.
		((Student)person).study();
		((Student)person).walk(20);
		
	}

}
