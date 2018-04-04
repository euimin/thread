package encapsulation13;
//[감기 처방과 관련된 약들을 캡슐화]
public class Contack600 {
	//멤버변수]
	SneezeCap sneeze   = new SneezeCap();
	SnivelCap snivel   = new SnivelCap();
	SniffleCap sniffle = new SniffleCap();
	//멤버메소드]
	public void take(){
		//복용순서가 중요하다]
		//콧물 ->기침->재채기
		snivel.take();
		sniffle.take();
		sneeze.take();
	}
}
