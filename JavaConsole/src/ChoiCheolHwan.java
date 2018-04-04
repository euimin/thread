//1]패키지 선언부- 클래스를 종류별로 묶어서 관리하기 
//                 위한  선언. 디렉토리 선언의 의미다

//2]import선언부- 내가 만든 클래스에서 필요한 자바 클래스들을
//                가져다 쓰기 위한 선언 
//java.lang패키지 안에 있는 클래스는 import불필요(해도 상관없다)
//java.lang패키지안에 있는 클래스들은 자동으로 import된다.
import java.lang.System; 
import java.util.Date;
import java.text.SimpleDateFormat;

//3]클래스 선언부
/*
클래스 선언방법]

public class 클래스명{

}
-클래스명은 대문자로 시작(권장사항)
-파일명은 클래스명.java 여야한다.(필수)
*/
public class ChoiCheolHwan{//클래스 시작

	/*
    	자바의 실행파일인 .class파일을 실행시킬때
    	JVM의 인터프리터가 main메소드를 찾아서
    	순차적으로 즉 위에서 아래로
    	한 줄 한줄 실행해 나간다
    
    	자바로 만든 콘솔이나 윈도우 어플리케이션은 
    	반드시 main()메소드가 하나 존재해야 한다.
    
    	main메소드가 없으면 컴파일은 되나 실행은 안된다.
    
   	*/ 
	public static void main(String[]   args){
		//Hello World 출력하기
		System.out.println("Hello World!!!");
		//System.out.println("Go Fighting !!!");

		/*
		System.out.println("한국소프트웨어");
		System.out.println("인재 개발원");
		System.out.println("가산 디지털 단지에 위치");
		*/

		Date today = new Date();
		System.out.println(today);

		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    		//String formatDate=simple.format(today);
		String formatDate = simple.format(today);		
		System.out.println(formatDate);
		
	}

}//클래스 끝
