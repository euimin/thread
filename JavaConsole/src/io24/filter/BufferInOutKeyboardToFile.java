package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
키보드로부터 데이타를 읽어
파일(KeyboardBuffered.txt)로 출력해라
(1바이트 기반의 노드 스트림 사용)
단 입력/출력시 필터를 끼워라.

데이타소스:키보드 -노드 스트림:System.in
데이타목적지:파일 - 노드 스트림:FileOutputStream
필터 스트림:BufferedInputStream/BufferedOutputStream
*/
public class BufferInOutKeyboardToFile {

	public static void main(String[] args) throws IOException {
		//1]바이트 기반 입력용 노드 스트림 생성
		InputStream is = System.in;
		//2]바이트 기반 출력용 노드 스트림 생성
		FileOutputStream fos = new FileOutputStream("src/io24/filter/KeyboardBuffered.txt");
		/*
		 노드 스트림과 필터 스트림 연결방법]
		 필터스트림 생성자의 인자로 노드스트림을 전달하면된다.	
		 */
		//3]바이트 기반 입력용 필터 스트림 생성
		BufferedInputStream bis = new BufferedInputStream(is);
		//4]바이트 기반 출력용 필터 스트림 생성
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//5]bis로 bos로 출력
		int data;
		/*
		while((data=bis.read()) !=-1){
			bos.write(data);
			bos.flush();
		}
		*/
		byte[] b = new byte[10];
		while((data= bis.read(b))!=-1){
			bos.write(b,0,data);
			bos.flush();
		}
		//6]스트림 닫기
		bos.close();
	}/////////////////main
}////////////////////class
