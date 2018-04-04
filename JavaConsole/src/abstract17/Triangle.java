package abstract17;

public class Triangle extends Figure {
	//[인자 생성자]
	public Triangle(int width, int height) {
		//추상 클래스를 상속받은 자식클래스의 생성자에서
		//추상 클래스의 생성자 호출 가능]
		super(width, height, -1);
		System.out.println("Triangle의 인자 생성자");
	}	
	@Override
	void area(String figureName) {		
		System.out.println(figureName+"의 면적:"+width*height/2);
	}//////////////

	
}
