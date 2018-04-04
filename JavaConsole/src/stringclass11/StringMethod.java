package stringclass11;

import java.util.Scanner;

import wrapperclass10.WrapperClass03;

public class StringMethod {

	public static void main(String[] args) {
		/*String클래스의 주요 메소드 */
		String str1 = "Welcome To Java!";
		String str2 = "안녕 자바!";
		//1]int length() :문자열의 길이 반환.
		System.out.println("str1의 문자열 길이:"+str1.length());
		System.out.println("str2의 문자열 길이:"+str2.length());
		//2]char charAt(int index)
		//:문자열에서  index에 해당하는 하나의 문자를 반환한다.
		// index는 0부터 시작한다.
		System.out.println("str1의 4번째 문자:"+str1.charAt(3));
		System.out.println("str2의 4번째 문자:"+str2.charAt(3));
		//각 인덱스 위치에 해당하는 문자들 출력]
		for(int i=0;i < str1.length();i++)
			System.out.printf("%d번째 인덱스에 해당하는 문자:%c%n",
					          i,str1.charAt(i));
		String jumin = "012345-1234567";
		System.out.println(jumin.charAt(7)=='1' ? "남자":"여자");
		
		int lastjumin=1234567;
		//int를 Integer타입으로 바꾼후 toString()메소드로 문자열로 변경]
		//오토박싱하거나 혹은 Integer클래스의 메소드 직접 사용
		//방법1]
		char ch=Integer.valueOf(lastjumin).toString().charAt(0);
		System.out.println(ch=='1' ? "남자" : "여자");
		//방법2]
		System.out.println(Integer.toString(lastjumin).charAt(0)=='1' ?"남자":"여자");
		//방법3]
		Integer obj = lastjumin;//오토박싱
		System.out.println(obj.toString().charAt(0)=='1' ? "남자" :"여자");
		//3]int codePointAt(int index) :
		//문자열에서 index에 해당하는 아스키(유니코드) 코드값 반환
		System.out.println("str1의 4번째 문자의 아스키코드값:"+str1.codePointAt(3));
		System.out.println("str2의 4번째 문자의 유니코드값:"+Integer.toHexString(str2.codePointAt(3)));
		System.out.println(WrapperClass03.isNumber("100"));
		System.out.println(WrapperClass03.isNumber("100삼십"));
		//4]int compareTo(String anotherString)  
		//: 두 문자열을 비교하는 데 첫번째 문자부터 
		//  순차적으로 비교해 나간다
		//  첫번째 문자열의 아스키 코드값이 크면 양수
		//  첫번째 문자열의 아스키 코드값이 작으면 음수
		//  첫번째 와 두번째 문자열이 모두 같으면 0을 반환한다.
		//  ※두 문자열의 비교시에는 주로
		//    equals()메소드 사용
		//    compareTo()메소드는 문자열로 정렬할때 사용
		//    (오버라이딩한 메소드안에서)
		String str3="ABc";//c=99
		String str4="ABC";//C=67
		System.out.println(str3.compareTo(str4));//32
		System.out.println(str4.compareTo(str3));//-32
		System.out.println("ABC".compareTo("ABC")==0 ? "문자열이 같다":"문자열이 다르다");
		System.out.println("aBC".compareTo("ABC"));//32
		System.out.println("ABCDE".compareTo("A"));//4(남은 문자수)
		System.out.println("A".compareTo("ABCDE"));//-4(부족한 문자수)
		//5] String concat(String str)  :두 문자열을 연결할때 
		//                               +와 같은 기능
		System.out.println("JAVA".concat(" WORLD").concat(" HI!"));
		System.out.println("JAVA"+ " WORLD"+ " HI!");
		//6]boolean contains(CharSequence s): 
		//문자열에 특정 문자열이 포함되었지는
		//판단하는 메소드. 특정 문자열이 포함 되었으면 
		//true 아니면 false반환.
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("to"));
		String email="kim@nate.com";
		System.out.println(email.contains("@")? "이메일 형식이다" :"이메일 형식이 아니다");
		//7]static String copyValueOf(char[] data)  
		//  static String copyValueOf(char[] data, int offset, int count)  
		//  static String valueOf(char[] data)  
		//  static String valueOf(char[] data, int offset, int count)  
		//:char형 배열에 저장된 문자들을 String형으로 반환함.
		char[] cha = {'A','C','A','D','E','M','Y','!'};
		System.out.println(String.copyValueOf(cha));
		//3는 문자열로 만들 시작인덱스
		//4는 문자열로 만들 갯수
		System.out.println(String.copyValueOf(cha, 3, 4));
		System.out.println(String.valueOf(cha));
		System.out.println(String.valueOf(cha,0,cha.length));
		//메소드 사용안하고 char형 배열에 저장된 문자들을
		//문자열로 변환]
		String strplus="";
		for(int i=0;i < cha.length;i++)
			strplus+=cha[i];
		System.out.println(strplus);
		//8]boolean endsWith(String suffix)  
	    //:문자열이 특정 문자열로 끝나면 true ,
	    // 아니면 false 
		System.out.println("www.nate.com".endsWith("com"));
		System.out.println("www.nate.com".endsWith("co.kr"));
		//9]boolean startsWith(String prefix)  
		//:문자열이 특정 문자열로 시작하면 true,아니면 false
		System.out.println("www.nate.com".startsWith("www"));
		System.out.println("www.nate.com".startsWith("http"));
		System.out.println("www.nate.com".startsWith("nate", 4));
		//10]static String format(String format, Object... args)  
		//:출력 형식을 지정하여 문자열로 반환할때
		System.out.printf("국어:%d,영어:%d,수학:%d,평균:%.2f%n",99,99,99,99*3/3.0);
		System.out.format("국어:%d,영어:%d,수학:%d,평균:%.2f%n",99,99,99,99*3/3.0);
		System.out.println(String.format("국어:%d,영어:%d,수학:%d,평균:%.2f%n",99,99,99,99*3/3.0));
		//11]byte[] getBytes() : 
		//문자열을 byte형 배열로 반환 해줌
	    //배열로 반환 될때 아스키 코드값으로 변환 됨.
		//* 한글은 getBytes()로 적용하지 말자
		byte[] by="ABCD".getBytes();
		//by[0]=65,by[1]=66.....
		for(int i=0;i < by.length;i++)
			//아스키 코드로 출력
			System.out.println(String.format("by[%d]=%d", i,by[i]));
			//해당 문자로 출력
			//System.out.println(String.format("by[%d]=%c", i,by[i]));
		//12]char[] toCharArray():문자열을 char형 배열로 반환
		char[] charr="가나다라".toCharArray();
		//charr[0]='가',charr[1]='나'....
		for(int i=0;i<charr.length;i++)
			System.out.println(String.format("charr[%d]=%c",i,charr[i]));
		//13]int indexOf(String str):문자열에서 특정 문자열의 
		//   시작 인덱스를 반환,특정 문자열이 없는 경우 -1반환
		System.out.println("JAVA".indexOf("AVA"));//1
		System.out.println("JAVA".indexOf("A"));//1
		System.out.println("JAVA".indexOf("VA"));//2
		System.out.println("JAVA".indexOf("aVA"));//-1
		System.out.println(email.indexOf("@") !=-1 ?"이메일 형식이다":"이메일 형식이 아니다");
		
