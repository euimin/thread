package io24.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
파일로 부터 
데이타를 읽어서(노드 스트림:FileReader)
모니터로 출력하자
필터스트림을 통해 필터링하자
(BufferedReader/PrintWriter)	
 */
public class BufferedRWFileToMonitor {

	public static void main(String[] args) throws IOException {
		//1]필터 끼운 입력 스트림 생성
		BufferedReader br = 
				new BufferedReader(
						new FileReader("src/io24/filter/BufferedRWKeyboardToFile.java"));
		//2]필터 끼운 출력 스트림 생성
		PrintWriter pw = new PrintWriter(System.out,true);
		//3]br로 읽고 pw로 출력
		String data;
		int line =1;
		while((data=br.readLine()) !=null){
			//문]라인번호 붙여서 출력하고 java를 한글 자바로 바꿔서 출력해라
			pw.println(String.format("%-4d",line)+data.replace("java","자바"));
			line++;
		}
		//4]스트림 닫기
		br.close();
	}//////////////main
}//////////////////class
