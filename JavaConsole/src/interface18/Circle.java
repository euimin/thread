package interface18;

public class Circle implements Figure,Drawable{

	int radius;
	
	public Circle(int radius) {		
		this.radius = radius;
	}
	
	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"(연속된 점)을 그리다");
	}
	@Override
	public void area(String figureName) {		
		System.out.println(figureName+"의 면적:"+radius*radius*Math.PI);
	}

}
