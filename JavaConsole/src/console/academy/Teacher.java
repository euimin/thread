package console.academy;

public class Teacher extends Person {
	//[멤버 변수]
	String subject;//새롭게 확장한 멤버
	//[인자 생성자]
	public Teacher(String name, int age,String subject) {
		super(name, age);
		this.subject = subject;
	}
	//[멤버 메소드]
	@Override
	public String get() {		
		return String.format("%s,과목:%s",super.get(),subject);
	}
	@Override
	public void print() {
		System.out.println(get());
	}
	
	
}
