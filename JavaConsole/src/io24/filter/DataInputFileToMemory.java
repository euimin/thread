package io24.filter;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
파일(javatype.txt)에 저장된 자바의 
각 자료형 값을 디코딩(필터 사용)해서 
자바의 각 자료형에 저장하자
그리고 확인차 모니터에 출력하자

데이타 소스: 파일
             노드 스트림 :FileInputStream
데이타 목적지:자바의 각 변수-메모리
              모니터- 노드 스트림:System.out
※DataOutputStream으로 필터링한(암호화된) 데이타는
  DataInputStream클래스를 사용해서 읽어야 제대로 읽어 온다.	
  단, 읽어 올때는 저장된  자료형 순서대로 읽어 와야 한다.	
 */
public class DataInputFileToMemory {

	public static void main(String[] args) throws IOException {
		//1]입력 노드 스트림 생성
		FileInputStream fis = 
				new FileInputStream("src/io24/filter/javatype.txt");
		//[DataInputStream 필터 미사용]-데이타 제대로 못 읽어 옴
		/*
		int data;
		while((data = fis.read()) != -1){
			System.out.println((char)data);
		}
		*/
		//2]DataInputStream 필터 사용
		
		DataInputStream dis = new DataInputStream(fis);
		//3]dis로 읽어서 자바의 각 자료형에 저장
		//  단, 반드시 DataOutputStream으로 출력할때의
		//  순서를 꼭 지켜야한다.
		byte b=dis.readByte();
		System.out.println("b="+b);
		byte[] barr = new byte[4];
		dis.read(barr,0,barr.length);
		for(byte by : barr) System.out.println(by);
		char ch=dis.readChar();
		System.out.println(ch);
		boolean bool=dis.readBoolean();
		System.out.println(bool);
		int num=dis.readInt();
		System.out.println(num);
		String str=dis.readUTF();
		System.out.println(str);
		//읽어올 데이타가 없는 경우
		//java.io.EOFException예외 발생	
		//Long ln=dis.readLong();
		//System.out.println(ln);
	}/////////////main

}
