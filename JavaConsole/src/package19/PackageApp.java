//1]패키지 선언문
package package19;



//2]import선언문
/*
import:다른 패키지에 있는 클래스들을 가져다 쓸때 
사용하는 선언문
패키지명.하위패키지명.클래스명 식으로
단,java.lang패키지 안에 있는 클래스들은 
기본 패키지로 import할 필요 없다.
패키지명.*;   *는 모든 클래스를 의미
*/
import java.lang.String;//의미없다
//util패키지안에 있는 모든 클래스나 인터페이스를 의미
//util패키지안의 하위 패키지는 포함 안됨.
//import java.util.*;//*(asterik)는 모든의 의미
import java.util.Date;

//[jar파일 배포후]
/*
* jar파일로 묶는 방법]
* 
* 루트 패키지 선택 -> 마우스 우클릭 -> export
* ->java의 Jar file선택 -> 필요한 패키지 체크후 finish
* 
* jar파일 가져다 쓰는 방법1]
* 
* Poject선택후 마우스 우클릭->Build Path->Configure Build Path
* ->Add External Jars클릭후 jar로 묶은 파일 선택
* 
* jar파일 가져다 쓰는 방법2]
* -장점:필요한 Project마다 Build Path할 필요가 없다.
* jdk가 설치된 디렉토리 즉
* jdk1.버전\jre\lib\ext 폴더에 jar파일을 넣어 놓으면
* 이클립스가 끌어옴.
* 
* jar넣어 논후 이클립스 재실행
* 
*/
public class PackageApp {

	public static void main(String[] args) {
		
		/*
		 * 하나의 클래스 안에서 패키지가 다른 같은 이름의
		 * 클래스 접근시 주로 사용
		 * 예]
		 * java.util.Date
		 * java.sql.Date
		 * 
		 */
		//다른 패키지에 있는 클래스 접근 방법]		
		//방법1]import해서 사용-패키지 지정 불필요
		//util의 Date사용
		Date utilDate = new Date();
		System.out.println("utilDate="+utilDate);
		//방법2]import불필요-직접 패키지 명까지 지정		
		//sql의 Date사용
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("sqlDate="+sqlDate);
		
	}/////////////////main

}////////////////////class
