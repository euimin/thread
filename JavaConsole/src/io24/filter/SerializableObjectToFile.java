package io24.filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
직렬화된 PersonSerializable클래스를 인스턴스화(객체화)하여
파일로 저장하자

데이타 소스:PersonSerializable객체(메모리)
데이타 목적지:파일
			   노드 스트림:FileOutputStream
			   
객체를 저장하기 위한 필터 스트림:ObjectOutputStream	 
*/
public class SerializableObjectToFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//1]데이타 소스(메모리) 준비-입력 스트림 불필요
		PersonSerializable person1 =
				new PersonSerializable("김길동",20,"강남");
		PersonSerializable person2 =
				new PersonSerializable("나길동",30,"강동");
		PersonSerializable person3 =
				new PersonSerializable("다길동",40,"강서");
		//2]필터를 끼운 출력 스트림 생성]
		ObjectOutputStream oos = new ObjectOutputStream(
									new FileOutputStream("src/io24/filter/objectSeries.dat"));
		//3]인스턴화된 객체를 oos로 출력
		oos.writeObject(person1);
		oos.writeObject(person2);
		oos.writeObject(person3);
		//4]스트림 닫기
		oos.close();
	}/////////////////

}
