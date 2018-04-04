package io24.node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
파일로부터(Keyboard.txt) 데이타를 읽어 
모니터 와 파일(KeyboardCopy.txt)에 동시 출력	  
파일에 직접 연결이 가능한 
바이트 기반의 노드 스트림 이용

※데이타 소스나 데이타 목적지에 따라
  입출력 노드 스트림 결정

데이타 소스:File
		바이트 기반의 입력 스트림:FileInputStream
	
데이타 목적지:Monitor
		바이트 기반의 출력 스트림:System.out-PrintStream타입   
			 File
		바이트 기반의 출력 스트림:FileOutputStream
*/
public class FileInputStreamToMonitor {

	public static void main(String[] args) throws IOException {
		//1]입력 스트림 생성
		FileInputStream fis = new FileInputStream("src/io24/node/Keyboard.txt");
		//2]출력 스트림 생성
		//파일용]
		FileOutputStream fos = new FileOutputStream("src/io24/node/KeyboardCopy.txt");
		//모니터용]
		OutputStream out= System.out;
		//3]fis로 읽고 fos와 out로 출력
		//파일에서 읽어온 데이타를 저장할 변수
		int data;
		while((data= fis.read()) !=-1){//파일의 끝에 도달하면 -1반환
			//파일 출력]
			fos.write(data);
			fos.flush();
			//모니터 출력]
			out.write(data);
			out.flush();
		}
		//4]스트림 닫기
		fis.close();
		fos.close();
	}///////////////main
}/////////////////class
