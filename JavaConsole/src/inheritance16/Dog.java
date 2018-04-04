package inheritance16;

//[Dog is a Animal성립]
public class Dog extends Animal {

	//[멤버변수]
	//[확장한 멤버]
	String dogKind;
	int age;//Dog에서 새롭게 추가(확장)한 멤버 변수
	public Dog(){
		super(null,0,null);
	}
	//[인자 생성자]
	public Dog(String species, int age, String gender,String dogKind) {
		//super();//[x]부모에 인자 생성자 추가후 ,기본 생성자 정의 하지 않은 경우 
		//          단,부모의 기본 생성자 정의시에 오류가 해결됨.
		
		super(species, age, gender);//부모의 인자 생성자 호출시에는 
								    //기본생성자 정의 안해도 됨.
		
		//this();//[x]동시 호출 불가
		this.dogKind = dogKind;
		//super(species, age, gender);//[x]항상 첫번째 문장이어야 한다
	}
	
	//[멤버 메소드]
	void bark(){
		System.out.println(super.age+"살인 "+dogKind+"가(이) 짓다");
	}
	void printDog(){
		//super(null,0,null);//[x]생성자 안에서만 호출 가능
		printAnimal();
		System.out.println(",개 종류:"+dogKind);
	}
	int getSuperAge(){
		return super.age;
	}
	static void staticMethod(){
		//super(null,0,null);//[x]정적 메소드에서 호출 불가
	}
}
