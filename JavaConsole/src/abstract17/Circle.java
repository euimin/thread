package abstract17;

public class Circle extends Figure {
	//[인자 생성자]
	public Circle(int radius) {
		//추상 클래스를 상속받은 자식클래스의 생성자에서
		//추상 클래스의 생성자 호출 가능]
		super(-1,-1,radius);
		System.out.println("Circle의 인자 생성자");
	}	
	@Override
	void area(String figureName) {		
		System.out.println(figureName+"의 면적:"+radius*radius*Math.PI);
	}//////////////

	
}
