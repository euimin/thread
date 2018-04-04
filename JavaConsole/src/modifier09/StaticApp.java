package modifier09;

public class StaticApp {

	public static void main(String[] args) {
		//static블락이 있는 아래 클래스를 인스턴스화
		//(즉 new 클래스명(); 이때 클래스명()이 생성자다)
		//할때 생성자보다 static블락이 먼저 실행된다.
		StaticBlock sb = new StaticBlock();
	}

}
