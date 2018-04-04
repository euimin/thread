package accessmodifier07;
/*
 *   ※protetced접근지정자:
 *    같은 패키지는 물론 다른 패키지 일지지라도
 *    두 클래스간의 상속관계가 존재한다면  접근 가능
 */
public class Super {
	//[멤버메소드]
	private void privatemethod(){}
	void packagemethod(){}
	protected void protectedmethod(){}
	public void publicmethod(){}
	//해당 클래스 안에서는 모든 멤버 접근 가능
	void showall(){
		privatemethod();
		packagemethod();
		protectedmethod();
		publicmethod();
	}
}
