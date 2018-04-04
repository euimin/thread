package io24.filter;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
자바의 각 자료형을 
인코딩(필터 사용)해서 파일로 저장하자

데이타 소스: 자바의 각 자료형에 저장된 값(메모리-변수)
데이타 목적지:파일
              노드 스트림:FileOutputStream

※DataOutputStream으로 필터링한(암호화된) 데이타는
  DataInputStream클래스를 사용해서 읽어야 제대로 읽어 온다. 

 */
public class DataOutputMemoryToFile {

	public static void main(String[] args) throws IOException {
		//1]데이타 소스 준비-입력 스트림 불필요
		byte b= 100;		
		byte[] bArray = {97,98,99,100};
		char ch ='가';
		boolean bool =false;
		int number=256;
		String strObject="안녕 자바!!.Hello Java!!.123456789";
		//2]출력 스트림 생성
		DataOutputStream dos =
				new DataOutputStream(
						new FileOutputStream("src/io24/filter/javatype.txt"));
		//3]메모리에서 데이타 읽고  dos로 출력
		//  자바의 각 자료형에 해당하는 출력용 메소드 사용
		dos.writeByte(b);
		dos.write(bArray);
		dos.writeChar(ch);
		dos.writeBoolean(bool);
		dos.writeInt(number);
		dos.writeUTF(strObject);
		//4]스트림 닫기
		dos.close();
	}//////////////main

}
