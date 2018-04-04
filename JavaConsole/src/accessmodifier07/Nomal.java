package accessmodifier07;

public class Nomal extends Super{//상속관계
	/*
	 * 두 클래스는 상속 관계로
	 * 같은 패키지 안에 있기 때문에
	 * 생략형 /protected/public이 접근이 가능하니까
	 * 모두 상속이 됨.
	 */
	void access(){
		
		this.packagemethod();
		this.protectedmethod();
		this.publicmethod();
	}
}
