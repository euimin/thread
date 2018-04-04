package method05;

public class CallByValueNReference {
	//※메소드 호출과 관련된 개념으로
	//  매개변수에 값을 전달(복사)하거나
	//  메모리의 주소값을 전달(복사)하는 경우
	/*
	매개변수가 기본 자료형(primative type)인 경우:
	Call By Value(값에 의한 호출)
	:값이 매개변수에 전달됨
	*/
	//CallByValue 테스트용 메소드 정의]
	static void callByValue(int first,int second){
		int temp;
		temp = first;
		first = second;
		second= temp;
		System.out.printf("[callByValue메소드 안]first=%d,second=%d%n",first,second);
	}/////////////////callByValue
	/*
	매개변수가 참조형(배열,String,클래스,인터페이스등) 
	인 경우:
	call by reference(참조에 의한 호출)
	값이 아니라 주소값이 매개변수에 전달됨.
	같은 메모리를 참조한다
	-매개변수에 여러개의 값을 동시에 전달하는 효과가
	 있고 또한
	 여러개의 값을 반환하는 효과도 있다.
	 (반환타입이 void여도)
	*/
	//CallByReference테스트를 위한 메소드 정의]
	static void callByRef(int[] ref){
		int temp;
		temp= ref[0];
		ref[0] = ref[1];
		ref[1] = temp;
		System.out.printf("[callByRef메소드 안]ref[0]=%d,ref[1]=%d%n",ref[0],ref[1]);
	}//////////////////////////////
	
	public static void main(String[] args) {
		//CallByValue 테스트]
		int first=1;
		int second=100;
		System.out.printf("[main메소드 안-callByValue호출전]first=%d,second=%d%n",first,second);
		callByValue(first,second);
		System.out.printf("[main메소드 안-callByValue호출후]first=%d,second=%d%n",first,second);
		//CallByReference테스트]
		int[] ref=new int[2];
		ref[0] =1;
		ref[1]=100;
		System.out.printf("[main메소드 안-callByRef호출전]ref[0]=%d,ref[1]=%d%n",ref[0],ref[1]);
		callByRef(ref);
		System.out.printf("[main메소드 안-callByRef호출후]ref[0]=%d,ref[1]=%d%n",ref[0],ref[1]);
		
		
	}/////////////main

}////////////////class
