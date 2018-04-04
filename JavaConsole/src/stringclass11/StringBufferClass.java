package stringclass11;

import java.util.Scanner;

public class StringBufferClass {
	/*StringBuffer 클래스:
	 String클래스는 String클래스의 메서드를 이용해서
	 새로운 문자열을 생성하면 원래 문자열은 변하지 않고
	 새롭게 생성된 문자열을 저장하기 위해서
	 메모리가 새롭게 생성된다.
	 이런 메모리 낭비를 막기위해서
	 StringBuffer클래스가 사용된다.
	 즉 StringBuffer클래스는 원래값이 변한다
	 (메모리가 계속 생기지 않고)
	  */
		
	
	public static void main(String[] args) {
		/* [StringBuffer클래스의 주요 메소드] */
		//[StringBuffer클래스를 생성(인스턴스화,객체화)
		//  하면서 문자열 초기화 하지 않기]
		//StringBuffer buf = "HELLO";//[X]직접 대입 불가
		StringBuffer buf = new StringBuffer();
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		//위는 아래 스트링 클래스를 아래처럼 생성한 거와 같다
		String str="";
		System.out.println("str="+str);
		System.out.println("str에 저장된 문자열의 길이:"+str.length());
		System.out.println("buf에 저장된 문자열의 길이:"+buf.length());
		System.out.println("기본 버퍼크기:"+buf.capacity());
		//1]문자열 저장(계속 연결):StringBuffer append("문자열");
		buf.append("JAVA");
		System.out.println("[문자열 저장후]");
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf에 저장된 문자열의 길이:"+buf.length());
		System.out.println("버퍼크기:"+buf.capacity());
		buf.append("0123456789").append("ABCD");
		System.out.println("[문자열 저장후-계속]");
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf에 저장된 문자열의 길이:"+buf.length());
		System.out.println("버퍼크기:"+buf.capacity());
		//2]trimToSize():저장된 문자열만큼 버퍼크기를 줄인다
		buf.trimToSize();
		System.out.println("trimToSize()호출후 버퍼크기:"+buf.capacity());
		//3]StringBuffer delete(int start, int end) 
		//:start인덱스부터 end-1 인덱스까지의 문자열을 삭제
		buf.delete(4, 14);
		System.out.println("문자열 삭제후] buf="+buf);
		//4]StringBuffer deleteCharAt(int index)  
		//:index위치의 하나의 문자 삭제
		buf.deleteCharAt(4);
		System.out.println("한 문자 삭제후:"+buf);
		//5]StringBuffer insert(int index, String str)  
		//index-1 위치에 특정 문자열 삽입
		System.out.println("삽입후:"+buf.insert(4,"12345"));
		System.out.println("JAVA앞에 문자열 삽입:"+buf.insert(0, "가나다라"));
		//가나다라JAVA12345BCD
		//JAVA문자열만 알고 있다고 가정하고
		//JAVA이후의 문자열부터 끝까지 삭제하자
		int start = buf.indexOf("JAVA");
		int end   = buf.length();
		System.out.println("JAVA이후부터 끝까지 삭제:"+buf.delete(start, end));
		start = buf.indexOf("다라");
		end   = start + "다라".length();
		System.out.println("교체후:"+buf.replace(start, end,"CDEF"));
		
		//[특정 문자열로 초기화 하면서 StringBuffer클래스 객체 생성]
		buf = new StringBuffer("123456789");
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf에 저장된 문자열의 길이:"+buf.length());
		System.out.println("버퍼크기:"+buf.capacity());
		//7]StringBuffer reverse() 문자열을 반대로 배치
		System.out.println("거꾸로:"+buf.reverse());
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요?");
		String reverseString = scanner.nextLine();
		System.out.println("거꾸로:"+toReverseString(reverseString));		
	}////////////////////main
	//문]String클래스의 메소드를 이용해서 StringBuffer클래스의
	//   reverse()메소드와 같은 기능을 하는 메소드를 정의해라
	public static String toReverseString(String reverseString) {
		//1]StringBuffer클래스의 reverse()메소드 이용		
		//return new StringBuffer(reverseString).reverse().toString();
		//방법2]char[] 2개 사용
		/*
		//원본 배열]
		char[] src=reverseString.toCharArray();
		//거꾸로 바꿔서 저장할 배열]
		char[] dest = new char[src.length];
		for(int i=0; i < src.length;i++){
			dest[src.length-1-i]  = src[i];
		}
		return String.valueOf(dest);
		*/
		//방법3]반복을 2분의 1로 줄이고 char[]하나 사용
		/*
		char[] src=reverseString.toCharArray();
		for(int i=0; i < src.length/2;i++){
			char temp = src[i];
			src[i]    = src[src.length-1-i];
			src[src.length-1-i] = temp;
		}
		return String.valueOf(src);
		*/
		//방법4]char[] 요소를 String에 누적
		char[] src=reverseString.toCharArray();
		StringBuffer reString=new StringBuffer();
		for(int i=src.length-1; i >=0;i--){
			reString.append(src[i]);
		}		
		return reString.toString();
		
	}

}////////////////////////class
