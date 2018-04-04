package io24.node;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/*
키보드로부터 입력받아 입력 받은 내용을 
파일과 모니터로 출력

데이타 소스:키보드
			  1바이트 노드 스트림:System.in
데이타 목적지:
			  파일
			  1바이트 노드 스트림:FileOutputStream 
			  모니터
			  1바이트 노드 스트림:System.out

*/
public class KeyboardToFileOutput {

	public static void main(String[] args) throws IOException {
		//1]데이타 입력용 바이트기반의 노드 스트림 생성
		InputStream is= System.in;
		//2]출력용 바이트 기반의 노드 스트림 생성
		//2-1]파일 출력용
		//파일의 전체 경로 설정]
		//window식 디렉토리 표기법
		//FileOutputStream fos = new FileOutputStream("C:\\CCH\\JAVA\\Workspace\\Basic\\JavaConsole\\src\\io24\\node\\Keyboard.txt");
		//유니스/리눅스식 디렉토리 표기법
		//FileOutputStream fos = new FileOutputStream("C:/CCH/JAVA/Workspace/Basic/JavaConsole/src/io24/node/Keyboard.txt");
		//파일 경로:src부터 시작]
		FileOutputStream fos = new FileOutputStream("src/io24/node/Keyboard.txt");
		//2-2]모니터 출력용
		PrintStream out= System.out;
		//3]is로 읽고 fos와 out으로 출력
		//입력한 데이타를 저장할 변수]
		int asciiCode;
		while((asciiCode= is.read()) !=-1){//ctrl+z를 입력하지 않을 동안 반복
			//모니터로 출력]
			out.write(asciiCode);
			out.flush();
			//파일로 출력]
			fos.write(asciiCode);
			fos.flush();
		}
		//4]스트림 닫기
		fos.close();
		
	}////////////////////main

}///////////////////////class
