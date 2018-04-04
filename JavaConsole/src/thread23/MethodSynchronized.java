package thread23;
/*
메소드 동기화: 여러 스레드에 의해 호출되는
공유 메소드를 동기화 함으로써 여러 스레드가
동시에 호출 못하도록 lock을 거는 것

[형식]
	접근지정자 synchronized  반환타입 메소드명([매개변수]){
	
	}
*/
/* 여러 스레드가 공유하는 메소드를 가진 클래스*/
class MethodSyncClass{
	synchronized void increase(int seed,int inc){
		for(int i=1;i <=10;i++){
			//seed에 저장된 값을 inc만큼 증가시키면서 누적]
			seed+=inc;
			System.out.println(
					String.format("[스레드명:%s,공유데이타:%d]",
							Thread.currentThread().getName(),
							seed));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}///////////////////////////
	
}

//[공유 메소드를 호출하는 스레드]

class MethodSyncThread extends Thread{
	//[멤버 변수]
	MethodSyncClass msc;
	int seed,inc;
	//[인자 생성자]
	public MethodSyncThread(String threadName,MethodSyncClass msc, int seed, int inc) {
		super(threadName);
		this.msc = msc;
		this.seed = seed;
		this.inc = inc;
	}
	
	@Override
	public void run() {
		msc.increase(seed, inc);
	}
}///////////////////////////////
public class MethodSynchronized {

	public static void main(String[] args) {
		//공유 메소드 갖고 있는 클래스, 하나만 인스턴스화]
		MethodSyncClass msc = new MethodSyncClass();
		//스레드 생성]
		MethodSyncThread mst1 = 
				new MethodSyncThread("1st", msc, 10, 2);
		mst1.start();
		
		MethodSyncThread mst2 = 
				new MethodSyncThread("2nd", msc, 10, 5);
		mst2.start();
		
	}////////////////main
}///////////////////class
