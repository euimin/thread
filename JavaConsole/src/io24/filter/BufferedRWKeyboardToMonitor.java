package io24.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
/*
키보드로 부터 입력받아서
모니터로 출력하자
단, 브릿지 스트림을 통해 문자단위로 변환하고
필터스트림을 통해 필터링하자
(BufferedReader/BufferedWriter필터 스트림 사용)   
*/
public class BufferedRWKeyboardToMonitor {

	public static void main(String[] args) throws IOException {
		//1]필터를 끼운 입력 스트림 생성
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
	
		//2]필터를 끼운 출력 스트림 생성
		BufferedWriter bw =
				new BufferedWriter(
						new OutputStreamWriter(System.out));
		
		//3]br로 읽고 bw로 출력
		
		//BufferedReader의 readLine()메소드: 파일(스트림)의 끝에 
		//도달하면 null을 반환 하거나
		//읽은 문자열이 없는 경우 null반환
		//엔터값을 읽지 않는다
		String data;
		/*
		while((data=br.readLine()) !=null){
			//방법1]읽어온 데이타 뒤에 엔터값 추가
			//bw.write(data+"\r\n");
			bw.write(data);
			//방법2]줄바꿈 기능을 하는 메소드 호출:newLine()
			bw.newLine();		
			bw.flush();
		}
		*/
		/*
		[PrintWriter-출력용 필터 스트림] 
				   
		  PrintWriter 객체 생성시 생성자의 두번째 인자로
		  true를 주면 autoflush지원
		  즉 flush()를 호출 할 필요 없다
		  BufferedWriter는 줄바꿈을 하려면 \r\n을 추가해주거나
		  newLine()메서드를 호출 해야 하지만
		  PrintWriter는 줄바꿈을 지원하는 println(String str)메소드를
		  제공한다
		  즉 문자 기반으로 입출력시 BufferedReader읽고
		  PrintWriter출력하면 편하다
		*/
		//플러쉬 불필요,브릿지 사용 불필요,줄바꿈 불필요
		PrintWriter pw = new PrintWriter(System.out, true);
		//3-1]br로 읽고 pw로 출력
		while((data=br.readLine()) !=null){
			pw.println(data.toUpperCase());
		}
		
	}//////////main
}/////////////class
