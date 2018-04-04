package thread23;
//동기화 블락을 이용한 데이타 동기화
//동기화 블락:
/*
synchronized(동기화할 객체){

동기화할 로직

} 
*/
/* 여러 스레드가 공유하는 데이타(메모리)를 갖고 있는 클래스 */
class DataSyncClass{
	//여러 스레드가 공유하는 메모리]
	int shareData;
	//[인자 생성자]
	public DataSyncClass(int shareData) {		
		this.shareData = shareData;
	}
	
}///////////////////////////////
/* 공유 데이타를 사용하는 스레드 */
class DataSyncThread extends Thread{
	//[멤버 변수]
	//공유할 데이타를 갖고 있는 DataSyncClass타입의 멤버
	DataSyncClass dsc;
	//일정하게 증가시킬 숫자를 저장할 멤버
	int inc;
	//스레드명을 저장할 멤버
	String threadName;
	//[인자 생성자]
	public DataSyncThread(DataSyncClass dsc, int inc, String threadName) {
		super(threadName);
		this.dsc = dsc;
		this.inc = inc;
		this.threadName = threadName;
	}
	//[오래 걸리는 메소드]
	//DataSyncClass의 shareData에 저장된 값을 반복하면서
	//inc(증가분)만큼 누적해서 계속 저장.
	void increase(){
		for(int i=1;i <=10;i++){
			//shareData에 저장된 값을 inc만큼 증가시키면서 누적]
			dsc.shareData+=inc;
			System.out.println(
					String.format("[스레드명:%s,공유데이타:%d]",
							getName(),dsc.shareData));
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {}
		}
	}///////////////////////////
	@Override
	public void run() {
		//데이타 동기화 전]
		//increase();
		//데이타 동기화 후]		
		synchronized (dsc) {
			increase();
		}
		
	}
}//////////////////////////////////


public class DataSynchronized {

	public static void main(String[] args) {	
		 //공유 메모리 갖고 있는 클래스, 하나만 인스턴스화]
		 DataSyncClass dsc = new  DataSyncClass(10);
		//두 개의 스레드 생성]
		 DataSyncThread dst1 = new DataSyncThread(dsc,2,"1st 스레드");
		 dst1.start();
		 /*
		 try {
			dst1.join();
		} catch (InterruptedException e) {}
		*/
		 DataSyncThread dst2 = new DataSyncThread(dsc,5,"2nd 스레드");
		 dst2.start();
	}///////////main
}///////////////class
