package inheritance16;

public class Animal {
	//[멤버변수]
	String species;
	int age;
	String gender;
	//[생성자]
	//기본 생성자]
	//public Animal(){super();//Object의 기본 생성자 호출.생략 가능(하는일 없다)}
	//[인자 생성자]
	public Animal(String species, int age, String gender) {
		super();//Object의 기본 생성자 호출.생략 가능(하는일 없다)
		this.species = species;
		this.age = age;
		this.gender = gender;
		
	}
	//[멤버 메소드]
	void printAnimal(){
		System.out.print(
				String.format("종:%s,나이:%d,암수:%s",species,age,gender));
	}
	
}
