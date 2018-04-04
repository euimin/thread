package polymorphism14;
/*
-자바의 모든 클래스의 최상위 부모는 Object클래스이다
-Object클래스의 toString()메소드는 객체의 주소를
 String으로 반환해주는 메소드다 
-Object클래스의 equals()메소드는 
 두 객체간의 인스턴스비교
 즉 주소값 비교,주소가 같으면 true,다르면 false반환 
 Object클래스의 String toString()메소드]
		 :객체의 주소를 문자열로 반환
		  패키지명.클래스명@주소(16진수) 
		  
 Object클래스의 boolean equals()메소드]
        : 비교 클래스의 
          인스턴스변수.equals(대상클래스의 인스턴스변수)
          두 객체의 주소비교
 */

class MyClass{
	//[멤버변수]
	int data;
	//[인자 생성자]
	public MyClass(int data) {		
		this.data = data;
	}
	//실제 저장된 데이타가 반환되도록 Object로부터 상속받은
	//toString()메소드 오버라이딩(재정의)]
	@Override
	public String toString() {	
		return String.valueOf(data);
	}
	
	@Override
	public int hashCode() {		
		return data;
	}
	//실제 저장된 데이타를 비교하도록 equals(Object)메소드 
	//오버 라이딩]
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof MyClass){
			//저장된 데이타가 같다면 true
			//다르다면 false반환
			MyClass mc=(MyClass)obj;
			if(mc.data != this.data) return false;
			else return true;
		}
		//인자에 전달받는 타입이 MyClass타입이 아닌 경우
		else return false;
		
	}
	
}////////////

class Point{
	int x,y;

	public Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}
	//문1]"x=10,y=20"처럼 반환하도록 toString() 메소드를 
	//   오버라이딩 하여라
	@Override
	public String toString() {
		
		return String.format("x=%d,y=%d",x,y);
	}
	//문2]저장된 x좌표와 y좌표가 같은지 비교하도록 equals()메소드를
	//    오버라딩하여라.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			Point pt=(Point)obj;
			if(pt.x== x && pt.y==y) return true;
			else return false;
		}
		return false;
	}
}
public class ObjectClass {

	public static void main(String[] args) {
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		System.out.println("[두 객체의 toString()메소드 호출]");
		System.out.println(mc1.toString());
		System.out.println(mc1.getClass().getName()+"@"+Integer.toHexString(mc1.hashCode()));
		
		System.out.println(mc2.toString());
		System.out.println(mc2.getClass().getName()+"@"+Integer.toHexString(mc2.hashCode()));
		
		System.out.println("[두 객체를 equals()메소드로 비교]");
		System.out.println(mc1.equals(mc2) ? "같다" : "다르다");
		
		Point pt1 = new Point(10,20);
		Point pt2 = new Point(10,20);
		System.out.println("[두 객체의 toString()메소드 호출]");
		System.out.println(pt1.toString());
		System.out.println(pt2.toString());
		System.out.println("[두 객체를 equals()메소드로 비교]");
		System.out.println(pt1.equals(pt2) ? "같다":"다르다");
	}

}
