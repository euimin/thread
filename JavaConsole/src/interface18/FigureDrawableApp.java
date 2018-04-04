package interface18;

public class FigureDrawableApp {

	public static void main(String[] args) {
		//[이질화]
		Figure f = new Rectangle(100, 100);
		f.area("사각형");
		((Rectangle)f).draw("사각형");
		
		Drawable draw = new Triangle(100, 100);
		draw.draw("삼각형");
		((Triangle)draw).area("삼각형");
		
		f= new Circle(100);
		f.area("원");
		((Circle)f).draw("원");
		
		//[동질화]
		Circle c = new Circle(10);
		c.area("원");
		c.draw("원");
		
	}//////////main

}////////////////class
