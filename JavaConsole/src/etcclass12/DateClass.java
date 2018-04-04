package etcclass12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {
	//날짜 차이를 반환하는 메소드]
	//반환타입:long
	//매개변수:String타입의 두 날짜,날짜패턴,구분자(단위)
	public static long getDiffBetweenDates(
			String strFirstDate,
			String strSecondDate,
			String pattern,
			char delim
			) throws ParseException{
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		//1]String -> Date:parse()
		Date firstDate=simple.parse(strFirstDate);
		Date secondDate=simple.parse(strSecondDate);
		//2]시간차 구하기
		long firstTime=firstDate.getTime();
		long secondTime=secondDate.getTime();
		long diff=Math.abs(firstTime-secondTime);
		//3]단위에 따른 날짜 차이 반환
		switch(Character.toUpperCase(delim)){
			case 'D':return diff/(24*60*60*1000);//일 단위
			case 'H':return diff/(60*60*1000);//시간 단위
			case 'M':return diff/(60*1000);//분 단위
			default :return diff/(1000);//초 단위
		}////////////////////////		
	}///////////////////////////////////////////	
	public static void main(String[] args) throws ParseException {
		/*
		  Date클래스:날짜 정보를 다루는 클래스로
		  대부분 Deprecated되었음
		  Date()기본 생성자나 Date(long date)인자 생성자를 제외한 
		  모든  생성자와 대부분의 메소드가  Deprecated됨.
		  
		  java.util패키지에 있음
		  
		  Date클래스의 toString() 메소드도
		  메모리의 주소를 문자열로 반환하는 것이 아니라
		  저장된 날짜 데이타를 
		  문자열로 반환되도록 오버라이딩 되었음. 
		   */
		Date today = new Date();
		
		System.out.println("today="+today);
		System.out.println("today.toString()="+today.toString());
		System.out.println("년도만 기져오기:"+(today.getYear()+1900));
		//int getDay():숫자 반환(0:일요일,1:월요일...6:토요일)
		switch(today.getDay()){
			case 0:System.out.println("일요일");break;
			case 1:System.out.println("월요일");break;
			case 2:System.out.println("화요일");break;
			case 3:System.out.println("수요일");break;
			case 4:System.out.println("목요일");break;
			case 5:System.out.println("금요일");break;
			default:System.out.println("일요일");
		}
		System.out.printf(
				"%d년 %d월 %d일 %d시 %d분 %d초%n",
				today.getYear()+1900,
				today.getMonth()+1,
				today.getDate(),
				today.getHours(),
				today.getMinutes(),
				today.getSeconds()
				);
		today.setYear(2012-1900);
		System.out.println("[년도만 재 설정후]");
		System.out.printf(
				"%d년 %d월 %d일 %d시 %d분 %d초%n",
				today.getYear()+1900,
				today.getMonth()+1,
				today.getDate(),
				today.getHours(),
				today.getMinutes(),
				today.getSeconds()
				);
		//1970년 1월 1일 0시 0분 0초부터 특정시점까지 흘러온 
		//시간을
		//1000분 1초단위로 반환:long getTime()
		//영국에 있는 그리리치천문대 기준
		//우리나라는 9시간 빠름
		//pasteDate객체를 1970년 1월 1일 0시 0분 1초
		Date pasteDate = new Date(1970-1900,0,1,0,0,1);
		System.out.printf(
				"%d년 %d월 %d일 %d시 %d분 %d초%n",
				pasteDate.getYear()+1900,
				pasteDate.getMonth()+1,
				pasteDate.getDate(),
				pasteDate.getHours(),
				pasteDate.getMinutes(),
				pasteDate.getSeconds()
				);
		long diff=pasteDate.getTime();
		System.out.println(diff+(9*60*60*1000));
		/*
		   * Calendar클래스:
		   * 생성자로 Calendar객체를 인스턴스화 할 수없다
		   * 왜냐하면 접근지정자가 protected이기때문에
		   * Calendar클래스는 Single tone Design으로 
		   * 정의 되었음.
		   * 그래서 getInstance()메소드로 인스턴스화 함.
		   * 
		   * java.util패키지에 존재
		   */
		//Calendar cal = new Calendar();//[x]
		Calendar cal = Calendar.getInstance();
		System.out.println("cal="+cal);
		System.out.println("cal.toString()="+cal.toString());
		/*
		   * 날짜및 시간 얻기]
		   int get(int field) 메소드로 년월일시분초 얻기
		   field는 Calendar클래스의 int형 상수
		  */
		System.out.println("년도만 가져오기:"+cal.get(Calendar.YEAR));
		//1:일요일,2:월요일.... 7:토요일
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case 1:System.out.println("일요일");break;
			case 2:System.out.println("월요일");break;
			case 3:System.out.println("화요일");break;
			case 4:System.out.println("수요일");break;
			case 5:System.out.println("목요일");break;
			case 6:System.out.println("금요일");break;
			default:System.out.println("일요일");
		}  
		//오전 오후 구분]
		//cal.get(Calendar.AM_PM)의 반환값:0이면 오전 ,1이면 오후
		System.out.printf(
				"%d년 %d월 %d일 %s %d시 %d분 %d초%n",
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH)+1,
				cal.get(Calendar.DATE),
				cal.get(Calendar.AM_PM)==0?"오전":"오후",
				cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND)
				);
		
		
		/*
	   * SimpleDateFormat클래스:java.text패키지에 있는 
	   * 클래스로 날짜관련 정보를 얻는 데 유용한 클래스
	   */
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("dateFormat="+dateFormat);
		System.out.println("dateFormat.toString()="+dateFormat.toString());
		//1]Date타입을 String형으로 반환해주는 메소드
	    //  날짜패턴에 맞게 반환 해줌.
	    //  String format(Date d);
	    //  Date->String
		System.out.println("today:"+dateFormat.format(today));
		System.out.println("pasteDate:"+dateFormat.format(pasteDate));
		System.out.println("오늘 날짜:"+dateFormat.format(new Date()));
		//중간에 날짜 패턴 변경] -applyPattern(String 날짜패턴)
		// a는 오전오후를 나타내는 패턴
		// 예로 날짜 패턴에 at를 출력하고 싶다면
		// a는 패턴을 의미하는 문자 이기때문에
		// "yyyy년 MM월 dd일 at HH시"라고 하면 에러
		// 그래서 'at'으로 표현하면 a는 패턴을 의미하는게아니라
		// 그냥 a문장에 해당
		// "yyyy년 MM월 dd일 'at' HH시"는 정상
		dateFormat.applyPattern("yyyy년 MM월 dd일 a HH시 mm분입니다.");
		System.out.println("[패턴 변경후]");
		System.out.println("today:"+dateFormat.format(today));
		System.out.println("pasteDate:"+dateFormat.format(pasteDate));
		System.out.println("오늘 날짜:"+dateFormat.format(new Date()));
		
		//2]문자열 형식의 날짜를 Date타입으로 반환 해주는 메소드
	    //  Date parse("날짜형식의 문자열");
	    //  String ->Date
	    //※단,날짜 형식의 문자열이 날짜패턴과 일치해야한다.
		dateFormat.applyPattern("yyyy/MM/dd");
		//날짜 형식의 문자열: 날짜 패턴에 맞게
		String stringDate="2017/04/27";
		Date parseDate=dateFormat.parse(stringDate);
		System.out.println(parseDate);
		
		String strfDate="2017.4.27";
		String strsDate="2017.4.28";
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		//1]String -> Date:parse()
		Date fDate=simple.parse(strfDate);
		Date sDate=simple.parse(strsDate);
		//2]1970년 1월1 일 0시 0분0초부터		
		//  각 날짜까지 흘러온 시간을 1000분의 1초 
		//  단위로 얻기:Date클래스의 getTime()호출

		long ftime = fDate.getTime();
		long stime = sDate.getTime();
		//3]차이를 구해서 일단위/시간단위/분단위/초단위로
	    //  환산하기
	    /*
	     * 일단위:1000*24*60*60
	     * 시간단위:1000*60*60
	     * 분단위: 1000*60;
	     * 초단위:1000 
	     */
		diff =  stime-ftime;
		System.out.println("초단위:"+diff/(1000));
		System.out.println("분단위:"+diff/(1000*60));
		System.out.println("시간단위:"+diff/(1000*60*60));
		System.out.println("일단위:"+diff/(1000*60*60*24));
		
		//Date클래스의 날짜 차이관련 메소드]
		//1]두 날짜 사이의 선후관계 판단하는 메소드
		//boolean after()/before()
		System.out.println(fDate.before(sDate) ?"fDate가 sDate의 이전날짜다" : "fDate가 sDate의 이전날짜가 아니다");
		System.out.println(fDate.after(sDate) ?"fDate가 sDate의 이후날짜다" : "fDate가 sDate의 이후날짜가 아니다");
		
		//2]두 날짜가 같은지 비교
	   //  같으면 true,다르면 false
	   //  Date클래스의 equals()메소드는 
	   //  메모리 주소 비교가 아닌
	   //  날짜 비교하도록 오버라이딩 됨
		System.out.println(fDate.equals(sDate)?"날짜가 같다":"날짜가 다르다");
		//3]int compareTo(Date anotherDate)  
		//  두 날짜가 같다면 0반환
		//  다르다면 양수(1)나 음수(-1) 반환.
		//  날짜 차이는 계산 안됨
		System.out.println(fDate.compareTo(sDate));//-1
		System.out.println(sDate.compareTo(fDate));//1
		System.out.println(fDate.compareTo(sDate) > 0 ?"fDate가 sDate보다 이후 날짜다" : "fDate가 sDate보다 이후 날짜가 아니다");
	
		System.out.println("[getDiffBetweenDates()메소드로 날짜 차이 구하기]");
		System.out.println(getDiffBetweenDates("2017-4-27 14:58","2017-12-25 14:58", "yyyy-MM-dd HH:mm",'D'));
		System.out.println(getDiffBetweenDates("2017년4월27일","2017년4월26일", "yyyy년MM월dd일",'H'));
		
		//Calendar타입으로 날짜 설정-set()메소드
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.set(2017, 3, 11, 9, 30, 0);
				cal2.set(2017,9,12,18,30,0);
				
				//STEP1]Calendar타입을 Date타입으로 변경:
				//      Calendar클래스의 Date getTime()메소드로
				Date firstDate=cal1.getTime();
				Date secondDate=cal2.getTime();
				//STEP2]Date타입을 String타입으로 바꾸기 위해
				//SimpleDateFormat객체 생성:format()메소드 이용]
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String fString=sdf.format(firstDate);
				String sString=sdf.format(secondDate);
				System.out.println("과정 종료시까지 남은 일수:"+
				getDiffBetweenDates(fString, sString, sdf.toPattern(), 'D'));
		
		
	}///main
}/////////class
