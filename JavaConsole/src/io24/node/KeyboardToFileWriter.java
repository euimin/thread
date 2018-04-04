package io24.node;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
키보드로 읽어서 문자단위로 파일에 출력

브릿지 스트림을 이용해서 1바이트씩 읽은
데이타를 문자단위로 변환한다.

데이타 소스:키보드 - System.in(1바이트씩 읽음)
브릿지 스트림:InputStreamReader(1바이트를 문자단위로 변환)
데이타 목적지:파일 - FileWriter(한문자씩 출력)

[자바IO에서 한글이 깨지는 경우]

-1바이트씩 읽어서 한 문자씩 출력시
  :InputStreamReader브릿지 스트림 이용
-한 문자씩 읽어서 1바이트로 출력시
  :OutputStreamWriter브릿지 스트림 이용

※1바이트씩 읽어서 1바이트씩 출력하거나
  한문자 씩 읽어서 한문자 씩 출력 할때는
  한글이 깨지지 않음.

*/
public class KeyboardToFileWriter {

	public static void main(String[] args) throws IOException {
		//1]바이트 기반 입력 스트림 생성
		//InputStream is= System.in;
		//2]브릿지 스트림을 이용해서 바이트 기반 입력을 문자 기반으로 변환
		InputStreamReader isr = new InputStreamReader(System.in);
		//3]문자 기반의 출력 스트림생성
		FileWriter fw = new FileWriter("src/io24/node/KeyboardWriter.txt");
		int data;
		int totalChar=0;
		/*
		//is로 읽고 fw로 출력-한글이 깨진다]
		while((data=is.read()) !=-1){
			fw.write(data);
			fw.flush();
		}
		*/
		//4]isr로 읽어서 fw로 출력
		//필터 효과 적용전]
		//read()는 바이트 단위가 아니라 문자 단위로 읽는다.
		//고로 총 바이트수를 카운트로 알아내기 힘들다.
		/*
		while((data = isr.read())!=-1){
			totalChar++;
			fw.write(data);
			fw.flush();
		}	
		*/
		//필터 효과 적용]
		//계란판 준비
		char[] cbuf = new char[10];
		//read(cbuf)는 읽은 문자 수 반환
		//실제 데이타는 cbuf에 저장됨.
		while((data=isr.read(cbuf))!=-1){
			totalChar+=data;
			//write(char[],0,읽은 문자수)
			fw.write(cbuf, 0, data);
			fw.flush();
		}
		
		System.out.println("총 입력 문자수:"+totalChar);
		//5]스트림 닫기
		fw.close();
	}////////////////////////main
}///////////////////////////class
