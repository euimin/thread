package io24.node;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/*
[표준 입출력 장치:]
표준 입력장치:키보드
표준 출력장치:모니터

키보드(데이타소스)로부터 데이타를 읽어서
모니터(데이타 목적지)에 출력하자

노드 스트림: 데이타 소스나 목적지에 직접 연결 할 수 
             있는 스트림.
             
키보드에 직접 연결할 수 있는 1바이트 기반의 
노드 스트림(입력 스트림):System.in

모니터에 직접 연결할 수 있는 1바이트 기반으 
노드스트림(출력 스트림):System.out
*/
public class STDNodeInOut {

	public static void main(String[] args) throws IOException {
		//1] 바이트 기반의 입력용 노드 스트림 생성(키보드와
		//   직접 연결 가능한 노드 스트림)
		InputStream is=System.in;
		//2] 바이트 기반의 출력용 노드 스트림 생성(모니터와
		//   직접 연결 가능한 노드 스트림)
		PrintStream ps= System.out;
		//3]is(입력스트림)로 읽고 ps(출력스트림)로 출력
		//3-1]is로 키보드로부터 입력 받기
		/*
		 * int read():입력스트림으로 부터 1바이트씩 읽어서 
		 *            그 값을 아스키 코드값으로 반환
		 */
		//int ascii=is.read();//int ascii=System.in.read()와 같다.
		//[출력]
		//3-2]ps로 모니터에 출력
		//4-1]print()계열 메소드로 출력:아스키 코드값을 출력.
		//ps.println("입력 문자:"+ascii);//System.out.println("입력 문자:"+ascii);와 같다
		/*
		 * ctrl+z(이클립스용 콘솔)를 입력할때
		 * (read()는 -1반환)까지 
		 * 계속 키보드로부터 입력받고 출력
		 * 엔터값:\r\n ->\r:13 ,\n:10(아스키 코드값)
		*/
		//ABC엔터 -> \n\rCBA ->1013676665
		int ascii;
		/*
		while((ascii=is.read()) != -1){
			//print계열은 flush할 필요 없음.
			ps.println(ascii);
			
		}
		*/
		//4-2]write()계열 메소드로 출력
		//    입력한 문자 그대로 출력
		//write계열 메소드는 자동 flush가 안된다.
		//즉 출력 스트림에 있는 값을 데이타 목적지로 보내려면
		//flush()해주거나 close()를 해줘야 한다.
		//ascii = is.read();
		//ps.write(ascii);
		//ps.flush();
		//스트림 닫기.출력 스트림을 닫으면
        //이후 출력 불가] 
		//ps.close();		
		//ps.println("close()이후 출력문");
		//※모든 입출력 스트림은 사용후 스트림을 닫아야한다.
		//  단 ,표준 입출력 스트림은 닫지 않아도 무방.
		/*
		//사용자가 입력한 문자 그대로 출력하기
		while((ascii = is.read()) !=-1){
			//방법1]write계열 사용
			//ps.write(ascii);
			//ps.flush();
			//방법2]print계열 사용(한글은 깨짐)
			ps.print((char)ascii);
		}
		*/
		/* 사용자가 입력한 문자열을 변수에 그대로 저장 */	
		// 즉 read()메소드로 Scanner클래스의 
		// nextLine()메소드 기능 구현하기
		/*
		ps.println("문자열을 입력하세요?");
		StringBuffer buffer = new StringBuffer();
		while((ascii = is.read()) != -1){
			//엔터값 제외]
			if(ascii != 10 && ascii !=13){
				buffer.append((char)ascii);
			}
			//엔터 칠때 모니터에 출력]
			if(ascii ==10){
				//ps.println(buffer);
				break;
			}			
		}
		ps.println("입력한 문자열:"+buffer);
		*/
		int totalByte=0,repeatCount=0;
		String inputString="";
		//필터 효과 적용전]
		/*
		while((ascii = is.read()) !=-1){
			totalByte++;
			repeatCount++;
			//한바이트씩 읽은 문자를 누적]
			inputString+=(char)ascii;
		}	
		*/	
		//필터 효과 적용]
		//ascii에는 읽는 바이트 수
		//실제 데이타는 byte형 배열 인 b에 저장
		/*
		 * read(): 1바이트씩 읽어서 읽은 문자의 아스키 코드값 반환
		 * read(byte[]):1바이트씩 읽어서 읽은 문자를 바이트형 배열에 채운다.
		 *              입력스트림에 있는 모든 문자를 읽은 경우
		 *              혹은 바이트형 배열이 다 채워진 경우
		 *              읽은 바이트 수 반환
		 */
		byte[] b = new byte[5];
		while( (ascii = is.read(b))!=-1){
			totalByte+=ascii;
			repeatCount++;
			//byte형 배열을 String형으로 변환후 누적
			inputString+=new String(b,0,ascii);
		}
		System.out.println(
				String.format("입력 문자열:%s,총바이트 수:%d,총 반복수:%d", 
						inputString.substring(0,inputString.length()-2),
						totalByte,
						repeatCount));
		
	}///////////////////////main
}///////////////////////////class