		jumin = "012345-1234567";
		int index = jumin.indexOf("-")+1;
		System.out.println(jumin.charAt(index)=='1'?"남자":"여자");
		//14]int lastIndexOf(String str) : 문자열에서 특정 문자열의 
		// 시작 인덱스를 반환하는데 뒤에서 부터 찾는다
		// 특정 문자열이 없는 경우 -1반환.
		System.out.println("JAVAAVA".lastIndexOf("AVA"));//1
		System.out.println("JAVA".lastIndexOf("A"));//3
		System.out.println("JAVA".lastIndexOf("VA"));//2
		System.out.println("JAVA".lastIndexOf("aVA"));//-1
		System.out.println("MY.FILE.TXT".lastIndexOf("."));//7
		//15]
		//String replace(char oldChar, char newChar) 
		//String replace(CharSequence target, CharSequence replacement) 
		String str5=str1.replace('T','G');
		System.out.println(str5);
		//스트형에 저장된 데이타는 절대 불변
		System.out.println(str1);
		System.out.println(str1.replace('o','a'));
		System.out.println(str1.replace("Java", "Korea"));
		System.out.println(str1.replace("Welcome","안녕"));
		System.out.println("Hi Java".replace("Hello", "안녕"));
		//16]String[] split(String regex) :
		//문자열을 특정 구분자로 분리해서 String형 배열로 반환.
		//해당 구분자가 없는 경우 배열크기가 1인 String형 배열이
		//생성되면서 모든 문자열이 0번방에 저장됨.
		String tel = "010-1234-5678";
		String[] arr=tel.split("-");//arr[0]="010",arr[1]="1234"..
		for(int i=0;i< arr.length;i++)
			System.out.println(String.format("arr[%d]=%s",i,arr[i]));
		
