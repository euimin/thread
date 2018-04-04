package accessmodifier07.sub;

import accessmodifier07.Super;

public class General {//Super와 상속관계 없음
	/*
	 * 
	 * 다른 패키지에 있고 상속 관계가 아님으로
	 * protected 접근지정자도 접근 불가함으로 보이지 않는다
	 * 다른 패키지에 있기 때문에 Super클래스는 import해야한다
	 */
	void access(){
		Super sup = new Super();
		//sup.packagemethod();//[x]
		//sup.protectedmethod();//[x]
		sup.publicmethod();
	}
}
