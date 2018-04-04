package constructor15;
/*
 * 싱글톤 디자인: 클래스를 설계하는
 *                디자인 패턴의하나로
 *                하나의 인스턴스 즉 하나의 메모리를 
 *                생성해
 *                이를 공유하고자 할때 사용하는 패턴
  
                  즉 하나의 메모리를 서로 공유해서 
                  사용함으로
                  값 변경시 문제가 발생할 수 있는 
                  경우는 사용하지 말자
                 
    예]java.util패키지의 Calendar클래스
    

 *  방법]
 *  1.생성자의 접근 지정자를 private으로 한다
 *  2.정적 메소드로 해당 클래스의 객체를
 *    반환하도록 정의한다.
 */

//싱글톤으로 미 설계시]
class NoSingleTone{
	//[멤버변수]
	int nosharevar;
	//[멤버 메소드]
	void print(){
		System.out.println(String.format("nosharevar=%d",nosharevar));
	}
}

//싱글톤으로 설계시]
class SingleTone{
	//[멤버변수]
	int sharevar;
	private static SingleTone single = new SingleTone();
	//[생성자]
	//1.접근지정자를 private 으로 지정
	private SingleTone(){}
	//[멤버 메소드]
	//2.정적 메소드로 해당 클래스의 객체를
	//  반환하도록 정의한다.
	public static SingleTone getInstance(){
		return single;
	}/////////////////////////
	
	void print(){
		System.out.println(String.format("sharevar=%d",sharevar));
	}
}///////////////////////////////////

public class SingleToneDesign {

	public static void main(String[] args) {
		//싱글톤으로 미 설계시]
		//new할때마다 메모리가 생긴다.
		NoSingleTone nst1 = new NoSingleTone();
		nst1.nosharevar=100;
		nst1.print();
		NoSingleTone nst2 = new NoSingleTone();
		nst2.nosharevar=200;
		nst2.print();
		
		System.out.println(String.format("nst1의 주소:%s,nst1의 nosharevar:%d",nst1,nst1.nosharevar));
		System.out.println(String.format("nst2의 주소:%s,nst2의 nosharevar:%d",nst2,nst2.nosharevar));
		
		//싱글톤으로 설계시]
		//SingleTone st = new SingleTone();[x]인스턴스화 불가
		//반드시 정적메소드를 통해서 인스턴스화 한다.
		SingleTone st1 = SingleTone.getInstance();
		st1.sharevar=100;
		st1.print();
		
		SingleTone st2 = SingleTone.getInstance();
		st2.sharevar=200;
		st2.print();
		
		System.out.println(String.format("st1의 주소:%s,st1의 sharevar:%d",st1,st1.sharevar));
		System.out.println(String.format("st2의 주소:%s,st2의 sharevar:%d",st2,st2.sharevar));
		
		
	}////////////////////main
}////////////////////////class