		//없는 구분자로 split시 배열의 크기가 1인 메모리가 생성되며
		//전체 문자열이 인덱스가 0인 방에 저장됨.
		arr=tel.split("@");
		for(int i=0;i< arr.length;i++)
			System.out.println(String.format("arr[%d]=%s",i,arr[i]));
		
		//17]String substring(int beginIndex) 
		//: 문자열에서 시작인덱스부터 문자열 끝까지를 추출하는
		//  메소드
		System.out.println("Welcome".substring(3));
		String filename = "my.file.homework.ppt";
		int beginIndex=filename.lastIndexOf(".")+1;
		System.out.println("확장자:"+filename.substring(beginIndex));
		//18]String substring(int beginIndex, int endIndex)  
		//시작인덱스부터 끝 인덱스-1 까지 문자열 추출
		//끝인덱스는 포함 안됨. 
		System.out.println("kim@nate.com".substring(4,8));
		String[] emails={
				"a@b.c",
				"kim@cyworld.com",
				"choi@daum.net",
				"lee@naver.com"};
		
		for(int i=0;i < emails.length;i++){
			int start=emails[i].indexOf("@")+1;
			int end  = emails[i].lastIndexOf(".");
			System.out.println(emails[i].substring(start,end));
		}
		//19]String toLowerCase()  :대문자를 소문자로 변환
		//20]String toUpperCase()  :소문자를 대문자로
		System.out.println("대문자로 변경:"+str1.toUpperCase());
		System.out.println("소문자로 변경:"+str1.toLowerCase());
		//대소문자 구분없이 아이디 체크하기]
		//회원의 아이디가 소문자 "park"이라고 가정하자
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력?");
		String nick = scanner.nextLine();
		//1]equalsIgnoreCase(anotherString) 사용
		System.out.println(nick.equalsIgnoreCase("park") ? "회원":"비회원");
		//2]toLowerCase()나 toUpperCase()사용
		System.out.println(nick.toUpperCase().equals("PARK")?"회원":"비회원");
		System.out.println(nick.toLowerCase().equals("park")?"회원":"비회원");
		//21]String trim()  : 양쪽 끝에 있는 공백 제거
		//문자열은 값을 비교하기전에 항상 trim()해라
		//※항상 문자열 비교시에는 트림후 비교하여라
		System.out.println("X"+"  J   A  V  A    "+"X");
		System.out.println("X"+"  J   A  V  A    ".trim()+"X");
	}///////////////main
}///////////////////class
